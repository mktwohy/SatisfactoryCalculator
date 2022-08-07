package data

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

private inline fun <reified T> decodeAll(
    fileName: String,
    directory: String = "src/main/resources/json/"
): Map<String, T> =
    Json.decodeFromString(
        File("$directory/$fileName").readText()
    )

abstract class Repository<T>(
    private val deserializedData: Map<String, T>
) {
    fun getAll(predicate: (T) -> Boolean): List<T> =
        deserializedData.values.filter { predicate(it) }

    fun get(name: String): T? =
        deserializedData[name]

}

object Buildings : Repository<Building>(
    deserializedData = decodeAll("Buildings.json")
) {
    fun getAll(vararg buildingType: BuildingType): List<Building> =
        getAll { it.type in buildingType }
}

object Connections : Repository<Connection>(
    deserializedData = decodeAll("Connections.json")
)

object Items : Repository<Item>(
    deserializedData = decodeAll("Items.json")
)

object Recipes : Repository<Recipes>(
    deserializedData = decodeAll("Recipes.json")
)