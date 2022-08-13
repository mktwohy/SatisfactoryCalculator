package composables

import Model
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

val roundedCornerShape = RoundedCornerShape(10.dp)

@Composable
fun SelectRecipeScreen() {
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            MachineSelector(
                machineType = Model.machineType,
                onMachineSelect = {
                    Model.selectMachine(it)
                    coroutineScope.launch {
                        Model.recipeListState.scrollToItem(0)
                    }
                },
                expanded = Model.expanded,
                onExpandedChange = { Model.expanded = !Model.expanded }
            )
            SearchBar(
                text = Model.search,
                onTextChange = {
                    Model.search = it
                    Model.search()
                }
            )
        }
    }

    LazyColumn(state = Model.recipeListState) {
        items(Model.recipes.chunked(4)) { row ->
            Row {
                for (recipe in row) {
                    RecipeThumbnail(
                        modifier = Modifier.width(150.dp).height(200.dp),
                        recipe = recipe,
                        onClick = Model::selectRecipe
                    )
                }
            }
        }
    }
}



@Composable
fun ProductionScreen() {
    Row {
        Model.selectedRecipe?.let {
            Ingredients(modifier = Modifier.padding(5.dp), recipe = it)
            Products(modifier = Modifier.padding(5.dp), recipe = it)
        }
    }
}