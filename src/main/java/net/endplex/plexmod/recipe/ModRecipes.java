package net.endplex.plexmod.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.endplex.plexmod.PlexMod;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(PlexMod.MOD_ID, LightningChannelerRecipe.Serializer.ID),
                LightningChannelerRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(PlexMod.MOD_ID, LightningChannelerRecipe.Type.ID),
                LightningChannelerRecipe.Type.INSTANCE);
    }
}
