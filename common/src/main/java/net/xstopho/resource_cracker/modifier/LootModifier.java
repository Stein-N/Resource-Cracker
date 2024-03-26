package net.xstopho.resource_cracker.modifier;

public class LootModifier {

    public static void init() {
        EntityLootModifier.init();
        BlockLootModifier.init();
        ChestLootModifier.init();
    }
}
