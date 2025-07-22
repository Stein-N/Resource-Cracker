package net.xstopho.resource_cracker.mixin;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.xstopho.resource_cracker.item.ChiselItem;
import net.xstopho.resource_cracker.item.CrackHammerItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShapedRecipe.class)
public abstract class ShapedRecipeMixin {

    @Shadow
    public abstract ItemStack getResultItem(HolderLookup.Provider registries);

    @Shadow
    public abstract NonNullList<Ingredient> getIngredients();

    @Inject(method = "assemble", at = @At("HEAD"), cancellable = true)
    private void onAssemble(CraftingInput input, HolderLookup.Provider registries, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = getResultItem(registries).copy();

        if (result.getItem() instanceof ChiselItem chisel) {
            cir.setReturnValue(addDurability(result, chisel.getDurability()));
        }
        if (result.getItem() instanceof CrackHammerItem crackHammer) {
            cir.setReturnValue(addDurability(result, crackHammer.getDurability()));
        }
    }

    private ItemStack addDurability(ItemStack stack, int durability) {
        stack.set(DataComponents.MAX_DAMAGE, durability);
        stack.set(DataComponents.MAX_STACK_SIZE, 1);
        stack.set(DataComponents.DAMAGE, 0);
        return stack;
    }
}
