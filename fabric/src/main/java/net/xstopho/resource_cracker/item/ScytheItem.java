package net.xstopho.resource_cracker.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Tier;
import net.xstopho.resource_cracker.registries.AttributeRegistry;

import java.util.UUID;

public class ScytheItem extends ScytheBase{
    public static final UUID BASE_ATTACK_RANGE_UUID = UUID.fromString("DB0F1F0B-7DF7-4D45-BA75-9BA60DABCCCD");

    public ScytheItem(Tier toolTier, int attackDamage, float attackSpeed) {
        super(toolTier, attackDamage, attackSpeed);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributes = ImmutableMultimap.builder();
        attributes.putAll(super.getDefaultAttributeModifiers(slot));
        attributes.put(AttributeRegistry.ATTACK_RANGE, new AttributeModifier(BASE_ATTACK_RANGE_UUID, "bonus", 1, AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND ? attributes.build() : super.getDefaultAttributeModifiers(slot);
    }
}
