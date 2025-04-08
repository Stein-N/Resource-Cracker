package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemLore;
import net.xstopho.resource_cracker.item.components.TooltipContainer;
import net.xstopho.resource_cracker.registries.DataComponentRegistry;
import net.xstopho.resourcelibrary.item.ResourceCraftingRemainder;

import java.util.List;
import java.util.function.Supplier;

public class CrackHammerItem extends ResourceCraftingRemainder {
    private final Supplier<Integer> durability;

    public CrackHammerItem(Supplier<Integer> durability, Properties properties) {
        super(properties.component(DataComponentRegistry.TOOLTIP_CONTAINER.get(), new TooltipContainer(List.of(
                Component.translatable("item.crack_hammer.tooltip").withStyle(ChatFormatting.GOLD)
        ))));
        this.durability = durability;
    }

    @Override
    public ItemStack getRemainingItem(ItemStack itemStack) {
        if (itemStack.getDamageValue() < itemStack.getMaxDamage() -1) {
            ItemStack damaged = itemStack.copy();
            damaged.setDamageValue(itemStack.getDamageValue() + 1);
            return damaged;
        }

        return ItemStack.EMPTY;
    }

    public ItemStack addDurability(ItemStack stack) {
        ItemStack copy = stack.copy();
        copy.set(DataComponents.MAX_DAMAGE, this.durability.get());
        copy.set(DataComponents.MAX_STACK_SIZE, 1);
        copy.set(DataComponents.DAMAGE, 0);
        return copy;
    }
}
