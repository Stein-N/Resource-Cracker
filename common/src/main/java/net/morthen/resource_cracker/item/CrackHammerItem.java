package net.morthen.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.morthen.resource_cracker.item.components.TooltipContainer;
import net.morthen.resource_cracker.registries.DataComponentRegistry;
import net.morthen.resourcelibrary.item.ResourceCraftingRemainder;

import java.util.List;
import java.util.function.Supplier;

public class CrackHammerItem extends ResourceCraftingRemainder {
    private final Supplier<Integer> durability;

    public CrackHammerItem(Supplier<Integer> durability, Properties properties) {
        super(properties
                .component(DataComponents.MAX_STACK_SIZE, 1)
                .component(DataComponentRegistry.TOOLTIP_CONTAINER.get(), new TooltipContainer(List.of(
                Component.translatable("item.crack_hammer.tooltip").withStyle(ChatFormatting.GOLD)
        ))));
        this.durability = durability;
    }

    @Override
    public ItemStackTemplate getRemainingItem(ItemStack itemStack) {
        if (!itemStack.has(DataComponents.MAX_DAMAGE)) {
            this.addDurability(itemStack);
        }

        if (itemStack.getDamageValue() < itemStack.getMaxDamage() -1) {
            ItemStack damaged = itemStack.copy();
            damaged.setDamageValue(itemStack.getDamageValue() + 1);
            return ItemStackTemplate.fromNonEmptyStack(damaged);
        }

        return super.getCraftingRemainder();
    }

    private void addDurability(ItemStack stack) {
        stack.set(DataComponents.MAX_DAMAGE, this.durability.get());
        stack.set(DataComponents.DAMAGE, 0);
    }
}
