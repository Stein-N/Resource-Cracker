package net.morthen.resource_cracker.helper;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.morthen.resource_cracker.CrackerConstants;

import java.util.List;
import java.util.Optional;

public class ItemModelHelper {

    private static final Identifier PARENT_FLAT = Identifier.withDefaultNamespace("item/handheld");
    private static final Identifier PARENT_FLAT_LARGE = Identifier.fromNamespaceAndPath(CrackerConstants.MOD_ID, "item/in_hand/handheld_large");

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
                        TextureMapping.layer0(new Material(getModelLocation(item, "item/"))),
                        generator.modelOutput);

        new ModelTemplate(Optional.of(PARENT_FLAT_LARGE), Optional.empty(), TextureSlot.LAYER0)
                .create(getModelLocation(item, "item/in_hand/"),
                        TextureMapping.layer0(new Material(getModelLocation(item, "item/in_hand/"))),
                        generator.modelOutput);
    }

    private static ItemModel.Unbaked inventoryModel(Item item) {
        Identifier modelLocation = getModelLocation(item, "item/");
        return ItemModelUtils.plainModel(modelLocation);
    }

    private static ItemModel.Unbaked inHandModel(Item item) {
        Identifier modelLocation = getModelLocation(item, "item/in_hand/");
        return ItemModelUtils.plainModel(modelLocation);
    }

    private static Identifier getModelLocation(Item item, String prefix) {
        Identifier location = BuiltInRegistries.ITEM.getKey(item);
        return location.withPrefix(prefix);
    }
}
