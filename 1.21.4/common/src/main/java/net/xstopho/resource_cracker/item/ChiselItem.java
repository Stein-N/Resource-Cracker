package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ChiselItem extends Item {
    public static final Random rnd = new Random();
    private final Supplier<Integer> durability;
    private final Supplier<Float> saltpeterChance;

    public ChiselItem(Supplier<Integer> durability, Properties properties) {
        super(properties);
        this.durability = durability;
        this.saltpeterChance = () -> LootConfig.saltpeterFromBricks;
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() == null) return InteractionResult.FAIL;

        Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());

        if (block.equals(Blocks.BRICKS) && rnd.nextFloat() <= saltpeterChance.get()) {
            Containers.dropItemStack(context.getLevel(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemRegistry.MATERIAL_DUST_SALTPETER.get()));
        }

        context.getItemInHand().hurtAndBreak(1, context.getPlayer(), EquipmentSlot.MAINHAND);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext ccontext, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item.chisel.tooltip").withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, ccontext, tooltip, flag);
    }

    public ItemStack addDurability(ItemStack stack) {
        ItemStack copy = stack.copy();
        copy.set(DataComponents.MAX_DAMAGE, this.durability.get());
        copy.set(DataComponents.MAX_STACK_SIZE, 1);
        copy.set(DataComponents.DAMAGE, 0);
        return copy;
    }
}
