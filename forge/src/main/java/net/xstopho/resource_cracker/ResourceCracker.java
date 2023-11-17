package net.xstopho.resource_cracker;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.xstopho.resource_cracker.config.ConstantConfig;

@Mod(Constants.MOD_ID)
public class ResourceCracker {
    
    public ResourceCracker() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConstantConfig.SPEC, Constants.MOD_ID + ".toml");

        Constants.LOG.info("Hello Forge world!");
    }
}