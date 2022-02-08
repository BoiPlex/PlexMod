package net.endplex.plexmod.world.biome;

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
                        .waterColor(0x3f76e4).waterFogColor(0x050533)
                        .fogColor(0xc0d8ff).skyColor(0x77adff)
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
                        .waterColor(0x3f76e4).waterFogColor(0x050533)
                        .fogColor(0xc0d8ff).skyColor(0x77adff)
                        .build()).spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build()).build();
    }

    public static RegistryKey<Biome> registerKey(String name) {
        return RegistryKey.of(Registry.BIOME_KEY, new Identifier(PlexMod.MOD_ID, name));

    }

    public static void registerBiomes() {
        Registry.register(BuiltinRegistries.BIOME, LAVA_LAND_KEY.getValue(), LAVA_LAND);
        Registry.register(BuiltinRegistries.BIOME, PINK_LAND_KEY.getValue(), PINK_LAND);

        OverworldBiomes.addContinentalBiome(LAVA_LAND_KEY, OverworldClimate.DRY, 1D);
        OverworldBiomes.addContinentalBiome(PINK_LAND_KEY, OverworldClimate.DRY, 1D);
    }

    public static void initBiomes() {
        System.out.println("Registering ModBiomes for " + PlexMod.MOD_ID);
    }
}
