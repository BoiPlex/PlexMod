package net.endplex.plexmod;

import net.fabricmc.api.ModInitializer;
import net.endplex.plexmod.block.ModBlocks;
import net.endplex.plexmod.config.ModConfigs;
import net.endplex.plexmod.enchantments.ModEnchantments;
import net.endplex.plexmod.item.ModItems;
import net.endplex.plexmod.recipe.ModRecipes;
import net.endplex.plexmod.registries.ModRegistries;
import net.endplex.plexmod.sounds.ModSounds;
import net.endplex.plexmod.util.ModCommandRegister;
import net.endplex.plexmod.util.ModEventsRegister;
import net.endplex.plexmod.util.ModLootTableModifiers;
import net.endplex.plexmod.world.biome.ModBiomes;
import net.endplex.plexmod.world.dimension.ModDimensions;
import net.endplex.plexmod.world.dimension.ModPortals;
import net.endplex.plexmod.world.features.ModConfiguredFeatures;
import net.endplex.plexmod.world.gen.ModWorldGen;

public class PlexMod implements ModInitializer {

	public static final String MOD_ID = "plexmod";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModConfigs.registerConfigs();

		ModConfiguredFeatures.registerConfiguredFeatures();
		ModBiomes.initBiomes();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModFuels();
		ModRegistries.registerStrippables();

		ModCommandRegister.registerCommands();
		ModEventsRegister.registerEvents();

		ModRecipes.register();

		ModLootTableModifiers.modifyLootTables();
		ModSounds.registerSounds();

		ModEnchantments.registerModEnchantments();

		ModBiomes.registerBiomes();
		ModWorldGen.generateModWorldGen();
		ModDimensions.register();

		ModPortals.registerPortals();

		System.out.println("Hello Fabric world!");
	}
}
