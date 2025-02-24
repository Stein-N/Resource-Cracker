package net.xstopho.resource_cracker.provider;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class ItemModels extends ItemModelProvider {

    private static final ResourceLocation PARENT = ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "item/in_hand/handheld_large");

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

        itemWithParentBlock(BlockRegistry.LAVA_SPRING_BLOCK.get());
        itemWithParentBlock(BlockRegistry.WATER_SPRING_BLOCK.get());

        createInHandItem(ItemRegistry.SCYTHE_COPPER.get());
        createInHandItem(ItemRegistry.SCYTHE_GOLD.get());
        createInHandItem(ItemRegistry.SCYTHE_IRON.get());
        createInHandItem(ItemRegistry.SCYTHE_STEEL.get());
        createInHandItem(ItemRegistry.SCYTHE_DIAMOND.get());
        createInHandItem(ItemRegistry.SCYTHE_NETHERITE.get());
    }

    public void itemWithParentBlock(Block block) {
        ResourceLocation location = BuiltInRegistries.BLOCK.getKey(block);
        withExistingParent(location.getPath(), location.withPrefix("block/"));
    }

    public void simpleItem(Item item) {
        ResourceLocation key = getItemKey(item);
        withExistingParent(getItemKey(item).getPath(), ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(key.getNamespace(), "item/" + key.getPath()));
    }

    public void createInHandItem(Item item) {
        this.getBuilder(modifyItemKey(item).toString())
                .parent(new ModelFile.UncheckedModelFile(PARENT))
                .texture("layer0", modifyItemKey(item));
    }

    private ResourceLocation modifyItemKey(Item item) {
        ResourceLocation key = getItemKey(item);
        return key.withPrefix("item/in_hand/");
    }

    private ResourceLocation getItemKey(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
