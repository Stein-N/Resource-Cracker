package net.xstopho.resource_cracker.mixin;

import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.entity.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemRenderer.class)
public interface ItemRendererAccessor {
    @Accessor("itemModelShaper")
    ItemModelShaper getItemModelShaper();
}
