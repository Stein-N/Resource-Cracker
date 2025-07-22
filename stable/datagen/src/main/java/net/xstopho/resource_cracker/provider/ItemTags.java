package net.xstopho.resource_cracker.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.helper.CrackerItemTags;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper fileHelper) {
        super(output, lookupProvider, blockTags, CrackerConstants.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(CrackerItemTags.CRACK_HAMMER).add(
                ItemRegistry.CRACK_HAMMER_COPPER.get(),
                ItemRegistry.CRACK_HAMMER_GOLD.get(),
                ItemRegistry.CRACK_HAMMER_IRON.get(),
                ItemRegistry.CRACK_HAMMER_STEEL.get(),
                ItemRegistry.CRACK_HAMMER_DIAMOND.get(),
                ItemRegistry.CRACK_HAMMER_NETHERITE.get());

        this.tag(CrackerItemTags.CHISEL).add(
                ItemRegistry.CHISEL_COPPER.get(),
                ItemRegistry.CHISEL_GOLD.get(),
                ItemRegistry.CHISEL_IRON.get(),
                ItemRegistry.CHISEL_STEEL.get(),
                ItemRegistry.CHISEL_DIAMOND.get(),
                ItemRegistry.CHISEL_NETHERITE.get());

        this.tag(CrackerItemTags.SCYTHE).add(
                ItemRegistry.SCYTHE_COPPER.get(),
                ItemRegistry.SCYTHE_GOLD.get(),
                ItemRegistry.SCYTHE_IRON.get(),
                ItemRegistry.SCYTHE_STEEL.get(),
                ItemRegistry.SCYTHE_DIAMOND.get(),
                ItemRegistry.SCYTHE_NETHERITE.get());

        this.tag(CrackerItemTags.CRACK_HAMMER_INGREDIENTS)
                .addTag(CrackerItemTags.LEATHER)
                .addTag(CrackerItemTags.STRING);

        this.tag(CrackerItemTags.SCYTHE_INGREDIENTS)
                .addTag(CrackerItemTags.LEATHER);

        this.tag(net.minecraft.tags.ItemTags.SWORDS).add(
                ItemRegistry.SCYTHE_COPPER.get(),
                ItemRegistry.SCYTHE_GOLD.get(),
                ItemRegistry.SCYTHE_IRON.get(),
                ItemRegistry.SCYTHE_STEEL.get(),
                ItemRegistry.SCYTHE_DIAMOND.get(),
                ItemRegistry.SCYTHE_NETHERITE.get());

        this.tag(net.minecraft.tags.ItemTags.SWORD_ENCHANTABLE).add(
                ItemRegistry.SCYTHE_COPPER.get(),
                ItemRegistry.SCYTHE_GOLD.get(),
                ItemRegistry.SCYTHE_IRON.get(),
                ItemRegistry.SCYTHE_STEEL.get(),
                ItemRegistry.SCYTHE_DIAMOND.get(),
                ItemRegistry.SCYTHE_NETHERITE.get());

        this.tag(CrackerItemTags.COAL_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        this.tag(CrackerItemTags.CARBON_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        this.tag(CrackerItemTags.COPPER_DUSTS).add(ItemRegistry.MATERIAL_DUST_COPPER.get());
        this.tag(CrackerItemTags.IRON_DUSTS).add(ItemRegistry.MATERIAL_DUST_IRON.get());

        this.tag(CrackerItemTags.GOLD_DUSTS).add(ItemRegistry.MATERIAL_DUST_GOLD.get());
        this.tag(CrackerItemTags.DIAMOND_DUSTS).add(ItemRegistry.MATERIAL_DUST_DIAMOND.get());
        this.tag(CrackerItemTags.EMERALD_DUSTS).add(ItemRegistry.MATERIAL_DUST_EMERALD.get());
        this.tag(CrackerItemTags.SULFUR_DUSTS).add(ItemRegistry.MATERIAL_DUST_SULFUR.get());

        this.tag(CrackerItemTags.SALTPETER_DUSTS).add(ItemRegistry.MATERIAL_DUST_SALTPETER.get());
        this.tag(CrackerItemTags.STEEL_DUSTS).add(ItemRegistry.MATERIAL_DUST_STEEL.get());
        this.tag(CrackerItemTags.NETHERITE_SCRAP_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get());
        this.tag(CrackerItemTags.NETHERITE_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE.get());

        this.tag(CrackerItemTags.DIAMOND_NUGGETS).add(ItemRegistry.NUGGET_DIAMOND.get());
        this.tag(CrackerItemTags.EMERALD_NUGGETS).add(ItemRegistry.NUGGET_EMERALD.get());
        this.tag(CrackerItemTags.COPPER_NUGGETS).add(ItemRegistry.NUGGET_COPPER.get());
        this.tag(CrackerItemTags.STEEL_INGOTS).add(ItemRegistry.STEEL_INGOT.get());

        this.tag(CrackerItemTags.COPPER_INGOTS).add(Items.COPPER_INGOT);
        this.tag(CrackerItemTags.STEEL_BLOCKS).add(BlockRegistry.STEEL_BLOCK.get().asItem());
        this.tag(CrackerItemTags.LEATHER).add(Items.LEATHER, Items.RABBIT_HIDE);
        this.tag(CrackerItemTags.STRING).add(Items.STRING);

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
                .addTag(CrackerItemTags.EMERALD_NUGGETS)
                .addTag(CrackerItemTags.COPPER_NUGGETS);

        this.tag(CrackerItemTags.INGOTS).add(ItemRegistry.STEEL_INGOT.get());
        this.tag(CrackerItemTags.GARLIC).add(ItemRegistry.GARLIC.get());
        this.tag(CrackerItemTags.BEEF_JERKY).add(ItemRegistry.BEEF_JERKY.get());
        this.tag(CrackerItemTags.FOODS).add(ItemRegistry.GARLIC.get(), ItemRegistry.BEEF_JERKY.get());

        this.tag(CrackerItemTags.TOOLS)
                .addTag(CrackerItemTags.CRACK_HAMMER)
                .addTag(CrackerItemTags.CHISEL)
                .addTag(CrackerItemTags.SCYTHE);

        this.tag(CrackerItemTags.ENCHANTABLES).addTag(CrackerItemTags.SCYTHE);

        this.tag(net.minecraft.tags.ItemTags.WEAPON_ENCHANTABLE).addTag(CrackerItemTags.SCYTHE);
        this.tag(net.minecraft.tags.ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(CrackerItemTags.SCYTHE);

        this.tag(net.minecraft.tags.ItemTags.VILLAGER_PLANTABLE_SEEDS).add(ItemRegistry.GARLIC.get());

        this.tag(net.minecraft.tags.ItemTags.BREAKS_DECORATED_POTS)
                .addTag(CrackerItemTags.SCYTHE)
                .addTag(CrackerItemTags.CHISEL)
                .addTag(CrackerItemTags.CRACK_HAMMER);
    }
}
