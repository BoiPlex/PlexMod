package net.endplex.plexmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Objects;

public class TurtleChestplateItem extends ModArmorItem {
    public TurtleChestplateItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        PlayerEntity player = (PlayerEntity) entity;
        if (player.isSneaking()) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5, 1));
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
