package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class RecipeProv extends FabricRecipeProvider {
    public RecipeProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(RecipeOutput output) {
        Recipes.crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_COPPER.get(), Items.COPPER_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_GOLD.get(), Items.GOLD_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_IRON.get(), Items.IRON_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_DIAMOND.get(), Items.DIAMOND, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.crackHammerRecipe(output, ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.netheriteUpgrade(output, ItemRegistry.CRACK_HAMMER_NETHERITE.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get());

        /*  Chisel  */
        Recipes.chiselRecipe(output, ItemRegistry.CHISEL_COPPER.get(), Items.COPPER_INGOT);
        Recipes.chiselRecipe(output, ItemRegistry.CHISEL_GOLD.get(), Items.GOLD_INGOT);
        Recipes.chiselRecipe(output, ItemRegistry.CHISEL_IRON.get(), Items.IRON_INGOT);
        Recipes.chiselRecipe(output, ItemRegistry.CHISEL_DIAMOND.get(), Items.DIAMOND);
        Recipes.chiselRecipe(output, ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        Recipes.netheriteUpgrade(output, ItemRegistry.CHISEL_NETHERITE.get(), ItemRegistry.CHISEL_DIAMOND.get());

        /* Scythe */
        Recipes.scytheRecipe(output, ItemRegistry.SCYTHE_COPPER.get(), Items.COPPER_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.scytheRecipe(output, ItemRegistry.SCYTHE_IRON.get(), Items.IRON_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.scytheRecipe(output, ItemRegistry.SCYTHE_GOLD.get(), Items.GOLD_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.scytheRecipe(output, ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.scytheRecipe(output, ItemRegistry.SCYTHE_DIAMOND.get(), Items.DIAMOND, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.netheriteUpgrade(output, ItemRegistry.SCYTHE_NETHERITE.get(), ItemRegistry.SCYTHE_DIAMOND.get());

        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_CARBON.get(), Items.CHARCOAL, 2, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.RAW_COPPER, 2, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.RAW_IRON, 2, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.RAW_GOLD, 2, FabricItemTags.CRACK_HAMMER);

        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, 1, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, 1, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, 1, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), 1, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, 1, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT, 1, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, 1, FabricItemTags.CRACK_HAMMER);

        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND_ORE, 2, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DEEPSLATE_DIAMOND_ORE, 2, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD_ORE, 2, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.DEEPSLATE_EMERALD_ORE, 2, FabricItemTags.CRACK_HAMMER);
        Recipes.materialDustRecipe(output, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.ANCIENT_DEBRIS, 2, FabricItemTags.CRACK_HAMMER);

        Recipes.springBlockRecipe(output, BlockRegistry.WATER_SPRING_BLOCK.get(), Items.WATER_BUCKET, FabricItemTags.STEEL_INGOTS);
        Recipes.springBlockRecipe(output, BlockRegistry.LAVA_SPRING_BLOCK.get(), Items.LAVA_BUCKET, FabricItemTags.STEEL_BLOCKS);

        Recipes.processingRecipes(output, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, true, true, false, true);
        Recipes.processingRecipes(output, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, true, true, false, true);
        Recipes.processingRecipes(output, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, true, true, false, true);
        Recipes.processingRecipes(output, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, true, true, false, true);
        Recipes.processingRecipes(output, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, true, true, false, true);
        Recipes.processingRecipes(output, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.NETHERITE_SCRAP, true, true, false, true);
        Recipes.processingRecipes(output, ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), true, true, false, true);
        Recipes.processingRecipes(output, ItemRegistry.GARLIC.get(), ItemRegistry.MATERIAL_DUST_SULFUR.get(), true, true, false, true);
        Recipes.processingRecipes(output, Items.ROTTEN_FLESH, Items.LEATHER, true, true, false, true);

        Recipes.blastingRecipe(output, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT);
        Recipes.smokingRecipe(output, Items.ROTTEN_FLESH, ItemRegistry.BEEF_JERKY.get());

        Recipes.compressionRecipe(output, BlockRegistry.STEEL_BLOCK.get(), ItemRegistry.STEEL_INGOT.get(), true, true);
        Recipes.compressionRecipe(output, Items.DIAMOND, ItemRegistry.NUGGET_DIAMOND.get(), true, false);
        Recipes.compressionRecipe(output, Items.EMERALD, ItemRegistry.NUGGET_EMERALD.get(), true, false);
        Recipes.compressionRecipe(output, Items.COPPER_INGOT, ItemRegistry.NUGGET_COPPER.get(), true, true);

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
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
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
}
