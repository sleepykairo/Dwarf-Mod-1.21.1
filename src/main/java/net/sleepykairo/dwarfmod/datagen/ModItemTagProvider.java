package net.sleepykairo.dwarfmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.ItemTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.sleepykairo.dwarfmod.block.ModBlocks;
import net.sleepykairo.dwarfmod.item.ModItems;
import net.sleepykairo.dwarfmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.MITHRIL_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.MITHRIL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.MITHRIL_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.MITHRIL_HOE);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.MITHRIL_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.MITHRIL_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.MITHRIL_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.MITHRIL_BOOTS);
    }
}
