package net.endplex.plexmod.item.custom;

import net.endplex.plexmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BananaWandItem extends Item {
    public BananaWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState bananaBlockState = ModBlocks.BANANA_BLOCK.getDefaultState();

        if (world.getBlockState(pos) == bananaBlockState) {
            world.breakBlock(pos, true);
        }
        else {
            world.setBlockState(pos, bananaBlockState);
        }

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.plexmod.banana_wand")); // Translation added

        super.appendTooltip(stack, world, tooltip, context);
    }
}
