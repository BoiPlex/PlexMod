package net.endplex.plexmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.endplex.plexmod.item.ModArmorMaterial;

import java.util.Map;
import java.util.Random;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffect> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffect>())
                    .put(ModArmorMaterial.RUBY, StatusEffects.INVISIBILITY)
                    .put(ArmorMaterials.GOLD, StatusEffects.HASTE)
                    .put(ArmorMaterials.LEATHER, StatusEffects.SPEED)
                    .put(ModArmorMaterial.BANANA, StatusEffects.REGENERATION)
                    .put(ArmorMaterials.NETHERITE, StatusEffects.SLOWNESS)
                    .build();
            // If you want unique effects/abilities or no potion effect you can edit the addStatusEffectForMaterial method

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;

                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffect> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffect mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffect mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect);

        int amplifier = 0;
        // Banana armor gives regen 2
        if (mapArmorMaterial == ModArmorMaterial.BANANA) {
            amplifier = 1;
        }

        // If has correct armor
        if(hasCorrectArmorOn(mapArmorMaterial, player)) {
            // Netherite armor gives strength 2 if on fire and not already have strength
            if (mapArmorMaterial == ArmorMaterials.NETHERITE && player.isOnFire() && !player.hasStatusEffect(StatusEffects.STRENGTH)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20, 1));
            }
            // Leather armor gives temporary jump 3 if sneaking (sneak + jump for a high jump)
            if (mapArmorMaterial == ArmorMaterials.LEATHER && player.isSneaking()) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 5, 2));
            }

            // If player doesn't already have an effect
            if (!hasPlayerEffect) {
                // Give effect
                player.addStatusEffect(new StatusEffectInstance(mapStatusEffect, 200, amplifier));

                // 60% chance to damage ruby armor after giving effect
                if(mapArmorMaterial == ModArmorMaterial.RUBY && new Random().nextFloat() > 0.6f) {
                    player.getInventory().damageArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
                }
            }

        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
