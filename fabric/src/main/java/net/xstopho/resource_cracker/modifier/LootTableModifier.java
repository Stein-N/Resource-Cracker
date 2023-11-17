package net.xstopho.resource_cracker.modifier;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.xstopho.resource_cracker.config.ConstantConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class LootTableModifier {

    private static LootTable.Builder build;
    private static ResourceLocation location;

    public static void init() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            build = tableBuilder;
            location = id;

            modifyLootTables(getEntityID("zombie"), 0.15f, ItemRegistry.GARLIC, 2f);
            modifyLootTables(getEntityID("creeper"), 0.15f, ItemRegistry.MATERIAL_DUST_SULFUR, 1f);
            modifyLootTables(getEntityID("creeper"), 0.10f, ItemRegistry.MATERIAL_DUST_SALTPETER, 1f);

            modifyLootTables(getBlockID("diamond_ore"), 0.15f, ItemRegistry.DIAMOND_NUGGET, 2f);
            modifyLootTables(getBlockID("deepslate_diamond_ore"), 0.15f, ItemRegistry.DIAMOND_NUGGET, 2f);

            modifyLootTables(getBlockID("coal_ore"), 0.025f, ItemRegistry.DIAMOND_NUGGET, 1f);
            modifyLootTables(getBlockID("deepslate_coal_ore"), 0.025f, ItemRegistry.DIAMOND_NUGGET, 1f);

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_SULFUR, ConstantConfig.SULFUR.get(),6f,
                    "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "village/village_desert_house");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_SALTPETER, ConstantConfig.SALTPETER.get(), 6f,
                    "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "desert_pyramid", "village/village_desert_house");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_COPPER, ConstantConfig.COPPER_DUST.get(), 6f,
                    "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith", "abandoned_mineshafts");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_IRON, ConstantConfig.IRON_DUST.get(), 6f,
                    "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith", "abandoned_mineshafts");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_GOLD, ConstantConfig.GOLD_DUST.get(), 6f,
                    "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith", "abandoned_mineshafts");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_EMERALD, ConstantConfig.EMERALD_DUST.get(), 3f,
                    "shipwreck_treasure", "abandoned_mineshafts");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_DIAMOND, ConstantConfig.DIAMOND_DUST.get(), 3f,
                    "shipwreck_treasure", "ancient_city");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, ConstantConfig.NETHERITE_SCRAP.get(), 2f,
                    "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "ancient_city");

            modifyStructureLoot(ItemRegistry.MATERIAL_DUST_NETHERITE, ConstantConfig.NETHERITE.get(), 2f,
                    "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "ancient_city");

            modifyStructureLoot(ItemRegistry.DIAMOND_NUGGET, ConstantConfig.DIAMOND_NUGGET.get(), 4f,
                    "desert_pyramid", "shipwreck_treasure", "abandoned_mineshafts", "ancient_city");

            modifyStructureLoot(ItemRegistry.GARLIC, ConstantConfig.GARLIC.get(), 6f,
                    "spawn_bonus_chest");

            modifyStructureLoot(ItemRegistry.CRACK_HAMMER_COPPER, ConstantConfig.HAMMER_COPPER.get(), 1f,
                    "spawn_bonus_chest");

            modifyStructureLoot(ItemRegistry.CRACK_HAMMER_IRON, ConstantConfig.HAMMER_IRON.get(), 1f,
                    "spawn_bonus_chest", "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith");

            modifyStructureLoot(ItemRegistry.CRACK_HAMMER_STEEL, ConstantConfig.HAMMER_STEEL.get(), 1f,
                    "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith");

        });
    }

    private static void modifyLootTables(ResourceLocation id, float chance, Item dropItem, float amount) {
        if (location.equals(id)) {
            build.withPool(getBuilder(dropItem, chance, amount));
        }
    }

    private static void modifyStructureLoot(Item item, float chance, float maxAmount, String... structures) {
        for (String id : structures) {
            if (location.equals(getChestID(id))) {
                build.withPool(getBuilder(item, chance, maxAmount));
            }
        }
    }

    private static LootPool.Builder getBuilder(Item item, float chance, float maxAmount) {
        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .when(LootItemRandomChanceCondition.randomChance(value(chance)))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, maxAmount)));
    }

    private static ResourceLocation getBlockID(String id) {
        return new ResourceLocation("blocks/" + id);
    }

    private static ResourceLocation getChestID(String id) {
        return new ResourceLocation("chests/" + id);
    }

    private static ResourceLocation getEntityID(String id) {
        return new ResourceLocation("entities/" + id);
    }

    private static float value(float chance) {
        return Math.min(1.0f, Math.max(0.0f, chance));
    }
}
