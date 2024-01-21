package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class RecipeProv extends FabricRecipeProvider {
    public RecipeProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        Recipes.crackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_COPPER.get(), Items.COPPER_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.crackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_GOLD.get(), Items.GOLD_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.crackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_IRON.get(), Items.IRON_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.crackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_DIAMOND.get(), Items.DIAMOND, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.crackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.netheriteUpgrade(exporter, ItemRegistry.CRACK_HAMMER_NETHERITE.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get());

        /*  Chisel  */
        Recipes.chiselRecipe(exporter, ItemRegistry.CHISEL_COPPER.get(), Items.COPPER_INGOT);
        Recipes.chiselRecipe(exporter, ItemRegistry.CHISEL_GOLD.get(), Items.GOLD_INGOT);
        Recipes.chiselRecipe(exporter, ItemRegistry.CHISEL_IRON.get(), Items.IRON_INGOT);
        Recipes.chiselRecipe(exporter, ItemRegistry.CHISEL_DIAMOND.get(), Items.DIAMOND);
        Recipes.chiselRecipe(exporter, ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        Recipes.netheriteUpgrade(exporter, ItemRegistry.CHISEL_NETHERITE.get(), ItemRegistry.CHISEL_DIAMOND.get());

        /* Scythe */
        Recipes.scytheRecipe(exporter, ItemRegistry.SCYTHE_COPPER.get(), Items.COPPER_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.scytheRecipe(exporter, ItemRegistry.SCYTHE_IRON.get(), Items.IRON_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.scytheRecipe(exporter, ItemRegistry.SCYTHE_GOLD.get(), Items.GOLD_INGOT, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.scytheRecipe(exporter, ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.scytheRecipe(exporter, ItemRegistry.SCYTHE_DIAMOND.get(), Items.DIAMOND, FabricItemTags.CRAFTING_INGREDIENTS);
        Recipes.netheriteUpgrade(exporter, ItemRegistry.SCYTHE_NETHERITE.get(), ItemRegistry.SCYTHE_DIAMOND.get());

        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_CARBON.get(), Items.CHARCOAL, 2);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.RAW_COPPER, 2);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.RAW_IRON, 2);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.RAW_GOLD, 2);

        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, 1);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, 1);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, 1);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), 1);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, 1);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT, 1);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, 1);

        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND_ORE, 2);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DEEPSLATE_DIAMOND_ORE, 2);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD_ORE, 2);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.DEEPSLATE_EMERALD_ORE, 2);
        Recipes.materialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.ANCIENT_DEBRIS, 2);

        Recipes.springBlockRecipe(exporter, BlockRegistry.WATER_SPRING_BLOCK.get(), Items.WATER_BUCKET, FabricItemTags.STEEL_BLOCKS);
        Recipes.springBlockRecipe(exporter, BlockRegistry.LAVA_SPRING_BLOCK.get(), Items.LAVA_BUCKET, FabricItemTags.STEEL_BLOCKS);

        Recipes.processingRecipes(exporter, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, true, true, false, true);
        Recipes.processingRecipes(exporter, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, true, true, false, true);
        Recipes.processingRecipes(exporter, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, true, true, false, true);
        Recipes.processingRecipes(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, true, true, false, true);
        Recipes.processingRecipes(exporter, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, true, true, false, true);
        Recipes.processingRecipes(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.NETHERITE_SCRAP, true, true, false, true);
        Recipes.processingRecipes(exporter, ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), true, true, false, true);
        Recipes.processingRecipes(exporter, ItemRegistry.GARLIC.get(), ItemRegistry.MATERIAL_DUST_SULFUR.get(), true, true, false, true);
        Recipes.processingRecipes(exporter, Items.ROTTEN_FLESH, Items.LEATHER, true, true, false, true);

        Recipes.blastingRecipe(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT);
        Recipes.smokingRecipe(exporter, Items.ROTTEN_FLESH, ItemRegistry.BEEF_JERKY.get());

        Recipes.compressionRecipe(exporter, BlockRegistry.STEEL_BLOCK.get(), ItemRegistry.STEEL_INGOT.get(), true, true);
        Recipes.compressionRecipe(exporter, Items.DIAMOND, ItemRegistry.NUGGET_DIAMOND.get(), true, false);
        Recipes.compressionRecipe(exporter, Items.EMERALD, ItemRegistry.NUGGET_EMERALD.get(), true, false);
        Recipes.compressionRecipe(exporter, Items.COPPER_INGOT, ItemRegistry.NUGGET_COPPER.get(), true, true);

        // Netherite Dust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), 1)
                .pattern("AAA").pattern("AGG").pattern("GG ")
                .define('A', FabricItemTags.NETHERITE_SCRAP_DUSTS)
                .define('G', FabricItemTags.GOLD_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get()), has(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get()))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_NETHERITE.get())));

        // Steeldust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_STEEL.get(), 2)
                .pattern("II").pattern("SS")
                .define('I', FabricItemTags.IRON_DUSTS)
                .define('S', FabricItemTags.COAL_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_IRON.get()), has(ItemRegistry.MATERIAL_DUST_IRON.get()))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_STEEL.get())));

        // Slimeball Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SLIME_BALL, 3)
                .pattern("HGS")
                .define('H', Items.HONEYCOMB)
                .define('G', Items.GREEN_DYE)
                .define('S', FabricItemTags.SALTPETER_DUSTS)
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER.get()), has(ItemRegistry.MATERIAL_DUST_SALTPETER.get()))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(Items.SLIME_BALL)));

        // Gunpowder Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GUNPOWDER, 3)
                .pattern("SPC").define('C', Items.CHARCOAL)
                .define('P', FabricItemTags.SALTPETER_DUSTS)
                .define('S', FabricItemTags.SULFUR_DUSTS)
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER.get()), has(ItemRegistry.MATERIAL_DUST_SALTPETER.get()))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(Items.GUNPOWDER)));
    }
}
