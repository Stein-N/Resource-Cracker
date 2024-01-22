package net.xstopho.resource_cracker.datagen;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.xstopho.resource_cracker.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Recipes {

    public static void crackHammerRecipe(RecipeOutput exporter, ItemLike output, ItemLike input, TagKey<Item> ingredients) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" IT").pattern(" SI").pattern("S  ")
                .define('T', Ingredient.of(ingredients))
                .define('S', Items.STICK).define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/crack_hammer/" + getSimpleRecipeName(output)));
    }

    public static void chiselRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" I").pattern("S ")
                .define('I', input).define('S', Items.STICK)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/chisel/" + getSimpleRecipeName(output)));
    }

    public static void scytheRecipe(RecipeOutput exporter, ItemLike output, ItemLike input, TagKey<Item> ingredients) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("IIT").pattern(" SI").pattern("S  ")
                .define('T', Ingredient.of(ingredients))
                .define('S', Items.STICK).define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/scythe/" + getSimpleRecipeName(output)));
    }

    public static void netheriteUpgrade(RecipeOutput exporter, Item output, ItemLike input) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(input),
                Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, output)
                .unlocks(getHasName(input), has(input))
                .save(exporter, location("smithing/" + getSimpleRecipeName(output)));
    }

    public static void springBlockRecipe(RecipeOutput exporter, ItemLike output, ItemLike input, TagKey<Item> ingredients) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1)
                .pattern("SSS").pattern("SBS").pattern("SSS")
                .define('S', Ingredient.of(ingredients))
                .define('B', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blocks/" + getSimpleRecipeName(output)));
    }

    public static void materialDustRecipe(RecipeOutput exporter, ItemLike output, ItemLike input, int outputAmount, TagKey<Item> crackHammerTag) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputAmount)
                .requires(Ingredient.of(crackHammerTag))
                .requires(input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("material_dusts/" + getSimpleRecipeName(output) + "_from_" + getSimpleRecipeName(input)));
    }

    public static void compressionRecipe(RecipeOutput exporter, ItemLike output, ItemLike input, boolean compress, boolean decompress) {
        if (compress) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1).pattern("###").pattern("###").pattern("###")
                    .define('#', input).unlockedBy(getHasName(input), has(input))
                    .save(exporter, location("compress/" + getSimpleRecipeName(output) + "_from_" + getSimpleRecipeName(input)));
        }
        if (decompress) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, input, 9)
                    .requires(output).unlockedBy(getHasName(output), has(output))
                    .save(exporter, location("decompress/" + getSimpleRecipeName(input) + "_from_" + getSimpleRecipeName(output)));
        }
    }

    public static void processingRecipes(RecipeOutput exporter, ItemLike input, ItemLike output, boolean smelting, boolean blasting, boolean smoking, boolean campfire) {
        if (smelting) smeltingRecipe(exporter, input, output);
        if (blasting) blastingRecipe(exporter, input, output);
        if (smoking) smokingRecipe(exporter, input, output);
        if (campfire) campfireRecipe(exporter, input, output);

    }

    public static void smeltingRecipe(RecipeOutput exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 200)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smelting/" + getSimpleRecipeName(output)));
    }

    public static void blastingRecipe(RecipeOutput exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 100)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blasting/" + getSimpleRecipeName(output)));
    }

    public static void smokingRecipe(RecipeOutput exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 150)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smoking/" + getSimpleRecipeName(output)));
    }

    public static void campfireRecipe(RecipeOutput exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 600)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("campfire/" + getSimpleRecipeName(output)));
    }

    private static String getHasName(ItemLike item) {
        return "has_" + getItemName(item);
    }

    private static String getItemName(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }

    private static String getSimpleRecipeName(ItemLike item) {
        return getItemName(item);
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike itemLike) {
        return inventoryTrigger(net.minecraft.advancements.critereon.ItemPredicate.Builder.item().of(new ItemLike[]{itemLike}));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate.Builder... builders) {
        return inventoryTrigger(Arrays.stream(builders).map(ItemPredicate.Builder::build).toArray(ItemPredicate[]::new));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate... itemPredicates) {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(itemPredicates)));
    }

    private static ResourceLocation location(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }
}
