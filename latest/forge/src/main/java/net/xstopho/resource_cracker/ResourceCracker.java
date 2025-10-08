package net.xstopho.resource_cracker;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.xstopho.resource_cracker.registries.BlockRegistry;

@Mod(CrackerConstants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        CrackerConstants.commonInit();
    }

    @Mod.EventBusSubscriber(value = Dist.CLIENT)
    public static class ResourceCrackerClient {

        @SubscribeEvent
        public static void colorBlockTexture(RegisterColorHandlersEvent.Block event) {
            event.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> 0x3F76E4, BlockRegistry.WATER_SPRING_BLOCK.get());
        }
    }
}
