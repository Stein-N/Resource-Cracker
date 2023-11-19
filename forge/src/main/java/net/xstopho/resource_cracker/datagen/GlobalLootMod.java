package net.xstopho.resource_cracker.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.modifier.AddItemModifier;
import net.xstopho.resource_cracker.registries.ItemRegistry;

public class GlobalLootMod extends GlobalLootModifierProvider {
    public GlobalLootMod(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void start() {
        add("garlic_from_zombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build()
                }, ItemRegistry.MATERIAL_DUST_CARBON.get()));
    }
}
