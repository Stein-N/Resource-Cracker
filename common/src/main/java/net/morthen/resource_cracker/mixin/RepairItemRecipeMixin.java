package net.morthen.resource_cracker.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RepairItemRecipe;
import net.morthen.resource_cracker.item.CrackHammerItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RepairItemRecipe.class)
public class RepairItemRecipeMixin {

    @Shadow(remap = false)
    public static Pair<ItemStack, ItemStack> getItemsToCombine(CraftingInput input) {
        throw new AbstractMethodError();
    }

    @Inject(method = "assemble", at = @At("HEAD"), cancellable = true, remap = false)
    private void onAssemble(CraftingInput input, CallbackInfoReturnable<ItemStack> cir) {
        Pair<ItemStack, ItemStack> pair = getItemsToCombine(input);

        if (isCrackHammer(pair)) {
            cir.setReturnValue(ItemStack.EMPTY);
        }
    }

    @Unique
    private boolean isCrackHammer(Pair<ItemStack, ItemStack> pair) {
        return pair.getFirst().getItem() == pair.getSecond().getItem() && pair.getFirst().getItem() instanceof CrackHammerItem;
    }
}
