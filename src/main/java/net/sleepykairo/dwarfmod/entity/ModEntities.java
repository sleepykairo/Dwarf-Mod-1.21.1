package net.sleepykairo.dwarfmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sleepykairo.dwarfmod.DwarfMod;
import net.sleepykairo.dwarfmod.entity.custom.MithrilMinecartEntity;

public class ModEntities {
    public static final EntityType<MithrilMinecartEntity> MITHRIL_MINECART_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(DwarfMod.MOD_ID, "mithril_minecart"),
            EntityType.Builder.<MithrilMinecartEntity>create(MithrilMinecartEntity::new, SpawnGroup.CREATURE).
                    dimensions(0.98f, 0.75f).passengerAttachments(0.1875F).makeFireImmune().maxTrackingRange(8).build("mithril_minecart")
    );
    public static final EntityType<BlackPowderTntEntity> BLACK_POWDER_TNT_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(DwarfMod.MOD_ID, "black_powder_tnt"),
            EntityType.Builder.<BlackPowderTntEntity>create(BlackPowderTntEntity::new, SpawnGroup.MISC)
            .makeFireImmune()
            .dimensions(0.98F, 0.98F)
            .eyeHeight(0.15F)
            .maxTrackingRange(10)
            .trackingTickInterval(10).build("black_powder_tnt")
    );

    public static void registerModEntities() {
        DwarfMod.LOGGER.info("Registering Entities for " + DwarfMod.MOD_ID + "!!!");
    }
}
