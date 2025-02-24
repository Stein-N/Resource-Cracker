package net.xstopho.resource_cracker;

import net.minecraft.resources.ResourceLocation;
import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.config.ToolConfig;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.CreativeTabRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourceconfigapi.api.ConfigRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrackerConstants {
    public static final String MOD_ID = "resource_cracker";
    public static final String MOD_NAME = "Resource Cracker/Tools";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static ResourceLocation of(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }

    public static void commonInit() {
        ConfigRegistry.register(ToolConfig.class, MOD_ID);
        ConfigRegistry.register(LootConfig.class, MOD_ID);

        BlockRegistry.init();
        ItemRegistry.init();
        CreativeTabRegistry.init();

        LootModifier.init();
    }
}
