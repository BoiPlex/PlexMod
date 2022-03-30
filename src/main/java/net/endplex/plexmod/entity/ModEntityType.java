package net.endplex.plexmod.entity;

import net.endplex.plexmod.PlexMod;
import net.endplex.plexmod.entity.trident.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntityType {
    public static final EntityType<EarthTridentEntity> EARTH_TRIDENT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(PlexMod.MOD_ID, "earth_trident"),
            FabricEntityTypeBuilder.<EarthTridentEntity>create(SpawnGroup.MISC, EarthTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
    public static final EntityType<OceanTridentEntity> OCEAN_TRIDENT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(PlexMod.MOD_ID, "ocean_trident"),
            FabricEntityTypeBuilder.<OceanTridentEntity>create(SpawnGroup.MISC, OceanTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
    public static final EntityType<IceTridentEntity> ICE_TRIDENT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(PlexMod.MOD_ID, "ice_trident"),
            FabricEntityTypeBuilder.<IceTridentEntity>create(SpawnGroup.MISC, IceTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
    public static final EntityType<SkyTridentEntity> SKY_TRIDENT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(PlexMod.MOD_ID, "sky_trident"),
            FabricEntityTypeBuilder.<SkyTridentEntity>create(SpawnGroup.MISC, SkyTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
    public static final EntityType<NetherTridentEntity> NETHER_TRIDENT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(PlexMod.MOD_ID, "nether_trident"),
            FabricEntityTypeBuilder.<NetherTridentEntity>create(SpawnGroup.MISC, NetherTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
    public static final EntityType<EndTridentEntity> END_TRIDENT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(PlexMod.MOD_ID, "end_trident"),
            FabricEntityTypeBuilder.<EndTridentEntity>create(SpawnGroup.MISC, EndTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
}
