package net.xstopho.resource_cracker.rendering;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.xstopho.resource_cracker.Constants;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ScytheHandModel implements BakedModel {
    /**
     *  Only used for Neo-/Forge will eventually be changed later on
     */
    final ResourceLocation inventoryLocation, inHandLocation;
    final BakedModel inventoryModel, inHandModel;

    public ScytheHandModel(String item, Map<ResourceLocation, BakedModel> map) {
        this.inventoryLocation = new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, item), "inventory");
        this.inHandLocation = new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, "in_hand/" + item), "inventory");
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
}
