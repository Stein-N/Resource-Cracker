package net.xstopho.resource_cracker;

import net.fabricmc.api.ModInitializer;

public class ResourceCracker implements ModInitializer {
    @Override
    public void onInitialize() {
        CrackerConstants.initCommon();
    }
}
