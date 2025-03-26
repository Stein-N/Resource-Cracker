package net.xstopho.resource_cracker.item.materials;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.item.tags.CrackerItemTags;

import java.util.List;

public record ScytheToolMaterial(int durability, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems) {

    private static final ResourceLocation EXTENDED_ENTITY_REACH = ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "extended_entity_reach");
    private static final ResourceLocation EXTENDED_BLOCK_REACH = ResourceLocation.fromNamespaceAndPath(CrackerConstants.MOD_ID, "extended_block_reach");

    public static final ScytheToolMaterial COPPER = new ScytheToolMaterial(100, 0.0F, 5, CrackerItemTags.COPPER_TOOL_MATERIALS);
    public static final ScytheToolMaterial GOLD = new ScytheToolMaterial(32, 0.0F, 22, ItemTags.GOLD_TOOL_MATERIALS);
    public static final ScytheToolMaterial IRON = new ScytheToolMaterial(250, 0.0F, 15, ItemTags.IRON_TOOL_MATERIALS);
    public static final ScytheToolMaterial STEEL = new ScytheToolMaterial(450,  1.5F, 13, CrackerItemTags.STEEL_TOOL_MATERIALS);
    public static final ScytheToolMaterial DIAMOND = new ScytheToolMaterial(1561, 3.0F, 10, ItemTags.DIAMOND_TOOL_MATERIALS);
    public static final ScytheToolMaterial NETHERITE = new ScytheToolMaterial(2031,  4.0F, 15, ItemTags.NETHERITE_TOOL_MATERIALS);

    private Item.Properties applyCommonProperties(Item.Properties properties) {
        return properties.durability(this.durability).repairable(this.repairItems).enchantable(this.enchantmentValue);
    }

    public Item.Properties applyScytheProperties(Item.Properties properties, float attackDamage, float attackSpeed) {
        HolderGetter<Block> holdergetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return this.applyCommonProperties(properties)
                .component(DataComponents.TOOL, new Tool(List.of(Tool.Rule.minesAndDrops(HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()), 15.0F),
                        Tool.Rule.overrideSpeed(holdergetter.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)), 1.0F, 2))
                .attributes(this.createSwordAttributes(attackDamage, attackSpeed));
    }

    private ItemAttributeModifiers createSwordAttributes(float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, attackDamage + this.attackDamageBonus, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(EXTENDED_ENTITY_REACH, 1.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(EXTENDED_BLOCK_REACH, 1.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }
}
