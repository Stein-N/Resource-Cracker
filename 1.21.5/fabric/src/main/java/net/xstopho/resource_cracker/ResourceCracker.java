package net.xstopho.resource_cracker;

import net.fabricmc.api.ModInitializer;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.CreativeTabRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourceconfigapi.api.ConfigRegistry;

public class ResourceCracker implements ModInitializer {
    @Override
    public void onInitialize() {
        CrackerConstants.commonInit();
    }
}
