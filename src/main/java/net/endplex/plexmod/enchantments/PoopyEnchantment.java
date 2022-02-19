package net.endplex.plexmod.enchantments;

import net.endplex.plexmod.item.ModItems;
import net.endplex.plexmod.item.entity.GrenadeEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class PoopyEnchantment extends Enchantment {
    public PoopyEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient() && target instanceof LivingEntity) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);
            BlockPos position = target.getBlockPos();

            for (int i = 0; i < level; i++) {
                GrenadeEntity entity = new GrenadeEntity(world, user);

                entity.setItem(ModItems.POOP.getDefaultStack());
                entity.setProperties(user, user.getPitch(), user.getYaw(), 1.0F, 1.5F, 1.0F);
                world.spawnEntity(entity);
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
