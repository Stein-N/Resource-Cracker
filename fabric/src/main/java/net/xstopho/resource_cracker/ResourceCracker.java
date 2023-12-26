package net.xstopho.resource_cracker;

import net.fabricmc.api.ModInitializer;

import net.xstopho.resource_cracker.config.ConstantConfig;
import net.xstopho.resource_cracker.modifier.LootTableModifier;
import net.xstopho.resource_cracker.registries.*;
import net.xstopho.simpleconfig.api.SimpleConfigRegistry;

public class ResourceCracker implements ModInitializer {

    @Override
    public void onInitialize() {
        SimpleConfigRegistry.INSTANCE.register(ConstantConfig.BUILDER);

        AttributeRegistry.init();
        BlockRegistry.init();
        ItemRegistry.init();
        ItemGroupRegistry.init();

        LootTableModifier.init();

        Constants.LOG.info("Initialisation finished!");
    }
}
