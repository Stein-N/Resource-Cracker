package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.function.Consumer;

public class RecipeProv extends FabricRecipeProvider {
    private static Consumer<FinishedRecipe> exporter;

    public RecipeProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        RecipeProv.exporter = exporter;

        /*  Crack Hammers */
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_COPPER, Items.COPPER_INGOT);
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_GOLD, Items.GOLD_INGOT);
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_IRON, Items.IRON_INGOT);
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_DIAMOND, Items.DIAMOND);
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_NETHERITE, Items.NETHERITE_INGOT);
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_STEEL, ItemRegistry.STEEL_INGOT);

        /*  Chisel  */
        offerChiselRecipe(ItemRegistry.CHISEL_COPPER, Items.COPPER_INGOT);
        offerChiselRecipe(ItemRegistry.CHISEL_GOLD, Items.GOLD_INGOT);
        offerChiselRecipe(ItemRegistry.CHISEL_IRON, Items.IRON_INGOT);
        offerChiselRecipe(ItemRegistry.CHISEL_DIAMOND, Items.DIAMOND);
        offerChiselRecipe(ItemRegistry.CHISEL_NETHERITE, Items.NETHERITE_INGOT);
        offerChiselRecipe(ItemRegistry.CHISEL_STEEL, ItemRegistry.STEEL_INGOT);

        /* Scythe */
        offerScytheRecipe(ItemRegistry.SCYTHE_COPPER, Items.COPPER_INGOT);
        offerScytheRecipe(ItemRegistry.SCYTHE_IRON, Items.IRON_INGOT);
        offerScytheRecipe(ItemRegistry.SCYTHE_GOLD, Items.GOLD_INGOT);
        offerScytheRecipe(ItemRegistry.SCYTHE_STEEL, ItemRegistry.STEEL_INGOT);
        offerScytheRecipe(ItemRegistry.SCYTHE_DIAMOND, Items.DIAMOND);
        netheriteSmithing(exporter, ItemRegistry.SCYTHE_DIAMOND, RecipeCategory.MISC, ItemRegistry.SCYTHE_NETHERITE);

        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_CARBON, Items.CHARCOAL, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_COPPER, Items.RAW_COPPER, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_IRON, Items.RAW_IRON, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_GOLD, Items.RAW_GOLD, 2);

        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_COPPER, Items.COPPER_INGOT, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_IRON, Items.IRON_INGOT, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_GOLD, Items.GOLD_INGOT, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_STEEL, ItemRegistry.STEEL_INGOT, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_DIAMOND, Items.DIAMOND, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_NETHERITE, Items.NETHERITE_INGOT, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_EMERALD, Items.EMERALD, 1);

        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_DIAMOND, Items.DIAMOND_ORE, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_DIAMOND, Items.DEEPSLATE_DIAMOND_ORE, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_EMERALD, Items.EMERALD_ORE, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_EMERALD, Items.DEEPSLATE_EMERALD_ORE, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, Items.ANCIENT_DEBRIS, 2);

        createSpringRecipe(BlockRegistry.WATER_SPRING_BLOCK, Items.WATER_BUCKET);
        createSpringRecipe(BlockRegistry.LAVA_SPRING_BLOCK, Items.LAVA_BUCKET);

        // Netherite Dust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_NETHERITE, 1)
                .pattern("AAA").pattern("AGG").pattern("GG ")
                .define('A', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c:netherite_scrap_dusts"))))
                .define('G', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c:gold_dusts"))))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP), has(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_GOLD), has(ItemRegistry.MATERIAL_DUST_GOLD))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_NETHERITE)));

        // Steeldust Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MATERIAL_DUST_STEEL, 2)
                .pattern("II").pattern("SS")
                .define('I', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c:iron_dusts"))))
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c:coal_dusts"))))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_IRON), has(ItemRegistry.MATERIAL_DUST_IRON))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_CARBON), has(ItemRegistry.MATERIAL_DUST_CARBON))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(ItemRegistry.MATERIAL_DUST_STEEL)));

        // Slimeball Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SLIME_BALL, 3)
                .pattern("HGS")
                .define('H', Items.HONEYCOMB)
                .define('G', Items.GREEN_DYE)
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c:saltpeter_dusts"))))
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER), has(ItemRegistry.MATERIAL_DUST_SALTPETER))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(Items.SLIME_BALL)));

        // Gunpowder Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GUNPOWDER, 3)
                .pattern("SPC").define('C', Items.CHARCOAL)
                .define('P', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c:saltpeter_dusts"))))
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c:sulfur_dusts"))))
                .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SALTPETER), has(ItemRegistry.MATERIAL_DUST_SALTPETER))
                .unlockedBy(getHasName(ItemRegistry.MATERIAL_DUST_SULFUR), has(ItemRegistry.MATERIAL_DUST_SULFUR))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(Items.GUNPOWDER)));

        // Diamond Compression Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DIAMOND, 1)
                .pattern("NNN").pattern("NNN").pattern("NNN")
                .define('N', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c:diamond_nuggets"))))
                .unlockedBy(getHasName(ItemRegistry.DIAMOND_NUGGET), has(ItemRegistry.DIAMOND_NUGGET))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(Items.DIAMOND)));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.STEEL_BLOCK, 1)
                .pattern("NNN").pattern("NNN").pattern("NNN")
                .define('N', ItemRegistry.STEEL_INGOT)
                .unlockedBy(getHasName(ItemRegistry.STEEL_INGOT), has(ItemRegistry.STEEL_INGOT))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(BlockRegistry.STEEL_BLOCK) + "_from_" + getSimpleRecipeName(ItemRegistry.STEEL_INGOT)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.STEEL_INGOT, 9)
                .requires(BlockRegistry.STEEL_BLOCK).unlockedBy(getHasName(BlockRegistry.STEEL_BLOCK), has(BlockRegistry.STEEL_BLOCK))
                .save(exporter, new ResourceLocation("crafting/" + getSimpleRecipeName(ItemRegistry.STEEL_INGOT) + "_from_" + getSimpleRecipeName(BlockRegistry.STEEL_BLOCK)));

        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_COPPER, Items.COPPER_INGOT, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_IRON, Items.IRON_INGOT, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_GOLD, Items.GOLD_INGOT, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_DIAMOND, Items.DIAMOND, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_EMERALD, Items.EMERALD, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, Items.NETHERITE_SCRAP, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_STEEL, ItemRegistry.STEEL_INGOT, true, false, true);
        createProcessingRecipes(ItemRegistry.GARLIC, ItemRegistry.MATERIAL_DUST_SULFUR, true, false, true);
        createProcessingRecipes(Items.ROTTEN_FLESH, Items.LEATHER, true, false, true);

        createBlastingRecipe(ItemRegistry.MATERIAL_DUST_NETHERITE, Items.NETHERITE_INGOT);
        createSmokingRecipe(Items.ROTTEN_FLESH, ItemRegistry.BEEF_JERKY);
    }

    private static void offerCrackHammerRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" IT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', Ingredient.of(ItemTagProv.CRAFT_INGREDIENTS))
                .define('S', Items.STICK)
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, new ResourceLocation("tools/crack_hammer/" + getSimpleRecipeName(output)));
    }

    private static void offerChiselRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" I")
                .pattern("S ")
                .define('I', input)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, new ResourceLocation("tools/chisel/" + getSimpleRecipeName(output)));
    }

    private static void offerScytheRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("IIT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', Ingredient.of(ItemTagProv.CRAFT_INGREDIENTS))
                .define('S', Items.STICK)
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, new ResourceLocation("tools/scythe/" + getSimpleRecipeName(output)));
    }

    private static void createSpringRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1)
                .pattern("SSS").pattern("SBS").pattern("SSS")
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "steel_blocks"))))
                .define('B', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, new ResourceLocation("blocks/" + getSimpleRecipeName(output)));
    }

    private static void offerMaterialDustRecipe(ItemLike output, ItemLike input, int outputAmount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputAmount)
                .requires(Ingredient.of(ItemTagProv.CRACK_HAMMER))
                .requires(input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, new ResourceLocation("material_dusts/" + getSimpleRecipeName(output) + "_from_" + getSimpleRecipeName(input)));
    }

    private static void createProcessingRecipes(ItemLike input, ItemLike output, boolean smeltingBlasting, boolean smoking, boolean campfire) {
        if (smeltingBlasting) createSmeltingRecipe(input, output); createBlastingRecipe(input, output);
        if (smoking) createSmokingRecipe(input, output);
        if (campfire) createCampfireRecipe(input, output);

    }

    private static void createSmeltingRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 200)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, new ResourceLocation("smelting/" + getSimpleRecipeName(output)));
    }

    private static void createBlastingRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 100)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, new ResourceLocation("blasting/" + getSimpleRecipeName(output)));
    }

    private static void createSmokingRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 150)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, new ResourceLocation("smoking/" + getSimpleRecipeName(output)));
    }

    private static void createCampfireRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 600)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, new ResourceLocation("campfire/" + getSimpleRecipeName(output)));
    }
}
