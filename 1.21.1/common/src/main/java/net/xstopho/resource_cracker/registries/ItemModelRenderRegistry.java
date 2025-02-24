package net.xstopho.resource_cracker.registries;

import net.minecraft.resources.ResourceLocation;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resourcelibrary.rendering.item.ItemModelRenderHelper;

public class ItemModelRenderRegistry {

    public static void init() {
        ItemModelRenderHelper.registerItemModel(ItemRegistry.SCYTHE_COPPER.get(), location("scythe_copper"));
        ItemModelRenderHelper.registerItemModel(ItemRegistry.SCYTHE_GOLD.get(), location("scythe_gold"));
        ItemModelRenderHelper.registerItemModel(ItemRegistry.SCYTHE_IRON.get(), location("scythe_iron"));
        ItemModelRenderHelper.registerItemModel(ItemRegistry.SCYTHE_STEEL.get(), location("scythe_steel"));
        ItemModelRenderHelper.registerItemModel(ItemRegistry.SCYTHE_DIAMOND.get(), location("scythe_diamond"));
        ItemModelRenderHelper.registerItemModel(ItemRegistry.SCYTHE_NETHERITE.get(), location("scythe_netherite"));
    }

    private static ResourceLocation location(String id) {
        return ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "in_hand/" + id);
    }
}
