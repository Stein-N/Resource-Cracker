package net.xstopho.resource_cracker.modifier;

import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;

public class BlockLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, 3f, () -> LootConfig.diamondNuggetFromDiamondOre,
                Blocks.DIAMOND_ORE.getLootTable().get(),
                Blocks.DEEPSLATE_DIAMOND_ORE.getLootTable().get());

        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, () -> LootConfig.diamondNuggetFromCoalOre,
                Blocks.COAL_ORE.getLootTable().get(),
                Blocks.DEEPSLATE_COAL_ORE.getLootTable().get());

        modifier.addItems(ItemRegistry.NUGGET_EMERALD, 1f, 4f, () -> LootConfig.emeraldNuggetFromOre,
                Blocks.EMERALD_ORE.getLootTable().get(),
                Blocks.DEEPSLATE_EMERALD_ORE.getLootTable().get());

        modifier.addItems(ItemRegistry.NUGGET_COPPER, 1f, 6f, () -> LootConfig.copperNuggetFromOre,
                Blocks.COPPER_ORE.getLootTable().get(),
                Blocks.DEEPSLATE_COPPER_ORE.getLootTable().get());
    }
}