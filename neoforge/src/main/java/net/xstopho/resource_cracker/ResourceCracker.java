package net.xstopho.resource_cracker;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.xstopho.resource_cracker.config.ConstantConfig;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemGroupRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.simpleconfig.api.SimpleConfigRegistry;

@Mod(Constants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        SimpleConfigRegistry.INSTANCE.register(Constants.MOD_ID, ConstantConfig.BUILDER);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(eventBus);
        BlockRegistry.register(eventBus);
        ItemGroupRegistry.register(eventBus);

        Constants.LOG.info("Initialisation finished!");
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceCrackerClient {

        @SubscribeEvent
        public static void renderSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GARLIC_CROP.get(), RenderType.cutout());
        }
    }
}