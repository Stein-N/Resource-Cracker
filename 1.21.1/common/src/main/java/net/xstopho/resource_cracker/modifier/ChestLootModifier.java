package net.xstopho.resource_cracker.modifier;

import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;
import net.xstopho.resourcelibrary.modifier.loot_tables.ChestLootTables;

import java.util.function.Supplier;

public class ChestLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addItems(ItemRegistry.MATERIAL_DUST_SULFUR, 6f, () -> LootConfig.sulfur,
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.VILLAGE_DESERT_HOUSE);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, 6f, () -> LootConfig.saltpeter,
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.DESERT_PYRAMID,
                ChestLootTables.VILLAGE_DESERT_HOUSE);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_COPPER, 1f, 6f, () -> LootConfig.copperDust,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_GOLD, 1f, 6f, () -> LootConfig.goldDust,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_IRON, 1f, 6f, () -> LootConfig.ironDust,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_EMERALD, 1f, 3f, () -> LootConfig.emeraldDust,
                ChestLootTables.SHIPWRECK_TREASURE,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_DIAMOND, 1f, 3, () -> LootConfig.diamondDust,
                ChestLootTables.SHIPWRECK_TREASURE,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, 1f, 2f, () -> LootConfig.netheriteScrapDust,
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.ANCIENT_CITY,
                ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_NETHERITE, 1f, 2f, () -> LootConfig.netheriteDust,
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.ANCIENT_CITY,
                ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, 4f, () -> LootConfig.diamondNugget,
                ChestLootTables.DESERT_PYRAMID,
                ChestLootTables.SHIPWRECK_TREASURE,
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.ANCIENT_CITY,
                ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.NUGGET_EMERALD, 1f, 4f, () -> LootConfig.emeraldNugget,
                ChestLootTables.DESERT_PYRAMID,
                ChestLootTables.SHIPWRECK_TREASURE,
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.ANCIENT_CITY,
                ChestLootTables.ANCIENT_CITY_ICE_BOX);

        modifier.addItems(ItemRegistry.NUGGET_COPPER, 1f, 9f, () -> LootConfig.copperNugget,
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.BASTION_OTHER,
                ChestLootTables.DESERT_PYRAMID,
                ChestLootTables.PILLAGER_OUTPOST,
                ChestLootTables.RUINED_PORTAL,
                ChestLootTables.VILLAGE_TOOLSMITH);

        modifier.addItems(ItemRegistry.GARLIC, 1f, 6f, () -> LootConfig.garlic,
                ChestLootTables.SPAWN_BONUS_CHEST,
                ChestLootTables.ABANDONED_MINESHAFT);

        modifier.addItems(ItemRegistry.CRACK_HAMMER_COPPER, 1f, () -> LootConfig.copperHammer,
                ChestLootTables.SPAWN_BONUS_CHEST);

        modifier.addItems(ItemRegistry.CRACK_HAMMER_IRON, 1f, () -> LootConfig.ironHammer,
                ChestLootTables.SPAWN_BONUS_CHEST,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH);

        modifier.addItems(ItemRegistry.CRACK_HAMMER_STEEL, 1f, () -> LootConfig.steelHammer,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH);

        modifier.addItems(ItemRegistry.STEEL_INGOT, 1f, 2f, () -> LootConfig.steelIngot,
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_STEEL, 1f, 2f, () -> LootConfig.steelDust,
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.VILLAGE_ARMORER,
                ChestLootTables.VILLAGE_TOOLSMITH,
                ChestLootTables.VILLAGE_WEAPONSMITH);

        modifier.addItems(ItemRegistry.MATERIAL_DUST_CARBON, 1f, 4f, () -> LootConfig.carbonDust,
                ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.VILLAGE_WEAPONSMITH,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.BASTION_BRIDGE,
                ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.RUINED_PORTAL);
    }
}