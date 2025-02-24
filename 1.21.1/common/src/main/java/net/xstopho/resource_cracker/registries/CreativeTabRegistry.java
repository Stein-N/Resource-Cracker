package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.item.ChiselItem;
import net.xstopho.resource_cracker.item.CrackHammerItem;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

public class CreativeTabRegistry {

    private static final RegistryProvider<CreativeModeTab> CREATIVE_TABS = RegistryProvider.get(Registries.CREATIVE_MODE_TAB, CrackerConstants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RESOURCE_CRACKER = CREATIVE_TABS.register("item_group",
            () -> CreativeModeTab.builder(null, -1).title(Component.translatable("item_group.resource_cracker"))
                    .icon(() -> new ItemStack(ItemRegistry.CRACK_HAMMER_DIAMOND.get())).displayItems((itemDisplayParameters, output) -> {

                        output.accept(((CrackHammerItem) ItemRegistry.CRACK_HAMMER_COPPER.get()).addDurability());
                        output.accept(((CrackHammerItem) ItemRegistry.CRACK_HAMMER_GOLD.get()).addDurability());
                        output.accept(((CrackHammerItem) ItemRegistry.CRACK_HAMMER_IRON.get()).addDurability());
                        output.accept(((CrackHammerItem) ItemRegistry.CRACK_HAMMER_STEEL.get()).addDurability());
                        output.accept(((CrackHammerItem) ItemRegistry.CRACK_HAMMER_DIAMOND.get()).addDurability());
                        output.accept(((CrackHammerItem) ItemRegistry.CRACK_HAMMER_NETHERITE.get()).addDurability());

                        output.accept(((ChiselItem) ItemRegistry.CHISEL_COPPER.get()).addDurability());
                        output.accept(((ChiselItem) ItemRegistry.CHISEL_GOLD.get()).addDurability());
                        output.accept(((ChiselItem) ItemRegistry.CHISEL_IRON.get()).addDurability());
                        output.accept(((ChiselItem) ItemRegistry.CHISEL_STEEL.get()).addDurability());
                        output.accept(((ChiselItem) ItemRegistry.CHISEL_DIAMOND.get()).addDurability());
                        output.accept(((ChiselItem) ItemRegistry.CHISEL_NETHERITE.get()).addDurability());

                        output.accept(ItemRegistry.SCYTHE_COPPER.get());
                        output.accept(ItemRegistry.SCYTHE_GOLD.get());
                        output.accept(ItemRegistry.SCYTHE_IRON.get());
                        output.accept(ItemRegistry.SCYTHE_STEEL.get());
                        output.accept(ItemRegistry.SCYTHE_DIAMOND.get());
                        output.accept(ItemRegistry.SCYTHE_NETHERITE.get());

                        output.accept(BlockRegistry.WATER_SPRING_BLOCK.get());
                        output.accept(BlockRegistry.LAVA_SPRING_BLOCK.get());
                        output.accept(BlockRegistry.STEEL_BLOCK.get());

                        output.accept(ItemRegistry.NUGGET_DIAMOND.get());
                        output.accept(ItemRegistry.NUGGET_EMERALD.get());
                        output.accept(ItemRegistry.NUGGET_COPPER.get());

                        output.accept(ItemRegistry.MATERIAL_DUST_COPPER.get());
                        output.accept(ItemRegistry.MATERIAL_DUST_IRON.get());
                        output.accept(ItemRegistry.MATERIAL_DUST_GOLD.get());
                        output.accept(ItemRegistry.MATERIAL_DUST_DIAMOND.get());
                        output.accept(ItemRegistry.MATERIAL_DUST_EMERALD.get());
                        output.accept(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP.get());
                        output.accept(ItemRegistry.MATERIAL_DUST_NETHERITE.get());

                        output.accept(ItemRegistry.MATERIAL_DUST_CARBON.get());
                        output.accept(ItemRegistry.MATERIAL_DUST_STEEL.get());
                        output.accept(ItemRegistry.MATERIAL_DUST_SULFUR.get());
                        output.accept(ItemRegistry.MATERIAL_DUST_SALTPETER.get());

                        output.accept(ItemRegistry.STEEL_INGOT.get());

                        output.accept(ItemRegistry.GARLIC.get());
                        output.accept(ItemRegistry.BEEF_JERKY.get());

                    }).build());

    public static void init() {}
}
