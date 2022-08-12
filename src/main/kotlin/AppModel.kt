import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import data.GameData
import data.MachineType
import data.Recipe

enum class Tab { SELECT_RECIPE, PRODUCTION }

object AppModel {
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