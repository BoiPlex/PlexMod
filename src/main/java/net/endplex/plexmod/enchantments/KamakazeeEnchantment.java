package net.endplex.plexmod.enchantments;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class KamakazeeEnchantment extends Enchantment {
    public KamakazeeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient() && target instanceof LivingEntity) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);
            BlockPos position = target.getBlockPos();

            for (int i = 0; i < level; i++) {
                TntEntity tntEntity = EntityType.TNT.create(world);
                tntEntity.setFuse(25);
                tntEntity.setPosition(target.prevX, target.prevY + 10, target.prevZ);

                world.spawnEntity(tntEntity);

                /* Bad version
                EntityType.TNT.spawn(world, null, null, player, position,
                        SpawnReason.TRIGGERED, true, true);
                */
            }

        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
