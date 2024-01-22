package net.xstopho.resource_cracker;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.xstopho.resource_cracker.datagen.BlockTagProv;
import net.xstopho.resource_cracker.datagen.ItemTagProv;
import net.xstopho.resource_cracker.datagen.RecipeProv;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ResourceCrackerDatagen {
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
