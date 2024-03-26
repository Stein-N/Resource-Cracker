package net.xstopho.resource_cracker.datagen.recipes.mods;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resource_cracker.datagen.recipes.ModRecipes;

public class AE2Recipes extends ModRecipes {

    public static void generate(RecipeOutput output, TagKey<Item> key) {
        setConstants(output, "ae2", key);

        defineRecipe("certus_quartz_dust", "certus_quartz_crystal");
        defineRecipe("certus_quartz_dust", "charged_certus_quartz_crystal");
        defineRecipe("fluix_dust", "fluix_crystal");
        defineRecipe("sky_dust", "sky_stone_block");
    }
}
