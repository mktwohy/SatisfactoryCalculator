package data

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.util.function.BiPredicate

class JsonData(
    buildingsFileName: String = "Buildings.json",
    connectionsFileName: String = "Connections.json",
    itemsFileName: String = "Items.json",
    recipesFileName: String = "Recipes.json",
) {
    val buildings = decodeAll<JsonBuilding>(buildingsFileName)
    val connections = decodeAll<JsonConnection>(connectionsFileName)
    val items = decodeAll<JsonItem>(itemsFileName)
    val recipes = decodeAll<JsonRecipe>(recipesFileName)


    fun getItem(
        predicate: (Pair<String, JsonItem>) -> Boolean
    ): Pair<String, JsonItem>? =
        items.toList().find { predicate(it) }

    fun getItemById(id: String): Pair<String, JsonItem>? =
        getItem { (itemId, _) -> itemId == id }

    fun getRecipe(
        predicate: (Pair<String, JsonRecipe>) -> Boolean
    ): Pair<String, JsonRecipe>? =
        recipes.toList().find { predicate(it) }

    fun getRecipeById(id: String): Pair<String, JsonItem>? =
        getItem { (recipeId, _) -> recipeId == id }

    private inline fun <reified T> decodeAll(
        fileName: String,
        directory: String = "src/main/resources/json/"
    ): Map<String, T> =
        Json.decodeFromString(
            File("$directory/$fileName").readText()
        )
}
