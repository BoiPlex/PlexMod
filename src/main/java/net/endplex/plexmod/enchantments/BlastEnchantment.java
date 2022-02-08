package net.endplex.plexmod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.explosion.Explosion;

public class BlastEnchantment extends Enchantment {

    public BlastEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient() && target instanceof LivingEntity) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);

            if (player.totalExperience >= (level * 3) && player.isSneaking()) {
                world.createExplosion(target, target.getX(), target.getY(), target.getZ(), level, true, Explosion.DestructionType.BREAK);
                player.addExperience(-level * 3);
            }

            /*
            TntEntity tntEntity = EntityType.TNT.create(world);
            tntEntity.setFuse(0);
            tntEntity.setPosition(target.prevX, target.prevY, target.prevZ);
            world.spawnEntity(tntEntity);
            */
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
