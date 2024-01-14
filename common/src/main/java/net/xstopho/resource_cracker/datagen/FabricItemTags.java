package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class FabricItemTags {

    public static final TagKey<Item> CRACK_HAMMER = getTagKey("crack_hammer");
    public static final TagKey<Item> CHISEL = getTagKey("chisel");
    public static final TagKey<Item> SCYTHE = getTagKey("scythe");
    public static final TagKey<Item> CRAFTING_INGREDINTS = getTagKey("crafting_ingredients");

    public static final TagKey<Item> COAL_DUSTS = getTagKey("coal_dusts");
    public static final TagKey<Item> CARBON_DUSTS = getTagKey("carbon_dusts");
    public static final TagKey<Item> COPPER_DUSTS = getTagKey("copper_dusts");
    public static final TagKey<Item> IRON_DUSTS = getTagKey("iron_dusts");

    public static final TagKey<Item> GOLD_DUSTS = getTagKey("gold_dusts");
    public static final TagKey<Item> DIAMOND_DUSTS = getTagKey("diamond_dusts");
    public static final TagKey<Item> EMERALD_DUSTS = getTagKey("emerald_dusts");
    public static final TagKey<Item> SULFUR_DUSTS = getTagKey("sulfur_dusts");

    public static final TagKey<Item> SALTPETER_DUSTS = getTagKey("saltpeter_dusts");
    public static final TagKey<Item> STEEL_DUSTS = getTagKey("steel_dusts");
    public static final TagKey<Item> NETHERITE_SCRAP_DUSTS = getTagKey("netherite_scrap_dusts");
    public static final TagKey<Item> NETHERITE_DUSTS = getTagKey("netherite_dusts");

    public static final TagKey<Item> DIAMOND_NUGGETS = getTagKey("diamond_nuggets");
    public static final TagKey<Item> STEEL_INGOTS = getTagKey("steel_ingots");
    public static final TagKey<Item> STEEL_BLOCKS = getTagKey("steel_blocks");

    private static TagKey<Item> getTagKey(String id) {
        return TagKey.create(Registries.ITEM, location(id));
    }

    private static ResourceLocation location(String id) {
        return new ResourceLocation("c", id);
    }
}
