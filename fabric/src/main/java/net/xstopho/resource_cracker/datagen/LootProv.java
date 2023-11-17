package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class LootProv extends FabricBlockLootTableProvider {
    public LootProv(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        LootItemBlockStatePropertyCondition.Builder builder =
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.GARLIC_CROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 5));
        add(BlockRegistry.GARLIC_CROP, createCropDrops(BlockRegistry.GARLIC_CROP, ItemRegistry.GARLIC, ItemRegistry.GARLIC, builder));

        dropSelf(BlockRegistry.STEEL_BLOCK);
        dropSelf(BlockRegistry.LAVA_SPRING_BLOCK);
        dropSelf(BlockRegistry.WATER_SPRING_BLOCK);
    }
}
