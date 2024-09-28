package net.sleepykairo.dwarfmod.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public abstract class EntityAccessMixin {
    @Shadow protected boolean touchingWater;
}
