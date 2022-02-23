package net.endplex.plexmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.endplex.plexmod.item.ModArmorMaterial;
import net.minecraft.world.explosion.Explosion;

import java.util.Map;
import java.util.Random;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffect> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffect>())
                    .put(ModArmorMaterial.RUBY, StatusEffects.INVISIBILITY)
                    .put(ModArmorMaterial.BANANA, StatusEffects.SPEED)
                    .put(ArmorMaterials.TURTLE, StatusEffects.DOLPHINS_GRACE)
                    .build();
            // If you want unique effects/abilities or no potion effect you can edit the addStatusEffectForMaterial method

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {

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

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return super.canRepair(stack, ingredient);
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffect mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect);

        // If has correct armor
        if(hasCorrectArmorOn(mapArmorMaterial, player)) {
            // Banana armor gives temporary jump 3 if sneaking (sneak + jump for a high jump)
            if (mapArmorMaterial == ModArmorMaterial.BANANA && player.isSneaking()) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 5, 2));
            }
            /*
            // Explode if wearing banana armor and on fire
            if (mapArmorMaterial == ModArmorMaterial.BANANA && player.isOnFire()) {
                World world = player.getEntityWorld();
                world.createExplosion(player, player.getX(), player.getY(), player.getZ(), 10, true, Explosion.DestructionType.BREAK);
            }
             */

            // If player doesn't already have the main effect
            if (!hasPlayerEffect) {
                // Give main effect
                player.addStatusEffect(new StatusEffectInstance(mapStatusEffect, 200, 0));

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
