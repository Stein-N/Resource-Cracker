package net.xstopho.resource_cracker.item.tier;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ToolTiers implements Tier {

    STEEL(2, 450, 6.0F, 2.0F, 14, () -> Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c:steel_ingots"))));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ToolTiers(int $$0, int $$1, float $$2, float $$3, int $$4, Supplier<Ingredient> $$5) {
        this.level = $$0;
        this.uses = $$1;
        this.speed = $$2;
        this.damage = $$3;
        this.enchantmentValue = $$4;
        this.repairIngredient = new LazyLoadedValue<>($$5);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
