package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.stophoslib.registration.RegistryObject;
import net.xstopho.stophoslib.registration.RegistryProvider;

public class ItemGroupRegistry {

    private static final RegistryProvider<CreativeModeTab> CREATIVE_MODE_TABS = RegistryProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RESOURCE_CRACKER = CREATIVE_MODE_TABS.register("item_group",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).title(Component.translatable("item-group.resource_cracker"))
                    .icon(() -> new ItemStack(ItemRegistry.CRACK_HAMMER_DIAMOND.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ItemRegistry.CRACK_HAMMER_COPPER.get());
                        output.accept(ItemRegistry.CRACK_HAMMER_GOLD.get());
                        output.accept(ItemRegistry.CRACK_HAMMER_IRON.get());
                        output.accept(ItemRegistry.CRACK_HAMMER_STEEL.get());
                        output.accept(ItemRegistry.CRACK_HAMMER_DIAMOND.get());
                        output.accept(ItemRegistry.CRACK_HAMMER_NETHERITE.get());

                        output.accept(ItemRegistry.CHISEL_COPPER.get());
                        output.accept(ItemRegistry.CHISEL_GOLD.get());
                        output.accept(ItemRegistry.CHISEL_IRON.get());
                        output.accept(ItemRegistry.CHISEL_STEEL.get());
                        output.accept(ItemRegistry.CHISEL_DIAMOND.get());
                        output.accept(ItemRegistry.CHISEL_NETHERITE.get());

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
