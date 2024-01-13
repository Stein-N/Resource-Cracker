package net.xstopho.resource_cracker;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.AttributeRegistry;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemGroupRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.simpleconfig.api.SimpleConfigRegistry;
import net.xstopho.stophoslib.modifier.loot_tables.ChestLootTables;

@Mod(Constants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        SimpleConfigRegistry.INSTANCE.register(Constants.MOD_ID, Config.BUILDER);

        AttributeRegistry.init();
        ItemRegistry.init();
        BlockRegistry.init();
        ItemGroupRegistry.init();

        LootModifier.init();

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