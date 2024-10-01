package net.sleepykairo.dwarfmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sleepykairo.dwarfmod.DwarfMod;
import net.sleepykairo.dwarfmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup DWARFMOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DwarfMod.MOD_ID, "dwarfmod_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MITHRIL_HELMET))
                    .displayName(Text.translatable("itemgroup.dwarfmod.dwarfmod_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MITHRIL_INGOT);
                        entries.add(ModItems.RAW_MITHRIL);
                        entries.add(ModItems.MITHRIL_SWORD);
                        entries.add(ModItems.MITHRIL_SHOVEL);
                        entries.add(ModItems.MITHRIL_PICKAXE);
                        entries.add(ModItems.MITHRIL_AXE);
                        entries.add(ModItems.MITHRIL_HOE);
                        entries.add(ModItems.MITHRIL_HELMET);
                        entries.add(ModItems.MITHRIL_CHESTPLATE);
                        entries.add(ModItems.MITHRIL_LEGGINGS);
                        entries.add(ModItems.MITHRIL_BOOTS);
                        entries.add(ModItems.MITHRIL_MINECART);
                        entries.add(ModBlocks.MITHRIL_BLOCK);
                        entries.add(ModBlocks.MITHRIL_ORE);
                        entries.add(ModBlocks.DEEPSLATE_MITHRIL_ORE);
                    }).build());

    public static void registerItemGroups() {
        DwarfMod.LOGGER.info("Registering Item Groups for " + DwarfMod.MOD_ID + "!!!");
    }
}
