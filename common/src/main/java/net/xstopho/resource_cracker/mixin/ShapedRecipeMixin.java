package net.xstopho.resource_cracker.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.xstopho.resource_cracker.item.ChiselItem;
import net.xstopho.resource_cracker.item.CrackHammerItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShapedRecipe.class)
public abstract class ShapedRecipeMixin {

    @Inject(method = "assemble", at = @At("HEAD"), cancellable = true, remap = false)
    private void onAssemble(CraftingInput input, CallbackInfoReturnable<ItemStack> cir) {
        ItemStackTemplate result = ((ShapedRecipeAccessor) this).cracker_getResult();
        ItemStack stack = result.create();

        if (stack.getItem() instanceof ChiselItem chisel) {
            cir.setReturnValue(chisel.addDurability(stack));
        }

        if (stack.getItem() instanceof CrackHammerItem crackHammer) {
            cir.setReturnValue(crackHammer.addDurability(stack));
        }
    }
}
