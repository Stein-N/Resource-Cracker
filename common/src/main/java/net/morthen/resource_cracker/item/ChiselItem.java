package net.morthen.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Repairable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.morthen.resource_cracker.config.LootConfig;
import net.morthen.resource_cracker.item.components.TooltipContainer;
import net.morthen.resource_cracker.registries.DataComponentRegistry;
import net.morthen.resource_cracker.registries.ItemRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ChiselItem extends Item {
    public static final Random rnd = new Random();
    private final Supplier<Integer> durability;
    private final Supplier<Float> saltpeterChance;
    private final Holder<Item> repairItem;

    public ChiselItem(Supplier<Integer> durability, Holder<Item> repairItem, Properties properties) {
        super(properties
                .component(DataComponents.MAX_STACK_SIZE, 1)
                .component(DataComponentRegistry.TOOLTIP_CONTAINER.get(), new TooltipContainer(List.of(
                        Component.translatable("item.chisel.tooltip").withStyle(ChatFormatting.GOLD)
                ))));
        this.durability = durability;
        this.repairItem = repairItem;

        this.saltpeterChance = () -> LootConfig.saltpeterFromBricks;
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() == null) return InteractionResult.FAIL;
        ItemStack stack = context.getItemInHand();

        if (!stack.has(DataComponents.MAX_DAMAGE)) {
            this.addToolComponents(stack);
        }

        Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());

        if (block.equals(Blocks.BRICKS) && rnd.nextFloat() <= saltpeterChance.get()) {
            Containers.dropItemStack(context.getLevel(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemRegistry.MATERIAL_DUST_SALTPETER.get()));
        }

        stack.hurtAndBreak(1, context.getPlayer(), EquipmentSlot.MAINHAND);

        return InteractionResult.SUCCESS;
    }

    private void addToolComponents(ItemStack stack) {
        stack.set(DataComponents.MAX_DAMAGE, this.durability.get());
        stack.set(DataComponents.DAMAGE, 0);

        stack.set(DataComponents.REPAIRABLE, new Repairable(HolderSet.direct(this.repairItem)));
        stack.set(DataComponents.REPAIR_COST, 1);
    }
}
