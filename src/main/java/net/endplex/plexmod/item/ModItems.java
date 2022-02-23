package net.endplex.plexmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.endplex.plexmod.PlexMod;
import net.endplex.plexmod.block.ModBlocks;
import net.endplex.plexmod.config.ModConfigs;
import net.endplex.plexmod.item.custom.*;

public class ModItems {
    public static final Item BANANA = registerItem("banana",
            new BananaItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())
            .group(ModItemGroup.PLEX)));
    public static final Item BANANA_BUNDLE = registerItem("banana_bundle",
            new Item(new FabricItemSettings()
            .group(ModItemGroup.PLEX)));
    public static final Item BANANA_INGOT = registerItem("banana_ingot",
            new Item(new FabricItemSettings()
            .group(ModItemGroup.PLEX)));
    public static final Item BANANA_BREAD = registerItem("banana_bread",
            new BananaBreadItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build())
            .group(ModItemGroup.PLEX)));
    public static final Item BANANA_WAND = registerItem("banana_wand",
            new BananaWandItem(new FabricItemSettings()
                    .maxCount(1)
                    .group(ModItemGroup.PLEX)));

    public static final Item BANANA_SWORD = registerItem("banana_sword",
            new BananaSwordItem(ModToolMaterial.BANANA, 10, 1f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item BANANA_SHOVEL = registerItem("banana_shovel",
            new ShovelItem(ModToolMaterial.BANANA, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item BANANA_PICKAXE = registerItem("banana_pickaxe",
            new ModPickaxeItem(ModToolMaterial.BANANA, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item BANANA_AXE = registerItem("banana_axe",
            new ModAxeItem(ModToolMaterial.BANANA, 15, -1f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item BANANA_HOE = registerItem("banana_hoe",
            new ModHoeItem(ModToolMaterial.BANANA, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));

    public static final Item BANANA_HELMET = registerItem("banana_helmet",
            new ModArmorItem(ModArmorMaterial.BANANA, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item BANANA_CHESTPLATE = registerItem("banana_chestplate",
            new ArmorItem(ModArmorMaterial.BANANA, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item BANANA_LEGGINGS = registerItem("banana_leggings",
            new ArmorItem(ModArmorMaterial.BANANA, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item BANANA_BOOTS = registerItem("banana_boots",
            new ArmorItem(ModArmorMaterial.BANANA, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));

    public static final Item GRENADE = registerItem("grenade",
            new GrenadeItem(new FabricItemSettings()
                    .maxCount(16)
                    .group(ModItemGroup.PLEX)));
    public static final Item POOP = registerItem("poop",
            new GrenadeItem(new FabricItemSettings()
                    .maxCount(16)
                    .group(ModItemGroup.PLEX)));
    public static final Item GLASS_PICKAXE = registerItem("glass_pickaxe",
            new ModPickaxeItem(ModToolMaterial.GLASS, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));

    public static final Item WOOD_DRILL = registerItem("wood_drill",
            new DrillItem(ToolMaterials.WOOD, 0, 2f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item STONE_DRILL = registerItem("stone_drill",
            new DrillItem(ToolMaterials.STONE, 0, 2f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item IRON_DRILL = registerItem("iron_drill",
            new DrillItem(ToolMaterials.IRON, 0, 2f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item GOLD_DRILL = registerItem("gold_drill",
            new DrillItem(ToolMaterials.GOLD, 0, 2f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item DIAMOND_DRILL = registerItem("diamond_drill",
            new DrillItem(ToolMaterials.DIAMOND, 0, 2f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item NETHERITE_DRILL = registerItem("netherite_drill",
            new DrillItem(ToolMaterials.NETHERITE, 0, 2f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.PLEX)));
    public static final Item BANANA_DRILL = registerItem("banana_drill",
            new DrillItem(ModToolMaterial.BANANA, 0, 2f,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));

    public static final Item BANANA_POTION = registerItem("banana_potion",
            new BananaPotionItem(new FabricItemSettings()
                    .group(ModItemGroup.PLEX)));
    public static final Item BANANA_SPLASH_POTION = registerItem("banana_splash_potion",
            new BananaSplashPotionItem(new FabricItemSettings()
                    .group(ModItemGroup.PLEX)));
    public static final Item BANANA_LINGERING_POTION = registerItem("banana_lingering_potion",
            new BananaLingeringPotionItem(new FabricItemSettings()
                    .group(ModItemGroup.PLEX)));
    public static final Item LAUNCH_POTION = registerItem("launch_potion",
            new LaunchPotionItem(new FabricItemSettings()
                    .group(ModItemGroup.PLEX)));
    public static final Item LAUNCH_SPLASH_POTION = registerItem("launch_splash_potion",
            new BananaPotionItem(new FabricItemSettings()
                    .group(ModItemGroup.PLEX)));
    public static final Item LAUNCH_LINGERING_POTION = registerItem("launch_lingering_potion",
            new BananaPotionItem(new FabricItemSettings()
                    .group(ModItemGroup.PLEX)));

    // Rest of turtle armor
    public static final Item TURTLE_CHESTPLATE = registerItem("turtle_chestplate",
            new TurtleChestplateItem(ArmorMaterials.TURTLE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item TURTLE_LEGGINGS = registerItem("turtle_leggings",
            new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));
    public static final Item TURTLE_BOOTS = registerItem("turtle_boots",
            new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.PLEX)));

    
    // -----

    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item PEPPER = registerItem("pepper", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())
            .group(ModItemGroup.RUBY)));

    public static final Item DOWSING_ROD = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.RUBY)
                    .maxDamage(ModConfigs.MAX_DAMAGE_DOWSING_ROD)));

    public static final Item IRON_WOOL = registerItem("iron_wool",
            new Item(new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterial.RUBY, 2, 1f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new ModPickaxeItem(ModToolMaterial.RUBY, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new ModAxeItem(ModToolMaterial.RUBY, 4, -1f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new ModHoeItem(ModToolMaterial.RUBY, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item RUBY_HORSE_ARMOR = registerItem("ruby_horse_armor",
            new HorseArmorItem(7, "ruby",
                    new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item DATA_TABLET = registerItem("data_tablet",
            new DataTabletItem(new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item PEPPER_SEEDS = registerItem("pepper_seeds",
            new AliasedBlockItem(ModBlocks.PEPPER_PLANT, new FabricItemSettings().group(ModItemGroup.RUBY)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(PlexMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + PlexMod.MOD_ID);
    }
}
