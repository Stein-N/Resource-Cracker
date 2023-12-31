package net.xstopho.resource_cracker.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.xstopho.resource_cracker.item.ScytheBase;
import org.jetbrains.annotations.NotNull;

public class ScytheItem extends ScytheBase {
    public ScytheItem(Tier toolTier, int attackDamage, float attackSpeed) {
        super(toolTier, attackDamage, attackSpeed);
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> atts = ImmutableMultimap.builder();
        atts.putAll(super.getDefaultAttributeModifiers(slot));
        atts.put(NeoForgeMod.ENTITY_REACH.value(), new AttributeModifier(BASE_ENTITY_REACH_UUID, "bonus", 1, AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND ? atts.build() : super.getDefaultAttributeModifiers(slot);
    }
}
