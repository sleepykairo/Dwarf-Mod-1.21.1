package net.sleepykairo.dwarfmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.sleepykairo.dwarfmod.entity.ModEntities;
import net.sleepykairo.dwarfmod.entity.client.MithrilMinecartEntityRenderer;

public class DwarfModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DwarfMod.LOGGER.info("Initializing Client DwarfMod!");

        EntityRendererRegistry.register(ModEntities.MITHRIL_MINECART_ENTITY, MithrilMinecartEntityRenderer::new);
    }
}
