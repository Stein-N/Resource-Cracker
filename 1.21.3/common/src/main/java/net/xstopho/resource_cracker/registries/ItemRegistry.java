package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.config.ToolConfig;
import net.xstopho.resource_cracker.item.ChiselItem;
import net.xstopho.resource_cracker.item.CrackHammerItem;
import net.xstopho.resource_cracker.item.ScytheItem;
import net.xstopho.resource_cracker.item.food.CrackerFoodProperties;
import net.xstopho.resource_cracker.item.materials.ScytheToolMaterial;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

import java.util.function.Function;

public class ItemRegistry {

    public static final RegistryProvider<Item> ITEMS = RegistryProvider.get(CrackerConstants.MOD_ID, BuiltInRegistries.ITEM);

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

    public static final RegistryObject<Item> CRACK_HAMMER_COPPER = register("crack_hammer_copper", properties -> new CrackHammerItem(() -> ToolConfig.copperHammer, properties));
    public static final RegistryObject<Item> CRACK_HAMMER_GOLD = register("crack_hammer_gold", properties -> new CrackHammerItem(() -> ToolConfig.goldHammer, properties));
    public static final RegistryObject<Item> CRACK_HAMMER_IRON = register("crack_hammer_iron", properties -> new CrackHammerItem(() -> ToolConfig.ironHammer, properties));
    public static final RegistryObject<Item> CRACK_HAMMER_STEEL = register("crack_hammer_steel", properties -> new CrackHammerItem(() -> ToolConfig.steelHammer, properties));
    public static final RegistryObject<Item> CRACK_HAMMER_DIAMOND = register("crack_hammer_diamond", properties -> new CrackHammerItem(() -> ToolConfig.diamondHammer, properties));
    public static final RegistryObject<Item> CRACK_HAMMER_NETHERITE = register("crack_hammer_netherite", properties -> new CrackHammerItem(() -> ToolConfig.netheriteHammer, properties.fireResistant()));

    public static final RegistryObject<Item> CHISEL_COPPER = register("chisel_copper", properties -> new ChiselItem(() -> ToolConfig.copperChisel, properties));
    public static final RegistryObject<Item> CHISEL_GOLD = register("chisel_gold", properties -> new ChiselItem(() -> ToolConfig.goldChisel, properties));
    public static final RegistryObject<Item> CHISEL_IRON = register("chisel_iron", properties -> new ChiselItem(() -> ToolConfig.ironChisel, properties));
    public static final RegistryObject<Item> CHISEL_STEEL = register("chisel_steel", properties -> new ChiselItem(() -> ToolConfig.steelChisel, properties));
    public static final RegistryObject<Item> CHISEL_DIAMOND = register("chisel_diamond", properties -> new ChiselItem(() -> ToolConfig.diamondChisel, properties));
    public static final RegistryObject<Item> CHISEL_NETHERITE = register("chisel_netherite", properties -> new ChiselItem(() -> ToolConfig.netheriteChisel, properties.fireResistant()));

    public static final RegistryObject<Item> SCYTHE_COPPER = register("scythe_copper", properties -> new ScytheItem(ScytheToolMaterial.COPPER, 2, -1.8f, properties));
    public static final RegistryObject<Item> SCYTHE_GOLD = register("scythe_gold", properties -> new ScytheItem(ScytheToolMaterial.GOLD, 3, -1.8f, properties));
    public static final RegistryObject<Item> SCYTHE_IRON = register("scythe_iron", properties -> new ScytheItem(ScytheToolMaterial.IRON, 3, -1.8f, properties));
    public static final RegistryObject<Item> SCYTHE_STEEL = register("scythe_steel", properties -> new ScytheItem(ScytheToolMaterial.STEEL, 3, -1.8f, properties));
    public static final RegistryObject<Item> SCYTHE_DIAMOND = register("scythe_diamond", properties -> new ScytheItem(ScytheToolMaterial.DIAMOND, 4, -1.8f, properties));
    public static final RegistryObject<Item> SCYTHE_NETHERITE = register("scythe_netherite", properties -> new ScytheItem(ScytheToolMaterial.NETHERITE, 5, -1.8f, properties.fireResistant()));

    public static final RegistryObject<Item> GARLIC = register("garlic", properties -> new BlockItem(BlockRegistry.GARLIC_CROP.get(), properties.food(CrackerFoodProperties.GARLIC)));
    public static final RegistryObject<Item> BEEF_JERKY = register("beef_jerky", properties -> new Item(properties.food(CrackerFoodProperties.BEEF_JERKY)));

    public static RegistryObject<Item> register(String id, Function<Item.Properties, Item> function, Item.Properties properties) {
        return ITEMS.register(id, () -> function.apply(properties.setId(createKey(id))));
    }

    public static RegistryObject<Item> register(String id, Function<Item.Properties, Item> function) {
        return register(id, function, new Item.Properties());
    }

    public static RegistryObject<Item> register(String id) {
        return register(id, Item::new);
    }

    private static ResourceKey<Item> createKey(String id) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ITEMS.getModId(), id));
    }

    public static void init() {}
}
