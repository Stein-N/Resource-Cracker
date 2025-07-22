package net.xstopho.resource_cracker.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RepairItemRecipe;
import net.xstopho.resource_cracker.item.CrackHammerItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RepairItemRecipe.class)
public abstract class RepairItemRecipeMixin {

    @Shadow
    public abstract Pair<ItemStack, ItemStack> getItemsToCombine(CraftingInput input);

    @Inject(method = "assemble", at = @At("HEAD"), cancellable = true)
    private void onAssemble(CraftingInput input, HolderLookup.Provider registries, CallbackInfoReturnable<ItemStack> cir) {
        Pair<ItemStack, ItemStack> pair = this.getItemsToCombine(input);

        if (isCrackHammer(pair)) {
            cir.setReturnValue(ItemStack.EMPTY);
        }
    }

    private boolean isCrackHammer(Pair<ItemStack, ItemStack> pair) {
        return pair.getFirst().getItem() == pair.getSecond().getItem() && pair.getFirst().getItem() instanceof CrackHammerItem;
    }
}
