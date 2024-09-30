package net.sleepykairo.dwarfmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.MinecartEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.MinecartEntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.util.Identifier;
import net.sleepykairo.dwarfmod.entity.ModEntities;
import net.sleepykairo.dwarfmod.entity.client.MithrilMinecartEntityModel;
import net.sleepykairo.dwarfmod.entity.client.MithrilMinecartEntityRenderer;
import net.sleepykairo.dwarfmod.entity.client.ModModelLayers;

public class DwarfModClient implements ClientModInitializer {
    public static final EntityModelLayer MITHRIL_MINECART_MODEL_LAYER = new EntityModelLayer(Identifier.of(DwarfMod.MOD_ID, "mithril_minecart"), "main");

    @Override
    public void onInitializeClient() {
        DwarfMod.LOGGER.info("Initializing Client DwarfMod!");

        EntityRendererRegistry.register(ModEntities.MITHRIL_MINECART_ENTITY, (ctx -> new MithrilMinecartEntityRenderer(ctx, MITHRIL_MINECART_MODEL_LAYER)));

        EntityModelLayerRegistry.registerModelLayer(MITHRIL_MINECART_MODEL_LAYER, MithrilMinecartEntityModel::getTexturedModelData);
    }
}
