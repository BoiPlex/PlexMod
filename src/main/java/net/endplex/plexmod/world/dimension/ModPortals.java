package net.endplex.plexmod.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.endplex.plexmod.block.ModBlocks;
import net.endplex.plexmod.item.ModItems;

public class ModPortals {
    public static void registerPortals() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.RUBY_BLOCK)
                .lightWithItem(ModItems.PEPPER)
                .destDimID(ModDimensions.KJDIM_KEY.getValue())
                .tintColor(150, 200, 60)
                .registerPortal();
    }
}
