package data

/*
sealed interface Buildable {
    val name: String
    val description: String
    val baseType: String
}

data class Manufacturer(
    override val name: String,
    override val description: String,
    override val baseType: String,
    val manufacturingSpeed: Int
) : Buildable

data class TrainStation(
    override val name: String,
    override val description: String,
    override val baseType: String,
    val storageSizeX: Int,
    val storageSizeY: Int,
    val timeToCompleteUnload: Int,
    val timeToCompleteLoad: Int,
) : Buildable

data class ItemPassThrough(
    override val name: String,
    override val description: String,
    override val baseType: String,
    val speed: Int,
) : Buildable

data class FluidPassThrough(
    override val name: String,
    override val description: String,
    override val baseType: String,
    val speed: Int,
    val flowLimit: Int,
    val radius: Int,
) : Buildable

data class Generator(
    override val name: String,
    override val description: String,
    override val baseType: String,
    val defaultFuelClasses: List<String>,
    val powerProduction: Int,
    val powerProductionExponent: Float,
    val fuelResourceForm: Int,
    val supplementalResourceClass: String,
    val requiresSupplementalResource: Boolean,
    val supplementalLoadAmount: Int,
    val supplementalToPowerRatio: Int,
) : Buildable

data class Extractor(
    override val name: String,
    override val description: String,
    override val baseType: String,
    val extractStartupTime: Float,
    val extractCycleTime: Float,
    val itemsPerCycle: Int,
    val allowedResourceForms: List<Int>,
    val onlyAllowCertainResources: Boolean,
    val allowedResources: List<String>,
    val extractorTypeName: String,
) : Buildable

data class Restrictor(
    override val name: String,
    override val description: String,
    override val baseType: String,
    val designPressure: Int? = null,
    val maxPressure: Int? = null,
) : Buildable

data class FluidStorage(
    override val name: String,
    override val description: String,
    override val baseType: String,
    val storageCapacity: Int,
) : Buildable

data class ItemStorage(
    override val name: String,
    override val description: String,
    override val baseType: String,
    val inventorySizeX: Int,
    val inventorySizeY: Int,
) : Buildable
*/