package net.xstopho.resource_cracker;


import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConstantConfig.SPEC, Constants.MOD_ID + ".toml");

        Constants.LOG.info("Hello NeoForge world!");
    }
}