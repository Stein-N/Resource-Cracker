package net.xstopho.resource_cracker;

import net.fabricmc.api.ModInitializer;
import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.AttributeRegistry;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemGroupRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.simpleconfig.api.SimpleConfigRegistry;

public class ResourceCracker implements ModInitializer {

    @Override
    public void onInitialize() {
        SimpleConfigRegistry.INSTANCE.register(Constants.MOD_ID, Config.BUILDER);

        AttributeRegistry.init();
        BlockRegistry.init();
        ItemRegistry.init();
        ItemGroupRegistry.init();

        LootModifier.init();

        Constants.LOG.info("Initialisation finished!");
    }
}
