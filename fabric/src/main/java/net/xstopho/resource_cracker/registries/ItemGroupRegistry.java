package net.xstopho.resource_cracker.registries;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.xstopho.resource_cracker.Constants;

public class ItemGroupRegistry {

    public static final CreativeModeTab RESOURCE_CRACKER = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MOD_ID, "item-group"),
            FabricItemGroup.builder().title(Component.translatable("item-group.resource_cracker")).icon(() -> new ItemStack(ItemRegistry.CRACK_HAMMER_DIAMOND))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ItemRegistry.CRACK_HAMMER_COPPER);
                        output.accept(ItemRegistry.CRACK_HAMMER_GOLD);
                        output.accept(ItemRegistry.CRACK_HAMMER_IRON);
                        output.accept(ItemRegistry.CRACK_HAMMER_STEEL);
                        output.accept(ItemRegistry.CRACK_HAMMER_DIAMOND);
                        output.accept(ItemRegistry.CRACK_HAMMER_NETHERITE);

                        output.accept(ItemRegistry.CHISEL_COPPER);
                        output.accept(ItemRegistry.CHISEL_GOLD);
                        output.accept(ItemRegistry.CHISEL_IRON);
                        output.accept(ItemRegistry.CHISEL_STEEL);
                        output.accept(ItemRegistry.CHISEL_DIAMOND);
                        output.accept(ItemRegistry.CHISEL_NETHERITE);

                        output.accept(ItemRegistry.SCYTHE_COPPER);
                        output.accept(ItemRegistry.SCYTHE_GOLD);
                        output.accept(ItemRegistry.SCYTHE_IRON);
                        output.accept(ItemRegistry.SCYTHE_STEEL);
                        output.accept(ItemRegistry.SCYTHE_DIAMOND);
                        output.accept(ItemRegistry.SCYTHE_NETHERITE);

                        output.accept(BlockRegistry.WATER_SPRING_BLOCK);
                        output.accept(BlockRegistry.LAVA_SPRING_BLOCK);
                        output.accept(BlockRegistry.STEEL_BLOCK);

                        output.accept(ItemRegistry.MATERIAL_DUST_COPPER);
                        output.accept(ItemRegistry.MATERIAL_DUST_IRON);
                        output.accept(ItemRegistry.MATERIAL_DUST_GOLD);
                        output.accept(ItemRegistry.MATERIAL_DUST_DIAMOND);
                        output.accept(ItemRegistry.MATERIAL_DUST_EMERALD);
                        output.accept(ItemRegistry.MATERIAL_DUST_NETHERITE_SCRAP);
                        output.accept(ItemRegistry.MATERIAL_DUST_NETHERITE);

                        output.accept(ItemRegistry.MATERIAL_DUST_CARBON);
                        output.accept(ItemRegistry.MATERIAL_DUST_STEEL);
                        output.accept(ItemRegistry.MATERIAL_DUST_SULFUR);
                        output.accept(ItemRegistry.MATERIAL_DUST_SALTPETER);

                        output.accept(ItemRegistry.STEEL_INGOT);
                        output.accept(ItemRegistry.DIAMOND_NUGGET);

                        output.accept(ItemRegistry.GARLIC);
                        output.accept(ItemRegistry.BEEF_JERKY);

                    }).build());

    public static void init() {

    }
}
