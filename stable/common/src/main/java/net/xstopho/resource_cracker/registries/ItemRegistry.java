package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Tiers;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.config.ToolConfig;
import net.xstopho.resource_cracker.item.ChiselItem;
import net.xstopho.resource_cracker.item.CrackHammerItem;
import net.xstopho.resource_cracker.item.ScytheItem;
import net.xstopho.resource_cracker.item.food.CrackerFoodProperties;
import net.xstopho.resource_cracker.item.tier.CrackerToolTier;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

import java.util.function.Supplier;

public class ItemRegistry {

    public static final RegistryProvider<Item> ITEMS = RegistryProvider.get(Registries.ITEM, CrackerConstants.MOD_ID);

    public static final RegistryObject<Item> MATERIAL_DUST_COPPER = register("material_dust_copper");
    public static final RegistryObject<Item> MATERIAL_DUST_IRON = register("material_dust_iron");
    public static final RegistryObject<Item> MATERIAL_DUST_GOLD = register("material_dust_gold");
    public static final RegistryObject<Item> MATERIAL_DUST_EMERALD = register("material_dust_emerald");
    public static final RegistryObject<Item> MATERIAL_DUST_DIAMOND = register("material_dust_diamond");
    public static final RegistryObject<Item> MATERIAL_DUST_NETHERITE_SCRAP = register("material_dust_netherite_scrap");
    public static final RegistryObject<Item> MATERIAL_DUST_NETHERITE = register("material_dust_netherite");
    public static final RegistryObject<Item> MATERIAL_DUST_CARBON = register("material_dust_carbon");
    public static final RegistryObject<Item> MATERIAL_DUST_STEEL = register("material_dust_steel");
    public static final RegistryObject<Item> MATERIAL_DUST_SULFUR = register("material_dust_sulfur");
    public static final RegistryObject<Item> MATERIAL_DUST_SALTPETER = register("material_dust_saltpeter");

    public static final RegistryObject<Item> STEEL_INGOT = register("steel_ingot");
    public static final RegistryObject<Item> NUGGET_DIAMOND = register("nugget_diamond");
    public static final RegistryObject<Item> NUGGET_EMERALD = register("nugget_emerald");
    public static final RegistryObject<Item> NUGGET_COPPER = register("nugget_copper");

    public static final RegistryObject<Item> CRACK_HAMMER_COPPER = register("crack_hammer_copper", () -> new CrackHammerItem(() -> ToolConfig.copperHammer));
    public static final RegistryObject<Item> CRACK_HAMMER_GOLD = register("crack_hammer_gold", () -> new CrackHammerItem(() -> ToolConfig.goldHammer));
    public static final RegistryObject<Item> CRACK_HAMMER_IRON = register("crack_hammer_iron", () -> new CrackHammerItem(() -> ToolConfig.ironHammer));
    public static final RegistryObject<Item> CRACK_HAMMER_STEEL = register("crack_hammer_steel", () -> new CrackHammerItem(() -> ToolConfig.steelHammer));
    public static final RegistryObject<Item> CRACK_HAMMER_DIAMOND = register("crack_hammer_diamond", () -> new CrackHammerItem(() -> ToolConfig.diamondHammer));
    public static final RegistryObject<Item> CRACK_HAMMER_NETHERITE = register("crack_hammer_netherite", () -> new CrackHammerItem(() -> ToolConfig.netheriteHammer));

    public static final RegistryObject<Item> CHISEL_COPPER = register("chisel_copper", () -> new ChiselItem(() -> ToolConfig.copperChisel));
    public static final RegistryObject<Item> CHISEL_GOLD = register("chisel_gold", () -> new ChiselItem(() -> ToolConfig.goldChisel));
    public static final RegistryObject<Item> CHISEL_IRON = register("chisel_iron", () -> new ChiselItem(() -> ToolConfig.ironChisel));
    public static final RegistryObject<Item> CHISEL_STEEL = register("chisel_steel", () -> new ChiselItem(() -> ToolConfig.steelChisel));
    public static final RegistryObject<Item> CHISEL_DIAMOND = register("chisel_diamond", () -> new ChiselItem(() -> ToolConfig.diamondChisel));
    public static final RegistryObject<Item> CHISEL_NETHERITE = register("chisel_netherite", () -> new ChiselItem(() -> ToolConfig.netheriteChisel));

    public static final RegistryObject<Item> SCYTHE_COPPER = register("scythe_copper", () -> new ScytheItem(Tiers.GOLD, 2, -1.8f));
    public static final RegistryObject<Item> SCYTHE_GOLD = register("scythe_gold", () -> new ScytheItem(Tiers.GOLD, 3, -1.8f));
    public static final RegistryObject<Item> SCYTHE_IRON = register("scythe_iron", () -> new ScytheItem(Tiers.IRON, 3, -1.8f));
    public static final RegistryObject<Item> SCYTHE_STEEL = register("scythe_steel", () -> new ScytheItem(CrackerToolTier.STEEL, 3, -1.8f));
    public static final RegistryObject<Item> SCYTHE_DIAMOND = register("scythe_diamond", () -> new ScytheItem(Tiers.DIAMOND, 4, -1.8f));
    public static final RegistryObject<Item> SCYTHE_NETHERITE = register("scythe_netherite", () -> new ScytheItem(Tiers.NETHERITE, 5, -1.8f));

    public static final RegistryObject<Item> GARLIC = register("garlic", () -> new ItemNameBlockItem(BlockRegistry.GARLIC_CROP.get(),
            new Item.Properties().food(CrackerFoodProperties.GARLIC)));
    public static final RegistryObject<Item> BEEF_JERKY = register("beef_jerky", () -> new Item(new Item.Properties().food(CrackerFoodProperties.BEEF_JERKY)));

    private static RegistryObject<Item> register(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }

    private static RegistryObject<Item> register(String id) {
        return register(id, () -> new Item(new Item.Properties()));
    }

    public static void init() {}
}
