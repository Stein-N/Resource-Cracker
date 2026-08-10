package net.morthen.resource_cracker.item.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CrackerItemTags {

    // General Tags
    public static final TagKey<Item> DUSTS = createTag("dusts");
    public static final TagKey<Item> NUGGETS = createTag("nuggets");
    public static final TagKey<Item> INGOTS = createTag("ingots");
    public static final TagKey<Item> FOODS = createTag("foods");
    public static final TagKey<Item> TOOLS = createTag("tools");
    public static final TagKey<Item> ENCHANTABLES = createTag("enchantables");

    // Mod specific Tags
    public static final TagKey<Item> CRACK_HAMMER = createTag("tool/crack_hammer");
    public static final TagKey<Item> CHISEL = createTag("tool/chisel");
    public static final TagKey<Item> SCYTHE = createTag("tool/scythe");
    public static final TagKey<Item> CRACK_HAMMER_INGREDIENTS = createTag("tool/crack_hammer/crafting_ingredients");
    public static final TagKey<Item> SCYTHE_INGREDIENTS = createTag("tool/scythe/crafting_ingredients");

    public static final TagKey<Item> COAL_DUSTS = createTag("dust/coal");
    public static final TagKey<Item> CARBON_DUSTS = createTag("dust/carbon");
    public static final TagKey<Item> COPPER_DUSTS = createTag("dust/copper");
    public static final TagKey<Item> IRON_DUSTS = createTag("dust/iron");

    public static final TagKey<Item> GOLD_DUSTS = createTag("dust/gold");
    public static final TagKey<Item> DIAMOND_DUSTS = createTag("dust/diamond");
    public static final TagKey<Item> EMERALD_DUSTS = createTag("dust/emerald");
    public static final TagKey<Item> SULFUR_DUSTS = createTag("dust/sulfur");

    public static final TagKey<Item> SALTPETER_DUSTS = createTag("dust/saltpeter");
    public static final TagKey<Item> STEEL_DUSTS = createTag("dust/steel");
    public static final TagKey<Item> NETHERITE_SCRAP_DUSTS = createTag("dust/netherite_scrap");
    public static final TagKey<Item> NETHERITE_DUSTS = createTag("dust/netherite");

    public static final TagKey<Item> DIAMOND_NUGGETS = createTag("nugget/diamond");
    public static final TagKey<Item> EMERALD_NUGGETS = createTag("nugget/emerald");
    public static final TagKey<Item> STEEL_INGOTS = createTag("ingots/steel");
    public static final TagKey<Item> COPPER_INGOTS = createTag("ingots/copper");

    public static final TagKey<Item> STEEL_BLOCKS = createTag("block/steel");
    public static final TagKey<Item> GARLIC = createTag("food/garlic");
    public static final TagKey<Item> BEEF_JERKY = createTag("food/beef_jerky");
    public static final TagKey<Item> LEATHER = createTag("leather");
    public static final TagKey<Item> STRING = createTag("string");

    public static final TagKey<Item> STEEL_TOOL_MATERIALS = createTag("steel_tool_materials");
    public static final TagKey<Item> COPPER_TOOL_MATERIALS = createTag("copper_tool_materials");

    public static TagKey<Item> createTag(String id) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", id));
    }
}
