package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.function.Consumer;

public class RecipeGen extends RecipeProvider implements IConditionBuilder {

    private static Consumer<FinishedRecipe> exporter;

    public RecipeGen(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> exporter) {
        RecipeGen.exporter = exporter;

        /*  Crack Hammers */
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_COPPER.get(), Items.COPPER_INGOT);
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_GOLD.get(), Items.GOLD_INGOT);
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_IRON.get(), Items.IRON_INGOT);
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_DIAMOND.get(), Items.DIAMOND);
        offerCrackHammerRecipe(ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        offerNetheriteUpgrade(ItemRegistry.CRACK_HAMMER_NETHERITE.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get());

        /*  Chisel  */
        offerChiselRecipe(ItemRegistry.CHISEL_COPPER.get(), Items.COPPER_INGOT);
        offerChiselRecipe(ItemRegistry.CHISEL_GOLD.get(), Items.GOLD_INGOT);
        offerChiselRecipe(ItemRegistry.CHISEL_IRON.get(), Items.IRON_INGOT);
        offerChiselRecipe(ItemRegistry.CHISEL_DIAMOND.get(), Items.DIAMOND);
        offerChiselRecipe(ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        offerNetheriteUpgrade(ItemRegistry.CHISEL_NETHERITE.get(), ItemRegistry.CHISEL_DIAMOND.get());

        /* Scythe */
        offerScytheRecipe(ItemRegistry.SCYTHE_COPPER.get(), Items.COPPER_INGOT);
        offerScytheRecipe(ItemRegistry.SCYTHE_IRON.get(), Items.IRON_INGOT);
        offerScytheRecipe(ItemRegistry.SCYTHE_GOLD.get(), Items.GOLD_INGOT);
        offerScytheRecipe(ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.STEEL_INGOT.get());
        offerScytheRecipe(ItemRegistry.SCYTHE_DIAMOND.get(), Items.DIAMOND);
        offerNetheriteUpgrade(ItemRegistry.SCYTHE_NETHERITE.get(), ItemRegistry.SCYTHE_DIAMOND.get());

        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_CARBON.get(), Items.CHARCOAL, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.RAW_COPPER, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_IRON.get(), Items.RAW_IRON, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.RAW_GOLD, 2);

        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT, 1);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, 1);

        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND_ORE, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DEEPSLATE_DIAMOND_ORE, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD_ORE, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.DEEPSLATE_EMERALD_ORE, 2);
        offerMaterialDustRecipe(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.ANCIENT_DEBRIS, 2);

        createSpringRecipe(BlockRegistry.WATER_SPRING_BLOCK.get(), Items.WATER_BUCKET);
        createSpringRecipe(BlockRegistry.LAVA_SPRING_BLOCK.get(), Items.LAVA_BUCKET);

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
                .requires(BlockRegistry.STEEL_BLOCK.get()).unlockedBy(getHasName(BlockRegistry.STEEL_BLOCK.get()), has(BlockRegistry.STEEL_BLOCK.get()))
                .save(exporter, location("crafting/" + getSimpleRecipeName(ItemRegistry.STEEL_INGOT.get()) + "_from_" + getSimpleRecipeName(BlockRegistry.STEEL_BLOCK.get())));

        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_COPPER.get(), Items.COPPER_INGOT, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_IRON.get(), Items.IRON_INGOT, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_GOLD.get(), Items.GOLD_INGOT, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_DIAMOND.get(), Items.DIAMOND, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_EMERALD.get(), Items.EMERALD, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), Items.NETHERITE_SCRAP, true, false, true);
        createProcessingRecipes(ItemRegistry.MATERIAL_DUST_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), true, false, true);
        createProcessingRecipes(ItemRegistry.GARLIC.get(), ItemRegistry.MATERIAL_DUST_SULFUR.get(), true, false, true);
        createProcessingRecipes(Items.ROTTEN_FLESH, Items.LEATHER, true, false, true);

        createBlastingRecipe(ItemRegistry.MATERIAL_DUST_NETHERITE.get(), Items.NETHERITE_INGOT);
        createSmokingRecipe(Items.ROTTEN_FLESH, ItemRegistry.BEEF_JERKY.get());
    }

    private static void offerCrackHammerRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" IT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', Ingredient.of(ItemTagGen.CRAFT_INGREDIENTS))
                .define('S', Items.STICK)
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/crack_hammer/" + getSimpleRecipeName(output)));
    }

    private static void offerChiselRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern(" I")
                .pattern("S ")
                .define('S', Items.STICK)
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/chisel/" + getSimpleRecipeName(output)));
    }

    private static void offerScytheRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("IIT")
                .pattern(" SI")
                .pattern("S  ")
                .define('T', Ingredient.of(ItemTagGen.CRAFT_INGREDIENTS))
                .define('S', Items.STICK)
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("tools/scythe/" + getSimpleRecipeName(output)));
    }

    private static void offerNetheriteUpgrade(Item output, ItemLike input) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(input),
                Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, output)
                .unlocks(getHasName(input), has(input))
                .save(exporter, location("smithing/" + getSimpleRecipeName(output)));
    }

    private static void createSpringRecipe(ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1)
                .pattern("SSS").pattern("SBS").pattern("SSS")
                .define('S', Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "blocks/steel"))))
                .define('B', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blocks/" + getSimpleRecipeName(output)));
    }

    private static void offerMaterialDustRecipe(ItemLike output, ItemLike input, int outputAmount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputAmount)
                .requires(Ingredient.of(ItemTagGen.CRACK_HAMMER))
                .requires(input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("material_dusts/" + getSimpleRecipeName(output) + "_from_" + getSimpleRecipeName(input)));
    }

    private static void createProcessingRecipes(ItemLike input, ItemLike output, boolean smeltingBlasting, boolean smoking, boolean campfire) {
        if (smeltingBlasting) createSmeltingRecipe(input, output); createBlastingRecipe(input, output);
        if (smoking) createSmokingRecipe(input, output);
        if (campfire) createCampfireRecipe(input, output);

    }

    private static void createSmeltingRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 200)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smelting/" + getSimpleRecipeName(output)));
    }

    private static void createBlastingRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 100)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("blasting/" + getSimpleRecipeName(output)));
    }

    private static void createSmokingRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 150)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("smoking/" + getSimpleRecipeName(output)));
    }

    private static void createCampfireRecipe(ItemLike input, ItemLike output) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, output, 0.7f, 600)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, location("campfire/" + getSimpleRecipeName(output)));
    }

    private static ResourceLocation location(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }
}
