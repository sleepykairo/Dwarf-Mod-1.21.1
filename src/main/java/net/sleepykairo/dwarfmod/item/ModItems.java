package net.sleepykairo.dwarfmod.item;

import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sleepykairo.dwarfmod.DwarfMod;
import net.sleepykairo.dwarfmod.item.custom.MithrilMinecartItem;

public class ModItems {

    public static final Item MITHRIL_INGOT = registerItem("mithril_ingot", new Item(new Item.Settings()));
    public static final Item MITHRIL_SWORD = registerItem(
            "mithril_sword",
            new SwordItem(
                    ModToolMaterials.MITHRIL, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(
                            ModToolMaterials.MITHRIL, 3, -2.4F))
            )
    );
    public static final Item MITHRIL_SHOVEL = registerItem(
            "mithril_shovel",
            new ShovelItem(
                    ModToolMaterials.MITHRIL, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(
                            ModToolMaterials.MITHRIL, 1.5F, -3.0F))
            )
    );
    public static final Item MITHRIL_PICKAXE = registerItem(
            "mithril_pickaxe",
            new PickaxeItem(
                    ModToolMaterials.MITHRIL, new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MITHRIL, 1.0F, -2.8F))
            )
    );
    public static final Item MITHRIL_AXE = registerItem(
            "mithril_axe",
            new AxeItem(
                    ModToolMaterials.MITHRIL, new Item.Settings().fireproof().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.MITHRIL, 5.0F, -3.0F))
            )
    );
    public static final Item MITHRIL_HOE = registerItem(
            "mithril_hoe",
            new HoeItem(
                    ModToolMaterials.MITHRIL, new Item.Settings().fireproof().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MITHRIL, -4.0F, 0.0F))
            )
    );
    public static final Item MITHRIL_MINECART = registerItem("mithril_minecart", new MithrilMinecartItem(AbstractMinecartEntity.Type.CHEST, new Item.Settings()));

    public static final Item MITHRIL_HELMET = registerItem(
            "mithril_helmet",
            new ArmorItem(ModArmorMaterials.MITHRIL, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37)))
    );
    public static final Item MITHRIL_CHESTPLATE = registerItem(
            "mithril_chestplate",
            new ArmorItem(ModArmorMaterials.MITHRIL, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37)))
    );
    public static final Item MITHRIL_LEGGINGS = registerItem(
            "mithril_leggings",
            new ArmorItem(ModArmorMaterials.MITHRIL, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37)))
    );
    public static final Item MITHRIL_BOOTS = registerItem(
            "mithril_boots",
            new ArmorItem(ModArmorMaterials.MITHRIL, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37)))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(DwarfMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DwarfMod.LOGGER.info("Registering Mod Items for " + DwarfMod.MOD_ID + "!");
    }
}
