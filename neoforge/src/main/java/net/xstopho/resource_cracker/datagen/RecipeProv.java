package net.xstopho.resource_cracker.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.crafting.ConditionalRecipeOutput;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.datagen.recipes.mods.AE2Recipes;
import net.xstopho.resource_cracker.datagen.recipes.Recipes;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class RecipeProv extends RecipeProvider implements IConditionBuilder {
    public RecipeProv(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        Recipes.generateToolRecipes(output, ForgeItemTags.CRAFTING_INGREDIENTS);
        Recipes.generateMaterialDustRecipes(output, ForgeItemTags.CRACK_HAMMER);
        Recipes.generateSpringBlockRecipes(output, ForgeItemTags.STEEL_BLOCKS);
        Recipes.generateProcessingRecipes(output);
        Recipes.generateCompactingRecipes(output);

        // Mod Recipes
        // noinspection UnstableApiUsage
        AE2Recipes.generate(new ConditionalRecipeOutput(output, getConditions(modLoaded("ae2"))), ForgeItemTags.CRACK_HAMMER);

        // Netherite Dust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), 1)
                .pattern("AAA").pattern("AGG").pattern("GG ")
                .define('A', ForgeItemTags.NETHERITE_SCRAP_DUSTS)
                .define('G', ForgeItemTags.GOLD_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get()), has(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get()))
                .save(output, location("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_NETHERITE.get())));

        // Steeldust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_STEEL.get(), 2)
                .pattern("II").pattern("SS")
                .define('I', ForgeItemTags.IRON_DUSTS)
                .define('S', ForgeItemTags.COAL_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_IRON.get()), has(ItemRegistry.MATERIAL_DUST_IRON.get()))
                .save(output, location("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_STEEL.get())));

        // Slimeball Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SLIME_BALL, 3)
                .pattern("HGS")
                .define('H', Items.HONEYCOMB)
                .define('G', Items.GREEN_DYE)
                .define('S', ForgeItemTags.SALTPETER_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER.get()), has(ItemRegistry.MATERIAL_DUST_SALTPETER.get()))
                .save(output, location("crafting/" + getSimpleRecipeName(Items.SLIME_BALL)));

        // Gunpowder Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GUNPOWDER, 3)
                .pattern("SPC").define('C', Items.CHARCOAL)
                .define('P', ForgeItemTags.SALTPETER_DUSTS)
                .define('S', ForgeItemTags.SULFUR_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER.get()), has(ItemRegistry.MATERIAL_DUST_SALTPETER.get()))
                .save(output, location("crafting/" + getSimpleRecipeName(Items.GUNPOWDER)));
    }

    static ResourceLocation location(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }

    static ICondition[] getConditions(ICondition... conditions) {
        ICondition[] con = new ICondition[conditions.length];
        System.arraycopy(conditions, 0, con, 0, con.length);
        return con;
    }
}