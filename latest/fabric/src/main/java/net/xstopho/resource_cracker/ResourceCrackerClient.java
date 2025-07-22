package net.xstopho.resource_cracker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.xstopho.resource_cracker.registries.BlockRegistry;

public class ResourceCrackerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT,
                BlockRegistry.LAVA_SPRING_BLOCK.get(), BlockRegistry.WATER_SPRING_BLOCK.get());

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> 0x3F76E4, BlockRegistry.WATER_SPRING_BLOCK.get());
    }
}
