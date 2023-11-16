package net.xstopho.resource_cracker.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.world.entity.player.Player;
import net.xstopho.resource_cracker.registries.AttributeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {

    @Inject(method = "getPickRange", at = @At("HEAD"), cancellable = true)
    public void getPickRange(CallbackInfoReturnable<Float> cir) {
        Player player = Minecraft.getInstance().player;

        cir.setReturnValue((float) AttributeRegistry.getValue(player, AttributeRegistry.ATTACK_RANGE));
    }
}
