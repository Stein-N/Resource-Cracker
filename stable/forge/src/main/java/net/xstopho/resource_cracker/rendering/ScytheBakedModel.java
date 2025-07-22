package net.xstopho.resource_cracker.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.extensions.IForgeBakedModel;
import net.xstopho.resource_cracker.CrackerConstants;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ScytheBakedModel implements BakedModel, IForgeBakedModel {
    final ModelResourceLocation inventoryLocation, inHandLocation;
    final BakedModel inventoryModel, inHandModel;

    public ScytheBakedModel(String item, Map<ModelResourceLocation, BakedModel> map) {
        this.inventoryLocation = ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, item));
        this.inHandLocation = ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "item/in_hand/" + item));
        this.inventoryModel = map.get(inventoryLocation);
        this.inHandModel = map.get(inHandLocation);
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState var1, @Nullable Direction var2, RandomSource var3) {
        return inventoryModel.getQuads(var1, var2, var3);
    }

    @Override
    public boolean useAmbientOcclusion() {
        return inventoryModel.useAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return inventoryModel.isGui3d();
    }

    @Override
    public boolean usesBlockLight() {
        return inventoryModel.usesBlockLight();
    }

    @Override
    public boolean isCustomRenderer() {
        return inventoryModel.isCustomRenderer();
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return inventoryModel.getParticleIcon();
    }

    @Override
    public ItemTransforms getTransforms() {
        return inventoryModel.getTransforms();
    }

    @Override
    public ItemOverrides getOverrides() {
        return inventoryModel.getOverrides();
    }

    @Override
    public BakedModel applyTransform(ItemDisplayContext transformType, PoseStack poseStack, boolean applyLeftHandTransform) {
        BakedModel model = this.inventoryModel;
        if (transformType != ItemDisplayContext.GUI && transformType != ItemDisplayContext.GROUND && transformType != ItemDisplayContext.FIXED) {
            model = this.inHandModel;
        }
        return model.applyTransform(transformType, poseStack, applyLeftHandTransform);
    }
}