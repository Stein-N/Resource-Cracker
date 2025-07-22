package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.xstopho.resourcelibrary.items.RecipeRemainder;

import java.util.List;
import java.util.function.Supplier;

public class CrackHammerItem extends RecipeRemainder {
    private final Supplier<Integer> durability;

    public CrackHammerItem(Supplier<Integer> durability) {
        super(new Properties());
        this.durability = durability;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
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

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("item.crack_hammer.tooltip").withStyle(ChatFormatting.GOLD));

        super.appendHoverText(itemStack, tooltipContext, tooltip, tooltipFlag);
    }

    public int getDurability() {
        return durability.get();
    }

    public ItemStack addDurability() {
        ItemStack stack = this.getDefaultInstance();
        stack.set(DataComponents.MAX_DAMAGE, getDurability());
        stack.set(DataComponents.MAX_STACK_SIZE, 1);
        stack.set(DataComponents.DAMAGE, 0);
        return stack;
    }
}
