package net.endplex.plexmod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.endplex.plexmod.PlexMod;

public class ModEnchantments {
    public static Enchantment LIGHTNING_STRIKER = register("lightning_striker",
            new LightningStrikerEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment KAMAKAZEE = register("kamakazee",
            new KamakazeeEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.BREAKABLE, EquipmentSlot.MAINHAND));
    public static Enchantment BLAST = register("blast",
            new BlastEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.BREAKABLE, EquipmentSlot.MAINHAND));
    public static Enchantment HIVE_MASTER = register("hive_master",
            new HiveMasterEnchantment(Enchantment.Rarity.COMMON,
                    EnchantmentTarget.WEARABLE, EquipmentSlot.MAINHAND));
    public static Enchantment BERSERKER = register("berserker",
            new BerskerkerEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment TEST = register("test",
            new TestEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.BREAKABLE, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(PlexMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering ModEnchantments for " + PlexMod.MOD_ID);
    }
}
