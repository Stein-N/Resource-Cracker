package net.xstopho.resource_cracker;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.xstopho.resource_cracker.config.ConstantConfig;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemGroupRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.simpleconfig.api.SimpleConfigRegistry;

@Mod(Constants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        SimpleConfigRegistry.INSTANCE.register(ConstantConfig.BUILDER);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(eventBus);
        BlockRegistry.register(eventBus);
        ItemGroupRegistry.register(eventBus);

        Constants.LOG.info("Initialisation finished!");
    }
}