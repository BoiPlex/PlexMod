package net.endplex.plexmod.enchantments;

import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class TestEnchantment extends Enchantment {

    public TestEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient() && target instanceof LivingEntity) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);
            BlockPos pos = target.getBlockPos();

            if (player.isSneaking()) {
                for (int i = 0; i < level; i++) {
                    // world.setBlockState(pos.add(0, 10, 0), Blocks.RED_SAND.getDefaultState());

                    ItemStack itemStack = user.getStackInHand(player.getActiveHand());
                    SnowballEntity snowballEntity = new SnowballEntity(world, user);
                    snowballEntity.setItem(itemStack);
                    snowballEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 5.0F);
                    world.spawnEntity(snowballEntity);
                }
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
