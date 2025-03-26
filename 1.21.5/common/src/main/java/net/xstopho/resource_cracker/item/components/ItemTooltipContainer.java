package net.xstopho.resource_cracker.item.components;

import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.function.Consumer;

public class ItemTooltipContainer implements TooltipProvider {

    private final Component tooltip;

    public ItemTooltipContainer(Component tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public void addToTooltip(Item.TooltipContext tooltipContext, Consumer<Component> consumer, TooltipFlag tooltipFlag, DataComponentGetter dataComponentGetter) {
        consumer.accept(tooltip);
    }
}
