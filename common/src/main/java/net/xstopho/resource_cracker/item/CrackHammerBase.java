package net.xstopho.resource_cracker.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CrackHammerBase extends Item {
    public CrackHammerBase(int durability) {
        super(new Properties().defaultDurability(durability));
    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item.crack_hammer.tooltip"));

        super.appendHoverText(stack, world, tooltip, flag);
    }
}
