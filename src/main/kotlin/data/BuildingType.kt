package data

enum class BuildingType(val jsonName: String) {
    MANUFACTURER("MANUFACTURER"),
    GENERATOR("GENERATOR"),
    EXTRACTOR("EXTRACTOR"),
    RESTRICTOR("RESTRICTOR"),
    ITEM_STORAGE("ITEMSTORAGE"),
    FLUID_STORAGE("FLUIDSTORAGE"),
    TRAIN_STATION("TRAINSTATION"),
    TRUCK_STATION("TRUCKSTATION"),
    ITEM_PASS_THROUGH("ITEMPASSTHROUGH"),
    FLUID_PASS_THROUGH("FLUIDPASSTHROUGH"),
    ITEM_FLOW_MANIPULATOR("ITEMFLOWMANIPULATOR"),
    FLUID_FLOW_MANIPULATOR("FLUIDFLOWMANIPULATOR");

    companion object {
        private val jsonNameMapping = values().associateBy { it.jsonName }

        fun fromJsonName(jsonName: String): BuildingType? =
            jsonNameMapping[jsonName]
    }
}