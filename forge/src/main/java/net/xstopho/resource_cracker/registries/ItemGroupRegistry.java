package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.xstopho.resource_cracker.Constants;

public class ItemGroupRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RESOURCE_CRACKER = CREATIVE_MODE_TABS.register("item-group",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.CRACK_HAMMER_DIAMOND.get()))
                    .title(Component.translatable("item-group.resource_cracker"))
                    .displayItems((displayContext, output) -> {

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

                        output.accept(BlockRegistry.STEEL_BLOCK.get());
                        output.accept(BlockRegistry.LAVA_SPRING_BLOCK.get());
                        output.accept(BlockRegistry.WATER_SPRING_BLOCK.get());

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
                        output.accept(ItemRegistry.DIAMOND_NUGGET.get());

                        output.accept(ItemRegistry.GARLIC.get());
                        output.accept(ItemRegistry.BEEF_JERKY.get());

                    }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
