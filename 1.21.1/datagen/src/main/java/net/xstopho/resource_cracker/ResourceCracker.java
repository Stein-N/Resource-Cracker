package net.xstopho.resource_cracker;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.xstopho.resource_cracker.provider.*;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.concurrent.CompletableFuture;

@Mod(CrackerConstants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker(IEventBus bus) {
        BlockRegistry.init();
        ItemRegistry.init();
    }

    @EventBusSubscriber(modid = CrackerConstants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class Datagen {

        @SubscribeEvent
        public static void generateData(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper fileHelper = event.getExistingFileHelper();
            CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

            generator.addProvider(event.includeServer(), new Recipes(output, provider));
            generator.addProvider(event.includeServer(), Loot.create(output, provider));
            generator.addProvider(event.includeServer(), new BlockStates(output, fileHelper));
            generator.addProvider(event.includeServer(), new ItemModels(output, fileHelper));

            BlockTags blockTags = generator.addProvider(event.includeServer(), new BlockTags(output, provider, fileHelper));
            generator.addProvider(event.includeServer(), new ItemTags(output, provider, blockTags.contentsGetter(), fileHelper));
        }
    }
}
