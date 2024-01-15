package net.xstopho.resource_cracker;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.datagen.BlockTagProv;
import net.xstopho.resource_cracker.datagen.ItemTagProv;
import net.xstopho.resource_cracker.datagen.RecipeProv;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.AttributeRegistry;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemGroupRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.simpleconfig.api.SimpleConfigRegistry;

import java.util.concurrent.CompletableFuture;

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

    @Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Datagen {

        @SubscribeEvent
        public static void data(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper helper = event.getExistingFileHelper();
            CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

            generator.addProvider(event.includeServer(), new RecipeProv(output, provider));

            BlockTagProv blockTags = generator.addProvider(event.includeServer(), new BlockTagProv(output, provider, helper));
            generator.addProvider(event.includeServer(), new ItemTagProv(output, provider, blockTags.contentsGetter(), helper));
        }
    }
}