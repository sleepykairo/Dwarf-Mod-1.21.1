package net.sleepykairo.dwarfmod;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.client.render.entity.MinecartEntityRenderer;
import net.minecraft.client.render.entity.TntEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.MinecartEntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.util.Identifier;
import net.sleepykairo.dwarfmod.entity.ModEntities;
import net.sleepykairo.dwarfmod.entity.client.BlackPowderTntEntityRenderer;
import net.sleepykairo.dwarfmod.entity.client.MithrilMinecartEntityModel;
import net.sleepykairo.dwarfmod.entity.client.MithrilMinecartEntityRenderer;
import net.sleepykairo.dwarfmod.entity.client.ModModelLayers;

import java.util.Map;

public class DwarfModClient implements ClientModInitializer {

    public static final EntityModelLayer MITHRIL_MINECART_MODEL_LAYER = new EntityModelLayer(Identifier.of(DwarfMod.MOD_ID, "mithril_minecart"), "main");

    @Override
    public void onInitializeClient() {
        DwarfMod.LOGGER.info("Initializing Client DwarfMod!");

        EntityRendererRegistry.register(ModEntities.MITHRIL_MINECART_ENTITY, (ctx -> new MithrilMinecartEntityRenderer(ctx, MITHRIL_MINECART_MODEL_LAYER)));
        EntityRendererRegistry.register(ModEntities.BLACK_POWDER_TNT_ENTITY, (BlackPowderTntEntityRenderer::new));

        EntityModelLayerRegistry.registerModelLayer(MITHRIL_MINECART_MODEL_LAYER, MithrilMinecartEntityModel::getTexturedModelData);
    }
}
