package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.recipes.Recipes;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.function.Consumer;

public class RecipeGen extends RecipeProvider implements IConditionBuilder {

    public RecipeGen(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> exporter) {

        /*  Crack Hammers */
        Recipes.offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_COPPER.get(), Items.COPPER_INGOT, ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_GOLD.get(), Items.GOLD_INGOT, ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_IRON.get(), Items.IRON_INGOT, ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_DIAMOND.get(), Items.DIAMOND, ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerNetheriteUpgrade(exporter, ItemRegistry.CRACK_HAMMER_NETHERITE.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get());

        /*  Chisel  */
        Recipes.offerChiselRecipe(exporter, ItemRegistry.CHISEL_COPPER.get(), Items.COPPER_INGOT);
        Recipes.offerChiselRecipe(exporter, ItemRegistry.CHISEL_GOLD.get(), Items.GOLD_INGOT);
        Recipes.offerChiselRecipe(exporter, ItemRegistry.CHISEL_IRON.get(), Items.IRON_INGOT);
        Recipes.offerChiselRecipe(exporter, ItemRegistry.CHISEL_DIAMOND.get(), Items.DIAMOND);
        Recipes.offerChiselRecipe(exporter, ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        Recipes.offerNetheriteUpgrade(exporter, ItemRegistry.CHISEL_NETHERITE.get(), ItemRegistry.CHISEL_DIAMOND.get());

        /* Scythe */
        Recipes.offerScytheRecipe(exporter, ItemRegistry.SCYTHE_COPPER.get(), Items.COPPER_INGOT, ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerScytheRecipe(exporter, ItemRegistry.SCYTHE_IRON.get(), Items.IRON_INGOT, ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerScytheRecipe(exporter, ItemRegistry.SCYTHE_GOLD.get(), Items.GOLD_INGOT, ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerScytheRecipe(exporter, ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerScytheRecipe(exporter, ItemRegistry.SCYTHE_DIAMOND.get(), Items.DIAMOND, ItemTagGen.CRAFT_INGREDIENTS);
        Recipes.offerNetheriteUpgrade(exporter, ItemRegistry.SCYTHE_NETHERITE.get(), ItemRegistry.SCYTHE_DIAMOND.get());

        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_CARBON.get(), Items.CHARCOAL, 2, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.RAW_COPPER, 2, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.RAW_IRON, 2, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.RAW_GOLD, 2, ItemTagGen.CRACK_HAMMER);

        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, 1, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, 1, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, 1, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), 1, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, 1, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT, 1, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, 1, ItemTagGen.CRACK_HAMMER);

        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND_ORE, 2, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DEEPSLATE_DIAMOND_ORE, 2, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD_ORE, 2, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.DEEPSLATE_EMERALD_ORE, 2, ItemTagGen.CRACK_HAMMER);
        Recipes.offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.ANCIENT_DEBRIS, 2, ItemTagGen.CRACK_HAMMER);

        Recipes.createSpringRecipe(exporter, BlockRegistry.WATER_SPRING_BLOCK.get(), Items.WATER_BUCKET);
        Recipes.createSpringRecipe(exporter, BlockRegistry.LAVA_SPRING_BLOCK.get(), Items.LAVA_BUCKET);

        Recipes.createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, true, false, true);
        Recipes.createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, true, false, true);
        Recipes.createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, true, false, true);
        Recipes.createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, true, false, true);
        Recipes.createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, true, false, true);
        Recipes.createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.NETHERITE_SCRAP, true, false, true);
        Recipes.createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), true, false, true);
        Recipes.createProcessingRecipes(exporter, ItemRegistry.GARLIC.get(), ItemRegistry.MATERIAL_DUST_SULFUR.get(), true, false, true);
        Recipes.createProcessingRecipes(exporter, Items.ROTTEN_FLESH, Items.LEATHER, true, false, true);

        Recipes.createBlastingRecipe(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT);
        Recipes.createSmokingRecipe(exporter, Items.ROTTEN_FLESH, ItemRegistry.BEEF_JERKY.get());

        // Netherite Dust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), 1)
                .pattern("AAA").pattern("AGG").pattern("GG ")
                .define('A', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/netherite_scrap"))))
                .define('G', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/gold"))))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get()), has(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get()))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_GOLD.get()), has(ItemRegistry.MATERIAL_DUST_GOLD.get()))
                .save(exporter, location("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_NETHERITE.get())));

        // Steeldust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_STEEL.get(), 2)
                .pattern("II").pattern("SS")
                .define('I', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/iron"))))
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/coal"))))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_IRON.get()), has(ItemRegistry.MATERIAL_DUST_IRON.get()))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_CARBON.get()), has(ItemRegistry.MATERIAL_DUST_CARBON.get()))
                .save(exporter, location("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_STEEL.get())));

        // Slimeball Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SLIME_BALL, 3)
                .pattern("HGS")
                .define('H', Items.HONEYCOMB)
                .define('G', Items.GREEN_DYE)
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/saltpeter"))))
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER.get()), has(ItemRegistry.MATERIAL_DUST_SALTPETER.get()))
                .save(exporter, location("crafting/" + getSimpleRecipeName(Items.SLIME_BALL)));

        // Gunpowder Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GUNPOWDER, 3)
                .pattern("SPC").define('C', Items.CHARCOAL)
                .define('P', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/saltpeter"))))
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/sulfur"))))
                .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER.get()), has(ItemRegistry.MATERIAL_DUST_SALTPETER.get()))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SULFUR.get()), has(ItemRegistry.MATERIAL_DUST_SULFUR.get()))
                .save(exporter, location("crafting/" + getSimpleRecipeName(Items.GUNPOWDER)));

        // Diamond Compression Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DIAMOND, 1)
                .pattern("NNN").pattern("NNN").pattern("NNN")
                .define('N', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "nuggets/diamond"))))
                .unlockedBy(getHasName(ItemRegistry.DIAMOND_NUGGET.get()), has(ItemRegistry.DIAMOND_NUGGET.get()))
                .save(exporter, location("crafting/" + getSimpleRecipeName(Items.DIAMOND)));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.STEEL_BLOCK.get(), 1)
                .pattern("NNN").pattern("NNN").pattern("NNN")
                .define('N',  ItemRegistry.STEEL_INGOT.get())
                .unlockedBy(getHasName(ItemRegistry.STEEL_INGOT.get()), has(ItemRegistry.STEEL_INGOT.get()))
                .save(exporter, location("crafting/" + getSimpleRecipeName(BlockRegistry.STEEL_BLOCK.get()) + "_from_" + getSimpleRecipeName(ItemRegistry.STEEL_INGOT.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.STEEL_INGOT.get(), 9)
                .requires(BlockRegistry.STEEL_BLOCK.get())
                .unlockedBy(getHasName(BlockRegistry.STEEL_BLOCK.get()), has(BlockRegistry.STEEL_BLOCK.get()))
                .save(exporter, location("crafting/" + getSimpleRecipeName(ItemRegistry.STEEL_INGOT.get()) + "_from_" + getSimpleRecipeName(BlockRegistry.STEEL_BLOCK.get())));
    }

    private static ResourceLocation location(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }
}
