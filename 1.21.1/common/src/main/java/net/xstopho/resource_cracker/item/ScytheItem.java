package net.xstopho.resource_cracker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.config.ToolConfig;

import java.util.List;
import java.util.function.Supplier;

public class ScytheItem extends SwordItem {
    public static final ResourceLocation BASE_ENTITY_REACH = ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "base_entity_reach");
    public static final ResourceLocation BASE_BLOCK_REACH = ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "base_block_reach");
    private final Supplier<Integer> radius;

    public ScytheItem(Tier tier, int attackDamage, float attackSpeed) {
        super(tier, new Properties()
                .attributes(createAttributes(tier, attackDamage, attackSpeed)
                        .withModifierAdded(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(BASE_BLOCK_REACH, 1,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                        .withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(BASE_ENTITY_REACH, 1,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)));

        this.radius = () -> ToolConfig.scytheHarvestRadius;
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
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("item.scythe.tooltip").withStyle(ChatFormatting.GOLD));
        tooltip.add(Component.translatable("item.scythe.tooltip.radius").withStyle(ChatFormatting.GOLD)
                .append(Component.literal(String.valueOf(radius.get())).withStyle(ChatFormatting.RED)));

        super.appendHoverText(itemStack, tooltipContext, tooltip, tooltipFlag);
    }
}
