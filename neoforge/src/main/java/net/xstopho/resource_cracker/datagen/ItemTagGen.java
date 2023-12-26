package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class ItemTagGen extends ItemTagsProvider {
    private static final HashMap<String, TagKey<Item>> KEYS = new HashMap<>();

    public static final TagKey<Item> CRACK_HAMMER = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/crack_hammers"));
    public static final TagKey<Item> CRAFT_INGREDIENTS = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/craft_ingredients"));
    public static final TagKey<Item> CHISEL = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/chisels"));
    public static final TagKey<Item> SCYTHE = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/scythes"));
    public static final TagKey<Item> DUSTS = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts"));

    public ItemTagGen(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                      CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(CRAFT_INGREDIENTS)
                .add(Items.LEATHER, Items.RABBIT_HIDE, Items.STRING);

        this.tag(CRACK_HAMMER)
                .add(ItemRegistry.CRACK_HAMMER_COPPER.get(), ItemRegistry.CRACK_HAMMER_GOLD.get(), ItemRegistry.CRACK_HAMMER_IRON.get(),
                        ItemRegistry.CRACK_HAMMER_STEEL.get(), ItemRegistry.CRACK_HAMMER_DIAMOND.get(), ItemRegistry.CRACK_HAMMER_NETHERITE.get());

        this.tag(CHISEL)
                .add(ItemRegistry.CHISEL_COPPER.get(), ItemRegistry.CHISEL_GOLD.get(), ItemRegistry.CHISEL_IRON.get(),
                        ItemRegistry.CHISEL_STEEL.get(), ItemRegistry.CHISEL_DIAMOND.get(), ItemRegistry.CHISEL_NETHERITE.get());

        this.tag(SCYTHE)
                .add(ItemRegistry.SCYTHE_COPPER.get(), ItemRegistry.SCYTHE_GOLD.get(), ItemRegistry.SCYTHE_IRON.get(),
                        ItemRegistry.SCYTHE_STEEL.get(), ItemRegistry.SCYTHE_DIAMOND.get(), ItemRegistry.SCYTHE_DIAMOND.get());

        this.tag(create("dusts/coal")).add(ItemRegistry.MATERIAL_DUST_CARBON.get(), ItemRegistry.MATERIAL_DUST_CARBON.get());
        this.tag(create("dusts/carbon")).add(ItemRegistry.MATERIAL_DUST_CARBON.get());
        this.tag(create("dusts/copper")).add(ItemRegistry.MATERIAL_DUST_COPPER.get());
        this.tag(create("dusts/iron")).add(ItemRegistry.MATERIAL_DUST_IRON.get());
        this.tag(create("dusts/gold")).add(ItemRegistry.MATERIAL_DUST_GOLD.get());
        this.tag(create("dusts/diamond")).add(ItemRegistry.MATERIAL_DUST_DIAMOND.get());
        this.tag(create("dusts/emerald")).add(ItemRegistry.MATERIAL_DUST_EMERALD.get());
        this.tag(create("dusts/sulfur")).add(ItemRegistry.MATERIAL_DUST_SULFUR.get());
        this.tag(create("dusts/saltpeter")).add(ItemRegistry.MATERIAL_DUST_SALTPETER.get());
        this.tag(create("dusts/steel")).add(ItemRegistry.MATERIAL_DUST_STEEL.get());
        this.tag(create("dusts/netherite_scrap")).add(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get());
        this.tag(create("dusts/netherite")).add(ItemRegistry.MATERIAL_DUST_NETHERITE.get());

        for (TagKey<Item> key : KEYS.values()) {
            this.tag(DUSTS).addTags(key);
        }

        this.tag(createOther("nuggets/diamond")).add(ItemRegistry.DIAMOND_NUGGET.get());
        this.tag(createOther("nuggets")).addTags(createOther("nuggets/diamond"));

        this.tag(createOther("blocks/steel")).add(BlockRegistry.STEEL_BLOCK.get().asItem());
        this.tag(createOther("ingots/steel")).add(ItemRegistry.STEEL_INGOT.get());

    }

    private static TagKey<Item> create(String id) {
        TagKey<Item> key = TagKey.create(Registries.ITEM, new ResourceLocation("forge", id));
        KEYS.put(id, key);
        return key;
    }

    private static TagKey<Item> createOther(String id) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("forge", id));
    }
}
