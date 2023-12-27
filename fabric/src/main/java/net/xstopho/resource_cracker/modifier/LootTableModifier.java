package net.xstopho.resource_cracker.modifier;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootTable;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class LootTableModifier {

    private static LootTable.Builder build;
    private static ResourceLocation location;

    public static void init() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            build = tableBuilder;
            location = id;


            modifyEntityLoot(ItemRegistry.GARLIC, ConstantConfig.GARLIC_FROM_ZOMBIE.get().floatValue(), 2f, "zombie");
            modifyEntityLoot( ItemRegistry.MATERIAL_DUST_SULFUR, ConstantConfig.SULFUR_FROM_CREEPER.get().floatValue(), 1f, "creeper");
            modifyEntityLoot( ItemRegistry.MATERIAL_DUST_SALTPETER, ConstantConfig.SALTPETER_FROM_CREEPER.get().floatValue(), 1f, "creeper");

            modifyBlockLoot( ItemRegistry.DIAMOND_NUGGET, ConstantConfig.DIAMOND_NUGGET_FROM_DIAMOND.get().floatValue(), 2f, "diamond_ore", "deepslate_diamond_ore");
            modifyBlockLoot( ItemRegistry.DIAMOND_NUGGET, ConstantConfig.DIAMOND_NUGGET_FROM_COAL.get().floatValue(), 1f, "coal_ore", "deepslate_coal_ore");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_SULFUR, ConstantConfig.SULFUR.get().floatValue(), 6f,
                    "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "village/village_desert_house");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_SALTPETER, ConstantConfig.SALTPETER.get().floatValue(), 6f,
                    "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "desert_pyramid", "village/village_desert_house");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_COPPER, ConstantConfig.COPPER_DUST.get().floatValue(), 6f,
                    "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith", "abandoned_mineshafts");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_IRON, ConstantConfig.IRON_DUST.get().floatValue(), 6f,
                    "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith", "abandoned_mineshafts");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_GOLD, ConstantConfig.GOLD_DUST.get().floatValue(), 6f,
                    "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith", "abandoned_mineshafts");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_EMERALD, ConstantConfig.EMERALD_DUST.get().floatValue(), 3f,
                    "shipwreck_treasure", "abandoned_mineshafts");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_DIAMOND, ConstantConfig.DIAMOND_DUST.get().floatValue(), 3f,
                    "shipwreck_treasure", "ancient_city");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, ConstantConfig.NETHERITE_SCRAP.get().floatValue(), 2f,
                    "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "ancient_city");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_NETHERITE, ConstantConfig.NETHERITE.get().floatValue(), 2f,
                    "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "ancient_city");

            modifyStructureLoot(ItemRegistry.DIAMOND_NUGGET, ConstantConfig.DIAMOND_NUGGET.get().floatValue(), 4f,
                    "desert_pyramid", "shipwreck_treasure", "abandoned_mineshafts", "ancient_city");

            modifyStructureLoot(ItemRegistry.GARLIC, ConstantConfig.GARLIC.get().floatValue(), 6f,
                    "spawn_bonus_chest");

            modifyStructureLoot(ItemRegistry.CRACK_HAMMER_COPPER, ConstantConfig.HAMMER_COPPER.get().floatValue(), 1f,
                    "spawn_bonus_chest");

            modifyStructureLoot(ItemRegistry.CRACK_HAMMER_IRON, ConstantConfig.HAMMER_IRON.get().floatValue(), 1f,
                    "spawn_bonus_chest", "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith");

            modifyStructureLoot(ItemRegistry.CRACK_HAMMER_STEEL, ConstantConfig.HAMMER_STEEL.get().floatValue(), 1f,
                    "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith");

        });
    }

    private static void modifyEntityLoot(Item item, float chance, float maxAmount, String... entities) {
        for (String entity : entities) {
            if (location.equals(ConstantLootModifier.getEntityID(entity))) {
                build.withPool(ConstantLootModifier.createPool(item, chance, maxAmount));
            }
        }
    }

    private static void modifyBlockLoot(Item item, float chance, float maxAmount, String... blocks) {
        for (String block : blocks) {
            if (location.equals(ConstantLootModifier.getBlockID(block))) {
                build.withPool(ConstantLootModifier.createPool(item, chance, maxAmount));
            }
        }
    }

    private static void modifyStructureLoot(Item item, float chance, float maxAmount, String... structures) {
        for (String id : structures) {
            if (location.equals(ConstantLootModifier.getChestID(id))) {
                build.withPool(ConstantLootModifier.createPool(item, chance, maxAmount));
            }
        }
    }
}
