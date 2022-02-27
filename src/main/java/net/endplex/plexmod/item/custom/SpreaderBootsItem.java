package net.endplex.plexmod.item.custom;

import net.endplex.plexmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpreaderBootsItem extends ModArmorItem {

    public SpreaderBootsItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        PlayerEntity player = (PlayerEntity) entity;
        ItemStack boots = player.getInventory().getArmorStack(0);

        // If wearing the spreader boots
        if (!boots.isEmpty() && boots.getItem() == ModItems.SPREADER_BOOTS) {
            BlockPos pos = player.getBlockPos().add(0, -1, 0);
            BlockState steppedBlock = world.getBlockState(pos);
            ItemStack itemHeld = player.getMainHandStack();
            BlockState blockHeld = null;

            if (!player.isSneaking() && !itemHeld.isEmpty() && itemHeld.getItem() instanceof BlockItem) {
                blockHeld = ((BlockItem) itemHeld.getItem()).getBlock().getDefaultState();
            }

            if (blockHeld != null && steppedBlock != blockHeld) {
                world.setBlockState(pos, blockHeld);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("tooltip.plexmod.spreader_boots_shift"));
        } else {
            tooltip.add(new TranslatableText("tooltip.plexmod.spreader_boots"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

}
