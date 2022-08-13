package data

interface Identifiable {
    val id: String
    val name: String
}

data class Recipe(
    override val id: String,
    override val name: String,
    val isAlternate: Boolean,
    val ingredients: List<RecipeIO>,
    val products: List<RecipeIO>,
    val producedIn: List<MachineType>,
    val manualMultiplier: Float,
    val manufacturingDuration: Float
) : Identifiable

data class RecipeIO(
    val item: Item,
    val amount: Int,
    val rate: Float
)

data class Item(
    override val id: String,
    override val name: String,
    val description: String? = null,
    val itemType: String,
    val stackSize: Int,
    val canBeDiscarded: Boolean,
    val energyValue: Float,
    val radioactiveDecay: Float,
    val form: Int,
    val iconPath: String
) : Identifiable {
    val iconPathIsValid = iconPath != "images/.256.png"
}
