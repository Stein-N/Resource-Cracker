package net.morthen.resource_cracker.registries;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.morthen.resource_cracker.CrackerConstants;
import net.morthen.resource_cracker.item.components.ScytheTooltipContainer;
import net.morthen.resourcelibrary.registration.RegistryObject;
import net.morthen.resourcelibrary.registration.RegistryProvider;

public class DataComponentRegistry {

    private static final RegistryProvider<DataComponentType<?>> COMPONENTS = RegistryProvider.get(CrackerConstants.MOD_ID, BuiltInRegistries.DATA_COMPONENT_TYPE);

    public static final RegistryObject<DataComponentType<ScytheTooltipContainer>> SCYTHE_TOOLTIP_CONTAINER = COMPONENTS.register("scythe_tooltip_container",
            () -> DataComponentType.<ScytheTooltipContainer>builder().persistent(ScytheTooltipContainer.CODEC).networkSynchronized(ScytheTooltipContainer.STREAM_CODEC).build());

    public static void init() {}
}
