package net.xstopho.resource_cracker.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.block.LavaSpringBlock;
import net.xstopho.resource_cracker.block.WaterSpringBlock;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);

    public static final DeferredHolder<Block, Block> GARLIC_CROP = BLOCKS.register("garlic_crop", () -> new GarlicCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final DeferredHolder<Block, Block> STEEL_BLOCK = register("steel_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final DeferredHolder<Block, Block> LAVA_SPRING_BLOCK = register("lava_spring_block", () -> new LavaSpringBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final DeferredHolder<Block, Block> WATER_SPRING_BLOCK = register("water_spring_block", () -> new WaterSpringBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static DeferredHolder<Block, Block> register(String id, Supplier<Block> supplier) {
        DeferredHolder<Block, Block> block = BLOCKS.register(id, supplier);
        ItemRegistry.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
