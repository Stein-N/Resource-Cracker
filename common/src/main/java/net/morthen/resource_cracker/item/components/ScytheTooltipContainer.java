package net.morthen.resource_cracker.item.components;

import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.function.Consumer;
import java.util.function.Supplier;

public record ScytheTooltipContainer(Supplier<Integer> setting) implements TooltipProvider {
    public static final StreamCodec<RegistryFriendlyByteBuf, ScytheTooltipContainer> STREAM_CODEC =
            StreamCodec.of((output, value) -> output.writeVarInt(value.setting().get()),
                    input -> new ScytheTooltipContainer(input::readVarInt));

    public static final Codec<ScytheTooltipContainer> CODEC =
            Codec.INT.xmap(i -> new ScytheTooltipContainer(() -> i), c -> c.setting().get());

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
        consumer.accept(Component.translatable("item.scythe.tooltip").withStyle(ChatFormatting.GOLD));
        consumer.accept(Component.translatable("item.scythe.tooltip.radius").withStyle(ChatFormatting.GOLD)
                .append(Component.literal(String.valueOf(setting().get())).withStyle(ChatFormatting.RED)));
    }
}
