package net.sleepykairo.dwarfmod.mixin;

import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreen.class)
public class AnvilScreenMixin {
//	@Redirect(method = "drawForeground", at = @At(value = "FIELD", target = ""))
//	private void init(CallbackInfo info) {
//		// This code is injected into the start of MinecraftServer.loadWorld()V
//	}

}