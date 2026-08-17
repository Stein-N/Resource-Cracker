package net.morthen.resource_cracker.modifier;

import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.morthen.resource_cracker.config.LootConfig;
import net.morthen.resource_cracker.registries.ItemRegistry;
import net.morthen.resourcelibrary.modifier.LootTableModifier;

import java.util.List;

public class ChestLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addItem(ItemRegistry.MATERIAL_DUST_SULFUR, 6f, () -> LootConfig.sulfur,
                List.of(BuiltInLootTables.RUINED_PORTAL,
                BuiltInLootTables.BASTION_OTHER,
                BuiltInLootTables.BASTION_BRIDGE,
                BuiltInLootTables.NETHER_BRIDGE,
                BuiltInLootTables.VILLAGE_DESERT_HOUSE));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, 6f, () -> LootConfig.saltpeter,
                List.of(BuiltInLootTables.RUINED_PORTAL,
                BuiltInLootTables.BASTION_OTHER,
                BuiltInLootTables.BASTION_BRIDGE,
                BuiltInLootTables.NETHER_BRIDGE,
                BuiltInLootTables.DESERT_PYRAMID,
                BuiltInLootTables.VILLAGE_DESERT_HOUSE));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_COPPER, 1f, 6f, () -> LootConfig.copperDust,
                List.of(BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_WEAPONSMITH,
                BuiltInLootTables.ABANDONED_MINESHAFT));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_GOLD, 1f, 6f, () -> LootConfig.goldDust,
                List.of(BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_WEAPONSMITH,
                BuiltInLootTables.ABANDONED_MINESHAFT));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_IRON, 1f, 6f, () -> LootConfig.ironDust,
                List.of(BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_WEAPONSMITH,
                BuiltInLootTables.ABANDONED_MINESHAFT));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_EMERALD, 1f, 3f, () -> LootConfig.emeraldDust,
                List.of(BuiltInLootTables.SHIPWRECK_TREASURE,
                BuiltInLootTables.ABANDONED_MINESHAFT));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_DIAMOND, 1f, 3, () -> LootConfig.diamondDust,
                List.of(BuiltInLootTables.SHIPWRECK_TREASURE,
                BuiltInLootTables.ABANDONED_MINESHAFT));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, 1f, 2f, () -> LootConfig.netheriteScrapDust,
                List.of(BuiltInLootTables.RUINED_PORTAL,
                BuiltInLootTables.BASTION_OTHER,
                BuiltInLootTables.BASTION_BRIDGE,
                BuiltInLootTables.NETHER_BRIDGE,
                BuiltInLootTables.ANCIENT_CITY,
                BuiltInLootTables.ANCIENT_CITY_ICE_BOX));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_NETHERITE, 1f, 2f, () -> LootConfig.netheriteDust,
                List.of(BuiltInLootTables.RUINED_PORTAL,
                BuiltInLootTables.BASTION_OTHER,
                BuiltInLootTables.BASTION_BRIDGE,
                BuiltInLootTables.NETHER_BRIDGE,
                BuiltInLootTables.ANCIENT_CITY,
                BuiltInLootTables.ANCIENT_CITY_ICE_BOX));

        modifier.addItem(ItemRegistry.NUGGET_DIAMOND, 1f, 4f, () -> LootConfig.diamondNugget,
                List.of(BuiltInLootTables.DESERT_PYRAMID,
                BuiltInLootTables.SHIPWRECK_TREASURE,
                BuiltInLootTables.ABANDONED_MINESHAFT,
                BuiltInLootTables.ANCIENT_CITY,
                BuiltInLootTables.ANCIENT_CITY_ICE_BOX));

        modifier.addItem(ItemRegistry.NUGGET_EMERALD, 1f, 4f, () -> LootConfig.emeraldNugget,
                List.of(BuiltInLootTables.DESERT_PYRAMID,
                BuiltInLootTables.SHIPWRECK_TREASURE,
                BuiltInLootTables.ABANDONED_MINESHAFT,
                BuiltInLootTables.ANCIENT_CITY,
                BuiltInLootTables.ANCIENT_CITY_ICE_BOX));

        modifier.addItem(ItemRegistry.GARLIC, 1f, 6f, () -> LootConfig.garlic,
                List.of(BuiltInLootTables.SPAWN_BONUS_CHEST,
                BuiltInLootTables.ABANDONED_MINESHAFT));

        modifier.addItem(ItemRegistry.CRACK_HAMMER_COPPER, 1f, () -> LootConfig.copperHammer,
                List.of(BuiltInLootTables.SPAWN_BONUS_CHEST));

        modifier.addItem(ItemRegistry.CRACK_HAMMER_IRON, 1f, () -> LootConfig.ironHammer,
                List.of(BuiltInLootTables.SPAWN_BONUS_CHEST,
                BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_WEAPONSMITH));

        modifier.addItem(ItemRegistry.CRACK_HAMMER_STEEL, 1f, () -> LootConfig.steelHammer,
                List.of(BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_WEAPONSMITH));

        modifier.addItem(ItemRegistry.STEEL_INGOT, 1f, 2f, () -> LootConfig.steelIngot,
                List.of(BuiltInLootTables.ABANDONED_MINESHAFT,
                BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_WEAPONSMITH));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_STEEL, 1f, 2f, () -> LootConfig.steelDust,
                List.of(BuiltInLootTables.ABANDONED_MINESHAFT,
                BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_WEAPONSMITH));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_CARBON, 1f, 4f, () -> LootConfig.carbonDust,
                List.of(BuiltInLootTables.ABANDONED_MINESHAFT,
                BuiltInLootTables.VILLAGE_WEAPONSMITH,
                BuiltInLootTables.NETHER_BRIDGE,
                BuiltInLootTables.BASTION_BRIDGE,
                BuiltInLootTables.NETHER_BRIDGE,
                BuiltInLootTables.RUINED_PORTAL));
    }
}