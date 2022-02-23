package net.endplex.plexmod.item.custom;

import net.endplex.plexmod.item.ModItems;
import net.endplex.plexmod.item.ModToolMaterial;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class DrillItem extends ModPickaxeItem {
    public DrillItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        int n = 0;
        int stripN = 0;
        boolean cuber = true;
        // True: Mine a cube
        // False: Mine a cube randomly

        if (this.getMaterial() == ToolMaterials.WOOD) {
            n = 1;
            cuber = false;
            stripN = 1;
        }
        else if (this.getMaterial() == ToolMaterials.STONE) {
            n = 2;
            cuber = false;
            stripN = 2;
        }
        else if (this.getMaterial() == ToolMaterials.IRON) {
            n = 1;
            stripN = 3;
        }
        else if (this.getMaterial() == ToolMaterials.GOLD) {
            n = 3;
            cuber = false;
            stripN = 4;
        }
        else if (this.getMaterial() == ToolMaterials.DIAMOND) {
            n = 2;
            stripN = 5;
        }
        else if (this.getMaterial() == ToolMaterials.NETHERITE) {
            n = 3;
            stripN = 6;
        }
        else if (this.getMaterial() == ModToolMaterial.BANANA) {
            n = 4;
            cuber = false;
            stripN = 7;
        }

        if (miner.isSneaking())
            stripMine(world, pos, miner, n);
        else if (cuber)
            cubeMine(world, pos, n);
        else
            randCubeMine(world, pos, n);

        return super.postMine(stack, world, state, pos, miner);
    }

    private void cubeMine(World world, BlockPos pos, int n) {
        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++) {
                for (int k = -n; k <= n; k++) {
                    world.breakBlock(pos.add(i, j, k), true);
                }
            }
        }
    }

    private void randCubeMine(World world, BlockPos pos, int n) {
        Random rand = new Random();

        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++) {
                for (int k = -n; k <= n; k++) {
                    if (rand.nextBoolean())
                        world.breakBlock(pos.add(i, j, k), true);
                }
            }
        }
    }

    private void stripMine(World world, BlockPos pos, LivingEntity miner, int n) {
        Direction dir = miner.getMovementDirection();

        // Only works for west/east for some reason
        for (int i = 0; i <= n; i++) {
            if (dir == Direction.EAST)
                world.breakBlock(pos.add(i, 0, 0), true);
            else if (dir == Direction.WEST)
                world.breakBlock(pos.add(-i, 0, 0), true);
            else if (dir == Direction.NORTH)
                world.breakBlock(pos.add(0, 0, i), true);
            else if (dir == Direction.SOUTH)
                world.breakBlock(pos.add(0, 0, -i), true);
            else if (dir == Direction.UP)
                world.breakBlock(pos.add(0, i, 0), true);
            else if (dir == Direction.DOWN)
                world.breakBlock(pos.add(0, -i, 0), true);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("tooltip.plexmod.iron_drill_shift"));
        } else {
            tooltip.add(new TranslatableText("tooltip.plexmod.iron_drill"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}

