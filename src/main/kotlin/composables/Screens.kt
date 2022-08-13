package composables

import AppModel
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.Recipe
import kotlinx.coroutines.launch
import javax.swing.ViewportLayout

val roundedCornerShape = RoundedCornerShape(10.dp)

@Composable
fun SelectRecipeScreen() {
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            MachineSelector(
                machineType = AppModel.machineType,
                onMachineSelect = {
                    AppModel.selectMachine(it)
                    coroutineScope.launch {
                        AppModel.recipeListState.scrollToItem(0)
                    }
                },
                expanded = AppModel.expanded,
                onExpandedChange = { AppModel.expanded = !AppModel.expanded }
            )
            SearchBar(
                text = AppModel.search,
                onTextChange = {
                    AppModel.search = it
                    AppModel.search()
                }
            )
        }
    }

    LazyColumn(state = AppModel.recipeListState) {
        items(AppModel.recipes.chunked(4)) { row ->
            Row {
                for (recipe in row) {
                    RecipeThumbnail(
                        modifier = Modifier.width(150.dp).height(200.dp),
                        recipe = recipe,
                        onClick = AppModel::selectRecipe
                    )
                }
            }
        }
    }
}



@Composable
fun ProductionScreen() {
    Row {
        AppModel.selectedRecipe?.let {
            Ingredients(modifier = Modifier.padding(5.dp), recipe = it)
            Products(modifier = Modifier.padding(5.dp), recipe = it)
        }
    }
}