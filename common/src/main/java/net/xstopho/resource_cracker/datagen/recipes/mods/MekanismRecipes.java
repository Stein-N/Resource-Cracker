package net.xstopho.resource_cracker.datagen.recipes.mods;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resource_cracker.datagen.recipes.ModRecipes;

public class MekanismRecipes extends ModRecipes {

    public static void generate(RecipeOutput output, TagKey<Item> tagKey) {
        setConstants(output, "mekanism", tagKey);

        defineRecipe("dirty_dust_copper", "clump_copper");
    }
}
