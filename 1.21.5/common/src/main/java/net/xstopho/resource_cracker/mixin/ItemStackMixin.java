package net.xstopho.resource_cracker.mixin;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.TooltipProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow
    public abstract <T extends TooltipProvider> void addToTooltip(DataComponentType<T> component, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> consumer, TooltipFlag flag);

    @Inject(method = "addDetailsToTooltip", at = @At("TAIL"))
    public void resource_cracker$addDetailsToTooltip(Item.TooltipContext context, TooltipDisplay display, Player player, TooltipFlag flag, Consumer<Component> consumer) {
        //this.addToTooltip(DataComponentRegistry.TOOLTIP_CONTAINER.get(), context, display, consumer, flag);
    }
}
