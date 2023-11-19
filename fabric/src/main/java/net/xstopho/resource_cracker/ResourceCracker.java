package net.xstopho.resource_cracker;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.fml.config.ModConfig;
import net.xstopho.resource_cracker.config.ConstantConfig;
import net.xstopho.resource_cracker.modifier.LootTableModifier;
import net.xstopho.resource_cracker.registries.*;

public class ResourceCracker implements ModInitializer {

    @Override
    public void onInitialize() {
        ForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.COMMON, ConstantConfig.SPEC, Constants.MOD_ID + ".toml");

        AttributeRegistry.init();
        BlockRegistry.init();
        ItemRegistry.init();
        ItemGroupRegistry.init();

        LootTableModifier.init();

        Constants.LOG.info("Initialisation finished!");
    }
}
