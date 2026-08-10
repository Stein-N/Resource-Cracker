package net.morthen.resource_cracker.modifier;

import net.minecraft.world.entity.EntityTypes;
import net.morthen.resource_cracker.config.LootConfig;
import net.morthen.resource_cracker.registries.ItemRegistry;
import net.morthen.resourcelibrary.modifier.LootTableModifier;

import java.util.List;

public class EntityLootModifier {

    public static void init(LootTableModifier modifier) {
        modifier.addItem(ItemRegistry.GARLIC, 1f, () -> LootConfig.garlicFromZombie, List.of(EntityTypes.ZOMBIE.getDefaultLootTable().get()));

        modifier.addItem(ItemRegistry.MATERIAL_DUST_SULFUR, 1f, () -> LootConfig.sulfurFromCreeper, List.of(EntityTypes.CREEPER.getDefaultLootTable().get()));
        modifier.addItem(ItemRegistry.MATERIAL_DUST_SALTPETER, 1f, () -> LootConfig.saltpeterFromCreeper, List.of(EntityTypes.CREEPER.getDefaultLootTable().get()));
    }
}