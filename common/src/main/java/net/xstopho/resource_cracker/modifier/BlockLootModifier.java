package net.xstopho.resource_cracker.modifier;

import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.stophoslib.modifier.LootTableModifier;

public class BlockLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addToPool(ItemRegistry.NUGGET_DIAMOND, 1f, 3f, Config.DIAMOND_NUGGET_FROM_DIAMOND_ORE.get().floatValue(),
                Blocks.DIAMOND_ORE.getLootTable(), Blocks.DEEPSLATE_DIAMOND_ORE.getLootTable());

        modifier.addToPool(ItemRegistry.NUGGET_DIAMOND, 1f, Config.DIAMOND_NUGGET_FROM_COAL_ORE.get().floatValue(),
                Blocks.COAL_ORE.getLootTable(), Blocks.DEEPSLATE_COAL_ORE.getLootTable());

        modifier.addToPool(ItemRegistry.NUGGET_EMERALD, 1f, 4f, Config.EMERALD_NUGGET_FROM_ORE.get().floatValue(),
                Blocks.EMERALD_ORE.getLootTable(), Blocks.DEEPSLATE_EMERALD_ORE.getLootTable());

        modifier.addToPool(ItemRegistry.NUGGET_COPPER, 1f, 6f, Config.COPPER_NUGGET_FROM_ORE.get().floatValue(),
                Blocks.COPPER_ORE.getLootTable(), Blocks.DEEPSLATE_COPPER_ORE.getLootTable());
    }
}