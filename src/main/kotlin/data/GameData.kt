package data

abstract class Repository<T : Identifiable>(
    private val data: Collection<T>
) {
    fun get(predicate: (T) -> Boolean): T? =
        data.first(predicate)

    fun getAll(predicate: (T) -> Boolean): List<T> =
        data.filter(predicate)

    fun getFromId(id: String): T? =
        get { it.id == id }

    fun getFromName(name: String): T? =
        get { it.name == name }
}

object GameData {
    private val jsonData = JsonData()

    private val idToRecipe = jsonData.recipes.map { (id, jsonRecipe) ->
        recipeFromJson(id, jsonRecipe)
    }

    private val idToItem = jsonData.items.map { (id, jsonItem) ->
        itemFromJson(id, jsonItem)
    }

    object Recipes : Repository<Recipe>(idToRecipe) {
        fun getAllProducedIn(vararg machineType: MachineType): List<Recipe> =
            this.getAll { recipe ->
                recipe.producedIn.any { it in machineType }
            }

        fun getByName(name: String): Recipe? =
            get { it.name == name }

    }

    object Items : Repository<Item>(idToItem) {
        fun getByName(name: String): Recipe? =
            Recipes.get { it.name == name }
    }


    private fun recipeFromJson(
        id: String,
        jsonRecipe: JsonRecipe
    ): Recipe =
        Recipe(
            id = id,
            name = jsonRecipe.name,
            ingredients = jsonRecipe.ingredients.map { jsonIngredient ->
                recipeIOFromJson(
                    jsonRecipeIO = jsonIngredient,
                    manufacturingDuration = jsonRecipe.manufacturingDuration
                )
            },
            products = jsonRecipe.products.map { jsonProduct ->
                recipeIOFromJson(
                    jsonRecipeIO = jsonProduct,
                    manufacturingDuration = jsonRecipe.manufacturingDuration
                )
            },
            producedIn = jsonRecipe.producedIn.mapNotNull {
                MachineType.fromJsonName(it) ?: run {
                    null
                }
            },
            manualMultiplier = jsonRecipe.manualMultiplier,
            manufacturingDuration = jsonRecipe.manufacturingDuration
        )

    private fun recipeIOFromJson(
        jsonRecipeIO: JsonRecipeIO,
        manufacturingDuration: Float
    ): RecipeIO {
        val (id, jsonItem) = jsonData.getItemById(jsonRecipeIO.item)!!

        return RecipeIO(
            item = itemFromJson(id, jsonItem),
            amount = jsonRecipeIO.amount,
            rate = (60 / manufacturingDuration) * jsonRecipeIO.amount
        )
    }


    private fun itemFromJson(
        id: String,
        jsonItem: JsonItem
    ): Item =
        Item(
            id = id,
            name = jsonItem.name,
            description = jsonItem.description,
            itemType = jsonItem.itemType,
            stackSize = jsonItem.stackSize,
            canBeDiscarded = jsonItem.canBeDiscarded,
            energyValue = jsonItem.energyValue,
            radioactiveDecay = jsonItem.radioactiveDecay,
            form = jsonItem.form,
            iconPath = "images/${jsonItem.icon}.256.png"
        )

}