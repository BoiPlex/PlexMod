//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.endplex.plexmod.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class BananaPotionItem extends Item {
    private static final int MAX_USE_TIME = 32;

    public BananaPotionItem(Settings settings) {
        super(settings);
    }

    public ItemStack getDefaultStack() {
        return PotionUtil.setPotion(super.getDefaultStack(), Potions.WATER);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;
        if (playerEntity instanceof ServerPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity)playerEntity, stack);
        }

        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 2));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 0));
        }

        if (playerEntity != null) {
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!playerEntity.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }

        if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (playerEntity != null) {
                playerEntity.getInventory().insertStack(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        world.emitGameEvent(user, GameEvent.DRINKING_FINISH, user.getCameraBlockPos());
        return stack;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    public boolean hasGlint(ItemStack stack) {
        return super.hasGlint(stack) || !PotionUtil.getPotionEffects(stack).isEmpty();
    }

}
