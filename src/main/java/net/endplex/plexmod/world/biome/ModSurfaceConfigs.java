package net.endplex.plexmod.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.endplex.plexmod.PlexMod;
import net.endplex.plexmod.block.ModBlocks;

public class ModSurfaceConfigs {
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> LAVA_SURFACE_BUILDER = register("lava_surface",
            SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
                    Blocks.MAGMA_BLOCK.getDefaultState(),
                    ModBlocks.DICE_BLOCK.getDefaultState(),
                    Blocks.SANDSTONE.getDefaultState())));

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> PINK_SURFACE_BUILDER = register("pink_surface",
            SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
                    Blocks.PINK_WOOL.getDefaultState(),
                    Blocks.PINK_CONCRETE.getDefaultState(),
                    Blocks.PINK_TERRACOTTA.getDefaultState())));

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> DARK_SURFACE_BUILDER = register("dark_surface",
            SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
                    Blocks.GRASS_BLOCK.getDefaultState(),
                    Blocks.BLACK_CONCRETE_POWDER.getDefaultState(),
                    Blocks.DEEPSLATE.getDefaultState())));

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> AETHER_SURFACE_BUILDER = register("aether_surface",
            SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
                    Blocks.GRASS_BLOCK.getDefaultState(),
                    Blocks.WHITE_CONCRETE_POWDER.getDefaultState(),
                    Blocks.WHITE_WOOL.getDefaultState())));

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> BANANA_SURFACE_BUILDER = register("banana_surface",
            SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
                    ModBlocks.BANANA_BLOCK.getDefaultState(),
                    Blocks.JUNGLE_LOG.getDefaultState(),
                    Blocks.BEE_NEST.getDefaultState())));

    private static <T extends SurfaceConfig> ConfiguredSurfaceBuilder<T> register(String name,
                                                                                  ConfiguredSurfaceBuilder<T> surfaceBuilder) {
        return Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER,
                new Identifier(PlexMod.MOD_ID, name), surfaceBuilder);
    }

}
