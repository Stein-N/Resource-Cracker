package net.xstopho.resource_cracker.modifier;

import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.stophoslib.modifier.LootTableModifier;
import net.xstopho.stophoslib.modifier.loot_tables.ChestLootTables;
import net.xstopho.stophoslib.modifier.loot_tables.EntityLootTables;

public class LootModifier {

    static final LootTableModifier MODIFIER = LootTableModifier.get();

    public static void init() {
        MODIFIER.addToPool(ItemRegistry.GARLIC, 1f, Config.GARLIC_FROM_ZOMBIE.get().floatValue(), EntityLootTables.ZOMBIE);
        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_SULFUR, 1f, Config.SULFUR_FROM_CREEPER.get().floatValue(), EntityLootTables.CREEPER);
        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, Config.SALTPETER_FROM_CREEPER.get().floatValue(), EntityLootTables.CREEPER);

        MODIFIER.addToPool(ItemRegistry.NUGGET_DIAMOND, 1f, 3f, Config.DIAMOND_NUGGET_FROM_DIAMOND_ORE.get().floatValue(), Blocks.DIAMOND_ORE.getLootTable(), Blocks.DEEPSLATE_DIAMOND_ORE.getLootTable());
        MODIFIER.addToPool(ItemRegistry.NUGGET_DIAMOND, 1f, Config.DIAMOND_NUGGET_FROM_COAL_ORE.get().floatValue(), Blocks.COAL_ORE.getLootTable(), Blocks.DEEPSLATE_COAL_ORE.getLootTable());

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_SULFUR, 6f, Config.SULFUR.get().floatValue(),
                ChestLootTables.RUINED_PORTAL, ChestLootTables.BASTION_OTHER, ChestLootTables.BASTION_BRIDGE, ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.VILLAGE_DESERT_HOUSE);

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, 6f, Config.SALTPETER.get().floatValue(),
                ChestLootTables.RUINED_PORTAL, ChestLootTables.BASTION_OTHER, ChestLootTables.BASTION_BRIDGE, ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.DESERT_PYRAMID, ChestLootTables.VILLAGE_DESERT_HOUSE);

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_COPPER, 1f, 6f, Config.DUST_COPPER.get().floatValue(),
                ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH, ChestLootTables.ABANDONED_MINESHAFT);

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_GOLD, 1f, 6f, Config.DUST_COPPER.get().floatValue(),
                ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH, ChestLootTables.ABANDONED_MINESHAFT);

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_IRON, 1f, 6f, Config.DUST_COPPER.get().floatValue(),
                ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH, ChestLootTables.ABANDONED_MINESHAFT);

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_EMERALD, 1f, 3f, Config.DUST_EMERALD.get().floatValue(),
                ChestLootTables.SHIPWRECK_TREASURE, ChestLootTables.ABANDONED_MINESHAFT);

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_DIAMOND, 1f, 3, Config.DUST_DIAMOND.get().floatValue(),
                ChestLootTables.SHIPWRECK_TREASURE, ChestLootTables.ABANDONED_MINESHAFT);

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, 1f, 2f, Config.DUST_NETHERITE_SCRAP.get().floatValue(),
                ChestLootTables.RUINED_PORTAL, ChestLootTables.BASTION_OTHER, ChestLootTables.BASTION_BRIDGE, ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.ANCIENT_CITY, ChestLootTables.ANCIENT_CITY_ICE_BOX);

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_NETHERITE, 1f, 2f, Config.DUST_NETHERITE.get().floatValue(),
                ChestLootTables.RUINED_PORTAL, ChestLootTables.BASTION_OTHER, ChestLootTables.BASTION_BRIDGE, ChestLootTables.NETHER_BRIDGE,
                ChestLootTables.ANCIENT_CITY, ChestLootTables.ANCIENT_CITY_ICE_BOX);

        MODIFIER.addToPool(ItemRegistry.NUGGET_DIAMOND, 1f, 4f, Config.NUGGET_DIAMOND.get().floatValue(),
                ChestLootTables.DESERT_PYRAMID, ChestLootTables.SHIPWRECK_TREASURE, ChestLootTables.ABANDONED_MINESHAFT,
                ChestLootTables.ANCIENT_CITY, ChestLootTables.ANCIENT_CITY_ICE_BOX);

        MODIFIER.addToPool(ItemRegistry.GARLIC, 1f, 6f, Config.GARLIC.get().floatValue(),
                ChestLootTables.SPAWN_BONUS_CHEST, ChestLootTables.ABANDONED_MINESHAFT);

        MODIFIER.addToPool(ItemRegistry.CRACK_HAMMER_COPPER, 1f, Config.HAMMER_COPPER.get().floatValue(),
                ChestLootTables.SPAWN_BONUS_CHEST);

        MODIFIER.addToPool(ItemRegistry.CRACK_HAMMER_IRON, 1f, Config.HAMMER_IRON.get().floatValue(),
                ChestLootTables.SPAWN_BONUS_CHEST, ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH);

        MODIFIER.addToPool(ItemRegistry.CRACK_HAMMER_STEEL, 1f, Config.HAMMER_STEEL.get().floatValue(),
                ChestLootTables.VILLAGE_ARMORER, ChestLootTables.VILLAGE_TOOLSMITH, ChestLootTables.VILLAGE_WEAPONSMITH);
    }
}
