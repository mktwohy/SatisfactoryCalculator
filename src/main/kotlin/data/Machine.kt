package data

enum class Machine(val numInput: Int, val numOutput: Int) {
    EQUIPMENT_WORKSHOP(0,0),

    SMELTER(1,1),
    CONSTRUCTOR (1, 1),
    ASSEMBLER (2, 1),
    MANUFACTURER (4, 1),
    REFINERY(1, 2),
    PACKAGER(1, 1),
    FOUNDRY(2, 1),
    BLENDER(1,1),
    PARTICLE_ACCELERATOR(2,1)
}
