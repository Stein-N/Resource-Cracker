package net.xstopho.resource_cracker.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.block.LavaSpringBlock;
import net.xstopho.resource_cracker.block.WaterSpringBlock;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop", () -> new GarlicCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final RegistryObject<Block> STEEL_BLOCK = register("steel_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> LAVA_SPRING_BLOCK = register("lava_spring_block", () -> new LavaSpringBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> WATER_SPRING_BLOCK = register("water_spring_block", () -> new WaterSpringBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static <T extends Block> RegistryObject<T> register(String id, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(id, block);
        ItemRegistry.ITEMS.register(id, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
