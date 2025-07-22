package net.xstopho.resource_cracker.item.tier;

import com.google.common.base.Suppliers;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.xstopho.resourcelibrary.util.TagHelper;

import java.util.Objects;
import java.util.function.Supplier;

public enum CrackerToolTier implements Tier {

    STEEL(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 450, 6.0F, 2.0F, 14,
            () -> Ingredient.of(TagHelper.createItemTag("ingot/steel")));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    CrackerToolTier(final TagKey<Block> tagKey, final int j, final float f, final float g, final int k, final Supplier<Ingredient> supplier) {
        this.incorrectBlocksForDrops = tagKey;
        this.uses = j;
        this.speed = f;
        this.damage = g;
        this.enchantmentValue = k;
        Objects.requireNonNull(supplier);
        this.repairIngredient = Suppliers.memoize(supplier::get);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
