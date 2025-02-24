package net.xstopho.resource_cracker.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class GarlicCropBlock extends CropBlock {
    public final MapCodec<GarlicCropBlock> CODEC = simpleCodec(GarlicCropBlock::new);
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    public final int MAX_AGE = 5;


    public GarlicCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemRegistry.GARLIC.get();
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public MapCodec<? extends CropBlock> codec() {
        return CODEC;
    }
}
