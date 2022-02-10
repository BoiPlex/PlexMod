package net.endplex.plexmod.item.custom;

import net.endplex.plexmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
}
