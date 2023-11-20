package net.xstopho.resource_cracker.modifier;

import net.minecraft.world.item.Item;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.config.ConstantConfig;
import net.xstopho.resource_cracker.registries.ItemRegistry;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LootTableModifier {


    @SubscribeEvent
    public static void init(LootTableLoadEvent event) {
        modifyEntityLoot(event, ItemRegistry.GARLIC.get(), ConstantConfig.GARLIC_FROM_ZOMBIE.get().floatValue(), 3f, "zombie");
        modifyEntityLoot(event, ItemRegistry.MATERIAL_DUST_SULFUR.get(), ConstantConfig.SULFUR_FROM_CREEPER.get().floatValue(), 2f, "creeper");
        modifyEntityLoot(event, ItemRegistry.MATERIAL_DUST_SALTPETER.get(), ConstantConfig.SALTPETER_FROM_CREEPER.get().floatValue(), 2f, "creeper");

        modifyBlockLoot(event, ItemRegistry.DIAMOND_NUGGET.get(), ConstantConfig.DIAMOND_NUGGET_FROM_DIAMOND.get().floatValue(), 2f, "diamond_ore", "deepslate_diamond_ore");
        modifyBlockLoot(event, ItemRegistry.DIAMOND_NUGGET.get(), ConstantConfig.DIAMOND_NUGGET_FROM_COAL.get().floatValue(), 1f, "coal_ore", "deepslate_coal_ore");

        modifyStructureLoot(event, ItemRegistry.MATERIAL_DUST_SULFUR.get(), ConstantConfig.SULFUR.get().floatValue(), 6f,
                "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "village/village_desert_house");

        modifyStructureLoot(event, ItemRegistry.MATERIAL_DUST_SALTPETER.get(), ConstantConfig.SALTPETER.get().floatValue(), 6f,
                "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "desert_pyramid", "village/village_desert_house");

        modifyStructureLoot(event, ItemRegistry.MATERIAL_DUST_COPPER.get(), ConstantConfig.COPPER_DUST.get().floatValue(), 6f,
                "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith", "abandoned_mineshafts");

        modifyStructureLoot(event, ItemRegistry.MATERIAL_DUST_IRON.get(), ConstantConfig.IRON_DUST.get().floatValue(), 6f,
                "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith", "abandoned_mineshafts");

        modifyStructureLoot(event, ItemRegistry.MATERIAL_DUST_GOLD.get(), ConstantConfig.GOLD_DUST.get().floatValue(), 6f,
                "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith", "abandoned_mineshafts");

        modifyStructureLoot(event, ItemRegistry.MATERIAL_DUST_EMERALD.get(), ConstantConfig.EMERALD_DUST.get().floatValue(), 3f,
                "shipwreck_treasure", "abandoned_mineshafts");

        modifyStructureLoot(event, ItemRegistry.MATERIAL_DUST_DIAMOND.get(), ConstantConfig.DIAMOND_DUST.get().floatValue(), 3f,
                "shipwreck_treasure", "ancient_city");

        modifyStructureLoot(event, ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get(), ConstantConfig.NETHERITE_SCRAP.get().floatValue(), 2f,
                "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "ancient_city");

        modifyStructureLoot(event, ItemRegistry.MATERIAL_DUST_NETHERITE.get(), ConstantConfig.NETHERITE.get().floatValue(), 2f,
                "ruined_portal", "bastion_other", "bastion_bridge", "nether_bridge", "ancient_city");

        modifyStructureLoot(event, ItemRegistry.DIAMOND_NUGGET.get(), ConstantConfig.DIAMOND_NUGGET.get().floatValue(), 4f,
                "desert_pyramid", "shipwreck_treasure", "abandoned_mineshafts", "ancient_city");

        modifyStructureLoot(event, ItemRegistry.GARLIC.get(), ConstantConfig.GARLIC.get().floatValue(), 6f,
                "spawn_bonus_chest");

        modifyStructureLoot(event, ItemRegistry.CRACK_HAMMER_COPPER.get(), ConstantConfig.HAMMER_COPPER.get().floatValue(), 1f,
                "spawn_bonus_chest");

        modifyStructureLoot(event, ItemRegistry.CRACK_HAMMER_IRON.get(), ConstantConfig.HAMMER_IRON.get().floatValue(), 1f,
                "spawn_bonus_chest", "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith");

        modifyStructureLoot(event, ItemRegistry.CRACK_HAMMER_STEEL.get(), ConstantConfig.HAMMER_STEEL.get().floatValue(), 1f,
                "village/village_armorer", "village/village_toolsmith", "village/village_weaponsmith");
    }

    private static void modifyEntityLoot(LootTableLoadEvent event, Item item, float chance, float maxAmount, String... entities) {
        for (String entity : entities) {
            if (event.getName().equals(ConstantLootModifier.getEntityID(entity))) {
                event.getTable().addPool(ConstantLootModifier.createPool(item, chance, maxAmount).build());
            }
        }
    }

    private static void modifyBlockLoot(LootTableLoadEvent event, Item item, float chance, float maxAmount, String... blocks) {
        for (String block : blocks) {
            if (event.getName().equals(ConstantLootModifier.getBlockID(block))) {
                event.getTable().addPool(ConstantLootModifier.createPool(item, chance, maxAmount).build());
            }
        }
    }

    private static void modifyStructureLoot(LootTableLoadEvent event, Item item, float chance, float maxAmount, String... structures) {
        for (String structure : structures) {
            if (event.getName().equals(ConstantLootModifier.getChestID(structure))) {
                event.getTable().addPool(ConstantLootModifier.createPool(item, chance, maxAmount).build());
            }
        }
    }
}
