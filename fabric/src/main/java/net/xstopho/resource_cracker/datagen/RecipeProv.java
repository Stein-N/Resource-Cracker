package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class RecipeProv extends FabricRecipeProvider {

    public RecipeProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {

        /*  Crack Hammers */
        offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_COPPER, Items.COPPER_INGOT, ItemTagProv.CRAFT_INGREDIENTS);
        offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_GOLD, Items.GOLD_INGOT, ItemTagProv.CRAFT_INGREDIENTS);
        offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_IRON, Items.IRON_INGOT, ItemTagProv.CRAFT_INGREDIENTS);
        offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_DIAMOND, Items.DIAMOND, ItemTagProv.CRAFT_INGREDIENTS);
        offerCrackHammerRecipe(exporter, ItemRegistry.CRACK_HAMMER_STEEL, ItemRegistry.STEEL_INGOT, ItemTagProv.CRAFT_INGREDIENTS);
        offerNetheriteUpgrade(exporter, ItemRegistry.CRACK_HAMMER_NETHERITE, ItemRegistry.CRACK_HAMMER_DIAMOND);

        /*  Chisel  */
        offerChiselRecipe(exporter, ItemRegistry.CHISEL_COPPER, Items.COPPER_INGOT);
        offerChiselRecipe(exporter, ItemRegistry.CHISEL_GOLD, Items.GOLD_INGOT);
        offerChiselRecipe(exporter, ItemRegistry.CHISEL_IRON, Items.IRON_INGOT);
        offerChiselRecipe(exporter, ItemRegistry.CHISEL_DIAMOND, Items.DIAMOND);
        offerChiselRecipe(exporter, ItemRegistry.CHISEL_STEEL, ItemRegistry.STEEL_INGOT);
        offerNetheriteUpgrade(exporter, ItemRegistry.CHISEL_NETHERITE, ItemRegistry.CHISEL_DIAMOND);

        /* Scythe */
        offerScytheRecipe(exporter, ItemRegistry.SCYTHE_COPPER, Items.COPPER_INGOT, ItemTagProv.CRAFT_INGREDIENTS);
        offerScytheRecipe(exporter, ItemRegistry.SCYTHE_IRON, Items.IRON_INGOT, ItemTagProv.CRAFT_INGREDIENTS);
        offerScytheRecipe(exporter, ItemRegistry.SCYTHE_GOLD, Items.GOLD_INGOT, ItemTagProv.CRAFT_INGREDIENTS);
        offerScytheRecipe(exporter, ItemRegistry.SCYTHE_STEEL, ItemRegistry.STEEL_INGOT, ItemTagProv.CRAFT_INGREDIENTS);
        offerScytheRecipe(exporter, ItemRegistry.SCYTHE_DIAMOND, Items.DIAMOND, ItemTagProv.CRAFT_INGREDIENTS);
        offerNetheriteUpgrade(exporter, ItemRegistry.SCYTHE_NETHERITE, ItemRegistry.SCYTHE_DIAMOND);

        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_CARBON, Items.CHARCOAL, 2, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_COPPER, Items.RAW_COPPER, 2, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_IRON, Items.RAW_IRON, 2, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_GOLD, Items.RAW_GOLD, 2, ItemTagProv.CRACK_HAMMER);

        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_COPPER, Items.COPPER_INGOT, 1, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_IRON, Items.IRON_INGOT, 1, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_GOLD, Items.GOLD_INGOT, 1, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_STEEL, ItemRegistry.STEEL_INGOT, 1, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND, Items.DIAMOND, 1, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE, Items.NETHERITE_INGOT, 1, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_EMERALD, Items.EMERALD, 1, ItemTagProv.CRACK_HAMMER);

        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND, Items.DIAMOND_ORE, 2, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND, Items.DEEPSLATE_DIAMOND_ORE, 2, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_EMERALD, Items.EMERALD_ORE, 2, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_EMERALD, Items.DEEPSLATE_EMERALD_ORE, 2, ItemTagProv.CRACK_HAMMER);
        offerMaterialDustRecipe(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, Items.ANCIENT_DEBRIS, 2, ItemTagProv.CRACK_HAMMER);

        createSpringRecipe(exporter, BlockRegistry.WATER_SPRING_BLOCK, Items.WATER_BUCKET);
        createSpringRecipe(exporter, BlockRegistry.LAVA_SPRING_BLOCK, Items.LAVA_BUCKET);

        createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_COPPER, Items.COPPER_INGOT, true, false, true);
        createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_IRON, Items.IRON_INGOT, true, false, true);
        createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_GOLD, Items.GOLD_INGOT, true, false, true);
        createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_DIAMOND, Items.DIAMOND, true, false, true);
        createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_EMERALD, Items.EMERALD, true, false, true);
        createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP, Items.NETHERITE_SCRAP, true, false, true);
        createProcessingRecipes(exporter, ItemRegistry.MATERIAL_DUST_STEEL, ItemRegistry.STEEL_INGOT, true, false, true);
        createProcessingRecipes(exporter, ItemRegistry.GARLIC, ItemRegistry.MATERIAL_DUST_SULFUR, true, false, true);
        createProcessingRecipes(exporter, Items.ROTTEN_FLESH, Items.LEATHER, true, false, true);

        createBlastingRecipe(exporter, ItemRegistry.MATERIAL_DUST_NETHERITE, Items.NETHERITE_INGOT);
        createSmokingRecipe(exporter, Items.ROTTEN_FLESH, ItemRegistry.BEEF_JERKY);

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
    }

    public static void offerCrackHammerRecipe(RecipeOutput exporter, ItemLike output, ItemLike input, TagKey<Item> ingredients) {
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

    public static void offerChiselRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" I")
                .pattern("S ")
                .define('S', Items.STICK)
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/chisel/" + getSimpleRecipeName(output)));
    }

    public static void offerScytheRecipe(RecipeOutput exporter, ItemLike output, ItemLike input, TagKey<Item> ingredients) {
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

    public static void offerNetheriteUpgrade(RecipeOutput exporter, Item output, ItemLike input) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(input),
                        Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, output)
                .unlocks(getHasName(input), has(input))
                .save(exporter, location("smithing/" + getSimpleRecipeName(output)));
    }

    public static void createSpringRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1)
                .pattern("SSS").pattern("SBS").pattern("SSS")
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "steel_blocks"))))
                .define('B', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blocks/" + getSimpleRecipeName(output)));
    }

    public static void offerMaterialDustRecipe(RecipeOutput exporter, ItemLike output, ItemLike input, int outputAmount, TagKey<Item> crackHammer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputAmount)
                .requires(Ingredient.of(crackHammer))
                .requires(input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("material_dusts/" + getSimpleRecipeName(output) + "_from_" + getSimpleRecipeName(input)));
    }

    public static void createProcessingRecipes(RecipeOutput exporter, ItemLike input, ItemLike output, boolean smeltingBlasting, boolean smoking, boolean campfire) {
        if (smeltingBlasting) createSmeltingRecipe(exporter, input, output); createBlastingRecipe(exporter, input, output);
        if (smoking) createSmokingRecipe(exporter, input, output);
        if (campfire) createCampfireRecipe(exporter, input, output);

    }

    public static void createSmeltingRecipe(RecipeOutput exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 200)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smelting/" + getSimpleRecipeName(output)));
    }

    public static void createBlastingRecipe(RecipeOutput exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 100)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blasting/" + getSimpleRecipeName(output)));
    }

    public static void createSmokingRecipe(RecipeOutput exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 150)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smoking/" + getSimpleRecipeName(output)));
    }

    public static void createCampfireRecipe(RecipeOutput exporter, ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 600)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("campfire/" + getSimpleRecipeName(output)));
    }

    private static ResourceLocation location(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }
}
