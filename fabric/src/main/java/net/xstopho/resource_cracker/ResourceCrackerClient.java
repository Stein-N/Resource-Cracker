package net.xstopho.resource_cracker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.renderer.RenderType;
import net.xstopho.resource_cracker.registries.BlockRegistry;

public class ResourceCrackerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMapImpl.INSTANCE.putBlock(BlockRegistry.GARLIC_CROP, RenderType.cutout());
    }
}
