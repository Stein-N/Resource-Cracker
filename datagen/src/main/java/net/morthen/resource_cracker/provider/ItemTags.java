package net.morthen.resource_cracker.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.references.ItemIds;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.morthen.resource_cracker.CrackerConstants;
import net.morthen.resource_cracker.item.tags.CrackerItemTags;
import net.morthen.resource_cracker.registries.ItemRegistry;
import net.morthen.resourcelibrary.registration.RegistryObject;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture) {
        super(output, lookupProvider, CrackerConstants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.addAll(CrackerItemTags.CRACK_HAMMER,
                List.of(ItemRegistry.CRACK_HAMMER_COPPER,
                        ItemRegistry.CRACK_HAMMER_GOLD,
                        ItemRegistry.CRACK_HAMMER_IRON,
                        ItemRegistry.CRACK_HAMMER_STEEL,
                        ItemRegistry.CRACK_HAMMER_DIAMOND,
                        ItemRegistry.CRACK_HAMMER_NETHERITE));

        this.addAll(CrackerItemTags.CHISEL,
                List.of(ItemRegistry.CHISEL_COPPER,
                        ItemRegistry.CHISEL_GOLD,
                        ItemRegistry.CHISEL_IRON,
                        ItemRegistry.CHISEL_STEEL,
                        ItemRegistry.CHISEL_DIAMOND,
                        ItemRegistry.CHISEL_NETHERITE));
        
        this.addAll(CrackerItemTags.SCYTHE,
                List.of(ItemRegistry.SCYTHE_COPPER,
                        ItemRegistry.SCYTHE_GOLD,
                        ItemRegistry.SCYTHE_IRON,
                        ItemRegistry.SCYTHE_STEEL,
                        ItemRegistry.SCYTHE_DIAMOND,
                        ItemRegistry.SCYTHE_NETHERITE));

        this.tag(CrackerItemTags.CRACK_HAMMER_INGREDIENTS)
                .addTag(CrackerItemTags.LEATHER);

        this.tag(CrackerItemTags.SCYTHE_INGREDIENTS)
                .addTag(CrackerItemTags.LEATHER);

        this.addAll(net.minecraft.tags.ItemTags.SWORDS,
                List.of(ItemRegistry.SCYTHE_COPPER,
                        ItemRegistry.SCYTHE_GOLD,
                        ItemRegistry.SCYTHE_IRON,
                        ItemRegistry.SCYTHE_STEEL,
                        ItemRegistry.SCYTHE_DIAMOND,
                        ItemRegistry.SCYTHE_NETHERITE));

        this.addAll(net.minecraft.tags.ItemTags.SHARP_WEAPON_ENCHANTABLE,
                List.of(ItemRegistry.SCYTHE_COPPER,
                        ItemRegistry.SCYTHE_GOLD,
                        ItemRegistry.SCYTHE_IRON,
                        ItemRegistry.SCYTHE_STEEL,
                        ItemRegistry.SCYTHE_DIAMOND,
                        ItemRegistry.SCYTHE_NETHERITE));

        this.add(CrackerItemTags.COAL_DUSTS, ItemRegistry.MATERIAL_DUST_CARBON);
        this.add(CrackerItemTags.CARBON_DUSTS, ItemRegistry.MATERIAL_DUST_CARBON);
        this.add(CrackerItemTags.COPPER_DUSTS, ItemRegistry.MATERIAL_DUST_COPPER);
        this.add(CrackerItemTags.IRON_DUSTS, ItemRegistry.MATERIAL_DUST_IRON);

        this.add(CrackerItemTags.GOLD_DUSTS, ItemRegistry.MATERIAL_DUST_GOLD);
        this.add(CrackerItemTags.DIAMOND_DUSTS, ItemRegistry.MATERIAL_DUST_DIAMOND);
        this.add(CrackerItemTags.EMERALD_DUSTS, ItemRegistry.MATERIAL_DUST_EMERALD);
        this.add(CrackerItemTags.SULFUR_DUSTS, ItemRegistry.MATERIAL_DUST_SULFUR);

        this.add(CrackerItemTags.SALTPETER_DUSTS, ItemRegistry.MATERIAL_DUST_SALTPETER);
        this.add(CrackerItemTags.STEEL_DUSTS, ItemRegistry.MATERIAL_DUST_STEEL);
        this.add(CrackerItemTags.NETHERITE_SCRAP_DUSTS, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP);
        this.add(CrackerItemTags.NETHERITE_DUSTS, ItemRegistry.MATERIAL_DUST_NETHERITE);

        this.add(CrackerItemTags.DIAMOND_NUGGETS, ItemRegistry.NUGGET_DIAMOND);
        this.add(CrackerItemTags.EMERALD_NUGGETS, ItemRegistry.NUGGET_EMERALD);
        this.add(CrackerItemTags.STEEL_INGOTS, ItemRegistry.STEEL_INGOT);

        this.tag(CrackerItemTags.LEATHER).addAll(List.of(ItemIds.LEATHER, ItemIds.RABBIT_HIDE));

        this.tag(CrackerItemTags.COPPER_TOOL_MATERIALS).add(ItemIds.COPPER_INGOT);
        this.add(CrackerItemTags.STEEL_TOOL_MATERIALS, ItemRegistry.STEEL_INGOT);

        this.tag(CrackerItemTags.DUSTS)
                .addTag(CrackerItemTags.COAL_DUSTS)
                .addTag(CrackerItemTags.CARBON_DUSTS)
                .addTag(CrackerItemTags.COPPER_DUSTS)
                .addTag(CrackerItemTags.IRON_DUSTS)
                .addTag(CrackerItemTags.GOLD_DUSTS)
                .addTag(CrackerItemTags.DIAMOND_DUSTS)
                .addTag(CrackerItemTags.EMERALD_DUSTS)
                .addTag(CrackerItemTags.SULFUR_DUSTS)
                .addTag(CrackerItemTags.SALTPETER_DUSTS)
                .addTag(CrackerItemTags.STEEL_DUSTS)
                .addTag(CrackerItemTags.NETHERITE_SCRAP_DUSTS)
                .addTag(CrackerItemTags.NETHERITE_DUSTS);

        this.tag(CrackerItemTags.NUGGETS)
                .addTag(CrackerItemTags.DIAMOND_NUGGETS)
                .addTag(CrackerItemTags.EMERALD_NUGGETS);

        this.add(CrackerItemTags.INGOTS, ItemRegistry.STEEL_INGOT);
        this.add(CrackerItemTags.GARLIC, ItemRegistry.GARLIC);
        this.add(CrackerItemTags.BEEF_JERKY, ItemRegistry.BEEF_JERKY);
        this.addAll(CrackerItemTags.FOODS, List.of(ItemRegistry.GARLIC, ItemRegistry.BEEF_JERKY));

        this.tag(CrackerItemTags.TOOLS)
                .addTag(CrackerItemTags.CRACK_HAMMER)
                .addTag(CrackerItemTags.CHISEL)
                .addTag(CrackerItemTags.SCYTHE);

        this.tag(CrackerItemTags.ENCHANTABLES).addTag(CrackerItemTags.SCYTHE);

        this.tag(net.minecraft.tags.ItemTags.WEAPON_ENCHANTABLE).addTag(CrackerItemTags.SCYTHE);
        this.tag(net.minecraft.tags.ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(CrackerItemTags.SCYTHE);

        this.add(net.minecraft.tags.ItemTags.VILLAGER_PLANTABLE_SEEDS, ItemRegistry.GARLIC);

        this.tag(net.minecraft.tags.ItemTags.BREAKS_DECORATED_POTS)
                .addTag(CrackerItemTags.SCYTHE)
                .addTag(CrackerItemTags.CHISEL)
                .addTag(CrackerItemTags.CRACK_HAMMER);
    }

    private void add(TagKey<Item> key, RegistryObject<Item> block) {
        Identifier id = block.getId();
        this.tag(key).add(ResourceKey.create(Registries.ITEM, id));
    }

    private void addAll(TagKey<Item> key, List<RegistryObject<Item>> items) {
        items.forEach(item -> this.add(key, item));
    }
}
