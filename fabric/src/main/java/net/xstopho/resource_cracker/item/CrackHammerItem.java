package net.xstopho.resource_cracker.item;

import net.minecraft.world.item.ItemStack;

public class CrackHammerItem extends CrackHammerBase {
    public CrackHammerItem(int durability) {
        super(durability);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack item = stack.copy();
        item.setDamageValue(item.getDamageValue() + 1);

        if (item.getDamageValue() >= item.getMaxDamage()) {
            item.shrink(1);
        }

        return item;
    }
}
