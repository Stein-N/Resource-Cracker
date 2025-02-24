package net.xstopho.resource_cracker;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.xstopho.resource_cracker.registries.BlockRegistry;

@Mod(CrackerConstants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        CrackerConstants.initCommon();
    }

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceCrackerClient {

        @SubscribeEvent
        public static void renderSetup(FMLClientSetupEvent event) {
            CrackerConstants.initClient();

            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GARLIC_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WATER_SPRING_BLOCK.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LAVA_SPRING_BLOCK.get(), RenderType.cutout());
        }

        @SubscribeEvent
        public static void colorBlockTexture(RegisterColorHandlersEvent.Block event) {
            event.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> 0x3F76E4, BlockRegistry.WATER_SPRING_BLOCK.get());
        }

        @SubscribeEvent
        public static void colorItemTexture(RegisterColorHandlersEvent.Item event) {
            event.register((itemStack, i) -> 0x3F76E4, BlockRegistry.WATER_SPRING_BLOCK.get());
        }
    }
}
