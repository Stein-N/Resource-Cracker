package net.xstopho.resource_cracker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.xstopho.resource_cracker.registries.BlockRegistry;

public class ResourceCrackerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.GARLIC_CROP.get(), RenderType.cutout());
    }
}