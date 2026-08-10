package net.morthen.resource_cracker.item.materials;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.morthen.resource_cracker.CrackerConstants;
import net.morthen.resource_cracker.item.tags.CrackerItemTags;

import java.util.List;

public record ScytheMaterial(int durability, float damageBonus, int enchantmentValue, TagKey<Item> repairItem) {

    private static final Identifier EXTENDED_ENTITY_REACH_ID = CrackerConstants.of("extended_entity_reach");
    private static final Identifier EXTENDED_BLOCK_REACH_ID = CrackerConstants.of("extended_block_reach");

    public static final ScytheMaterial COPPER = new ScytheMaterial(100, 0.0F, 5, CrackerItemTags.COPPER_TOOL_MATERIALS);
    public static final ScytheMaterial GOLD = new ScytheMaterial(32, 0.0F, 22, ItemTags.GOLD_TOOL_MATERIALS);
    public static final ScytheMaterial IRON = new ScytheMaterial(250, 0.0F, 15, ItemTags.IRON_TOOL_MATERIALS);
    public static final ScytheMaterial STEEL = new ScytheMaterial(450,  1.5F, 13, CrackerItemTags.STEEL_TOOL_MATERIALS);
    public static final ScytheMaterial DIAMOND = new ScytheMaterial(1561, 3.0F, 10, ItemTags.DIAMOND_TOOL_MATERIALS);
    public static final ScytheMaterial NETHERITE = new ScytheMaterial(2031,  4.0F, 15, ItemTags.NETHERITE_TOOL_MATERIALS);

    private Item.Properties applyCommonProperties(Item.Properties properties) {
        return properties.durability(this.durability()).repairable(this.repairItem()).enchantable(this.enchantmentValue());
    }

    public Item.Properties applyScytheProperties(Item.Properties properties, float baseDamage, float baseSpeed) {
        HolderGetter<Block> getter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return this.applyCommonProperties(properties)
                .component(DataComponents.TOOL, new Tool(List.of(
                        Tool.Rule.minesAndDrops(HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()), 15f),
                        Tool.Rule.overrideSpeed(getter.getOrThrow(BlockTags.SWORD_INSTANTLY_MINES), Float.MAX_VALUE),
                        Tool.Rule.overrideSpeed(getter.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5f)
                ), 1f, 2, false))
                .attributes(this.createScytheAttributes(baseDamage, baseSpeed))
                .component(DataComponents.WEAPON, new Weapon(1));
    }

    private ItemAttributeModifiers createScytheAttributes(float baseDamage, float baseSpeed) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, baseDamage + this.damageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, baseSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(EXTENDED_ENTITY_REACH_ID, 1.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(EXTENDED_BLOCK_REACH_ID, 1.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }
}
