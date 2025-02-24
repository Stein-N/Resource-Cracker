package net.xstopho.resource_cracker.registries;

import net.minecraft.resources.ResourceLocation;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resourcelibrary.rendering.ItemModelRenderer;

public class ItemModelRenderRegistry {

    public static void init() {
        ItemModelRenderer renderer = new ItemModelRenderer(CrackerConstants.MOD_ID);

        renderer.registerInHandModel(ItemRegistry.SCYTHE_COPPER.get(), "scythe_copper");

        renderer.registerInHandModel(ItemRegistry.SCYTHE_GOLD.get(), "scythe_gold");
        renderer.registerInHandModel(ItemRegistry.SCYTHE_IRON.get(), "scythe_iron");
        renderer.registerInHandModel(ItemRegistry.SCYTHE_STEEL.get(), "scythe_steel");
        renderer.registerInHandModel(ItemRegistry.SCYTHE_DIAMOND.get(), "scythe_diamond");
        renderer.registerInHandModel(ItemRegistry.SCYTHE_NETHERITE.get(), "scythe_netherite");
    }

    private static ResourceLocation location(String id) {
        return ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "in_hand/" + id);
    }
}
