package net.xstopho.resource_cracker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.RenderType;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemModelRenderRegistry;

public class ResourceCrackerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CrackerConstants.clientInit();

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.GARLIC_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.WATER_SPRING_BLOCK.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.LAVA_SPRING_BLOCK.get(), RenderType.cutout());

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> 0x3F76E4, BlockRegistry.WATER_SPRING_BLOCK.get());
        ColorProviderRegistry.ITEM.register((itemStack, i) -> 0x3F76E4, BlockRegistry.WATER_SPRING_BLOCK.get());
    }
}
