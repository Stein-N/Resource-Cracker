package net.morthen.resource_cracker;

import net.minecraft.resources.Identifier;
import net.morthen.resource_cracker.config.LootConfig;
import net.morthen.resource_cracker.config.ToolConfig;
import net.morthen.resource_cracker.registries.BlockRegistry;
import net.morthen.resource_cracker.registries.CreativeTabRegistry;
import net.morthen.resource_cracker.registries.DataComponentRegistry;
import net.morthen.resource_cracker.registries.ItemRegistry;
import net.morthen.resourceconfigapi.api.ConfigRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrackerConstants {
    public static final String MOD_ID = "resource_cracker";
    public static final String MOD_NAME = "Resource Cracker";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static Identifier of(String id) {
        return Identifier.fromNamespaceAndPath(MOD_ID, id);
    }

    public static void commonInit() {
        ConfigRegistry.register(ToolConfig.class, MOD_ID);
        ConfigRegistry.register(LootConfig.class, MOD_ID);

        DataComponentRegistry.init();

        BlockRegistry.init();
        ItemRegistry.init();
        CreativeTabRegistry.init();
    }
}
