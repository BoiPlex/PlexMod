package net.endplex.plexmod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class HiveMasterEnchantment extends Enchantment {
    public HiveMasterEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);
            BlockPos position = target.getBlockPos();

            EntityType.BEE.spawn(world, null, null, player, position,
                    SpawnReason.TRIGGERED, true, true);
        }
        super.onTargetDamaged(user, target, level);
    }



    @Override
    public int getMaxLevel() {
        return 1;
    }
}
