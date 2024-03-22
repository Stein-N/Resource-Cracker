package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public class ModRecipes {

    private static RecipeOutput conditionalOutput;
    private static String id;
    private static TagKey<Item> key;

    public static void setConstants(RecipeOutput output, String modId, TagKey<Item> tagKey) {
        conditionalOutput = output;
        id = modId;
        key = tagKey;
    }

    public static void defineRecipe(String output, String input) {
        defineRecipe(item(output), item(input));
    }

    public static void defineRecipe(String output, ItemLike input) {
        defineRecipe(item(output), input);
    }

    public static void defineRecipe(ItemLike output, String input) {
        defineRecipe(output, item(input));
    }

    public static void defineRecipe(ItemLike output, ItemLike input) {
        Recipes.materialDustRecipe(conditionalOutput, output, input, 1, key, id);
    }

    public static Item item(String itemId) {
        ResourceLocation location = new ResourceLocation(id, itemId);
        if (BuiltInRegistries.ITEM.containsKey(location)) return BuiltInRegistries.ITEM.get(location);
        else return dummyItem(location);
    }

    static Item dummyItem(ResourceLocation location) {
        return Registry.register(BuiltInRegistries.ITEM, location, new Item(new Item.Properties()));
    }
}
