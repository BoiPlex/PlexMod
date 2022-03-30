package net.endplex.plexmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.endplex.plexmod.world.features.ModConfiguredFeatures;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModConfiguredFeatures.RUBY_ORE_KEY);
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.JUNGLE),
                GenerationStep.Feature.UNDERGROUND_ORES, ModConfiguredFeatures.BANANA_ORE_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.FROZEN_RIVER),
                GenerationStep.Feature.UNDERGROUND_ORES, ModConfiguredFeatures.DIAMOND_BLOCK_KEY);
    }
}

