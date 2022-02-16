package net.endplex.plexmod.world.gen;

import net.endplex.plexmod.world.biome.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.endplex.plexmod.world.features.ModConfiguredFeatures;

public class ModTreeGeneration {
    public static void generateTrees() {

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.REDWOOD_TREE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.BANANA_TREE_KEY);
    }
}
