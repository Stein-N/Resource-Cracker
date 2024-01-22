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
        BlockLootModifier.init();
        ChestLootModifier.init();
        EntityLootModifier.init();
    }
}
