package net.xstopho.resource_cracker.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.xstopho.resource_cracker.config.Config;
import net.xstopho.resource_cracker.registries.AttributeRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class ScytheItem extends SwordItem {
    public static final UUID BASE_ENTITY_REACH_UUID = UUID.fromString("DB0F1F0B-7DF7-4D45-BA75-9BA60DABCCCD");
    private static final int radius = Config.SCYTHE_RADIUS.get();

    public ScytheItem(Tier toolTier, int attackDamage, float attackSpeed) {
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
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
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
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributes = ImmutableMultimap.builder();
        attributes.putAll(super.getDefaultAttributeModifiers(slot));
        attributes.put(AttributeRegistry.ATTACK_RANGE.get(), new AttributeModifier(BASE_ENTITY_REACH_UUID, "bonus", 1, AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND ? attributes.build() : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item.scythe.tooltip").withStyle(ChatFormatting.GOLD));
        tooltip.add(Component.translatable("item.scythe.tooltip.radius").withStyle(ChatFormatting.GOLD)
                .append(Component.literal(String.valueOf(radius)).withStyle(ChatFormatting.RED)));

        super.appendHoverText(stack, world, tooltip, flag);
    }
}
