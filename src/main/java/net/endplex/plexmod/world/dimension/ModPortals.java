package net.endplex.plexmod.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.endplex.plexmod.block.ModBlocks;
import net.endplex.plexmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.world.dimension.DimensionType;

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

        // End Dimension (Vanilla)
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.END_STONE_BRICKS)
                .lightWithItem(Items.DRAGON_BREATH)
                .destDimID(DimensionType.THE_END_ID)
                .tintColor(245, 90, 250)
                .registerPortal();

        // End Dimension (Vanilla)
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.BANANA_BLOCK)
                .lightWithItem(ModItems.BANANA)
                .destDimID(ModDimensions.BANANA_KEY.getValue())
                .tintColor(227, 250, 55)
                .registerPortal();

    }
}
