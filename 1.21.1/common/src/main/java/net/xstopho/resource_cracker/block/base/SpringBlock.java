package net.xstopho.resource_cracker.block.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.Nullable;

public class SpringBlock extends Block {
    public static final MapCodec<SpringBlock> CODEC = simpleCodec(SpringBlock::new);

    public SpringBlock(Properties properties) {
        super(properties);
    }

    public static ItemInteractionResult addOrDropItem(Player player, ItemStack stack) {
        ItemStack handStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (handStack.getCount() == 1) {
            player.setItemInHand(InteractionHand.MAIN_HAND, stack);
            return ItemInteractionResult.SUCCESS;
        }
        if (!player.getInventory().add(stack)) player.drop(stack, false);
        handStack.shrink(1);
        return ItemInteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(BlockStateProperties.HORIZONTAL_FACING, rotation.rotate(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }
}
