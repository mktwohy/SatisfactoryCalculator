import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import composables.*
import data.*


enum class Tab { SELECT_RECIPE, PRODUCTION }

object FicsitColor {
    val Orange = Color(0xFFFA9549)
    val PurpleGray = Color(0xFF5F668C)
}

var text by mutableStateOf("")

object ViewModel {
    var selectedRecipe: Recipe? by mutableStateOf(null)
    var machineType: MachineType? by mutableStateOf(null)
    var dropDownIsExpanded by mutableStateOf(false)
    var tab by mutableStateOf(Tab.SELECT_RECIPE)
    var recipes: List<Recipe> by mutableStateOf(listOf())

    fun updateRecipes() {
        machineType?.let {
            recipes = GameData.Recipes.getAllProducedIn(it)
        }
    }

    fun selectRecipe(id: String) {
        selectedRecipe = GameData.Recipes.getFromId(id)
        tab = Tab.PRODUCTION
    }
}


@OptIn(ExperimentalComposeUiApi::class)
fun main() = singleWindowApplication(
    onKeyEvent = {
        if (it.isCtrlPressed && it.key == Key.R) {
            reset()
        }
        if (it.key == Key.Enter) {
            calculate()
        }
        true
    }
) {
    MaterialTheme(
        colors = darkColors(
            primary = FicsitColor.Orange,
            onSecondary = Color.LightGray,
            onBackground = Color.LightGray,
            surface = Color.Gray,
            onSurface = Color.LightGray,
            background = Color.Black
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            Column {
                Row {
                    Button(onClick = { ViewModel.tab = Tab.SELECT_RECIPE; ViewModel.updateRecipes() }) {
                        Text("Select Recipe")
                    }
                    Button(onClick = { ViewModel.tab = Tab.PRODUCTION }) {
                        Text("Production")
                    }
                }
                Column {
                    Button(onClick = { ViewModel.dropDownIsExpanded = true }) {
                        Text(ViewModel.machineType?.name ?: "Select Machine")
                    }
                    DropdownMenu(
                        expanded = ViewModel.dropDownIsExpanded,
                        onDismissRequest = { ViewModel.dropDownIsExpanded = false }
                    ) {
                        for (machineType in MachineType.values()) {
                            Text(
                                text = machineType.name,
                                modifier = Modifier.clickable {
                                    ViewModel.machineType = machineType
                                    ViewModel.updateRecipes()
                                    ViewModel.dropDownIsExpanded = false
                                }
                            )
                        }
                    }
                }
                when (ViewModel.tab) {
                    Tab.SELECT_RECIPE -> {
                        LazyColumn {
                            items(ViewModel.recipes) { recipe ->
                                Row(
                                    modifier = Modifier
                                        .width(400.dp)
                                        .height(100.dp)
                                        .padding(horizontal = 5.dp, vertical = 2.5.dp)
                                        .background(
                                            color = Color.LightGray,
                                            shape = roundedCornerShape
                                        )
                                        .clickable { ViewModel.selectRecipe(recipe.id) },
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column {
                                        for (product in recipe.products) {
                                            ItemIcon(item = product.item)
                                        }
                                    }
                                    Text(
                                        modifier = Modifier.padding(20.dp),
                                        text = recipe.name
                                    )
                                }
                            }
                        }
                    }
                    Tab.PRODUCTION -> {
                        Row {
                            ViewModel.selectedRecipe?.let {
                                Ingredients(modifier = Modifier.padding(5.dp), recipe = it)
                                Products(modifier = Modifier.padding(5.dp), recipe = it)
                            }
                        }
                    }
                }
            }
        }
    }
}

fun calculate() {
    clock = desiredPpm / output.ppm
}

fun reset() {
    clock = 1f
}