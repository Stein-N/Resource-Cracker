package net.morthen.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.enchantment.Repairable;
import net.morthen.resourcelibrary.item.ResourceCraftingRemainder;

import java.util.List;
import java.util.function.Supplier;

public class CrackHammerItem extends ResourceCraftingRemainder {
    private final Supplier<Integer> durability;
    private final Holder<Item> repairItem;

    public CrackHammerItem(Supplier<Integer> durability, Holder<Item> repairItem, Properties properties) {
        super(properties
                .component(DataComponents.MAX_STACK_SIZE, 1)
                .component(DataComponents.LORE, new ItemLore(List.of(), List.of(Component.translatable("item.crack_hammer.tooltip").withStyle(ChatFormatting.GOLD)))));
        this.durability = durability;
        this.repairItem = repairItem;
    }

    @Override
    public ItemStackTemplate getRemainingItem(ItemStack itemStack) {
        if (!itemStack.has(DataComponents.MAX_DAMAGE)) {
            this.addToolComponents(itemStack);
        }

        if (itemStack.getDamageValue() < itemStack.getMaxDamage() -1) {
            ItemStack damaged = itemStack.copy();
            damaged.setDamageValue(itemStack.getDamageValue() + 1);
            return ItemStackTemplate.fromNonEmptyStack(damaged);
        }

        return super.getCraftingRemainder();
    }

    private void addToolComponents(ItemStack stack) {
        stack.set(DataComponents.MAX_DAMAGE, this.durability.get());
        stack.set(DataComponents.DAMAGE, 0);

        stack.set(DataComponents.REPAIR_COST, 1);
        stack.set(DataComponents.REPAIRABLE, new Repairable(HolderSet.direct(this.repairItem)));
    }
}
