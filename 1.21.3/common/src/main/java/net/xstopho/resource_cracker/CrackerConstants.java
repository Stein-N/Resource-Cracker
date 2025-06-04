package net.xstopho.resource_cracker;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.xstopho.resource_cracker.config.LootConfig;
import net.xstopho.resource_cracker.config.ToolConfig;
import net.xstopho.resource_cracker.item.ChiselItem;
import net.xstopho.resource_cracker.item.CrackHammerItem;
import net.xstopho.resource_cracker.modifier.LootModifier;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.CreativeTabRegistry;
import net.xstopho.resource_cracker.registries.ItemModelRenderRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourceconfigapi.api.ConfigRegistry;
import net.xstopho.resourcelibrary.event.LootTableModifierCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrackerConstants {
    public static final String MOD_ID = "resource_cracker";
    public static final String MOD_NAME = "Resource Cracker/Tools";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void commonInit() {
        ConfigRegistry.register(ToolConfig.class, MOD_ID);
        ConfigRegistry.register(LootConfig.class, MOD_ID);

        BlockRegistry.init();
        ItemRegistry.init();
        CreativeTabRegistry.init();

        LootModifier.init();

        LootTableModifierCallback.MODIFY.register(itemStack -> {
            if (itemStack.getItem() instanceof CrackHammerItem hammer) {
                addDurability(itemStack, hammer.getDurability());
            }

            if (itemStack.getItem() instanceof ChiselItem chisel) {
                addDurability(itemStack, chisel.getDurability());
            }
        });
    }

    private static void addDurability(ItemStack stack, int durability) {
        stack.set(DataComponents.MAX_DAMAGE, durability);
        stack.set(DataComponents.MAX_STACK_SIZE, 1);
        stack.set(DataComponents.DAMAGE, 0);
    }

    public static void clientInit() {
        ItemModelRenderRegistry.init();
    }
}
