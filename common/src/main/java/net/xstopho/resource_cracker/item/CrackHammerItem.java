package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.xstopho.stophoslib.items.RecipeRemainder;

import java.util.List;

public class CrackHammerItem extends RecipeRemainder.Item {
    public CrackHammerItem(int durability) {
        super(new Properties().durability(durability));
    }

    @Override
    public ItemStack getRemainder(ItemStack stack) {
        if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
            ItemStack moreDamaged = stack.copy();
            moreDamaged.setDamageValue(stack.getDamageValue() + 1);
            return moreDamaged;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item.crack_hammer.tooltip").withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, world, tooltip, flag);
    }
}
