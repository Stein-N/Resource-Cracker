package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

    private static TagKey<Item> getTagKey(String id) {

        return TagKey.create(Registries.ITEM, location(id));
    }

    private static ResourceLocation location(String id) {
        return new ResourceLocation("forge", id);
    }
}
