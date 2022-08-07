package data

data class PartIO(val part: Part, val rate: Float)

enum class Recipe(
    val machine: Machine,
    val inputs: List<PartIO>,
    val output: PartIO,
    val isAlternate: Boolean
) {

    ADAPTIVE_CONTROL_UNIT(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.AUTOMATED_WIRING, 7.5f),
            PartIO(Part.CIRCUIT_BOARD, 5.0f),
            PartIO(Part.HEAVY_MODULAR_FRAME, 1.0f),
            PartIO(Part.COMPUTER, 1.0f)
        ),
        output = PartIO(Part.ADAPTIVE_CONTROL_UNIT, 1.0f),
        isAlternate = false
    ),

    AI_LIMITER(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.COPPER_SHEET, 25.0f),
            PartIO(Part.QUICKWIRE, 100.0f)
        ),
        output = PartIO(Part.AI_LIMITER, 5.0f),
        isAlternate = false
    ),

    ALCLAD_ALUMINUM_SHEET(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.ALUMINUM_INGOT, 30.0f),
            PartIO(Part.COPPER_INGOT, 10.0f)
        ),
        output = PartIO(Part.ALCLAD_ALUMINUM_SHEET, 30.0f),
        isAlternate = false
    ),

    ALUMINA_SOLUTION(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.BAUXITE, 120.0f),
            PartIO(Part.WATER, 180.0f)
        ),
        output = PartIO(Part.ALUMINA_SOLUTION, 120.0f),
        isAlternate = false
    ),

    UNPACKAGE_ALUMINA_SOLUTION(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_ALUMINA_SOLUTION, 120.0f)
        ),
        output = PartIO(Part.ALUMINA_SOLUTION, 120.0f),
        isAlternate = true
    ),

    SLOPPY_ALUMINA(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.BAUXITE, 200.0f),
            PartIO(Part.WATER, 200.0f)
        ),
        output = PartIO(Part.ALUMINA_SOLUTION, 240.0f),
        isAlternate = true
    ),

    ALUMINUM_CASING(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.ALUMINUM_INGOT, 90.0f)
        ),
        output = PartIO(Part.ALUMINUM_CASING, 60.0f),
        isAlternate = false
    ),

    ALCLAD_CASING(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.ALUMINUM_INGOT, 150.0f),
            PartIO(Part.COPPER_INGOT, 75.0f)
        ),
        output = PartIO(Part.ALUMINUM_CASING, 112.5f),
        isAlternate = true
    ),

    ALUMINUM_INGOT(
        machine = Machine.FOUNDRY,
        inputs = listOf(
            PartIO(Part.ALUMINUM_SCRAP, 90.0f),
            PartIO(Part.SILICA, 75.0f)
        ),
        output = PartIO(Part.ALUMINUM_INGOT, 60.0f),
        isAlternate = false
    ),

    PURE_ALUMINUM_INGOT(
        machine = Machine.SMELTER,
        inputs = listOf(
            PartIO(Part.ALUMINUM_SCRAP, 60.0f)
        ),
        output = PartIO(Part.ALUMINUM_INGOT, 30.0f),
        isAlternate = true
    ),

    ALUMINUM_SCRAP(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.ALUMINA_SOLUTION, 240.0f),
            PartIO(Part.COAL, 120.0f)
        ),
        output = PartIO(Part.ALUMINUM_SCRAP, 360.0f),
        isAlternate = false
    ),

    ELECTRODE___ALUMINUM_SCRAP(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.ALUMINA_SOLUTION, 180.0f),
            PartIO(Part.PETROLEUM_COKE, 60.0f)
        ),
        output = PartIO(Part.ALUMINUM_SCRAP, 300.0f),
        isAlternate = true
    ),

    INSTANT_SCRAP(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.BAUXITE, 150.0f),
            PartIO(Part.COAL, 100.0f),
            PartIO(Part.SULFURIC_ACID, 50.0f),
            PartIO(Part.WATER, 60.0f)
        ),
        output = PartIO(Part.ALUMINUM_SCRAP, 300.0f),
        isAlternate = true
    ),

    ASSEMBLY_DIRECTOR_SYSTEM(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.ADAPTIVE_CONTROL_UNIT, 1.5f),
            PartIO(Part.SUPERCOMPUTER, 0.75f)
        ),
        output = PartIO(Part.ASSEMBLY_DIRECTOR_SYSTEM, 0.75f),
        isAlternate = false
    ),

    AUTOMATED_WIRING(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.STATOR, 2.5f),
            PartIO(Part.CABLE, 50.0f)
        ),
        output = PartIO(Part.AUTOMATED_WIRING, 2.5f),
        isAlternate = false
    ),

    AUTOMATED_SPEED_WIRING(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.STATOR, 3.75f),
            PartIO(Part.WIRE, 75.0f),
            PartIO(Part.HIGH_SPEED_CONNECTOR, 1.875f)
        ),
        output = PartIO(Part.AUTOMATED_WIRING, 7.5f),
        isAlternate = true
    ),

    BATTERY(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.SULFURIC_ACID, 50.0f),
            PartIO(Part.ALUMINA_SOLUTION, 40.0f),
            PartIO(Part.ALUMINUM_CASING, 20.0f)
        ),
        output = PartIO(Part.BATTERY, 20.0f),
        isAlternate = false
    ),

    CLASSIC_BATTERY(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.SULFUR, 45.0f),
            PartIO(Part.ALCLAD_ALUMINUM_SHEET, 52.5f),
            PartIO(Part.PLASTIC, 60.0f),
            PartIO(Part.WIRE, 90.0f)
        ),
        output = PartIO(Part.BATTERY, 30.0f),
        isAlternate = true
    ),

    BEACON(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.IRON_PLATE, 22.5f),
            PartIO(Part.IRON_ROD, 7.5f),
            PartIO(Part.WIRE, 112.5f),
            PartIO(Part.CABLE, 15.0f)
        ),
        output = PartIO(Part.BEACON, 7.5f),
        isAlternate = false
    ),

    CRYSTAL_BEACON(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.STEEL_BEAM, 2.0f),
            PartIO(Part.STEEL_PIPE, 8.0f),
            PartIO(Part.CRYSTAL_OSCILLATOR, 0.5f)
        ),
        output = PartIO(Part.BEACON, 10.0f),
        isAlternate = true
    ),

    BIOMASS_ALIEN_CARAPACE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.ALIEN_CARAPACE, 15.0f)
        ),
        output = PartIO(Part.BIOMASS, 1500.0f),
        isAlternate = true
    ),

    BIOMASS_ALIEN_ORGANS(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.ALIEN_ORGANS, 7.5f)
        ),
        output = PartIO(Part.BIOMASS, 1500.0f),
        isAlternate = true
    ),

    BIOMASS_LEAVES(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.LEAVES, 120.0f)
        ),
        output = PartIO(Part.BIOMASS, 60.0f),
        isAlternate = true
    ),

    BIOMASS_MYCELIA(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.MYCELIA, 150.0f)
        ),
        output = PartIO(Part.BIOMASS, 150.0f),
        isAlternate = true
    ),

    BIOMASS_WOOD(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.WOOD, 60.0f)
        ),
        output = PartIO(Part.BIOMASS, 300.0f),
        isAlternate = true
    ),

    BLACK_POWDER(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.COAL, 7.5f),
            PartIO(Part.SULFUR, 15.0f)
        ),
        output = PartIO(Part.BLACK_POWDER, 7.5f),
        isAlternate = false
    ),

    FINE_BLACK_POWDER(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.SULFUR, 7.5f),
            PartIO(Part.COMPACTED_COAL, 3.75f)
        ),
        output = PartIO(Part.BLACK_POWDER, 15.0f),
        isAlternate = true
    ),

    BLADE_RUNNERS(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.QUICKWIRE, -1.0f),
            PartIO(Part.MODULAR_FRAME, -1.0f),
            PartIO(Part.ROTOR, -1.0f)
        ),
        output = PartIO(Part.BLADE_RUNNERS, -1.0f),
        isAlternate = false
    ),

    CABLE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.WIRE, 60.0f)
        ),
        output = PartIO(Part.CABLE, 30.0f),
        isAlternate = false
    ),

    INSULATED_CABLE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.WIRE, 45.0f),
            PartIO(Part.RUBBER, 30.0f)
        ),
        output = PartIO(Part.CABLE, 100.0f),
        isAlternate = true
    ),

    QUICKWIRE_CABLE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.QUICKWIRE, 7.5f),
            PartIO(Part.RUBBER, 5.0f)
        ),
        output = PartIO(Part.CABLE, 27.5f),
        isAlternate = true
    ),

    COATED_CABLE(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.WIRE, 37.5f),
            PartIO(Part.HEAVY_OIL_RESIDUE, 15.0f)
        ),
        output = PartIO(Part.CABLE, 67.5f),
        isAlternate = true
    ),

    CATERIUM_INGOT(
        machine = Machine.SMELTER,
        inputs = listOf(
            PartIO(Part.CATERIUM_ORE, 45.0f)
        ),
        output = PartIO(Part.CATERIUM_INGOT, 15.0f),
        isAlternate = false
    ),

    PURE_CATERIUM_INGOT(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.CATERIUM_ORE, 24.0f),
            PartIO(Part.WATER, 24.0f)
        ),
        output = PartIO(Part.CATERIUM_INGOT, 12.0f),
        isAlternate = true
    ),

    CHAINSAW(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.REINFORCED_IRON_PLATE, -1.0f),
            PartIO(Part.IRON_ROD, -1.0f),
            PartIO(Part.SCREW, -1.0f),
            PartIO(Part.CABLE, -1.0f)
        ),
        output = PartIO(Part.CHAINSAW, -1.0f),
        isAlternate = false
    ),

    CIRCUIT_BOARD(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.COPPER_SHEET, 15.0f),
            PartIO(Part.PLASTIC, 30.0f)
        ),
        output = PartIO(Part.CIRCUIT_BOARD, 7.5f),
        isAlternate = false
    ),

    SILICON_CIRCUIT_BOARD(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.COPPER_SHEET, 27.5f),
            PartIO(Part.SILICA, 27.5f)
        ),
        output = PartIO(Part.CIRCUIT_BOARD, 12.5f),
        isAlternate = true
    ),

    CATERIUM_CIRCUIT_BOARD(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.PLASTIC, 12.5f),
            PartIO(Part.QUICKWIRE, 37.5f)
        ),
        output = PartIO(Part.CIRCUIT_BOARD, 8.75f),
        isAlternate = true
    ),

    ELECTRODE_CIRCUIT_BOARD(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.RUBBER, 30.0f),
            PartIO(Part.PETROLEUM_COKE, 45.0f)
        ),
        output = PartIO(Part.CIRCUIT_BOARD, 5.0f),
        isAlternate = true
    ),

    CHARCOAL(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.WOOD, 15.0f)
        ),
        output = PartIO(Part.COAL, 150.0f),
        isAlternate = true
    ),

    BIOCOAL(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.BIOMASS, 37.5f)
        ),
        output = PartIO(Part.COAL, 45.0f),
        isAlternate = true
    ),

    COLOR_CARTRIDGE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.FLOWER_PETALS, 37.5f)
        ),
        output = PartIO(Part.COLOR_CARTRIDGE, 75.0f),
        isAlternate = false
    ),

    COMPACTED_COAL(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.COAL, 25.0f),
            PartIO(Part.SULFUR, 25.0f)
        ),
        output = PartIO(Part.COMPACTED_COAL, 25.0f),
        isAlternate = true
    ),

    COMPUTER(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.CIRCUIT_BOARD, 25.0f),
            PartIO(Part.CABLE, 22.5f),
            PartIO(Part.PLASTIC, 45.0f),
            PartIO(Part.SCREW, 130.0f)
        ),
        output = PartIO(Part.COMPUTER, 2.5f),
        isAlternate = false
    ),

    CATERIUM_COMPUTER(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.CIRCUIT_BOARD, 26.25f),
            PartIO(Part.QUICKWIRE, 105.0f),
            PartIO(Part.RUBBER, 45.0f)
        ),
        output = PartIO(Part.COMPUTER, 3.75f),
        isAlternate = true
    ),

    CRYSTAL_COMPUTER(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.CIRCUIT_BOARD, 7.5f),
            PartIO(Part.CRYSTAL_OSCILLATOR, 2.8125f)
        ),
        output = PartIO(Part.COMPUTER, 2.8125f),
        isAlternate = true
    ),

    CONCRETE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.LIMESTONE, 45.0f)
        ),
        output = PartIO(Part.CONCRETE, 15.0f),
        isAlternate = false
    ),

    FINE_CONCRETE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.SILICA, 7.5f),
            PartIO(Part.LIMESTONE, 30.0f)
        ),
        output = PartIO(Part.CONCRETE, 25.0f),
        isAlternate = true
    ),

    RUBBER_CONCRETE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.LIMESTONE, 50.0f),
            PartIO(Part.RUBBER, 10.0f)
        ),
        output = PartIO(Part.CONCRETE, 45.0f),
        isAlternate = true
    ),

    WET_CONCRETE(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.LIMESTONE, 120.0f),
            PartIO(Part.WATER, 100.0f)
        ),
        output = PartIO(Part.CONCRETE, 80.0f),
        isAlternate = true
    ),

    COOLING_SYSTEM(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.HEAT_SINK, 12.0f),
            PartIO(Part.RUBBER, 12.0f),
            PartIO(Part.WATER, 30.0f),
            PartIO(Part.NITROGEN_GAS, 150.0f)
        ),
        output = PartIO(Part.COOLING_SYSTEM, 6.0f),
        isAlternate = false
    ),

    COOLING_DEVICE(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.HEAT_SINK, 9.375f),
            PartIO(Part.MOTOR, 1.875f),
            PartIO(Part.NITROGEN_GAS, 45.0f)
        ),
        output = PartIO(Part.COOLING_SYSTEM, 3.75f),
        isAlternate = true
    ),

    COPPER_INGOT(
        machine = Machine.SMELTER,
        inputs = listOf(
            PartIO(Part.COPPER_ORE, 30.0f)
        ),
        output = PartIO(Part.COPPER_INGOT, 30.0f),
        isAlternate = false
    ),

    COPPER_ALLOY_INGOT(
        machine = Machine.FOUNDRY,
        inputs = listOf(
            PartIO(Part.COPPER_ORE, 50.0f),
            PartIO(Part.IRON_ORE, 25.0f)
        ),
        output = PartIO(Part.COPPER_INGOT, 100.0f),
        isAlternate = true
    ),

    PURE_COPPER_INGOT(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.COPPER_ORE, 15.0f),
            PartIO(Part.WATER, 10.0f)
        ),
        output = PartIO(Part.COPPER_INGOT, 37.5f),
        isAlternate = true
    ),

    COPPER_POWDER(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.COPPER_INGOT, 300.0f)
        ),
        output = PartIO(Part.COPPER_POWDER, 50.0f),
        isAlternate = false
    ),

    COPPER_SHEET(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.COPPER_INGOT, 20.0f)
        ),
        output = PartIO(Part.COPPER_SHEET, 10.0f),
        isAlternate = false
    ),

    STEAMED_COPPER_SHEET(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.COPPER_INGOT, 22.5f),
            PartIO(Part.WATER, 22.5f)
        ),
        output = PartIO(Part.COPPER_SHEET, 22.5f),
        isAlternate = true
    ),

    UNPACKAGE_OIL(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_OIL, 60.0f)
        ),
        output = PartIO(Part.CRUDE_OIL, 60.0f),
        isAlternate = true
    ),

    CRYSTAL_OSCILLATOR(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.QUARTZ_CRYSTAL, 18.0f),
            PartIO(Part.CABLE, 14.0f),
            PartIO(Part.REINFORCED_IRON_PLATE, 2.5f)
        ),
        output = PartIO(Part.CRYSTAL_OSCILLATOR, 1.0f),
        isAlternate = false
    ),

    INSULATED_CRYSTAL_OSCILLATOR(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.QUARTZ_CRYSTAL, 18.75f),
            PartIO(Part.RUBBER, 13.125f),
            PartIO(Part.AI_LIMITER, 1.875f)
        ),
        output = PartIO(Part.CRYSTAL_OSCILLATOR, 1.875f),
        isAlternate = true
    ),

    ELECTROMAGNETIC_CONTROL_ROD(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.STATOR, 6.0f),
            PartIO(Part.AI_LIMITER, 4.0f)
        ),
        output = PartIO(Part.ELECTROMAGNETIC_CONTROL_ROD, 4.0f),
        isAlternate = false
    ),

    ELECTROMAGNETIC_CONNECTION_ROD(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.STATOR, 8.0f),
            PartIO(Part.HIGH_SPEED_CONNECTOR, 4.0f)
        ),
        output = PartIO(Part.ELECTROMAGNETIC_CONTROL_ROD, 8.0f),
        isAlternate = true
    ),

    EMPTY_FLUID_TANK(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.ALUMINUM_INGOT, 60.0f)
        ),
        output = PartIO(Part.EMPTY_FLUID_TANK, 60.0f),
        isAlternate = false
    ),

    UNPACKAGE_NITRIC_ACID(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_NITRIC_ACID, 20.0f)
        ),
        output = PartIO(Part.NITRIC_ACID, 20.0f),
        isAlternate = true
    ),

    UNPACKAGE_NITROGEN_GAS(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_NITROGEN_GAS, 60.0f)
        ),
        output = PartIO(Part.NITROGEN_GAS, 240.0f),
        isAlternate = true
    ),

    ENCASED_INDUSTRIAL_BEAM(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.STEEL_BEAM, 24.0f),
            PartIO(Part.CONCRETE, 30.0f)
        ),
        output = PartIO(Part.ENCASED_INDUSTRIAL_BEAM, 6.0f),
        isAlternate = false
    ),

    ENCASED_INDUSTRIAL_PIPE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.STEEL_PIPE, 28.0f),
            PartIO(Part.CONCRETE, 20.0f)
        ),
        output = PartIO(Part.ENCASED_INDUSTRIAL_BEAM, 4.0f),
        isAlternate = true
    ),

    ENCASED_PLUTONIUM_CELL(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.PLUTONIUM_PELLET, 10.0f),
            PartIO(Part.CONCRETE, 20.0f)
        ),
        output = PartIO(Part.ENCASED_PLUTONIUM_CELL, 5.0f),
        isAlternate = false
    ),

    INSTANT_PLUTONIUM_CELL(
        machine = Machine.PARTICLE_ACCELERATOR,
        inputs = listOf(
            PartIO(Part.NON_FISSILE_URANIUM, 75.0f),
            PartIO(Part.ALUMINUM_CASING, 10.0f)
        ),
        output = PartIO(Part.ENCASED_PLUTONIUM_CELL, 10.0f),
        isAlternate = true
    ),

    ENCASED_URANIUM_CELL(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.URANIUM, 50.0f),
            PartIO(Part.CONCRETE, 15.0f),
            PartIO(Part.SULFURIC_ACID, 40.0f)
        ),
        output = PartIO(Part.ENCASED_URANIUM_CELL, 25.0f),
        isAlternate = false
    ),

    INFUSED_URANIUM_CELL(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.URANIUM, 25.0f),
            PartIO(Part.SILICA, 15.0f),
            PartIO(Part.SULFUR, 25.0f),
            PartIO(Part.QUICKWIRE, 75.0f)
        ),
        output = PartIO(Part.ENCASED_URANIUM_CELL, 20.0f),
        isAlternate = true
    ),

    FABRIC(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.MYCELIA, 15.0f),
            PartIO(Part.BIOMASS, 75.0f)
        ),
        output = PartIO(Part.FABRIC, 15.0f),
        isAlternate = false
    ),

    POLYESTER_FABRIC(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.POLYMER_RESIN, 80.0f),
            PartIO(Part.WATER, 50.0f)
        ),
        output = PartIO(Part.FABRIC, 5.0f),
        isAlternate = true
    ),

    FACTORY_CART(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.REINFORCED_IRON_PLATE, -1.0f),
            PartIO(Part.IRON_ROD, -1.0f),
            PartIO(Part.ROTOR, -1.0f)
        ),
        output = PartIO(Part.FACTORY_CART, -1.0f),
        isAlternate = true
    ),

    FUEL(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.CRUDE_OIL, 60.0f)
        ),
        output = PartIO(Part.FUEL, 40.0f),
        isAlternate = false
    ),

    RESIDUAL_FUEL(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.HEAVY_OIL_RESIDUE, 60.0f)
        ),
        output = PartIO(Part.FUEL, 40.0f),
        isAlternate = true
    ),

    UNPACKAGE_FUEL(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_FUEL, 60.0f)
        ),
        output = PartIO(Part.FUEL, 60.0f),
        isAlternate = true
    ),

    DILUTED_FUEL(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.HEAVY_OIL_RESIDUE, 50.0f),
            PartIO(Part.WATER, 100.0f)
        ),
        output = PartIO(Part.FUEL, 100.0f),
        isAlternate = true
    ),

    FUSED_MODULAR_FRAME(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.HEAVY_MODULAR_FRAME, 1.5f),
            PartIO(Part.ALUMINUM_CASING, 75.0f),
            PartIO(Part.NITROGEN_GAS, 37.5f)
        ),
        output = PartIO(Part.FUSED_MODULAR_FRAME, 1.5f),
        isAlternate = false
    ),

    HEAT_FUSED_FRAME(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.HEAVY_MODULAR_FRAME, 3.0f),
            PartIO(Part.ALUMINUM_INGOT, 150.0f),
            PartIO(Part.NITRIC_ACID, 24.0f),
            PartIO(Part.FUEL, 30.0f)
        ),
        output = PartIO(Part.FUSED_MODULAR_FRAME, 3.0f),
        isAlternate = true
    ),

    GAS_FILTER(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.COAL, 37.5f),
            PartIO(Part.RUBBER, 15.0f),
            PartIO(Part.FABRIC, 15.0f)
        ),
        output = PartIO(Part.GAS_FILTER, 7.5f),
        isAlternate = false
    ),

    GAS_MASK(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.RUBBER, -1.0f),
            PartIO(Part.PLASTIC, -1.0f),
            PartIO(Part.FABRIC, -1.0f)
        ),
        output = PartIO(Part.GAS_MASK, -1.0f),
        isAlternate = false
    ),

    GOLDEN_FACTORY_CART(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.CATERIUM_INGOT, -1.0f),
            PartIO(Part.IRON_ROD, -1.0f),
            PartIO(Part.ROTOR, -1.0f)
        ),
        output = PartIO(Part.GOLDEN_FACTORY_CART, -1.0f),
        isAlternate = true
    ),

    HAZMAT_SUIT(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.RUBBER, -1.0f),
            PartIO(Part.PLASTIC, -1.0f),
            PartIO(Part.ALCLAD_ALUMINUM_SHEET, -1.0f),
            PartIO(Part.FABRIC, -1.0f)
        ),
        output = PartIO(Part.HAZMAT_SUIT, -1.0f),
        isAlternate = false
    ),

    HEAT_SINK(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.ALCLAD_ALUMINUM_SHEET, 37.5f),
            PartIO(Part.COPPER_SHEET, 22.5f)
        ),
        output = PartIO(Part.HEAT_SINK, 7.5f),
        isAlternate = false
    ),

    HEAT_EXCHANGER(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.ALUMINUM_CASING, 30.0f),
            PartIO(Part.RUBBER, 30.0f)
        ),
        output = PartIO(Part.HEAT_SINK, 10.0f),
        isAlternate = true
    ),

    HEAVY_MODULAR_FRAME(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.MODULAR_FRAME, 10.0f),
            PartIO(Part.STEEL_PIPE, 30.0f),
            PartIO(Part.ENCASED_INDUSTRIAL_BEAM, 10.0f),
            PartIO(Part.SCREW, 200.0f)
        ),
        output = PartIO(Part.HEAVY_MODULAR_FRAME, 2.0f),
        isAlternate = false
    ),

    HEAVY_FLEXIBLE_FRAME(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.MODULAR_FRAME, 18.75f),
            PartIO(Part.ENCASED_INDUSTRIAL_BEAM, 11.25f),
            PartIO(Part.RUBBER, 75.0f),
            PartIO(Part.SCREW, 390.0f)
        ),
        output = PartIO(Part.HEAVY_MODULAR_FRAME, 3.75f),
        isAlternate = true
    ),

    HEAVY_ENCASED_FRAME(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.MODULAR_FRAME, 7.5f),
            PartIO(Part.ENCASED_INDUSTRIAL_BEAM, 9.375f),
            PartIO(Part.STEEL_PIPE, 33.75f),
            PartIO(Part.CONCRETE, 20.625f)
        ),
        output = PartIO(Part.HEAVY_MODULAR_FRAME, 2.8125f),
        isAlternate = true
    ),

    PLASTIC(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.CRUDE_OIL, 30.0f)
        ),
        output = PartIO(Part.PLASTIC, 20.0f),
        isAlternate = false
    ),

    RUBBER(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.CRUDE_OIL, 30.0f)
        ),
        output = PartIO(Part.RUBBER, 20.0f),
        isAlternate = false
    ),

    UNPACKAGE_HEAVY_OIL_RESIDUE(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_HEAVY_OIL_RESIDUE, 20.0f)
        ),
        output = PartIO(Part.HEAVY_OIL_RESIDUE, 20.0f),
        isAlternate = true
    ),

    HEAVY_OIL_RESIDUE(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.CRUDE_OIL, 30.0f)
        ),
        output = PartIO(Part.HEAVY_OIL_RESIDUE, 40.0f),
        isAlternate = true
    ),

    POLYMER_RESIN(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.CRUDE_OIL, 60.0f)
        ),
        output = PartIO(Part.POLYMER_RESIN, 130.0f),
        isAlternate = true
    ),

    HIGH_SPEED_CONNECTOR(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.QUICKWIRE, 210.0f),
            PartIO(Part.CABLE, 37.5f),
            PartIO(Part.CIRCUIT_BOARD, 3.75f)
        ),
        output = PartIO(Part.HIGH_SPEED_CONNECTOR, 3.75f),
        isAlternate = false
    ),

    SILICON_HIGH_SPEED_CONNECTOR(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.QUICKWIRE, 90.0f),
            PartIO(Part.SILICA, 37.5f),
            PartIO(Part.CIRCUIT_BOARD, 3.0f)
        ),
        output = PartIO(Part.HIGH_SPEED_CONNECTOR, 3.0f),
        isAlternate = true
    ),

    HOVER_PACK(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.MOTOR, -1.0f),
            PartIO(Part.HEAVY_MODULAR_FRAME, -1.0f),
            PartIO(Part.COMPUTER, -1.0f),
            PartIO(Part.ALCLAD_ALUMINUM_SHEET, -1.0f)
        ),
        output = PartIO(Part.HOVER_PACK, -1.0f),
        isAlternate = false
    ),

    IODINE_INFUSED_FILTER(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.GAS_FILTER, 3.75f),
            PartIO(Part.QUICKWIRE, 30.0f),
            PartIO(Part.ALUMINUM_CASING, 3.75f)
        ),
        output = PartIO(Part.IODINE_INFUSED_FILTER, 3.75f),
        isAlternate = false
    ),

    IRON_INGOT(
        machine = Machine.SMELTER,
        inputs = listOf(
            PartIO(Part.IRON_ORE, 30.0f)
        ),
        output = PartIO(Part.IRON_INGOT, 30.0f),
        isAlternate = false
    ),

    IRON_ALLOY_INGOT(
        machine = Machine.FOUNDRY,
        inputs = listOf(
            PartIO(Part.IRON_ORE, 20.0f),
            PartIO(Part.COPPER_ORE, 20.0f)
        ),
        output = PartIO(Part.IRON_INGOT, 50.0f),
        isAlternate = true
    ),

    PURE_IRON_INGOT(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.IRON_ORE, 35.0f),
            PartIO(Part.WATER, 20.0f)
        ),
        output = PartIO(Part.IRON_INGOT, 65.0f),
        isAlternate = true
    ),

    IRON_PLATE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.IRON_INGOT, 30.0f)
        ),
        output = PartIO(Part.IRON_PLATE, 20.0f),
        isAlternate = false
    ),

    COATED_IRON_PLATE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.IRON_INGOT, 50.0f),
            PartIO(Part.PLASTIC, 10.0f)
        ),
        output = PartIO(Part.IRON_PLATE, 75.0f),
        isAlternate = true
    ),

    STEEL_COATED_PLATE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.STEEL_INGOT, 7.5f),
            PartIO(Part.PLASTIC, 5.0f)
        ),
        output = PartIO(Part.IRON_PLATE, 45.0f),
        isAlternate = true
    ),

    IRON_ROD(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.IRON_INGOT, 15.0f)
        ),
        output = PartIO(Part.IRON_ROD, 15.0f),
        isAlternate = false
    ),

    STEEL_ROD(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.STEEL_INGOT, 12.0f)
        ),
        output = PartIO(Part.IRON_ROD, 48.0f),
        isAlternate = true
    ),

    JETPACK(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.PLASTIC, -1.0f),
            PartIO(Part.RUBBER, -1.0f),
            PartIO(Part.CIRCUIT_BOARD, -1.0f),
            PartIO(Part.MOTOR, -1.0f)
        ),
        output = PartIO(Part.JETPACK, -1.0f),
        isAlternate = false
    ),

    LIQUID_BIOFUEL(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.SOLID_BIOFUEL, 90.0f),
            PartIO(Part.WATER, 45.0f)
        ),
        output = PartIO(Part.LIQUID_BIOFUEL, 60.0f),
        isAlternate = false
    ),

    UNPACKAGE_LIQUID_BIOFUEL(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_LIQUID_BIOFUEL, 60.0f)
        ),
        output = PartIO(Part.LIQUID_BIOFUEL, 60.0f),
        isAlternate = true
    ),

    MAGNETIC_FIELD_GENERATOR(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.VERSATILE_FRAMEWORK, 2.5f),
            PartIO(Part.ELECTROMAGNETIC_CONTROL_ROD, 1.0f),
            PartIO(Part.BATTERY, 5.0f)
        ),
        output = PartIO(Part.MAGNETIC_FIELD_GENERATOR, 1.0f),
        isAlternate = false
    ),

    MEDICINAL_INHALER_ALIEN_ORGANS(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.ALIEN_ORGANS, -1.0f),
            PartIO(Part.MYCELIA, -1.0f)
        ),
        output = PartIO(Part.MEDICINAL_INHALER, -1.0f),
        isAlternate = true
    ),

    NUTRITIONAL_INHALER(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.BACON_AGARIC, -1.0f),
            PartIO(Part.PALEBERRY, -1.0f),
            PartIO(Part.BERYL_NUT, -1.0f),
            PartIO(Part.MYCELIA, -1.0f)
        ),
        output = PartIO(Part.MEDICINAL_INHALER, -1.0f),
        isAlternate = true
    ),

    MEDICINAL_INHALER(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.BACON_AGARIC, -1.0f),
            PartIO(Part.PALEBERRY, -1.0f),
            PartIO(Part.BERYL_NUT, -1.0f)
        ),
        output = PartIO(Part.MEDICINAL_INHALER, -1.0f),
        isAlternate = false
    ),

    MODULAR_ENGINE(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.MOTOR, 2.0f),
            PartIO(Part.RUBBER, 15.0f),
            PartIO(Part.SMART_PLATING, 2.0f)
        ),
        output = PartIO(Part.MODULAR_ENGINE, 1.0f),
        isAlternate = false
    ),

    MODULAR_FRAME(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.REINFORCED_IRON_PLATE, 3.0f),
            PartIO(Part.IRON_ROD, 12.0f)
        ),
        output = PartIO(Part.MODULAR_FRAME, 2.0f),
        isAlternate = false
    ),

    BOLTED_FRAME(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.REINFORCED_IRON_PLATE, 7.5f),
            PartIO(Part.SCREW, 140.0f)
        ),
        output = PartIO(Part.MODULAR_FRAME, 5.0f),
        isAlternate = true
    ),

    STEELED_FRAME(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.REINFORCED_IRON_PLATE, 2.0f),
            PartIO(Part.STEEL_PIPE, 10.0f)
        ),
        output = PartIO(Part.MODULAR_FRAME, 3.0f),
        isAlternate = true
    ),

    MOTOR(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.ROTOR, 10.0f),
            PartIO(Part.STATOR, 10.0f)
        ),
        output = PartIO(Part.MOTOR, 5.0f),
        isAlternate = false
    ),

    ELECTRIC_MOTOR(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.ELECTROMAGNETIC_CONTROL_ROD, 3.75f),
            PartIO(Part.ROTOR, 7.5f)
        ),
        output = PartIO(Part.MOTOR, 7.5f),
        isAlternate = true
    ),

    RIGOUR_MOTOR(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.ROTOR, 3.75f),
            PartIO(Part.STATOR, 3.75f),
            PartIO(Part.CRYSTAL_OSCILLATOR, 1.25f)
        ),
        output = PartIO(Part.MOTOR, 7.5f),
        isAlternate = true
    ),

    NITRIC_ACID(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.NITROGEN_GAS, 120.0f),
            PartIO(Part.WATER, 30.0f),
            PartIO(Part.IRON_PLATE, 10.0f)
        ),
        output = PartIO(Part.NITRIC_ACID, 30.0f),
        isAlternate = false
    ),

    NOBELISK(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.BLACK_POWDER, 15.0f),
            PartIO(Part.STEEL_PIPE, 30.0f)
        ),
        output = PartIO(Part.NOBELISK, 3.0f),
        isAlternate = false
    ),

    SEISMIC_NOBELISK(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.BLACK_POWDER, 12.0f),
            PartIO(Part.STEEL_PIPE, 12.0f),
            PartIO(Part.CRYSTAL_OSCILLATOR, 1.5f)
        ),
        output = PartIO(Part.NOBELISK, 6.0f),
        isAlternate = true
    ),

    NOBELISK_DETONATOR(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.OBJECT_SCANNER, -1.0f),
            PartIO(Part.ENCASED_INDUSTRIAL_BEAM, -1.0f),
            PartIO(Part.CABLE, -1.0f)
        ),
        output = PartIO(Part.NOBELISK_DETONATOR, -1.0f),
        isAlternate = false
    ),

    NON_FISSILE_URANIUM(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.URANIUM_WASTE, 37.5f),
            PartIO(Part.SILICA, 25.0f),
            PartIO(Part.NITRIC_ACID, 15.0f),
            PartIO(Part.SULFURIC_ACID, 15.0f)
        ),
        output = PartIO(Part.NON_FISSILE_URANIUM, 50.0f),
        isAlternate = false
    ),

    FERTILE_URANIUM(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.URANIUM, 25.0f),
            PartIO(Part.URANIUM_WASTE, 25.0f),
            PartIO(Part.NITRIC_ACID, 15.0f),
            PartIO(Part.SULFURIC_ACID, 25.0f)
        ),
        output = PartIO(Part.NON_FISSILE_URANIUM, 100.0f),
        isAlternate = true
    ),

    NUCLEAR_PASTA(
        machine = Machine.PARTICLE_ACCELERATOR,
        inputs = listOf(
            PartIO(Part.COPPER_POWDER, 100.0f),
            PartIO(Part.PRESSURE_CONVERSION_CUBE, 0.5f)
        ),
        output = PartIO(Part.NUCLEAR_PASTA, 0.5f),
        isAlternate = false
    ),

    PACKAGED_ALUMINA_SOLUTION(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.ALUMINA_SOLUTION, 120.0f),
            PartIO(Part.EMPTY_CANISTER, 120.0f)
        ),
        output = PartIO(Part.PACKAGED_ALUMINA_SOLUTION, 120.0f),
        isAlternate = false
    ),

    PACKAGED_FUEL(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.FUEL, 40.0f),
            PartIO(Part.EMPTY_CANISTER, 40.0f)
        ),
        output = PartIO(Part.PACKAGED_FUEL, 40.0f),
        isAlternate = false
    ),

    DILUTED_PACKAGED_FUEL(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.HEAVY_OIL_RESIDUE, 30.0f),
            PartIO(Part.PACKAGED_WATER, 60.0f)
        ),
        output = PartIO(Part.PACKAGED_FUEL, 60.0f),
        isAlternate = true
    ),

    PACKAGED_LIQUID_BIOFUEL(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.LIQUID_BIOFUEL, 40.0f),
            PartIO(Part.EMPTY_CANISTER, 40.0f)
        ),
        output = PartIO(Part.PACKAGED_LIQUID_BIOFUEL, 40.0f),
        isAlternate = false
    ),

    PACKAGED_NITRIC_ACID(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.NITRIC_ACID, 30.0f),
            PartIO(Part.EMPTY_FLUID_TANK, 30.0f)
        ),
        output = PartIO(Part.PACKAGED_NITRIC_ACID, 30.0f),
        isAlternate = false
    ),

    PACKAGED_NITROGEN_GAS(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.NITROGEN_GAS, 240.0f),
            PartIO(Part.EMPTY_FLUID_TANK, 60.0f)
        ),
        output = PartIO(Part.PACKAGED_NITROGEN_GAS, 60.0f),
        isAlternate = false
    ),

    PACKAGED_OIL(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.CRUDE_OIL, 30.0f),
            PartIO(Part.EMPTY_CANISTER, 30.0f)
        ),
        output = PartIO(Part.PACKAGED_OIL, 30.0f),
        isAlternate = false
    ),

    PACKAGED_SULFURIC_ACID(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.SULFURIC_ACID, 40.0f),
            PartIO(Part.EMPTY_CANISTER, 40.0f)
        ),
        output = PartIO(Part.PACKAGED_SULFURIC_ACID, 40.0f),
        isAlternate = false
    ),

    PACKAGED_TURBOFUEL(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.TURBOFUEL, 20.0f),
            PartIO(Part.EMPTY_CANISTER, 20.0f)
        ),
        output = PartIO(Part.PACKAGED_TURBOFUEL, 20.0f),
        isAlternate = false
    ),

    PACKAGED_WATER(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.WATER, 60.0f),
            PartIO(Part.EMPTY_CANISTER, 60.0f)
        ),
        output = PartIO(Part.PACKAGED_WATER, 60.0f),
        isAlternate = false
    ),

    PARACHUTE(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.FABRIC, -1.0f),
            PartIO(Part.CABLE, -1.0f)
        ),
        output = PartIO(Part.PARACHUTE, -1.0f),
        isAlternate = false
    ),

    PETROLEUM_COKE(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.HEAVY_OIL_RESIDUE, 40.0f)
        ),
        output = PartIO(Part.PETROLEUM_COKE, 120.0f),
        isAlternate = false
    ),

    RESIDUAL_PLASTIC(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.POLYMER_RESIN, 60.0f),
            PartIO(Part.WATER, 20.0f)
        ),
        output = PartIO(Part.PLASTIC, 20.0f),
        isAlternate = true
    ),

    RECYCLED_PLASTIC(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.RUBBER, 30.0f),
            PartIO(Part.FUEL, 30.0f)
        ),
        output = PartIO(Part.PLASTIC, 60.0f),
        isAlternate = true
    ),

    PLUTONIUM_FUEL_ROD(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.ENCASED_PLUTONIUM_CELL, 7.5f),
            PartIO(Part.STEEL_BEAM, 4.5f),
            PartIO(Part.ELECTROMAGNETIC_CONTROL_ROD, 1.5f),
            PartIO(Part.HEAT_SINK, 2.5f)
        ),
        output = PartIO(Part.PLUTONIUM_FUEL_ROD, 0.25f),
        isAlternate = false
    ),

    PLUTONIUM_FUEL_UNIT(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.ENCASED_PLUTONIUM_CELL, 10.0f),
            PartIO(Part.PRESSURE_CONVERSION_CUBE, 0.5f)
        ),
        output = PartIO(Part.PLUTONIUM_FUEL_ROD, 0.5f),
        isAlternate = true
    ),

    PLUTONIUM_PELLET(
        machine = Machine.PARTICLE_ACCELERATOR,
        inputs = listOf(
            PartIO(Part.NON_FISSILE_URANIUM, 100.0f),
            PartIO(Part.URANIUM_WASTE, 25.0f)
        ),
        output = PartIO(Part.PLUTONIUM_PELLET, 30.0f),
        isAlternate = false
    ),
    PORTABLE_MINER(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.IRON_PLATE, -1.0f),
            PartIO(Part.IRON_ROD, -1.0f)
        ),
        output = PartIO(Part.PORTABLE_MINER, -1.0f),
        isAlternate = false
    ),

    AUTOMATED_MINER(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.MOTOR, 1.0f),
            PartIO(Part.STEEL_PIPE, 4.0f),
            PartIO(Part.IRON_ROD, 4.0f),
            PartIO(Part.IRON_PLATE, 2.0f)
        ),
        output = PartIO(Part.PORTABLE_MINER, 1.0f),
        isAlternate = true
    ),

    POWER_SHARD_1(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.BLUE_POWER_SLUG, 7.5f)
        ),
        output = PartIO(Part.POWER_SHARD, 7.5f),
        isAlternate = true
    ),

    POWER_SHARD_2(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.YELLOW_POWER_SLUG, 5.0f)
        ),
        output = PartIO(Part.POWER_SHARD, 10.0f),
        isAlternate = true
    ),

    POWER_SHARD_5(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.PURPLE_POWER_SLUG, 2.5f)
        ),
        output = PartIO(Part.POWER_SHARD, 12.5f),
        isAlternate = true
    ),

    PRESSURE_CONVERSION_CUBE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.FUSED_MODULAR_FRAME, 1.0f),
            PartIO(Part.RADIO_CONTROL_UNIT, 2.0f)
        ),
        output = PartIO(Part.PRESSURE_CONVERSION_CUBE, 1.0f),
        isAlternate = false
    ),

    QUARTZ_CRYSTAL(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.RAW_QUARTZ, 37.5f)
        ),
        output = PartIO(Part.QUARTZ_CRYSTAL, 22.5f),
        isAlternate = false
    ),

    PURE_QUARTZ_CRYSTAL(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.RAW_QUARTZ, 67.5f),
            PartIO(Part.WATER, 37.5f)
        ),
        output = PartIO(Part.QUARTZ_CRYSTAL, 52.5f),
        isAlternate = true
    ),

    QUICKWIRE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.CATERIUM_INGOT, 12.0f)
        ),
        output = PartIO(Part.QUICKWIRE, 60.0f),
        isAlternate = false
    ),

    FUSED_QUICKWIRE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.CATERIUM_INGOT, 7.5f),
            PartIO(Part.COPPER_INGOT, 37.5f)
        ),
        output = PartIO(Part.QUICKWIRE, 90.0f),
        isAlternate = true
    ),

    RADIO_CONTROL_UNIT(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.ALUMINUM_CASING, 40.0f),
            PartIO(Part.CRYSTAL_OSCILLATOR, 1.25f),
            PartIO(Part.COMPUTER, 1.25f)
        ),
        output = PartIO(Part.RADIO_CONTROL_UNIT, 2.5f),
        isAlternate = false
    ),

    RADIO_CONTROL_SYSTEM(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.CRYSTAL_OSCILLATOR, 1.5f),
            PartIO(Part.CIRCUIT_BOARD, 15.0f),
            PartIO(Part.ALUMINUM_CASING, 90.0f),
            PartIO(Part.RUBBER, 45.0f)
        ),
        output = PartIO(Part.RADIO_CONTROL_UNIT, 4.5f),
        isAlternate = true
    ),

    RADIO_CONNECTION_UNIT(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.HEAT_SINK, 15.0f),
            PartIO(Part.HIGH_SPEED_CONNECTOR, 7.5f),
            PartIO(Part.QUARTZ_CRYSTAL, 45.0f)
        ),
        output = PartIO(Part.RADIO_CONTROL_UNIT, 3.75f),
        isAlternate = true
    ),

    REBAR_GUN(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.REINFORCED_IRON_PLATE, -1.0f),
            PartIO(Part.IRON_ROD, -1.0f),
            PartIO(Part.SCREW, -1.0f)
        ),
        output = PartIO(Part.REBAR_GUN, -1.0f),
        isAlternate = false
    ),

    RIFLE(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.STEEL_PIPE, -1.0f),
            PartIO(Part.HEAVY_MODULAR_FRAME, -1.0f),
            PartIO(Part.CIRCUIT_BOARD, -1.0f),
            PartIO(Part.SCREW, -1.0f)
        ),
        output = PartIO(Part.RIFLE, -1.0f),
        isAlternate = false
    ),

    RIFLE_CARTRIDGE(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.BEACON, 3.0f),
            PartIO(Part.STEEL_PIPE, 30.0f),
            PartIO(Part.BLACK_POWDER, 30.0f),
            PartIO(Part.RUBBER, 30.0f)
        ),
        output = PartIO(Part.RIFLE_CARTRIDGE, 15.0f),
        isAlternate = false
    ),

    ROTOR(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.IRON_ROD, 20.0f),
            PartIO(Part.SCREW, 100.0f)
        ),
        output = PartIO(Part.ROTOR, 4.0f),
        isAlternate = false
    ),

    COPPER_ROTOR(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.COPPER_SHEET, 22.5f),
            PartIO(Part.SCREW, 195.0f)
        ),
        output = PartIO(Part.ROTOR, 11.25f),
        isAlternate = true
    ),

    STEEL_ROTOR(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.STEEL_PIPE, 10.0f),
            PartIO(Part.WIRE, 30.0f)
        ),
        output = PartIO(Part.ROTOR, 5.0f),
        isAlternate = true
    ),

    RESIDUAL_RUBBER(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.POLYMER_RESIN, 40.0f),
            PartIO(Part.WATER, 40.0f)
        ),
        output = PartIO(Part.RUBBER, 20.0f),
        isAlternate = true
    ),

    RECYCLED_RUBBER(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.PLASTIC, 30.0f),
            PartIO(Part.FUEL, 30.0f)
        ),
        output = PartIO(Part.RUBBER, 60.0f),
        isAlternate = true
    ),

    SCREW(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.IRON_ROD, 10.0f)
        ),
        output = PartIO(Part.SCREW, 40.0f),
        isAlternate = false
    ),

    STEEL_SCREW(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.STEEL_BEAM, 5.0f)
        ),
        output = PartIO(Part.SCREW, 260.0f),
        isAlternate = true
    ),

    CAST_SCREW(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.IRON_INGOT, 12.5f)
        ),
        output = PartIO(Part.SCREW, 50.0f),
        isAlternate = true
    ),

    SILICA(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.RAW_QUARTZ, 22.5f)
        ),
        output = PartIO(Part.SILICA, 37.5f),
        isAlternate = false
    ),

    CHEAP_SILICA(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.RAW_QUARTZ, 11.25f),
            PartIO(Part.LIMESTONE, 18.75f)
        ),
        output = PartIO(Part.SILICA, 26.25f),
        isAlternate = true
    ),

    SMART_PLATING(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.REINFORCED_IRON_PLATE, 2.0f),
            PartIO(Part.ROTOR, 2.0f)
        ),
        output = PartIO(Part.SMART_PLATING, 2.0f),
        isAlternate = false
    ),

    PLASTIC_SMART_PLATING(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.REINFORCED_IRON_PLATE, 2.5f),
            PartIO(Part.ROTOR, 2.5f),
            PartIO(Part.PLASTIC, 7.5f)
        ),
        output = PartIO(Part.SMART_PLATING, 5.0f),
        isAlternate = true
    ),

    SOLID_BIOFUEL(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.BIOMASS, 120.0f)
        ),
        output = PartIO(Part.SOLID_BIOFUEL, 60.0f),
        isAlternate = false
    ),

    SPIKED_REBAR(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.IRON_ROD, 15.0f)
        ),
        output = PartIO(Part.SPIKED_REBAR, 15.0f),
        isAlternate = false
    ),

    STATOR(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.STEEL_PIPE, 15.0f),
            PartIO(Part.WIRE, 40.0f)
        ),
        output = PartIO(Part.STATOR, 5.0f),
        isAlternate = false
    ),

    QUICKWIRE_STATOR(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.STEEL_PIPE, 16.0f),
            PartIO(Part.QUICKWIRE, 60.0f)
        ),
        output = PartIO(Part.STATOR, 8.0f),
        isAlternate = true
    ),

    STEEL_INGOT(
        machine = Machine.FOUNDRY,
        inputs = listOf(
            PartIO(Part.IRON_ORE, 45.0f),
            PartIO(Part.COAL, 45.0f)
        ),
        output = PartIO(Part.STEEL_INGOT, 45.0f),
        isAlternate = false
    ),

    COKE_STEEL_INGOT(
        machine = Machine.FOUNDRY,
        inputs = listOf(
            PartIO(Part.IRON_ORE, 75.0f),
            PartIO(Part.PETROLEUM_COKE, 75.0f)
        ),
        output = PartIO(Part.STEEL_INGOT, 100.0f),
        isAlternate = true
    ),

    SOLID_STEEL_INGOT(
        machine = Machine.FOUNDRY,
        inputs = listOf(
            PartIO(Part.IRON_INGOT, 40.0f),
            PartIO(Part.COAL, 40.0f)
        ),
        output = PartIO(Part.STEEL_INGOT, 60.0f),
        isAlternate = true
    ),

    COMPACTED_STEEL_INGOT(
        machine = Machine.FOUNDRY,
        inputs = listOf(
            PartIO(Part.IRON_ORE, 22.5f),
            PartIO(Part.COMPACTED_COAL, 11.25f)
        ),
        output = PartIO(Part.STEEL_INGOT, 37.5f),
        isAlternate = true
    ),

    STEEL_PIPE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.STEEL_INGOT, 30.0f)
        ),
        output = PartIO(Part.STEEL_PIPE, 20.0f),
        isAlternate = false
    ),

    SULFURIC_ACID(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.SULFUR, 50.0f),
            PartIO(Part.WATER, 50.0f)
        ),
        output = PartIO(Part.SULFURIC_ACID, 50.0f),
        isAlternate = false
    ),

    UNPACKAGE_SULFURIC_ACID(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_SULFURIC_ACID, 60.0f)
        ),
        output = PartIO(Part.SULFURIC_ACID, 60.0f),
        isAlternate = true
    ),

    SUPERCOMPUTER(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.COMPUTER, 3.75f),
            PartIO(Part.AI_LIMITER, 3.75f),
            PartIO(Part.HIGH_SPEED_CONNECTOR, 5.625f),
            PartIO(Part.PLASTIC, 52.5f)
        ),
        output = PartIO(Part.SUPERCOMPUTER, 1.875f),
        isAlternate = false
    ),

    OC_SUPERCOMPUTER(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.RADIO_CONTROL_UNIT, 9.0f),
            PartIO(Part.COOLING_SYSTEM, 9.0f)
        ),
        output = PartIO(Part.SUPERCOMPUTER, 3.0f),
        isAlternate = true
    ),

    SUPER_STATE_COMPUTER(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.COMPUTER, 3.6f),
            PartIO(Part.ELECTROMAGNETIC_CONTROL_ROD, 2.4f),
            PartIO(Part.BATTERY, 24.0f),
            PartIO(Part.WIRE, 54.0f)
        ),
        output = PartIO(Part.SUPERCOMPUTER, 2.4f),
        isAlternate = true
    ),

    THERMAL_PROPULSION_ROCKET(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.MODULAR_ENGINE, 2.5f),
            PartIO(Part.TURBO_MOTOR, 1.0f),
            PartIO(Part.COOLING_SYSTEM, 3.0f),
            PartIO(Part.FUSED_MODULAR_FRAME, 1.0f)
        ),
        output = PartIO(Part.THERMAL_PROPULSION_ROCKET, 1.0f),
        isAlternate = false
    ),

    TURBO_MOTOR(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.COOLING_SYSTEM, 7.5f),
            PartIO(Part.RADIO_CONTROL_UNIT, 3.75f),
            PartIO(Part.MOTOR, 7.5f),
            PartIO(Part.RUBBER, 45.0f)
        ),
        output = PartIO(Part.TURBO_MOTOR, 1.875f),
        isAlternate = false
    ),

    TURBO_ELECTRIC_MOTOR(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.MOTOR, 6.5625f),
            PartIO(Part.RADIO_CONTROL_UNIT, 8.4375f),
            PartIO(Part.ELECTROMAGNETIC_CONTROL_ROD, 4.6875f),
            PartIO(Part.ROTOR, 6.5625f)
        ),
        output = PartIO(Part.TURBO_MOTOR, 2.8125f),
        isAlternate = true
    ),

    TURBO_PRESSURE_MOTOR(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.MOTOR, 7.5f),
            PartIO(Part.PRESSURE_CONVERSION_CUBE, 1.875f),
            PartIO(Part.PACKAGED_NITROGEN_GAS, 45.0f),
            PartIO(Part.STATOR, 15.0f)
        ),
        output = PartIO(Part.TURBO_MOTOR, 3.75f),
        isAlternate = true
    ),

    UNPACKAGE_TURBOFUEL(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_TURBOFUEL, 20.0f)
        ),
        output = PartIO(Part.TURBOFUEL, 20.0f),
        isAlternate = true
    ),

    TURBO_BLEND_FUEL(
        machine = Machine.BLENDER,
        inputs = listOf(
            PartIO(Part.FUEL, 15.0f),
            PartIO(Part.HEAVY_OIL_RESIDUE, 30.0f),
            PartIO(Part.SULFUR, 22.5f),
            PartIO(Part.PETROLEUM_COKE, 22.5f)
        ),
        output = PartIO(Part.TURBOFUEL, 45.0f),
        isAlternate = true
    ),

    TURBO_HEAVY_FUEL(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.HEAVY_OIL_RESIDUE, 37.5f),
            PartIO(Part.COMPACTED_COAL, 30.0f)
        ),
        output = PartIO(Part.TURBOFUEL, 30.0f),
        isAlternate = true
    ),

    TURBOFUEL(
        machine = Machine.REFINERY,
        inputs = listOf(
            PartIO(Part.FUEL, 22.5f),
            PartIO(Part.COMPACTED_COAL, 15.0f)
        ),
        output = PartIO(Part.TURBOFUEL, 18.75f),
        isAlternate = false
    ),

    URANIUM_FUEL_ROD(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.ENCASED_URANIUM_CELL, 20.0f),
            PartIO(Part.ENCASED_INDUSTRIAL_BEAM, 1.2f),
            PartIO(Part.ELECTROMAGNETIC_CONTROL_ROD, 2.0f)
        ),
        output = PartIO(Part.URANIUM_FUEL_ROD, 0.4f),
        isAlternate = false
    ),

    URANIUM_FUEL_UNIT(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.ENCASED_URANIUM_CELL, 20.0f),
            PartIO(Part.ELECTROMAGNETIC_CONTROL_ROD, 2.0f),
            PartIO(Part.CRYSTAL_OSCILLATOR, 0.6f),
            PartIO(Part.BEACON, 1.2f)
        ),
        output = PartIO(Part.URANIUM_FUEL_ROD, 0.6f),
        isAlternate = true
    ),

    VERSATILE_FRAMEWORK(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.MODULAR_FRAME, 2.5f),
            PartIO(Part.STEEL_BEAM, 30.0f)
        ),
        output = PartIO(Part.VERSATILE_FRAMEWORK, 5.0f),
        isAlternate = false
    ),

    FLEXIBLE_FRAMEWORK(
        machine = Machine.MANUFACTURER,
        inputs = listOf(
            PartIO(Part.MODULAR_FRAME, 3.75f),
            PartIO(Part.STEEL_BEAM, 22.5f),
            PartIO(Part.RUBBER, 30.0f)
        ),
        output = PartIO(Part.VERSATILE_FRAMEWORK, 7.5f),
        isAlternate = true
    ),

    UNPACKAGE_WATER(
        machine = Machine.PACKAGER,
        inputs = listOf(
            PartIO(Part.PACKAGED_WATER, 120.0f)
        ),
        output = PartIO(Part.WATER, 120.0f),
        isAlternate = true
    ),

    WIRE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.COPPER_INGOT, 15.0f)
        ),
        output = PartIO(Part.WIRE, 30.0f),
        isAlternate = false
    ),

    FUSED_WIRE(
        machine = Machine.ASSEMBLER,
        inputs = listOf(
            PartIO(Part.COPPER_INGOT, 12.0f),
            PartIO(Part.CATERIUM_INGOT, 3.0f)
        ),
        output = PartIO(Part.WIRE, 90.0f),
        isAlternate = true
    ),

    IRON_WIRE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.IRON_INGOT, 12.5f)
        ),
        output = PartIO(Part.WIRE, 22.5f),
        isAlternate = true
    ),

    CATERIUM_WIRE(
        machine = Machine.CONSTRUCTOR,
        inputs = listOf(
            PartIO(Part.CATERIUM_INGOT, 15.0f)
        ),
        output = PartIO(Part.WIRE, 120.0f),
        isAlternate = true
    ),

    XENO_BASHER(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.MODULAR_FRAME, -1.0f),
            PartIO(Part.XENO_ZAPPER, -1.0f),
            PartIO(Part.CABLE, -1.0f),
            PartIO(Part.WIRE, -1.0f)
        ),
        output = PartIO(Part.XENO_BASHER, -1.0f),
        isAlternate = false
    ),

    XENO_ZAPPER(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.IRON_ROD, -1.0f),
            PartIO(Part.REINFORCED_IRON_PLATE, -1.0f),
            PartIO(Part.CABLE, -1.0f),
            PartIO(Part.WIRE, -1.0f)
        ),
        output = PartIO(Part.XENO_ZAPPER, -1.0f),
        isAlternate = false
    ),

    ZIPLINE(
        machine = Machine.EQUIPMENT_WORKSHOP,
        inputs = listOf(
            PartIO(Part.XENO_ZAPPER, -1.0f),
            PartIO(Part.QUICKWIRE, -1.0f),
            PartIO(Part.IRON_ROD, -1.0f),
            PartIO(Part.CABLE, -1.0f)
        ),
        output = PartIO(Part.ZIPLINE, -1.0f),
        isAlternate = false
    ),
}