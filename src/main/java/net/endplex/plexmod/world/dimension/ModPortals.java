package net.endplex.plexmod.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.endplex.plexmod.block.ModBlocks;
import net.endplex.plexmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

public class ModPortals {
    public static void registerPortals() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.RUBY_BLOCK)
                .lightWithItem(ModItems.PEPPER)
                .destDimID(ModDimensions.KJDIM_KEY.getValue())
                .tintColor(150, 200, 60)
                .registerPortal();

        // Dark Land Dimension
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.NETHERITE_BLOCK)
                .lightWithItem(Items.NETHER_STAR)
                .destDimID(ModDimensions.DARK_KEY.getValue())
                .tintColor(54, 27, 33)
                .registerPortal();

        // Aether Dimension
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.GLOWSTONE)
                .lightWithItem(Items.WATER_BUCKET)
                .destDimID(ModDimensions.AETHER_KEY.getValue())
                .tintColor(58, 178, 218)
                .registerPortal();
    }
}
