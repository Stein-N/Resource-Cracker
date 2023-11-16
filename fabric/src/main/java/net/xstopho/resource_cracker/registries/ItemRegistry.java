package net.xstopho.resource_cracker.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Tiers;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.item.ChiselItem;
import net.xstopho.resource_cracker.item.CrackHammerItem;
import net.xstopho.resource_cracker.item.ScytheBase;
import net.xstopho.resource_cracker.item.ScytheItem;
import net.xstopho.resource_cracker.item.tier.ToolTiers;

public class ItemRegistry {

    /*   Vanilla Resources   */
    public static final Item MATERIAL_DUST_COPPER = register("material_dust_copper", new Item(new FabricItemSettings()));
    public static final Item MATERIAL_DUST_IRON = register("material_dust_iron", new Item(new FabricItemSettings()));
    public static final Item MATERIAL_DUST_GOLD = register("material_dust_gold", new Item(new FabricItemSettings()));
    public static final Item MATERIAL_DUST_DIAMOND = register("material_dust_diamond", new Item(new FabricItemSettings()));
    public static final Item MATERIAL_DUST_EMERALD = register("material_dust_emerald", new Item(new FabricItemSettings()));
    public static final Item MATERIAL_DUST_NETHERITE_SCRAP = register("material_dust_netherite_scrap", new Item(new FabricItemSettings()));
    public static final Item MATERIAL_DUST_NETHERITE = register("material_dust_netherite", new Item(new FabricItemSettings()));

    /*   Mod Resources   */
    public static final Item MATERIAL_DUST_CARBON = register("material_dust_carbon", new Item(new FabricItemSettings()));
    public static final Item MATERIAL_DUST_STEEL = register("material_dust_steel", new Item(new FabricItemSettings()));
    public static final Item MATERIAL_DUST_SULFUR = register("material_dust_sulfur", new Item(new FabricItemSettings()));
    public static final Item MATERIAL_DUST_SALTPETER = register("material_dust_saltpeter", new Item(new FabricItemSettings()));

    public static final Item STEEL_INGOT = register("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_NUGGET = register("diamond_nugget", new Item(new FabricItemSettings()));

    public static final Item CRACK_HAMMER_COPPER = register("crack_hammer_copper", new CrackHammerItem(100));
    public static final Item CRACK_HAMMER_GOLD = register("crack_hammer_gold",  new CrackHammerItem(100));
    public static final Item CRACK_HAMMER_IRON = register("crack_hammer_iron",  new CrackHammerItem(100));
    public static final Item CRACK_HAMMER_STEEL = register("crack_hammer_steel",  new CrackHammerItem(100));
    public static final Item CRACK_HAMMER_DIAMOND = register("crack_hammer_diamond",  new CrackHammerItem(100));
    public static final Item CRACK_HAMMER_NETHERITE = register("crack_hammer_netherite",  new CrackHammerItem(100));

    public static final Item CHISEL_COPPER = register("chisel_copper", new ChiselItem(100, MATERIAL_DUST_SALTPETER));
    public static final Item CHISEL_GOLD = register("chisel_gold", new ChiselItem(100, MATERIAL_DUST_SALTPETER));
    public static final Item CHISEL_IRON = register("chisel_iron", new ChiselItem(100, MATERIAL_DUST_SALTPETER));
    public static final Item CHISEL_STEEL = register("chisel_steel", new ChiselItem(100, MATERIAL_DUST_SALTPETER));
    public static final Item CHISEL_DIAMOND = register("chisel_diamond", new ChiselItem(100, MATERIAL_DUST_SALTPETER));
    public static final Item CHISEL_NETHERITE = register("chisel_netherite", new ChiselItem(100, MATERIAL_DUST_SALTPETER));

    public static final Item SCYTHE_COPPER = register("scythe_copper", new ScytheItem(Tiers.GOLD, 2, -1.8f));
    public static final Item SCYTHE_IRON = register("scythe_iron", new ScytheItem(Tiers.IRON, 3, -1.8f));
    public static final Item SCYTHE_GOLD = register("scythe_gold", new ScytheItem(Tiers.GOLD, 3, -1.8f));
    public static final Item SCYTHE_STEEL = register("scythe_steel", new ScytheItem(ToolTiers.STEEL, 3, -1.8f));
    public static final Item SCYTHE_DIAMOND = register("scythe_diamond", new ScytheItem(Tiers.DIAMOND, 4, -1.8f));
    public static final Item SCYTHE_NETHERITE = register("scythe_netherite", new ScytheItem(Tiers.NETHERITE, 5, -1.8f));

    /*  Mod Food  */
    public static final Item GARLIC = register("garlic", new ItemNameBlockItem(BlockRegistry.GARLIC_CROP, new FabricItemSettings().food(FuelFoodRegistry.GARLIC)));

    public static final Item BEEF_JERKY = register("beef_jerky", new Item(new FabricItemSettings().food(FuelFoodRegistry.BEEF_JERKY)));

    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, id), item);
    }

    public static void init() {

    }
}
