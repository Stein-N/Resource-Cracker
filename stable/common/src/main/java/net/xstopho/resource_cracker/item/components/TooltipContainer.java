package net.xstopho.resource_cracker.item.components;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.List;
import java.util.function.Consumer;

public final class TooltipContainer implements TooltipProvider {
    public static final StreamCodec<RegistryFriendlyByteBuf, TooltipContainer> STREAM_CODEC =
            ComponentSerialization.STREAM_CODEC.apply(ByteBufCodecs.list(256)).map(TooltipContainer::new, TooltipContainer::tooltip);
    public static final Codec<TooltipContainer> CODEC =
            ComponentSerialization.CODEC.sizeLimitedListOf(256).xmap(TooltipContainer::new, TooltipContainer::tooltip);

    private final List<Component> tooltip;
    private final int hashCode;

    public TooltipContainer(final List<Component> tooltip) {
        this.tooltip = tooltip;
        this.hashCode = this.tooltip.hashCode();
    }

    public List<Component> tooltip() {
        return tooltip;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(final Object obj) {
        if (obj instanceof TooltipContainer container) {
            return this.tooltip.equals(container.tooltip());
        }
        return false;
    }

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> tooltip, TooltipFlag flags, DataComponentGetter getter) {
        this.tooltip.forEach(tooltip);
    }
}
