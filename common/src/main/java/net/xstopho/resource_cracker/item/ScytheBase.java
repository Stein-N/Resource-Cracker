package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ScytheBase extends SwordItem {
    public ScytheBase(Tier toolTier, int attackDamage, float attackSpeed) {
        super(toolTier, attackDamage, attackSpeed, new Properties());
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        assert context.getPlayer() != null;
        Player player = context.getPlayer();

        if (player.isSpectator() || player.isCreative()) {
            return InteractionResult.PASS;
        }

        BlockPos clickedPos = context.getClickedPos();
        BlockState clickedState = context.getLevel().getBlockState(clickedPos);

        if (clickedState.getBlock() instanceof CropBlock clickedCrop && clickedCrop.isMaxAge(clickedState)) {
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos crop = clickedPos.offset(x, 0, z);
                    BlockState cropState = context.getLevel().getBlockState(crop);
                    if (cropState.getBlock() instanceof CropBlock replantCrop && replantCrop.isMaxAge(cropState)) {
                        context.getLevel().destroyBlock(crop, true, player);
                        context.getLevel().setBlockAndUpdate(crop, replantCrop.getStateForAge(0));
                    }
                }
            }
            context.getItemInHand().hurtAndBreak(1, player, playerEntity -> playerEntity.getItemInHand(player.getUsedItemHand()));
            return InteractionResult.SUCCESS;
        }

        return  InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item.scythe.tooltip"));
        tooltip.add(Component.translatable("item.scythe.tooltip.radius").append(String.valueOf(1)).withStyle(ChatFormatting.RED));

        super.appendHoverText(stack, world, tooltip, flag);
    }
}
