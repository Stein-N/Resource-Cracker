package net.xstopho.resource_cracker;


import net.neoforged.fml.common.Mod;
import net.xstopho.resource_cracker.config.ConstantConfig;
import net.xstopho.simpleconfig.api.SimpleConfigRegistry;

@Mod(Constants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        SimpleConfigRegistry.INSTANCE.register(ConstantConfig.BUILDER);

        Constants.LOG.info("Initialisation finished!");
    }
}