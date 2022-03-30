package net.endplex.plexmod;

import net.endplex.plexmod.entity.EntitySpawnPacket;
import net.endplex.plexmod.entity.ModEntityType;
import net.endplex.plexmod.util.render.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.endplex.plexmod.screen.LightningChannelerScreen;
import net.endplex.plexmod.screen.ModScreenHandlers;
import net.endplex.plexmod.util.ModRenderHelper;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class PlexModClient implements ClientModInitializer {
    //public static final Identifier PacketID = new Identifier(PlexMod.MOD_ID, "spawn_packet");

    @Override
    public void onInitializeClient() {
        ModRenderHelper.setRenderLayers();
        ScreenRegistry.register(ModScreenHandlers.LIGHTNING_CHANNELER_SCREEN_HANDLER, LightningChannelerScreen::new);

        /*
        EntityRendererRegistry.register(ModEntityType.EARTH_TRIDENT, EarthTridentEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityType.OCEAN_TRIDENT, OceanTridentEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityType.ICE_TRIDENT, IceTridentEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityType.SKY_TRIDENT, SkyTridentEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityType.NETHER_TRIDENT, NetherTridentEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityType.END_TRIDENT, EndTridentEntityRenderer::new);
        receiveEntityPacket();
         */
    }

    /*
    public void receiveEntityPacket() {
        ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
            EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
            float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            ctx.getTaskQueue().execute(() -> {
                if (MinecraftClient.getInstance().world == null)
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                Entity e = et.create(MinecraftClient.getInstance().world);
                if (e == null)
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                e.updateTrackedPosition(pos);
                e.setPos(pos.x, pos.y, pos.z);
                e.setPitch(pitch);
                e.setYaw(yaw);
                e.setId(entityId);
                e.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });
    }

     */
}
