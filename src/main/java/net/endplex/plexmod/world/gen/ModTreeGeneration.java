package net.endplex.plexmod.world.gen;

import net.endplex.plexmod.world.biome.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeIds;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.gen.GenerationStep;
import net.endplex.plexmod.world.features.ModConfiguredFeatures;
import net.minecraft.world.gen.feature.OceanRuinFeature;

public class ModTreeGeneration {
    public static void generateTrees() {

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.GIANT_SPRUCE_TAIGA, BiomeKeys.GIANT_TREE_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.REDWOOD_TREE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE, BiomeKeys.MODIFIED_JUNGLE, BiomeKeys.JUNGLE_EDGE, BiomeKeys.MODIFIED_JUNGLE_EDGE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.BANANA_TREE_KEY);

        /*
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.BANANA_TREE_KEY);
         */
    }
}
