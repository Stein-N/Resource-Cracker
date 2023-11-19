package net.xstopho.resource_cracker.registries;

import com.mojang.datafixers.kinds.Const;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.config.ConstantConfig;
import net.xstopho.resource_cracker.food.ConstantFoodProperties;
import net.xstopho.resource_cracker.item.ChiselItem;
import net.xstopho.resource_cracker.item.tier.ToolTiers;
import net.xstopho.resource_cracker.items.CrackHammerItem;
import net.xstopho.resource_cracker.items.ScytheItem;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    public static final RegistryObject<Item> MATERIAL_DUST_COPPER = ITEMS.register("material_dust_copper", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATERIAL_DUST_IRON = ITEMS.register("material_dust_iron", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATERIAL_DUST_GOLD = ITEMS.register("material_dust_gold", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATERIAL_DUST_DIAMOND = ITEMS.register("material_dust_diamond", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATERIAL_DUST_EMERALD = ITEMS.register("material_dust_emerald", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATERIAL_DUST_NETHERITE_SCRAP = ITEMS.register("material_dust_netherite_scrap", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATERIAL_DUST_NETHERITE = ITEMS.register("material_dust_netherite", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MATERIAL_DUST_CARBON = ITEMS.register("material_dust_carbon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATERIAL_DUST_STEEL = ITEMS.register("material_dust_steel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATERIAL_DUST_SULFUR = ITEMS.register("material_dust_sulfur", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATERIAL_DUST_SALTPETER = ITEMS.register("material_dust_saltpeter", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_NUGGET = ITEMS.register("diamond_nugget", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRACK_HAMMER_COPPER = ITEMS.register("crack_hammer_copper", () -> new CrackHammerItem(ConstantConfig.CRACK_HAMMER_COPPER.get()));
    public static final RegistryObject<Item> CRACK_HAMMER_GOLD = ITEMS.register("crack_hammer_gold", () -> new CrackHammerItem(ConstantConfig.CRACK_HAMMER_GOLD.get()));
    public static final RegistryObject<Item> CRACK_HAMMER_IRON = ITEMS.register("crack_hammer_iron", () -> new CrackHammerItem(ConstantConfig.CRACK_HAMMER_IRON.get()));
    public static final RegistryObject<Item> CRACK_HAMMER_STEEL = ITEMS.register("crack_hammer_steel", () -> new CrackHammerItem(ConstantConfig.CRACK_HAMMER_STEEL.get()));
    public static final RegistryObject<Item> CRACK_HAMMER_DIAMOND = ITEMS.register("crack_hammer_diamond", () -> new CrackHammerItem(ConstantConfig.CRACK_HAMMER_DIAMOND.get()));
    public static final RegistryObject<Item> CRACK_HAMMER_NETHERITE = ITEMS.register("crack_hammer_netherite", () -> new CrackHammerItem(ConstantConfig.CRACK_HAMMER_NETHERITE.get()));

    public static final RegistryObject<Item> CHISEL_COPPER = ITEMS.register("chisel_copper", () -> new ChiselItem(ConstantConfig.CHISEL_COPPER.get(), MATERIAL_DUST_SALTPETER.get()));
    public static final RegistryObject<Item> CHISEL_GOLD = ITEMS.register("chisel_gold", () -> new ChiselItem(ConstantConfig.CHISEL_GOLD.get(), MATERIAL_DUST_SALTPETER.get()));
    public static final RegistryObject<Item> CHISEL_IRON = ITEMS.register("chisel_iron", () -> new ChiselItem(ConstantConfig.CHISEL_IRON.get(), MATERIAL_DUST_SALTPETER.get()));
    public static final RegistryObject<Item> CHISEL_STEEL = ITEMS.register("chisel_steel", () -> new ChiselItem(ConstantConfig.CHISEL_STEEL.get(), MATERIAL_DUST_SALTPETER.get()));
    public static final RegistryObject<Item> CHISEL_DIAMOND = ITEMS.register("chisel_diamond", () -> new ChiselItem(ConstantConfig.CHISEL_DIAMOND.get(), MATERIAL_DUST_SALTPETER.get()));
    public static final RegistryObject<Item> CHISEL_NETHERITE = ITEMS.register("chisel_netherite", () -> new ChiselItem(ConstantConfig.CHISEL_NETHERITE.get(), MATERIAL_DUST_SALTPETER.get()));

    public static final RegistryObject<Item> SCYTHE_COPPER = ITEMS.register("scythe_copper", () -> new ScytheItem(Tiers.GOLD, 2, -1.8f));
    public static final RegistryObject<Item> SCYTHE_GOLD = ITEMS.register("scythe_gold", () -> new ScytheItem(Tiers.GOLD, 3, -1.8f));
    public static final RegistryObject<Item> SCYTHE_IRON = ITEMS.register("scythe_iron", () -> new ScytheItem(Tiers.IRON, 3, -1.8f));
    public static final RegistryObject<Item> SCYTHE_STEEL = ITEMS.register("scythe_steel", () -> new ScytheItem(ToolTiers.STEEL, 3, -1.8f));
    public static final RegistryObject<Item> SCYTHE_DIAMOND = ITEMS.register("scythe_diamond", () -> new ScytheItem(Tiers.DIAMOND, 4, -1.8f));
    public static final RegistryObject<Item> SCYTHE_NETHERITE = ITEMS.register("scythe_netherite", () -> new ScytheItem(Tiers.NETHERITE, 5, -1.8f));

    public static final RegistryObject<Item> BEEF_JERKY = ITEMS.register("beef_jerky", () -> new Item(new Item.Properties().food(ConstantFoodProperties.BEEF_JERKY)));
    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic", () -> new BlockItem(BlockRegistry.GARLIC_CROP.get(), new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
