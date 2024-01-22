package net.xstopho.resource_cracker.modifier;

import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.stophoslib.modifier.LootTableModifier;
import net.xstopho.stophoslib.modifier.loot_tables.EntityLootTables;

public class EntityLootModifier {

    private static final LootTableModifier MODIFIER = LootTableModifier.get();

    public static void init() {
        MODIFIER.addToPool(ItemRegistry.GARLIC, 1f, Config.GARLIC_FROM_ZOMBIE.get().floatValue(), EntityLootTables.ZOMBIE);
        MODIFIER.addToPool(ItemRegistry.NUGGET_COPPER, 1f, 4f, Config.NUGGET_COPPER.get().floatValue(), EntityLootTables.ZOMBIE);

        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_SULFUR, 1f, Config.SULFUR_FROM_CREEPER.get().floatValue(), EntityLootTables.CREEPER);
        MODIFIER.addToPool(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, Config.SALTPETER_FROM_CREEPER.get().floatValue(), EntityLootTables.CREEPER);
    }
}