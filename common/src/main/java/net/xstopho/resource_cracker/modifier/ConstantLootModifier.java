package net.xstopho.resource_cracker.modifier;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ConstantLootModifier {

    public static LootPool.Builder createPool(Item item, float chance, float maxAmount) {
        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1f))
                .when(LootItemRandomChanceCondition.randomChance(value(chance)))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, maxAmount)));
    }

    public static ResourceLocation getBlockID(String id) {
        return new ResourceLocation("blocks/" + id);
    }

    public static ResourceLocation getChestID(String id) {
        return new ResourceLocation("chests/" + id);
    }

    public static ResourceLocation getEntityID(String id) {
        return new ResourceLocation("entities/" + id);
    }

    private static float value(float chance) {
        return Math.min(1.0f, Math.max(0.0f, chance));
    }
}
