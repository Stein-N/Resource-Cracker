package net.xstopho.resource_cracker.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class WaterSpringBlock extends Block {
    public WaterSpringBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        ItemStack handStack = player.getItemInHand(hand);

        if (handStack.getItem() == Items.BUCKET && !player.isCreative()) {
            ItemStack newStack = new ItemStack(Items.WATER_BUCKET);
            if (handStack.getCount() == 1) {
                player.setItemInHand(hand, newStack);
                return InteractionResult.SUCCESS;
            }
            if (player.getInventory().add(newStack)) {
                handStack.shrink(1);
                return InteractionResult.SUCCESS;
            } else {
                player.drop(newStack, false);
                handStack.shrink(1);
                return InteractionResult.SUCCESS;
            }
        }
        if (handStack.getItem() == Items.GLASS_BOTTLE && !player.isCreative()) {
            ItemStack stack = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
            if (handStack.getCount() == 1) {
                player.setItemInHand(hand, stack);
                return InteractionResult.SUCCESS;

            }
            if (player.getInventory().add(stack)) {
                handStack.shrink(1);
                return InteractionResult.SUCCESS;
            } else {
                player.drop(stack, false);
                handStack.shrink(1);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
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
