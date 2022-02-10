package net.endplex.plexmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BoostBlock extends Block {

    public BoostBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = ((PlayerEntity) entity);

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 15, 9));
            world.addBlockBreakParticles(pos, state);
            player.playSound(SoundEvents.ITEM_SPYGLASS_USE, 3, 10);
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new TranslatableText("tooltip.plexmod.boost_block")); // Add translation to this

        super.appendTooltip(stack, world, tooltip, options);
    }
}
