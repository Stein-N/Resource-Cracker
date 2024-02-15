package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ForgeItemTags {

    public static final TagKey<Item> CRACK_HAMMER = getTagKey("tools/crack_hammers");
    public static final TagKey<Item> CHISEL = getTagKey("tools/chisel");
    public static final TagKey<Item> SCYTHE = getTagKey("tools/scythe");
    public static final TagKey<Item> CRAFTING_INGREDIENTS = getTagKey("tools/crafting_ingredients");

    public static final TagKey<Item> COAL_DUSTS = getTagKey("dusts/coal");
    public static final TagKey<Item> CARBON_DUSTS = getTagKey("dusts/carbon");
    public static final TagKey<Item> COPPER_DUSTS = getTagKey("dusts/copper");
    public static final TagKey<Item> IRON_DUSTS = getTagKey("dusts/iron");

    public static final TagKey<Item> GOLD_DUSTS = getTagKey("dusts/gold");
    public static final TagKey<Item> DIAMOND_DUSTS = getTagKey("dusts/diamond");
    public static final TagKey<Item> EMERALD_DUSTS = getTagKey("dusts/emerald");
    public static final TagKey<Item> SULFUR_DUSTS = getTagKey("dusts/sulfur");

    public static final TagKey<Item> SALTPETER_DUSTS = getTagKey("dusts/saltpeter");
    public static final TagKey<Item> STEEL_DUSTS = getTagKey("dusts/steel");
    public static final TagKey<Item> NETHERITE_SCRAP_DUSTS = getTagKey("dusts/netherite_scrap");
    public static final TagKey<Item> NETHERITE_DUSTS = getTagKey("dusts/netherite");

    public static final TagKey<Item> DIAMOND_NUGGETS = getTagKey("nuggets/diamond");
    public static final TagKey<Item> EMERALD_NUGGETS = getTagKey("nuggets/emerald");
    public static final TagKey<Item> COPPER_NUGGETS = getTagKey("nuggets/copper");
    public static final TagKey<Item> STEEL_INGOTS = getTagKey("ingots/steel");

    public static final TagKey<Item> STEEL_BLOCKS = getTagKey("blocks/steel");

    private static TagKey<Item> getTagKey(String id) {
        return TagKey.create(Registries.ITEM, location(id));
    }

    private static ResourceLocation location(String id) {
        return new ResourceLocation("forge", id);
    }
}
