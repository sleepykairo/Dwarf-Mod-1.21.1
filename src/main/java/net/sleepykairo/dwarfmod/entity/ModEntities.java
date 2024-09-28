package net.sleepykairo.dwarfmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sleepykairo.dwarfmod.DwarfMod;
import net.sleepykairo.dwarfmod.entity.custom.MithrilMinecartEntity;

public class ModEntities {
    public static final EntityType<MithrilMinecartEntity> MITHRIL_MINECART_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(DwarfMod.MOD_ID, "mithril_minecart"),
            EntityType.Builder.create(MithrilMinecartEntity::new, SpawnGroup.CREATURE).
                    dimensions(0.98f, 0.75f).passengerAttachments(0.1875F).maxTrackingRange(8).build("mithril_minecart")
    );

    public static void registerModEntities() {
        DwarfMod.LOGGER.info("Registering Entities for " + DwarfMod.MOD_ID + "!");
    }
}
