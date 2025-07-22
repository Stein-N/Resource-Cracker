package net.xstopho.resource_cracker.modifier;

import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;

import java.util.List;

public class BlockLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, 3f, () -> LootConfig.diamondNuggetFromDiamondOre,
                List.of(Blocks.DIAMOND_ORE.getLootTable(),
                        Blocks.DEEPSLATE_DIAMOND_ORE.getLootTable()));

        modifier.addItems(ItemRegistry.NUGGET_DIAMOND, 1f, () -> LootConfig.diamondNuggetFromCoalOre,
                List.of(Blocks.COAL_ORE.getLootTable(),
                        Blocks.DEEPSLATE_COAL_ORE.getLootTable()));

        modifier.addItems(ItemRegistry.NUGGET_EMERALD, 1f, 4f, () -> LootConfig.emeraldNuggetFromOre,
                List.of(Blocks.EMERALD_ORE.getLootTable(),
                        Blocks.DEEPSLATE_EMERALD_ORE.getLootTable()));

        modifier.addItems(ItemRegistry.NUGGET_COPPER, 1f, 6f, () -> LootConfig.copperNuggetFromOre,
                List.of(Blocks.COPPER_ORE.getLootTable(),
                        Blocks.DEEPSLATE_COPPER_ORE.getLootTable()));
    }
}