package net.xstopho.resource_cracker.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.xstopho.resource_cracker.Constants;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ScytheInHandModel {
    public static final String[] HAND_MODEL_ITEMS = new String[] {"scythe_diamond"};

    @SubscribeEvent
    public static void onModelBakeEvent(ModelEvent.ModifyBakingResult event) {
        Map<ResourceLocation, BakedModel> map = event.getModels();
        for (String item : HAND_MODEL_ITEMS) {
            ResourceLocation modelInventory = new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, item), "inventory");
            ResourceLocation modelHand = new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, "in_hand/" + item), "inventory");

            BakedModel bakedModelInventory = map.get(modelInventory);
            BakedModel bakedModelInHand = map.get(modelHand);
            BakedModel modelWrapper = new BakedModel() {
                @Override
                public List<BakedQuad> getQuads(@Nullable BlockState blockState, @Nullable Direction direction, RandomSource randomSource) {
                    return bakedModelInventory.getQuads(blockState, direction, randomSource);
                }

                @Override
                public boolean useAmbientOcclusion() {
                    return bakedModelInventory.useAmbientOcclusion();
                }

                @Override
                public boolean isGui3d() {
                    return bakedModelInventory.isGui3d();
                }

                @Override
                public boolean usesBlockLight() {
                    return bakedModelInventory.usesBlockLight();
                }

                @Override
                public boolean isCustomRenderer() {
                    return bakedModelInventory.isCustomRenderer();
                }

                @Override
                public TextureAtlasSprite getParticleIcon() {
                    return bakedModelInventory.getParticleIcon();
                }

                @Override
                public ItemOverrides getOverrides() {
                    return bakedModelInventory.getOverrides();
                }

                @Override
                public BakedModel applyTransform(ItemDisplayContext transformType, PoseStack poseStack, boolean applyLeftHandTransform) {
                    BakedModel model = bakedModelInventory;
                    if (transformType != ItemDisplayContext.GUI && transformType != ItemDisplayContext.GROUND && transformType != ItemDisplayContext.FIXED) {
                        model = bakedModelInHand;
                    }
                    return ForgeHooksClient.handleCameraTransforms(poseStack, model, transformType, applyLeftHandTransform);
                }
            };
            map.put(modelInventory, modelWrapper);
        }
    }
}
