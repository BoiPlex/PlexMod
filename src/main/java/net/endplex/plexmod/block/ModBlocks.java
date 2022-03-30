package net.endplex.plexmod.block;

import net.endplex.plexmod.world.features.tree.BananaSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.endplex.plexmod.PlexMod;
import net.endplex.plexmod.block.custom.*;
import net.endplex.plexmod.item.ModItemGroup;
import net.endplex.plexmod.world.features.ModConfiguredFeatures;
import net.endplex.plexmod.world.features.tree.RedwoodSaplingGenerator;

public class ModBlocks {

    public static final Block BANANA_ORE = registerBlock("banana_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block BANANA_BLOCK = registerBlock("banana_block",
            new Block(FabricBlockSettings.of(Material.PLANT).strength(2.0f)
                    .breakByTool(FabricToolTags.SHEARS, 1)));

    public static final Block BANANA_SAPLING = registerBlock("banana_sapling",
            new ModSaplingBlock(new BananaSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.JUNGLE_SAPLING)));

    public static final Block BANANA_LEAVES = registerBlock("banana_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.JUNGLE_LEAVES).noCollision()));

    public static final Block BOOST_BLOCK = registerBlock("boost_block",
            new BoostBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block LANDMINE = registerBlock("landmine",
            new Landmine(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(4f)
                            .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    // -----

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block STATUS_BLOCK = registerBlock("status_block",
            new StatusBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block RUBY_STAIRS = registerBlock("ruby_stairs",
            new ModStairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block RUBY_SLAB = registerBlock("ruby_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block RUBY_FENCE = registerBlock("ruby_fence",
            new FenceBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));


    public static final Block RUBY_BUTTON = registerBlock("ruby_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));


    public static final Block RUBY_DOOR = registerBlock("ruby_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().nonOpaque()));

    public static final Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            new ModTrapdoorBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().nonOpaque()));

    public static final Block TEST_BLOCK = registerBlock("test_block",
            new TestBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block DICE_BLOCK = registerBlock("dice_block",
            new DiceBlock(FabricBlockSettings.of(Material.STONE).strength(6f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));

    public static final Block PEPPER_PLANT = registerBlockWithoutBlockItem("pepper_plant",
            new PepperPlantBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision()));

    public static final Block BLUEBELLS = registerBlock("bluebells",
            new FlowerBlock(StatusEffects.DOLPHINS_GRACE, 200,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque().noCollision()));


    public static final Block REDWOOD_LOG = registerBlock("redwood_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block REDWOOD_WOOD = registerBlock("redwood_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block REDWOOD_PLANKS = registerBlock("redwood_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block REDWOOD_LEAVES = registerBlock("redwood_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block REDWOOD_SAPLING = registerBlock("redwood_sapling",
            new ModSaplingBlock(new RedwoodSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final Block LIGHTNING_CHANNELER_BLOCK = registerBlock("lightning_channeler",
            new LightningChannelerBlock(FabricBlockSettings.of(Material.METAL)));




    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(PlexMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(PlexMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(PlexMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.PLEX)));
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + PlexMod.MOD_ID);
    }
}
