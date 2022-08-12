package data

import kotlinx.serialization.Serializable

@Serializable
data class JsonBuilding(
    val name: String,
    val description: String,
    val baseType: String,
    private val buildingType: String,

    // buildingType: most but not all
    val powerConsumption: Int? = null,
    val powerConsumptionExponent: Float? = null,
    val minPotential: Float? = null,
    val maxPotential: Float? = null,
    val maxPotentialIncreasePerCrystal: Float? = null,

    // buildingType: ITEMFLOWMANIPULATOR & FLUIDFLOWMANIPULATOR & SINK
    // no unique values

    // buildingType: MANUFACTURER
    val manufacturingSpeed: Int? = null,

    // buildingType: TRAINSTATION
    val storageSizeX: Int? = null,
    val storageSizeY: Int? = null,
    val timeToCompleteUnload: Int? = null,
    val timeToCompleteLoad: Int? = null,

    // buildingType: ITEMPASSTHROUGH
    val speed: Int? = null,

    // buildingType: ITEMPASSTHROUGH & FLUIDPASSTHROUGH
    val supportedResourceForms: List<Int>? = null,

    // buildingType: GENERATOR
    val defaultFuelClasses: List<String>? = null,
    val powerProduction: Int? = null,
    val powerProductionExponent: Float? = null,
    val fuelResourceForm: Int? = null,
    val supplementalResourceClass: String? = null,
    val requiresSupplementalResource: Boolean? = null,
    val supplementalLoadAmount: Int? = null,
    val supplementalToPowerRatio: Int? = null,

    // buildingType: EXTRACTOR
    val extractStartupTime: Float? = null,
    val extractCycleTime: Float? = null,
    val itemsPerCycle: Int? = null,
    val allowedResourceForms: List<Int>? = null,
    val onlyAllowCertainResources: Boolean? = null,
    val allowedResources: List<String>? = null,
    val extractorTypeName: String? = null,

    // buildingType: FLUIDSTORAGE
    val storageCapacity: Int? = null,

    // buildingType: FLUIDPASSTHROUGH
    val flowLimit: Int? = null,
    val radius: Int? = null,

    // buildingType: RESTRICTOR
    val designPressure: Int? = null,
    val maxPressure: Int? = null,

    // buildingType: ITEMSTORAGE
    val inventorySizeX: Int? = null,
    val inventorySizeY: Int? = null,

    // buildingType: TRUCKSTATION
    val transferSpeed: Float? = null,
    val fuelTransferSpeed: Int? = null,
) {
    val type = BuildingType.fromJsonName(buildingType)
}

@Serializable
data class JsonConnection(
    val inputBelts: Int? = null,
    val outputBelts: Int? = null,
    val inputPipes: Int? = null,
    val outputPipes: Int? = null,
    val anyPipes: Int? = null
)

@Serializable
data class JsonItem(
    val name: String,
    val description: String? = null,
    val itemType: String,
    val stackSize: Int,
    val canBeDiscarded: Boolean,
    val energyValue: Float,
    val radioactiveDecay: Float,
    val form: Int,
    val icon: String
)

@Serializable
data class JsonRecipe(
    val name: String,
    val ingredients: List<JsonRecipeIO>,
    val products: List<JsonRecipeIO>,
    val producedIn: List<String>,
    val manualMultiplier: Float,
    val manufacturingDuration: Float
)

@Serializable
data class JsonRecipeIO(
    val item: String,
    val amount: Int
)