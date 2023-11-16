package net.xstopho.resource_cracker.registries;

import net.fabricmc.fabric.mixin.object.builder.DefaultAttributeRegistryMixin;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import net.xstopho.resource_cracker.Constants;

public class AttributeRegistry {

    public static final Attribute ATTACK_RANGE = register("attack_range",
            new RangedAttribute("attribute.resource_cracker.attack_range", 3, 3, 1024.0D).setSyncable(true));

    private static Attribute register(String id, Attribute attribute) {
        return Registry.register(BuiltInRegistries.ATTRIBUTE, new ResourceLocation(Constants.MOD_ID, id), attribute);
    }

    public static double getValue(Player player, Attribute attribute) {
        if (contains(player, attribute)) {
            return attribute.getDefaultValue() +
                    player.getMainHandItem().getAttributeModifiers(EquipmentSlot.MAINHAND)
                            .get(attribute).stream().mapToDouble(AttributeModifier::getAmount).sum();
        }
        return 3.0;
    }

    public static boolean contains(Player player, Attribute attribute) {
        return player.getMainHandItem().getAttributeModifiers(EquipmentSlot.MAINHAND).containsKey(attribute);
    }
    public static void init() {

    }
}
