package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagProv extends ItemTagsProvider {


    public ItemTagProv(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ForgeItemTags.CRACK_HAMMER)
                .add(ItemRegistry.CRACK_HAMMER_COPPER.get(), ItemRegistry.CRACK_HAMMER_GOLD.get(), ItemRegistry.CRACK_HAMMER_IRON.get(),
                        ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get(), ItemRegistry.CRACK_HAMMER_NETHERITE.get());

        this.tag(ForgeItemTags.CHISEL)
                .add(ItemRegistry.CHISEL_COPPER.get(), ItemRegistry.CHISEL_GOLD.get(), ItemRegistry.CHISEL_IRON.get(),
                        ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.CHISEL_DIAMOND.get(), ItemRegistry.CHISEL_NETHERITE.get());

        this.tag(ForgeItemTags.SCYTHE)
                .add(ItemRegistry.SCYTHE_COPPER.get(), ItemRegistry.SCYTHE_GOLD.get(), ItemRegistry.SCYTHE_IRON.get(),
                        ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.SCYTHE_DIAMOND.get(), ItemRegistry.SCYTHE_NETHERITE.get());

        this.tag(ForgeItemTags.CRAFTING_INGREDINTS)
                .add(Items.STRING, Items.LEATHER, Items.RABBIT_HIDE);

        this.tag(ForgeItemTags.COAL_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        this.tag(ForgeItemTags.CARBON_DUSTS).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        this.tag(ForgeItemTags.COPPER_DUSTS).add(ItemRegistry.MATERIAL_DUST_COPPER.get());
        this.tag(ForgeItemTags.IRON_DUSTS).add(ItemRegistry.MATERIAL_DUST_IRON.get());

        this.tag(ForgeItemTags.GOLD_DUSTS).add(ItemRegistry.MATERIAL_DUST_GOLD.get());
        this.tag(ForgeItemTags.DIAMOND_DUSTS).add(ItemRegistry.MATERIAL_DUST_DIAMOND.get());
        this.tag(ForgeItemTags.EMERALD_DUSTS).add(ItemRegistry.MATERIAL_DUST_EMERALD.get());
        this.tag(ForgeItemTags.SULFUR_DUSTS).add(ItemRegistry.MATERIAL_DUST_SULFUR.get());

        this.tag(ForgeItemTags.SALTPETER_DUSTS).add(ItemRegistry.MATERIAL_DUST_SALTPETER.get());
        this.tag(ForgeItemTags.STEEL_DUSTS).add(ItemRegistry.MATERIAL_DUST_STEEL.get());
        this.tag(ForgeItemTags.NETHERITE_SCRAP_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get());
        this.tag(ForgeItemTags.NETHERITE_DUSTS).add(ItemRegistry.MATERIAL_DUST_NETHERITE.get());

        this.tag(ForgeItemTags.DIAMOND_NUGGETS).add(ItemRegistry.NUGGET_DIAMOND.get());
        this.tag(ForgeItemTags.STEEL_INGOTS).add(ItemRegistry.STEEL_INGOT.get());
        this.tag(ForgeItemTags.STEEL_BLOCKS).add(BlockRegistry.STEEL_BLOCK.get().asItem());
    }
}
