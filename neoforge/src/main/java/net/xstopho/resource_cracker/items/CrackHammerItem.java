package net.xstopho.resource_cracker.items;

import net.minecraft.world.item.ItemStack;
import net.xstopho.resource_cracker.item.CrackHammerBase;

public class CrackHammerItem extends CrackHammerBase {
    public CrackHammerItem(int durability) {
        super(durability);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack item = itemStack.copy();
        item.setDamageValue(item.getDamageValue() + 1);

        if (item.getDamageValue() >= item.getMaxDamage()) {
            item.shrink(1);
        }

        return item;
    }
}
