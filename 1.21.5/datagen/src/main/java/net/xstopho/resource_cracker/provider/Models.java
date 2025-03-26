package net.xstopho.resource_cracker.provider;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.helper.BlockModelHelper;
import net.xstopho.resource_cracker.helper.ItemModelHelper;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import org.jetbrains.annotations.NotNull;

public class Models extends ModelProvider {

    public Models(PackOutput packOutput) {
        super(packOutput, CrackerConstants.MOD_ID);
    }

    private void createItemModels(ItemModelGenerators item) {
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_COPPER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_GOLD.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_IRON.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_NETHERITE.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CRACK_HAMMER_STEEL.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.CHISEL_COPPER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_GOLD.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_IRON.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_NETHERITE.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.CHISEL_STEEL.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_COPPER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_IRON.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_GOLD.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_STEEL.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_CARBON.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_NETHERITE.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_EMERALD.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_SALTPETER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.MATERIAL_DUST_SULFUR.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.NUGGET_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.NUGGET_COPPER.get(), ModelTemplates.FLAT_ITEM);
        item.generateFlatItem(ItemRegistry.NUGGET_EMERALD.get(), ModelTemplates.FLAT_ITEM);

        item.generateFlatItem(ItemRegistry.BEEF_JERKY.get(), ModelTemplates.FLAT_ITEM);

        ItemModelHelper.generateScytheModels(item, ItemRegistry.SCYTHE_COPPER.get());
        ItemModelHelper.generateScytheModels(item, ItemRegistry.SCYTHE_GOLD.get());
        ItemModelHelper.generateScytheModels(item, ItemRegistry.SCYTHE_IRON.get());
        ItemModelHelper.generateScytheModels(item, ItemRegistry.SCYTHE_STEEL.get());
        ItemModelHelper.generateScytheModels(item, ItemRegistry.SCYTHE_DIAMOND.get());
        ItemModelHelper.generateScytheModels(item, ItemRegistry.SCYTHE_NETHERITE.get());
    }

    private void createBlockModels(BlockModelGenerators block) {
        BlockModelHelper.createLavaSpring(block, BlockRegistry.LAVA_SPRING_BLOCK.get());
        BlockModelHelper.createWaterSpring(block, BlockRegistry.WATER_SPRING_BLOCK.get());

        block.createTrivialCube(BlockRegistry.STEEL_BLOCK.get());
        block.createCropBlock(BlockRegistry.GARLIC_CROP.get(), GarlicCropBlock.AGE, 0, 1, 2, 3, 4, 5);
    }

    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels) {
        createBlockModels(blockModels);
        createItemModels(itemModels);
    }
}
