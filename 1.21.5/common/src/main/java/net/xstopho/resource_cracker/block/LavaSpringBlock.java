package net.xstopho.resource_cracker.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.xstopho.resource_cracker.block.base.SpringBlock;

public class LavaSpringBlock extends SpringBlock {
    public static final MapCodec<LavaSpringBlock> CODEC = simpleCodec(LavaSpringBlock::new);

    public LavaSpringBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item itemInHand = player.getItemInHand(hand).getItem();

        if (itemInHand == Items.BUCKET && !player.isCreative()) return addOrDropItem(player, new ItemStack(Items.LAVA_BUCKET));

        return InteractionResult.PASS;
    }
}
