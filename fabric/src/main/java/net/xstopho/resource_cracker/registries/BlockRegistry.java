package net.xstopho.resource_cracker.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.block.LavaSpringBlock;
import net.xstopho.resource_cracker.block.WaterSpringBlock;

public class BlockRegistry {

    public static final Block GARLIC_CROP = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, "garlic_crop"), new GarlicCropBlock());

    public static final Block STEEL_BLOCK = register("steel_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block LAVA_SPRING_BLOCK = register("lava_spring_block", new LavaSpringBlock());
    public static final Block WATER_SPRING_BLOCK = register("water_spring_block", new WaterSpringBlock());

    private static Block register(String id, Block block) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, id), new BlockItem(block, new Item.Properties()));
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, id), block);
    }

    public static void init() {

    }
}
