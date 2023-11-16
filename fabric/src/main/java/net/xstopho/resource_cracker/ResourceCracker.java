package net.xstopho.resource_cracker;

import net.fabricmc.api.ModInitializer;
import net.xstopho.resource_cracker.registries.*;

public class ResourceCracker implements ModInitializer {

    //TODO: RecipeProv, LoottableProv

    @Override
    public void onInitialize() {
        AttributeRegistry.init();
        BlockRegistry.init();
        ItemRegistry.init();
        FuelFoodRegistry.init();
        ItemGroupRegistry.init();

        Constants.LOG.info("Initialisation finished!");
    }
}
