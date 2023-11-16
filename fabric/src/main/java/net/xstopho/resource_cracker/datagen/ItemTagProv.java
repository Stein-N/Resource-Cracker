package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.xstopho.resource_cracker.registries.ItemRegistry;

import java.util.concurrent.CompletableFuture;

public class ItemTagProv extends FabricTagProvider.ItemTagProvider {

    public static final TagKey<Item> CRACK_HAMMER = TagKey.create(Registries.ITEM, new ResourceLocation("c", "crack_hammers"));
    public static final TagKey<Item> CRAFT_INGREDIENTS = TagKey.create(Registries.ITEM, new ResourceLocation("c", "craft_ingredients"));
    public static final TagKey<Item> CHISEL = TagKey.create(Registries.ITEM, new ResourceLocation("c", "chisels"));
    public static final TagKey<Item> SCYTHE = TagKey.create(Registries.ITEM, new ResourceLocation("c", "scythes"));

    public ItemTagProv(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(CRACK_HAMMER)
                .add(ItemRegistry.CRACK_HAMMER_COPPER, ItemRegistry.CRACK_HAMMER_IRON, ItemRegistry.CRACK_HAMMER_GOLD,
                        ItemRegistry.CRACK_HAMMER_DIAMOND, ItemRegistry.CRACK_HAMMER_NETHERITE, ItemRegistry.CRACK_HAMMER_STEEL);

        getOrCreateTagBuilder(CHISEL)
                .add(ItemRegistry.CHISEL_COPPER, ItemRegistry.CHISEL_GOLD, ItemRegistry.CHISEL_IRON,
                        ItemRegistry.CHISEL_DIAMOND, ItemRegistry.CHISEL_NETHERITE, ItemRegistry.CHISEL_STEEL);

        getOrCreateTagBuilder(SCYTHE)
                .add(ItemRegistry.SCYTHE_COPPER, ItemRegistry.SCYTHE_IRON, ItemRegistry.SCYTHE_GOLD,
                        ItemRegistry.SCYTHE_STEEL, ItemRegistry.SCYTHE_DIAMOND, ItemRegistry.SCYTHE_NETHERITE);

        getOrCreateTagBuilder(CRAFT_INGREDIENTS)
                .add(Items.LEATHER, Items.STRING, Items.RABBIT_HIDE);

        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "coal_dusts"))).add(ItemRegistry.MATERIAL_DUST_CARBON);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "carbon_dusts"))).add(ItemRegistry.MATERIAL_DUST_CARBON);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "copper_dusts"))).add(ItemRegistry.MATERIAL_DUST_COPPER);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "iron_dusts"))).add(ItemRegistry.MATERIAL_DUST_IRON);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "gold_dusts"))).add(ItemRegistry.MATERIAL_DUST_GOLD);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "diamond_dusts"))).add(ItemRegistry.MATERIAL_DUST_DIAMOND);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "diamond_nuggets"))).add(ItemRegistry.DIAMOND_NUGGET);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "emerald_dusts"))).add(ItemRegistry.MATERIAL_DUST_EMERALD);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "sulfur_dusts"))).add(ItemRegistry.MATERIAL_DUST_SULFUR);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "saltpeter_dusts"))).add(ItemRegistry.MATERIAL_DUST_SALTPETER);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "steel_dusts"))).add(ItemRegistry.MATERIAL_DUST_STEEL);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "steel_ingots"))).add(ItemRegistry.STEEL_INGOT);
        //getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, new ResourceLocation("c", "steel_blocks"))).add(BlockRegistry.STEEL_BLOCK.asItem());
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "netherite_scrap_dusts"))).add(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP);
        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, new ResourceLocation("c", "netherite_dusts"))).add(ItemRegistry.MATERIAL_DUST_NETHERITE);
    }
}
