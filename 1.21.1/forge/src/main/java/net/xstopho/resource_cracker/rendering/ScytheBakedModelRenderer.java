package net.xstopho.resource_cracker.rendering;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.xstopho.resource_cracker.CrackerConstants;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ScytheBakedModelRenderer {

    @SubscribeEvent
    public static void onRegisterModel(ModelEvent.RegisterAdditional event) {
        event.register(location("item/in_hand/scythe_copper"));
        event.register(location("item/in_hand/scythe_gold"));
        event.register(location("item/in_hand/scythe_iron"));
        event.register(location("item/in_hand/scythe_steel"));
        event.register(location("item/in_hand/scythe_diamond"));
        event.register(location("item/in_hand/scythe_netherite"));
    }

    @SubscribeEvent
    public static void onModelBakeEvent(ModelEvent.ModifyBakingResult event) {
        add(event, "scythe_copper");
        add(event, "scythe_gold");
        add(event, "scythe_iron");
        add(event, "scythe_steel");
        add(event, "scythe_diamond");
        add(event, "scythe_netherite");
    }

    private static void add(ModelEvent.ModifyBakingResult event, String id) {
        event.getModels().put(location(id), new ScytheBakedModel(id, event.getModels()));
    }

    private static ModelResourceLocation location(String path) {
        ModelResourceLocation loc = ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, path));
        CrackerConstants.LOGGER.debug(loc.id().getPath());
        return loc;
    }
}
