package net.xstopho.resource_cracker.helper;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.item.tags.CrackerItemTags;


public abstract class BaseRecipes extends RecipeProvider {

    protected final RecipeOutput recipeOutput;

    protected BaseRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
        this.recipeOutput = recipeOutput;
    }

    public void crackHammerRecipe(ItemLike result, ItemLike ingot) {
        this.shaped(RecipeCategory.TOOLS, result)
                .pattern(" IT").pattern(" SI").pattern("S  ")
                .define('T', CrackerItemTags.CRACK_HAMMER_INGREDIENTS)
                .define('S', Items.STICK).define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(this.recipeOutput, path("crack_hammer/" + getSimpleRecipeName(result)));
    }

    public void chiselRecipe(ItemLike result, ItemLike ingot) {
        this.shaped(RecipeCategory.TOOLS, result)
                .pattern(" I").pattern("S ")
                .define('I', ingot).define('S', Items.STICK)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(this.recipeOutput, path("chisel/" + getSimpleRecipeName(result)));
    }

    public void scytheRecipe(ItemLike result, ItemLike ingot) {
        this.shaped(RecipeCategory.TOOLS, result)
                .pattern("IIT").pattern(" SI").pattern("S  ")
                .define('T', CrackerItemTags.SCYTHE_INGREDIENTS)
                .define('S', Items.STICK).define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(this.recipeOutput, path("scythe/" + getSimpleRecipeName(result)));
    }

    public void materialDustRecipe(ItemLike result, ItemLike input, int amount) {
        this.shapeless(RecipeCategory.MISC, result, amount)
                .requires(input).requires(CrackerItemTags.CRACK_HAMMER)
                .unlockedBy("has_crack_hammer", has(CrackerItemTags.CRACK_HAMMER))
                .save(this.recipeOutput, path("material_dust/" + getConversionRecipeName(result, input)));
    }

    public void compressRecipe(ItemLike result, ItemLike input) {
        this.shapeless(RecipeCategory.MISC, result)
                .requires(input, 9)
                .unlockedBy(getHasName(input), has(input))
                .save(this.recipeOutput, path("compress/" + getConversionRecipeName(result, input)));
    }

    public void decompressRecipe(ItemLike result, ItemLike input) {
        this.shapeless(RecipeCategory.MISC, result, 9)
                .requires(input).unlockedBy(getHasName(input), has(input))
                .save(this.recipeOutput, path("decompress/" + getConversionRecipeName(result, input)));
    }

    public void smeltingRecipe(ItemLike result, ItemLike input) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, result,
                        0.7f, 200).unlockedBy(getHasName(input), has(input))
                .save(this.recipeOutput, path("smelting/" + getSmeltingRecipeName(result)));
    }

    public void blastingRecipe(ItemLike result, ItemLike input) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, result,
                        0.7f, 100).unlockedBy(getHasName(input), has(input))
                .save(this.recipeOutput, path("blasting/" + getSmeltingRecipeName(result)));
    }

    public void smokingRecipe(ItemLike result, ItemLike input) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, result,
                        0.7f, 150).unlockedBy(getHasName(input), has(input))
                .save(this.recipeOutput, path("smoking/" + getSmeltingRecipeName(result)));
    }

    public void campfireRecipe(ItemLike result, ItemLike input) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, result,
                        0.7f, 400).unlockedBy(getHasName(input), has(input))
                .save(this.recipeOutput, path("campfire/" + getSmeltingRecipeName(result)));
    }

    public void springBlockRecipe(ItemLike output, ItemLike bucket) {
        this.shaped(RecipeCategory.MISC, output)
                .pattern("III").pattern("IBI").pattern("III")
                .define('I', CrackerItemTags.STEEL_INGOTS)
                .define('B', bucket)
                .unlockedBy("has_steel_ingot", has(CrackerItemTags.STEEL_INGOTS))
                .save(this.recipeOutput, path(getSmeltingRecipeName(output)));
    }

    public void smithingUpgrade(Item output, ItemLike upgradeItem, ItemLike upgradeMaterial) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(upgradeItem), Ingredient.of(upgradeMaterial),
                        RecipeCategory.TOOLS, output)
                .unlocks(getHasName(upgradeItem), has(upgradeItem))
                .unlocks(getHasName(upgradeMaterial), has(upgradeMaterial))
                .save(this.recipeOutput, path("smithing/" + getSimpleRecipeName(output)));
    }

    protected ResourceKey<Recipe<?>> path(String path) {
        return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, path));
    }
}
