package net.xstopho.resource_cracker.registries;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.food.FoodProperties;

public class FuelFoodRegistry {

    public static final FoodProperties GARLIC = new FoodProperties.Builder().nutrition(3).saturationMod(0.25f).build();
    public static final FoodProperties BEEF_JERKY = new FoodProperties.Builder().nutrition(8).saturationMod(0.5f).build();

    public static void init() {
        FuelRegistry.INSTANCE.add(ItemRegistry.MATERIAL_DUST_CARBON, 1600);
    }
}
