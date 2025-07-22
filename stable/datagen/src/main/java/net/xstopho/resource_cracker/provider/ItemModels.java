package net.xstopho.resource_cracker.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.datagen.ResourceItemModelProvider;

public class ItemModels extends ResourceItemModelProvider {
    public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrackerConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemRegistry.CRACK_HAMMER_COPPER.get());
        simpleItem(ItemRegistry.CRACK_HAMMER_GOLD.get());
        simpleItem(ItemRegistry.CRACK_HAMMER_IRON.get());
        simpleItem(ItemRegistry.CRACK_HAMMER_DIAMOND.get());
        simpleItem(ItemRegistry.CRACK_HAMMER_NETHERITE.get());
        simpleItem(ItemRegistry.CRACK_HAMMER_STEEL.get());

        simpleItem(ItemRegistry.CHISEL_COPPER.get());
        simpleItem(ItemRegistry.CHISEL_GOLD.get());
        simpleItem(ItemRegistry.CHISEL_IRON.get());
        simpleItem(ItemRegistry.CHISEL_DIAMOND.get());
        simpleItem(ItemRegistry.CHISEL_NETHERITE.get());
        simpleItem(ItemRegistry.CHISEL_STEEL.get());

        simpleItem(ItemRegistry.SCYTHE_COPPER.get());
        simpleItem(ItemRegistry.SCYTHE_GOLD.get());
        simpleItem(ItemRegistry.SCYTHE_IRON.get());
        simpleItem(ItemRegistry.SCYTHE_DIAMOND.get());
        simpleItem(ItemRegistry.SCYTHE_NETHERITE.get());
        simpleItem(ItemRegistry.SCYTHE_STEEL.get());

        simpleItem(ItemRegistry.MATERIAL_DUST_COPPER.get());
        simpleItem(ItemRegistry.MATERIAL_DUST_IRON.get());
        simpleItem(ItemRegistry.MATERIAL_DUST_GOLD.get());
        simpleItem(ItemRegistry.MATERIAL_DUST_DIAMOND.get());
        simpleItem(ItemRegistry.MATERIAL_DUST_STEEL.get());
        simpleItem(ItemRegistry.MATERIAL_DUST_CARBON.get());

        simpleItem(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get());
        simpleItem(ItemRegistry.MATERIAL_DUST_NETHERITE.get());
        simpleItem(ItemRegistry.MATERIAL_DUST_EMERALD.get());
        simpleItem(ItemRegistry.MATERIAL_DUST_SALTPETER.get());
        simpleItem(ItemRegistry.MATERIAL_DUST_SULFUR.get());

        simpleItem(ItemRegistry.STEEL_INGOT.get());
        simpleItem(ItemRegistry.NUGGET_COPPER.get());
        simpleItem(ItemRegistry.NUGGET_DIAMOND.get());
        simpleItem(ItemRegistry.NUGGET_EMERALD.get());

        simpleItem(ItemRegistry.BEEF_JERKY.get());
        simpleItem(ItemRegistry.GARLIC.get());

        itemWithParentBlock("lava_spring_block");
        itemWithParentBlock("water_spring_block");

        inHandModel(ItemRegistry.SCYTHE_COPPER.get());
        inHandModel(ItemRegistry.SCYTHE_GOLD.get());
        inHandModel(ItemRegistry.SCYTHE_IRON.get());
        inHandModel(ItemRegistry.SCYTHE_STEEL.get());
        inHandModel(ItemRegistry.SCYTHE_DIAMOND.get());
        inHandModel(ItemRegistry.SCYTHE_NETHERITE.get());
    }

    private void itemWithParentBlock(String id) {
        withExistingParent(id, ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "block/" + id));
    }

    void inHandModel(Item item) {
        createInHandItem(item, ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "item/in_hand/handheld_large"));
    }
}
