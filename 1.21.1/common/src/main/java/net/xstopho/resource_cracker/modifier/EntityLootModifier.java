package net.xstopho.resource_cracker.modifier;

import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;
import net.xstopho.resourcelibrary.modifier.loot_tables.EntityLootTables;

import java.util.List;

public class EntityLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addItems(ItemRegistry.GARLIC, 1f, () -> LootConfig.garlicFromZombie, List.of(EntityLootTables.ZOMBIE));
        modifier.addItems(ItemRegistry.NUGGET_COPPER, 1f, 4f, () -> LootConfig.copperNuggetFromZombie, List.of(EntityLootTables.ZOMBIE));

        modifier.addItems(ItemRegistry.MATERIAL_DUST_SULFUR, 1f, () -> LootConfig.sulfurFromCreeper, List.of(EntityLootTables.CREEPER));
        modifier.addItems(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, () -> LootConfig.saltpeterFromCreeper, List.of(EntityLootTables.CREEPER));
    }
}