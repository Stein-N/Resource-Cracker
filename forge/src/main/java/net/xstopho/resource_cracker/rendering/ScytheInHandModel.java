package net.xstopho.resource_cracker.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.extensions.IForgeBakedModel;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.xstopho.resource_cracker.Constants;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ScytheInHandModel {

    @SubscribeEvent
    public static void onRegisterModel(ModelEvent.RegisterAdditional event) {
        event.register(location("in_hand/scythe_copper"));
        event.register(location("in_hand/scythe_gold"));
        event.register(location("in_hand/scythe_iron"));
        event.register(location("in_hand/scythe_steel"));
        event.register(location("in_hand/scythe_diamond"));
        event.register(location("in_hand/scythe_netherite"));
    }

    @SubscribeEvent
    public static void onModelBakeEvent(ModelEvent.ModifyBakingResult event) {
        Map<ResourceLocation, BakedModel> map = event.getModels();

        map.put(location("scythe_copper"), new ScytheBakedModel("scythe_copper", map));
        map.put(location("scythe_gold"), new ScytheBakedModel("scythe_gold", map));
        map.put(location("scythe_iron"), new ScytheBakedModel("scythe_iron", map));
        map.put(location("scythe_steel"), new ScytheBakedModel("scythe_steel", map));
        map.put(location("scythe_diamond"), new ScytheBakedModel("scythe_diamond", map));
        map.put(location("scythe_netherite"), new ScytheBakedModel("scythe_netherite", map));
    }

    private static ResourceLocation location(String path) {
        return new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, path), "inventory");
    }

    private static class ScytheBakedModel extends ScytheHandModel implements IForgeBakedModel {
        public ScytheBakedModel(String item, Map<ResourceLocation, BakedModel> map) {
            super(item, map);
        }

        @Override
        public BakedModel applyTransform(ItemDisplayContext transformType, PoseStack poseStack, boolean applyLeftHandTransform) {
            BakedModel model = this.inventoryModel;
            if (transformType != ItemDisplayContext.GUI && transformType != ItemDisplayContext.GROUND && transformType != ItemDisplayContext.FIXED) {
                model = this.inHandModel;
            }
            return ForgeHooksClient.handleCameraTransforms(poseStack, model, transformType, applyLeftHandTransform);
        }
    }
}