package net.endplex.plexmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.endplex.plexmod.PlexMod;

public class ModItemGroup {
    public static final ItemGroup RUBY = FabricItemGroupBuilder.build(new Identifier(PlexMod.MOD_ID, "ruby"),
            () -> new ItemStack(ModItems.RUBY));

    public static final ItemGroup PLEX = FabricItemGroupBuilder.build(new Identifier(PlexMod.MOD_ID, "plex"),
            () -> new ItemStack(Items.BAKED_POTATO));
}
