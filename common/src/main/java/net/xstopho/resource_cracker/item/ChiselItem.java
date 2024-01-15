package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.Config;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class ChiselItem extends Item {

    private static final Random rnd = new Random();
    private static Item drop;

    public ChiselItem(int durability, Item drop) {
        super(new Properties().durability(durability));
        ChiselItem.drop = drop;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        assert context.getPlayer() != null;
        Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());

        if (block == Blocks.BRICKS) {
            if (rnd.nextFloat() <= Config.SALTPETER_FROM_BRICKS.get().floatValue()) {
                Containers.dropItemStack(context.getLevel(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(drop));
            }
        }
        context.getItemInHand().hurtAndBreak(1, context.getPlayer(), entity -> entity.broadcastBreakEvent(entity.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item.chisel.tooltip").withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, world, tooltip, flag);
    }
}
