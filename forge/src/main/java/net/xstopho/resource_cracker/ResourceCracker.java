package net.xstopho.resource_cracker;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ConfigTracker;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.xstopho.resource_cracker.config.ConstantConfig;
import net.xstopho.resource_cracker.modifier.LootTableMod;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemGroupRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;

@Mod(Constants.MOD_ID)
public class ResourceCracker {

    public ResourceCracker() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConstantConfig.SPEC, Constants.MOD_ID + ".toml");

        ModConfig commonConfig = ConfigTracker.INSTANCE.configSets().get(ModConfig.Type.COMMON)
                .stream().filter(modConfig -> modConfig.getModId().equals(Constants.MOD_ID))
                .findFirst().orElseThrow(IllegalStateException::new);
        Method openConfig;
        try {
            openConfig = ConfigTracker.INSTANCE.getClass().getDeclaredMethod("openConfig", ModConfig.class, Path.class);
            openConfig.setAccessible(true);
            openConfig.invoke(ConfigTracker.INSTANCE, commonConfig, FMLPaths.CONFIGDIR.get());
            openConfig.setAccessible(false);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
            throw new RuntimeException(exception);
        }


        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();


        ItemRegistry.register(eventBus);
        BlockRegistry.register(eventBus);
        ItemGroupRegistry.register(eventBus);

        LootTableMod.register(eventBus);

        Constants.LOG.info("Hello Forge world!");
    }
}