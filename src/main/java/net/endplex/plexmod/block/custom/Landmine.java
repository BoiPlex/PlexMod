package net.endplex.plexmod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class Landmine extends ModPressurePlateBlock {

    public Landmine(ActivationRule type, Settings settings) {
        super(type, settings);
    }

    // Explodes after pressure plate is pressed
    @Override
    protected void playPressSound(WorldAccess world, BlockPos pos) {
        if(!world.isClient()) {
            ServerWorld serverWorld = ((ServerWorld) world);
            // Not using
            // float power = new Random().nextFloat() * 2 + 1
            serverWorld.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3, false, Explosion.DestructionType.DESTROY);
        }

        super.playPressSound(world, pos);
    }
}
