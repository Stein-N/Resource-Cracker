package net.xstopho.resource_cracker.modifier;

import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.stophoslib.modifier.LootTableModifier;
import net.xstopho.stophoslib.modifier.loot_tables.ChestLootTables;
import net.xstopho.stophoslib.modifier.loot_tables.EntityLootTables;

public class LootModifier {

    public static void init() {
        EntityLootModifier.init();
        BlockLootModifier.init();
        ChestLootModifier.init();
    }
}
