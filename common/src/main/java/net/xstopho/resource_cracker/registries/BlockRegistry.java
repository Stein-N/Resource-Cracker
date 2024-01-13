package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.block.LavaSpringBlock;
import net.xstopho.resource_cracker.block.WaterSpringBlock;
import net.xstopho.stophoslib.registration.RegistryObject;
import net.xstopho.stophoslib.registration.RegistryProvider;

import java.util.function.Supplier;

public class BlockRegistry {

    private static final RegistryProvider<Block> BLOCKS = RegistryProvider.get(Registries.BLOCK, Constants.MOD_ID);

    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop", GarlicCropBlock::new);

    public static final RegistryObject<Block> LAVA_SPRING_BLOCK = register("lava_spring_block", LavaSpringBlock::new);
    public static final RegistryObject<Block> WATER_SPRING_BLOCK = register("water_spring_block", WaterSpringBlock::new);
    public static final RegistryObject<Block> STEEL_BLOCK = register("steel_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    private static RegistryObject<Block> register(String id, Supplier<Block> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(id, block);
        ItemRegistry.ITEMS.register(id, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static void init() {}
}
