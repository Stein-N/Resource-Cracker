package net.xstopho.resource_cracker.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.stophoslib.registration.RegistryObject;
import net.xstopho.stophoslib.registration.RegistryProvider;

public class AttributeRegistry {

    private static final RegistryProvider<Attribute> ATTRIBUTES = RegistryProvider.get(Registries.ATTRIBUTE, Constants.MOD_ID);

    public static final RegistryObject<Attribute> ATTACK_RANGE = register("attack_range",
            new RangedAttribute("attribute.resource_cracker.attack_range", 4.5, 0.0, 1024.0).setSyncable(true));

    private static RegistryObject<Attribute> register(String id, Attribute attribute) {
        return ATTRIBUTES.register(id, () -> attribute);
    }

    public static void init() {}
}
