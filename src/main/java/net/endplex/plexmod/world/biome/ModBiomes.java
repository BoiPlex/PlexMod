package net.endplex.plexmod.world.biome;

import net.endplex.plexmod.world.dimension.ModDimensions;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.endplex.plexmod.PlexMod;
import net.endplex.plexmod.world.features.ModConfiguredFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> LAVA_LAND_KEY = registerKey("lava_land");
    public static final Biome LAVA_LAND = createLavaLand();

    public static final RegistryKey<Biome> PINK_LAND_KEY = registerKey("pink_land");
    public static final Biome PINK_LAND = createPinkLand();

    public static final RegistryKey<Biome> DARK_LAND_KEY = registerKey("dark_land");
    public static final Biome DARK_LAND = createDarkLand();

    public static final RegistryKey<Biome> AETHER_BIOME_KEY = registerKey("aether_biome");
    public static final Biome AETHER_BIOME = createAetherBiome();

    private static Biome createLavaLand() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(ModSurfaceConfigs.LAVA_SURFACE_BUILDER);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
        generationSettings.feature(GenerationStep.Feature.LAKES, ConfiguredFeatures.LAKE_LAVA);

        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModConfiguredFeatures.RUBY_ORE);

        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);

        return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.NONE)
                .depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xf29c11).waterFogColor(0xf26b11)
                        .fogColor(0xc0d8ff).skyColor(0xfa4925)
                        .build()).spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build()).build();
    }

    private static Biome createPinkLand() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(ModSurfaceConfigs.PINK_SURFACE_BUILDER);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
        generationSettings.feature(GenerationStep.Feature.LAKES, ConfiguredFeatures.LAKE_LAVA);

        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModConfiguredFeatures.RUBY_ORE);

        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);

        return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.NONE)
                .depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xff75dd).waterFogColor(0xff40cf)
                        .fogColor(0xff99fd).skyColor(0xff69fc)
                        .build()).spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build()).build();
    }

    private static Biome createDarkLand() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 100, 100, 100);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(ModSurfaceConfigs.DARK_SURFACE_BUILDER);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
        generationSettings.feature(GenerationStep.Feature.LAKES, ConfiguredFeatures.LAKE_LAVA);
        generationSettings.feature(GenerationStep.Feature.SURFACE_STRUCTURES, ConfiguredFeatures.BASALT_PILLAR);
        generationSettings.feature(GenerationStep.Feature.SURFACE_STRUCTURES, ConfiguredFeatures.FOSSIL);
        generationSettings.feature(GenerationStep.Feature.SURFACE_STRUCTURES, ConfiguredFeatures.PROTOTYPE_FOSSIL_LOWER);
        generationSettings.feature(GenerationStep.Feature.SURFACE_STRUCTURES, ConfiguredFeatures.PROTOTYPE_FOSSIL_UPPER);
        generationSettings.feature(GenerationStep.Feature.SURFACE_STRUCTURES, ConfiguredFeatures.CRIMSON_FOREST_VEGETATION);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.LUSH_CAVES_CEILING_VEGETATION);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.LUSH_CAVES_CLAY);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.LUSH_CAVES_VEGETATION);

        DefaultBiomeFeatures.addAncientDebris(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModConfiguredFeatures.BANANA_ORE);

        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);

        return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.NETHER)
                .depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                        .grassColor(0x253627).foliageColor(0x253627)
                        .waterColor(0x318539).waterFogColor(0x354475)
                        .fogColor(0x22242b).skyColor(0x318539)
                        .build()).spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build()).build();
    }

    private static Biome createAetherBiome() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 10, 1, 10);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(ModSurfaceConfigs.AETHER_SURFACE_BUILDER);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
        DefaultBiomeFeatures.addIcebergs(generationSettings);
        DefaultBiomeFeatures.addJungleVegetation(generationSettings);
        DefaultBiomeFeatures.addBirchTrees(generationSettings);
        DefaultBiomeFeatures.addTallBirchTrees(generationSettings);

        generationSettings.feature(GenerationStep.Feature.LAKES, ConfiguredFeatures.PILE_ICE);
        generationSettings.feature(GenerationStep.Feature.LAKES, ConfiguredFeatures.PILE_SNOW);
        generationSettings.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ConfiguredFeatures.LAKE_WATER);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.FLOWER_FOREST);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_SUNFLOWER);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.FLOWER_DEFAULT);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ICE_PATCH);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.AMETHYST_GEODE);

        DefaultBiomeFeatures.addAncientDebris(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModConfiguredFeatures.BANANA_ORE);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModConfiguredFeatures.RUBY_ORE);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, ConfiguredFeatures.ORE_DIAMOND);

        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);

        return (new Biome.Builder()).precipitation(Biome.Precipitation.SNOW).category(Biome.Category.EXTREME_HILLS)
                .depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                        .grassColor(0x61f5fa).foliageColor(0x38ff88)
                        .waterColor(0x00ffff).waterFogColor(0x85ffff)
                        .fogColor(0xabffff).skyColor(0x19fafa)
                        .build()).spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build()).build();
    }

    public static RegistryKey<Biome> registerKey(String name) {
        return RegistryKey.of(Registry.BIOME_KEY, new Identifier(PlexMod.MOD_ID, name));

    }

    public static void registerBiomes() {
        Registry.register(BuiltinRegistries.BIOME, LAVA_LAND_KEY.getValue(), LAVA_LAND);
        Registry.register(BuiltinRegistries.BIOME, PINK_LAND_KEY.getValue(), PINK_LAND);
        Registry.register(BuiltinRegistries.BIOME, DARK_LAND_KEY.getValue(), DARK_LAND);
        Registry.register(BuiltinRegistries.BIOME, AETHER_BIOME_KEY.getValue(), AETHER_BIOME);

        OverworldBiomes.addContinentalBiome(LAVA_LAND_KEY, OverworldClimate.DRY, 1D);
        OverworldBiomes.addContinentalBiome(PINK_LAND_KEY, OverworldClimate.COOL, 1D);
        OverworldBiomes.addContinentalBiome(DARK_LAND_KEY, OverworldClimate.TEMPERATE, 1D);
        OverworldBiomes.addContinentalBiome(AETHER_BIOME_KEY, OverworldClimate.SNOWY, 1D);

    }

    public static void initBiomes() {
        System.out.println("Registering ModBiomes for " + PlexMod.MOD_ID);
    }
}
