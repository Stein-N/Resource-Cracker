package net.xstopho.resource_cracker.helper;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.xstopho.resource_cracker.CrackerConstants;

import java.util.List;
import java.util.Optional;

public class ItemModelHelper {

    private static final ResourceLocation PARENT_FLAT = ResourceLocation.withDefaultNamespace("item/handheld");
    private static final ResourceLocation PARENT_FLAT_LARGE = ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "item/in_hand/handheld_large");

    public static void generateScytheModels(ItemModelGenerators generator, Item item) {
        createBaseModels(generator, item);
        generator.itemModelOutput.accept(item,
                ItemModelUtils.select(new DisplayContext(), inventoryModel(item),
                        List.of(
                                new SelectItemModel.SwitchCase<>(List.of(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND), inHandModel(item)),
                                new SelectItemModel.SwitchCase<>(List.of(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND), inHandModel(item)),
                                new SelectItemModel.SwitchCase<>(List.of(ItemDisplayContext.FIRST_PERSON_LEFT_HAND), inHandModel(item)),
                                new SelectItemModel.SwitchCase<>(List.of(ItemDisplayContext.THIRD_PERSON_LEFT_HAND), inHandModel(item))
                        )));
    }

    private static void createBaseModels(ItemModelGenerators generator, Item item) {
        new ModelTemplate(Optional.of(PARENT_FLAT), Optional.empty(), TextureSlot.LAYER0)
                .create(getModelLocation(item, "item/"),
                        TextureMapping.layer0(getModelLocation(item, "item/")),
                        generator.modelOutput);

        new ModelTemplate(Optional.of(PARENT_FLAT_LARGE), Optional.empty(), TextureSlot.LAYER0)
                .create(getModelLocation(item, "item/in_hand/"),
                        TextureMapping.layer0(getModelLocation(item, "item/in_hand/")),
                        generator.modelOutput);
    }

    private static ItemModel.Unbaked inventoryModel(Item item) {
        ResourceLocation modelLocation = getModelLocation(item, "item/");
        return ItemModelUtils.plainModel(modelLocation);
    }

    private static ItemModel.Unbaked inHandModel(Item item) {
        ResourceLocation modelLocation = getModelLocation(item, "item/in_hand/");
        return ItemModelUtils.plainModel(modelLocation);
    }

    private static ResourceLocation getModelLocation(Item item, String prefix) {
        ResourceLocation location = BuiltInRegistries.ITEM.getKey(item);
        return location.withPrefix(prefix);
    }
}
