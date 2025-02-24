package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.block.LavaSpringBlock;
import net.xstopho.resource_cracker.block.WaterSpringBlock;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

import java.util.function.Function;

public class BlockRegistry {

    public static final RegistryProvider<Block> BLOCKS = RegistryProvider.get(CrackerConstants.MOD_ID, BuiltInRegistries.BLOCK);

    public static final RegistryObject<Block> GARLIC_CROP = registerWithoutItem("garlic_crop", GarlicCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES));

    public static final RegistryObject<Block> WATER_SPRING_BLOCK = register("water_spring_block", WaterSpringBlock::new);

    public static final RegistryObject<Block> LAVA_SPRING_BLOCK = register("lava_spring_block", LavaSpringBlock::new);

    public static final RegistryObject<Block> STEEL_BLOCK = register("steel_block", Block::new);


    private static RegistryObject<Block> register(String id, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties blockBehavior) {
        RegistryObject<Block> toReturn = BLOCKS.register(id, () -> function.apply(blockBehavior.setId(createKey(id))));

        ItemRegistry.register(id, properties -> new BlockItem(toReturn.get(), properties));
        return toReturn;
    }

    private static RegistryObject<Block> registerWithoutItem(String id, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties blockBehavior) {
        return BLOCKS.register(id, () -> function.apply(blockBehavior.setId(createKey(id))));
    }

    private static RegistryObject<Block> register(String id, Function<BlockBehaviour.Properties, Block> function) {
        return register(id, function, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    }

    private static ResourceKey<Block> createKey(String id) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BLOCKS.getModId(), id));
    }

    public static void init() {}
}
