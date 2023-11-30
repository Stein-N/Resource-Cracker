package net.xstopho.resource_cracker.recipes;

import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.xstopho.resource_cracker.Constants;

import java.util.function.Consumer;

public class Recipes {

    public static void offerCrackHammerRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, TagKey<Item> ingredients) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" IT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', Ingredient.of(ingredients))
                .define('S', Items.STICK)
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/crack_hammer/" + getSimpleRecipeName(output)));
    }

    public static void offerChiselRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" I")
                .pattern("S ")
                .define('S', Items.STICK)
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/chisel/" + getSimpleRecipeName(output)));
    }

    public static void offerScytheRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, TagKey<Item> ingredients) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("IIT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', Ingredient.of(ingredients))
                .define('S', Items.STICK)
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/scythe/" + getSimpleRecipeName(output)));
    }

    public static void offerNetheriteUpgrade(Consumer<FinishedRecipe> exporter, Item output, ItemLike input) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(input),
                        Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, output)
                .unlocks(getHasName(input), has(input))
                .save(exporter, location("smithing/" + getSimpleRecipeName(output)));
    }

    public static void createSpringRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1)
                .pattern("SSS").pattern("SBS").pattern("SSS")
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "blocks/steel"))))
                .define('B', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blocks/" + getSimpleRecipeName(output)));
    }

    public static void offerMaterialDustRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, int outputAmount, TagKey<Item> crackHammer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputAmount)
                .requires(Ingredient.of(crackHammer))
                .requires(input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("material_dusts/" + getSimpleRecipeName(output) + "_from_" + getSimpleRecipeName(input)));
    }

    public static void createProcessingRecipes(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output, boolean smeltingBlasting, boolean smoking, boolean campfire) {
        if (smeltingBlasting) createSmeltingRecipe(exporter, input, output); createBlastingRecipe(exporter, input, output);
        if (smoking) createSmokingRecipe(exporter, input, output);
        if (campfire) createCampfireRecipe(exporter, input, output);

    }

    public static void createSmeltingRecipe(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 200)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smelting/" + getSimpleRecipeName(output)));
    }

    public static void createBlastingRecipe(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 100)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blasting/" + getSimpleRecipeName(output)));
    }

    public static void createSmokingRecipe(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 150)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smoking/" + getSimpleRecipeName(output)));
    }

    public static void createCampfireRecipe(Consumer<FinishedRecipe> exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 600)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("campfire/" + getSimpleRecipeName(output)));
    }

    private static ResourceLocation location(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }

    private static String getHasName(ItemLike item) {
        return "has_" + getItemName(item);
    }

    private static String getSimpleRecipeName(ItemLike item) {
        return getItemName(item);
    }

    private static String getItemName(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }

    private static InventoryChangeTrigger.TriggerInstance has(ItemLike item) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(item).build());
    }

    private static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... itemPredicates) {
        return new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, itemPredicates);
    }
}
