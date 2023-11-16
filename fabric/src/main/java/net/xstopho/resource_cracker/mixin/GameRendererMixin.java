package net.xstopho.resource_cracker.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.player.Player;
import net.xstopho.resource_cracker.registries.AttributeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @ModifyConstant(method = "pick", constant = @Constant(doubleValue = 3.0))
    public double injected(double constant) {
        Player player = Minecraft.getInstance().player;

        return AttributeRegistry.getValue(player, AttributeRegistry.ATTACK_RANGE);
    }
}
