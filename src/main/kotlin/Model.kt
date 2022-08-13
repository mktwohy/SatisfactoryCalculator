import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import composables.ScreenTab
import data.GameData
import data.MachineType
import data.Recipe
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

object Model {
    var selectedRecipe: Recipe? by mutableStateOf(null)
    var machineType: MachineType? by mutableStateOf(null)
    var tab by mutableStateOf(ScreenTab.SELECT_RECIPE)
    var recipes: List<Recipe> by mutableStateOf(listOf())
    var search by mutableStateOf("")
    var expanded by mutableStateOf(false)
    val recipeListState = LazyListState()

    init {
        updateRecipes()
    }

    fun search() {
        recipes = GameData.Recipes.search(search)
    }

    fun updateRecipes() {
        recipes = machineType?.let {
            GameData.Recipes.getAllProducedIn(it)
        } ?: GameData.Recipes.getAll { true }
    }

    fun selectRecipe(recipe: Recipe) {
        selectedRecipe = recipe
        tab = ScreenTab.PRODUCTION
    }

    fun selectMachine(machineType: MachineType?) {
        this.machineType = machineType
        updateRecipes()
    }
}