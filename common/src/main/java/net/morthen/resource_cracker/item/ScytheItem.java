package net.morthen.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.morthen.resource_cracker.config.ToolConfig;
import net.morthen.resource_cracker.item.components.TooltipContainer;
import net.morthen.resource_cracker.item.materials.ScytheMaterial;
import net.morthen.resource_cracker.registries.DataComponentRegistry;

import java.util.List;
import java.util.function.Supplier;

public class ScytheItem extends Item {
    private static final Supplier<Integer> radius = () -> ToolConfig.scytheHarvestRadius;

    public ScytheItem(ScytheMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material.applyScytheProperties(properties, attackDamage, attackSpeed)
                .component(DataComponentRegistry.TOOLTIP_CONTAINER.get(), new TooltipContainer(List.of(
                        Component.translatable("item.scythe.tooltip").withStyle(ChatFormatting.GOLD),
                        Component.translatable("item.scythe.tooltip.radius").withStyle(ChatFormatting.GOLD)
                                .append(Component.literal(String.valueOf(radius.get())).withStyle(ChatFormatting.RED))
                ))));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() == null) return InteractionResult.PASS;
        Player player = context.getPlayer();

        if (player.isSpectator() || player.isCreative()) return InteractionResult.PASS;

        BlockPos clickedPos = context.getClickedPos();
        BlockState clickedState = context.getLevel().getBlockState(clickedPos);

        if (clickedState.getBlock() instanceof CropBlock clickedCrop && clickedCrop.isMaxAge(clickedState)) {
            for (int x = -radius.get(); x <= radius.get(); x++) {
                for (int z = -radius.get(); z <= radius.get(); z++) {
                    BlockPos crop = clickedPos.offset(x, 0, z);
                    BlockState cropState = context.getLevel().getBlockState(crop);
                    if (cropState.getBlock() instanceof CropBlock replantCrop && replantCrop.isMaxAge(cropState)) {
                        context.getLevel().destroyBlock(crop, true, player);
                        context.getLevel().setBlockAndUpdate(crop, replantCrop.getStateForAge(0));
                    }
                }
            }
            context.getItemInHand().hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }
}
