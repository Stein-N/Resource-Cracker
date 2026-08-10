package net.morthen.resource_cracker;

import net.morthen.resource_cracker.modifier.LootModifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.LootTableLoadEvent;

@Mod(CrackerConstants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        CrackerConstants.commonInit();
    }

    @EventBusSubscriber(modid = CrackerConstants.MOD_ID)
    public static class ApplyLootModifier {
        @SubscribeEvent
        public static void loadTables(LootTableLoadEvent event) {
            LootModifier.init();
        }
    }
}
