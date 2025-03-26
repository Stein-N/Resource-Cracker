package net.xstopho.resource_cracker.registries;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.item.components.ItemTooltipContainer;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

import javax.xml.crypto.Data;

public class DataComponentRegistry {

    private static final RegistryProvider<DataComponentType<?>> COMPONENTS = RegistryProvider.get(CrackerConstants.MOD_ID, BuiltInRegistries.DATA_COMPONENT_TYPE);

    public static final RegistryObject<DataComponentType<ItemTooltipContainer>> TOOLTIP_CONTAINER = COMPONENTS.register("item_tooltip_container",
            () -> DataComponentType.<ItemTooltipContainer>builder().build());

    public static void init() {}
}
