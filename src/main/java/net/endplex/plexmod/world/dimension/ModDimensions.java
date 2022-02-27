package net.endplex.plexmod.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.endplex.plexmod.PlexMod;

public class ModDimensions {
    private static final RegistryKey<DimensionOptions> KJDIM_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(PlexMod.MOD_ID, "kjdim"));
    public static RegistryKey<World> KJDIM_KEY = RegistryKey.of(Registry.WORLD_KEY, KJDIM_DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> KJDIM_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(PlexMod.MOD_ID, "kjdim_type"));

    private static final RegistryKey<DimensionOptions> DARK_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(PlexMod.MOD_ID, "dark"));
    public static RegistryKey<World> DARK_KEY = RegistryKey.of(Registry.WORLD_KEY, DARK_DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> DARK_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(PlexMod.MOD_ID, "dark_type"));

    private static final RegistryKey<DimensionOptions> AETHER_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(PlexMod.MOD_ID, "aether"));
    public static RegistryKey<World> AETHER_KEY = RegistryKey.of(Registry.WORLD_KEY, AETHER_DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> AETHER_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(PlexMod.MOD_ID, "aether_type"));

    private static final RegistryKey<DimensionOptions> BANANA_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(PlexMod.MOD_ID, "banana"));
    public static RegistryKey<World> BANANA_KEY = RegistryKey.of(Registry.WORLD_KEY, BANANA_DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> BANANA_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(PlexMod.MOD_ID, "banana_type"));

    public static void register() {
        System.out.println("Registering ModDimensions for " + PlexMod.MOD_ID);
    }
}
