package net.xstopho.resource_cracker;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.xstopho.resource_cracker.provider.*;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

@Mod(CrackerConstants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker(IEventBus bus) {
        CrackerConstants.commonInit();
    }

    @EventBusSubscriber(modid = CrackerConstants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class Datagen {

        @SubscribeEvent
        public static void generateData(GatherDataEvent.Client event) {
            event.createBlockAndItemTags(BlockTags::new, ItemTags::new);
            event.createProvider(Recipes.Runner::new);
            event.createProvider(Loot::create);
            event.createProvider(Models::new);
        }
    }
}
