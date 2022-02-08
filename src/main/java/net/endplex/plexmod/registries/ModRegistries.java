package net.endplex.plexmod.registries;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.endplex.plexmod.PlexMod;
import net.endplex.plexmod.block.ModBlocks;
import net.endplex.plexmod.item.ModItems;

public class ModRegistries {

    public static void registerModFuels() {
        System.out.println("Now registering Fuels for " + PlexMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.IRON_WOOL, 300); // x / 20
        registry.add(ModItems.PEPPER, 60);

        registry.add(ModItems.BANANA, 100);
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.REDWOOD_LOG, ModBlocks.STRIPPED_REDWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.REDWOOD_WOOD, ModBlocks.STRIPPED_REDWOOD_WOOD);
    }
}
