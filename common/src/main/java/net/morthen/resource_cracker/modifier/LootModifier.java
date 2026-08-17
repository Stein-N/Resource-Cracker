package net.morthen.resource_cracker.modifier;


import net.morthen.resourcelibrary.modifier.LootTableModifier;

public class LootModifier {
    static final LootTableModifier modifier = LootTableModifier.getInstance();
    static boolean initialized = false;

    public static void init() {
        if (!initialized) {
            BlockLootModifier.init(modifier);
            ChestLootModifier.init(modifier);
            EntityLootModifier.init(modifier);
            initialized = true;
        }
    }
}
