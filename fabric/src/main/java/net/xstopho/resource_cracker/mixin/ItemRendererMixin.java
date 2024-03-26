package net.xstopho.resource_cracker.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @ModifyVariable(method = "render", at = @At("HEAD"), argsOnly = true)
    public BakedModel useInHandModel(BakedModel model, ItemStack stack, ItemDisplayContext displayContext, boolean leftHanded, PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) {
        if (displayContext != ItemDisplayContext.GUI && displayContext != ItemDisplayContext.GROUND && displayContext != ItemDisplayContext.FIXED) {
            if (stack.is(ItemRegistry.SCYTHE_COPPER.get())) return getModel("scythe_copper");
            if (stack.is(ItemRegistry.SCYTHE_GOLD.get())) return getModel("scythe_gold");
            if (stack.is(ItemRegistry.SCYTHE_IRON.get())) return getModel("scythe_iron");
            if (stack.is(ItemRegistry.SCYTHE_STEEL.get())) return getModel("scythe_steel");
            if (stack.is(ItemRegistry.SCYTHE_DIAMOND.get())) return getModel("scythe_diamond");
            if (stack.is(ItemRegistry.SCYTHE_NETHERITE.get())) return getModel("scythe_netherite");
        }
        return model;
    }

    private BakedModel getModel(String item) {
        return ((ItemRendererAccessor) this).cracker_getItemModelShaper().getModelManager()
                .getModel(new ModelResourceLocation(Constants.MOD_ID, "in_hand/" + item, "inventory"));
    }
}
