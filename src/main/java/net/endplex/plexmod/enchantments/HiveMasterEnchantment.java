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

import java.util.UUID;

public class HiveMasterEnchantment extends Enchantment {
    public HiveMasterEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient() && target instanceof LivingEntity) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);

            for (int i = 0; i < level; i++) {
                BeeEntity bee = EntityType.BEE.create(world);
                assert bee != null;
                bee.setAttacker((LivingEntity) target);
                bee.setAngryAt(target.getUuid());
                bee.setTarget((LivingEntity) target);
                bee.setAngerTime(6000); // 5 minutes
                bee.setPosition(player.prevX, player.prevY, player.prevZ);
                world.spawnEntity(bee);
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
