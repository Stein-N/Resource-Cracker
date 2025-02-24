package net.xstopho.resource_cracker;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.CreativeTabRegistry;
import net.xstopho.resource_cracker.registries.ItemModelRenderRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourceconfigapi.api.ConfigRegistry;

@Mod(CrackerConstants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        CrackerConstants.commonInit();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceCrackerClient {

        @SubscribeEvent
        public static void renderSetup(FMLClientSetupEvent event) {
            CrackerConstants.clientInit();

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
