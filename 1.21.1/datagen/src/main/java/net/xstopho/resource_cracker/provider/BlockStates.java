package net.xstopho.resource_cracker.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resourcelibrary.datagen.ResourceBlockStateProvider;
import net.xstopho.resourcelibrary.registration.RegistryObject;

import java.util.function.Function;

public class BlockStates extends ResourceBlockStateProvider {
    public BlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CrackerConstants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createTrivialCube(BlockRegistry.STEEL_BLOCK);
        createGarlicCrop((CropBlock) BlockRegistry.GARLIC_CROP.get(), "garlic_crop_stage", "garlic_crop_stage");
    }

    private void createGarlicCrop(CropBlock cropBlock, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cropStates(state, cropBlock, modelName, textureName);

        getVariantBuilder(cropBlock).forAllStates(function);
    }

    private ConfiguredModel[] cropStates(BlockState state, CropBlock cropBlock, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((GarlicCropBlock) cropBlock).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "block/" + textureName + state.getValue(((GarlicCropBlock) cropBlock).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void createTrivialCube(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
