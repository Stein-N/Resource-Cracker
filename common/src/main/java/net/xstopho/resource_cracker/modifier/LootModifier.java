package net.xstopho.resource_cracker.modifier;

import net.xstopho.stophoslib.modifier.LootTableModifier;

public class LootModifier {


    static final LootTableModifier modifier = LootTableModifier.get();

    public static void init() {
        BlockLootModifier.init(modifier);
        ChestLootModifier.init(modifier);
        EntityLootModifier.init(modifier);
    }
}
