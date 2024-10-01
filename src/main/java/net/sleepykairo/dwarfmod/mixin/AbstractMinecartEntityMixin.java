package net.sleepykairo.dwarfmod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractMinecartEntity.class)
public abstract class AbstractMinecartEntityMixin extends EntityAccessMixin{

    @ModifyReturnValue(method = "getMaxSpeed", at = @At("RETURN"))
    private double inject(double original) {
        return ((touchingWater ? 4.0 : 8.0) / 20.0) * 1.5f;
    }
}