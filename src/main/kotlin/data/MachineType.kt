package data

import extensions.formatFromEnum

enum class MachineType(val numInput: Int, val numOutput: Int, val jsonName: String) {
    BUILD_GUN(0, 0, "building-build-gun"),
    EQUIPMENT_WORKSHOP(0,0, "building-workshop-component"),
    WORK_BENCH(0, 0, "building-work-bench-component"),
    SMELTER(1,1, "building-smelter-mk1"),
    CONSTRUCTOR (1, 1, "building-constructor-mk1"),
    ASSEMBLER (2, 1, "building-assembler-mk1"),
    MANUFACTURER (4, 1, "building-manufacturer-mk1"),
    REFINERY(1, 2, "building-oil-refinery"),
    PACKAGER(1, 1, "building-packager"),
    FOUNDRY(2, 1, "building-foundry-mk1");

    // in game, but not included in json:
//    BLENDER(1,1),
//    PARTICLE_ACCELERATOR(2,1);

    companion object {
        private val jsonNameMapping = values().associateBy { it.jsonName }

        fun fromJsonName(jsonName: String): MachineType? =
            jsonNameMapping[jsonName]

        val MachineType?.formattedName: String get() =
            this?.name?.formatFromEnum() ?: "Any Machine"
    }
}

