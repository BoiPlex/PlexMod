package net.endplex.plexmod.world.features;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.endplex.plexmod.PlexMod;
import net.endplex.plexmod.block.ModBlocks;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> REDWOOD_TREE_KEY = registerKey("redwood_spawn");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUEBELLS_KEY = registerKey("bluebells");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_BLOCK_KEY = registerKey("diamond_block");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BANANA_TREE_KEY = registerKey("banana_spawn");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BANANA_ORE_KEY = registerKey("banana_ore");

    // Trees

    public static final ConfiguredFeature<TreeFeatureConfig, ?> REDWOOD_TREE = register("redwood",
            Feature.TREE.configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.REDWOOD_LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 4, 3),
                    new SimpleBlockStateProvider(ModBlocks.REDWOOD_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.REDWOOD_SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)).build()));
    public static final ConfiguredFeature<?, ?> REDWOOD_TREE_SPAWN = register(REDWOOD_TREE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING))
                    .spreadHorizontally().applyChance(3)), REDWOOD_TREE_KEY);

    public static final ConfiguredFeature<TreeFeatureConfig, ?> BANANA_TREE = register("banana",
            Feature.TREE.configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.JUNGLE_LOG.getDefaultState()),
                    new StraightTrunkPlacer(5, 3, 2),
                    new SimpleBlockStateProvider(ModBlocks.BANANA_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.BANANA_SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                    new TwoLayersFeatureSize(1, 0,  1)).build()));

    public static final ConfiguredFeature<?, ?> BANANA_TREE_SPAWN = register(BANANA_TREE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING))
                    .spreadHorizontally().applyChance(3)), BANANA_TREE_KEY);

    // Flowers

    public static final ConfiguredFeature<?, ?> BLUEBELLS_CONFIG = register(Feature.FLOWER.configure(
            new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.BLUEBELLS.getDefaultState()),
                    SimpleBlockPlacer.INSTANCE).tries(64).build())
            .decorate(Decorator.SPREAD_32_ABOVE.configure(NopeDecoratorConfig.INSTANCE)
                    .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING))
                            .spreadHorizontally().repeat(4))), BLUEBELLS_KEY);

    // Ores

    public static final ConfiguredFeature<?, ?> RUBY_ORE = register(Feature.ORE.configure(
            new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.RUBY_ORE.getDefaultState(), 8))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(2), YOffset.fixed(45))))
            .spreadHorizontally().repeat(6), RUBY_ORE_KEY);

    public static final ConfiguredFeature<?, ?> BANANA_ORE = register(Feature.ORE.configure(
                    new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.BANANA_ORE.getDefaultState(), 10))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(5), YOffset.fixed(40))))
            .spreadHorizontally().repeat(10), BANANA_ORE_KEY);



    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(PlexMod.MOD_ID, name));
    }

    private static ConfiguredFeature<TreeFeatureConfig, ?> register(String name,
                                                                    ConfiguredFeature<TreeFeatureConfig, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(PlexMod.MOD_ID, name),
                configuredFeature);
    }

    private static ConfiguredFeature<?, ?> register(ConfiguredFeature<?, ?> configuredFeature,
                                                    RegistryKey<ConfiguredFeature<?, ?>> key) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), configuredFeature);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + PlexMod.MOD_ID);
    }
}
