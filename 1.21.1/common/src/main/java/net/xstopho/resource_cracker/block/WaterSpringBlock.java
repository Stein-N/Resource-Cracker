package net.xstopho.resource_cracker.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.xstopho.resource_cracker.block.base.SpringBlock;

public class WaterSpringBlock extends SpringBlock {
    public static final MapCodec<WaterSpringBlock> CODEC = simpleCodec(WaterSpringBlock::new);

    public WaterSpringBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item itemInHand = player.getItemInHand(hand).getItem();

        if (itemInHand == Items.BUCKET && !player.isCreative()) return addOrDropItem(player, new ItemStack(Items.WATER_BUCKET));
        if (itemInHand == Items.GLASS_BOTTLE && !player.isCreative()) return addOrDropItem(player, PotionContents.createItemStack(Items.POTION, Potions.WATER));

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
