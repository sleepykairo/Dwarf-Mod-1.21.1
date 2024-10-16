package net.sleepykairo.dwarfmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Arm;
import net.sleepykairo.dwarfmod.block.ModBlocks;
import net.sleepykairo.dwarfmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MITHRIL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MITHRIL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MITHRIL_ORE);

        blockStateModelGenerator.registerSingleton(ModBlocks.BLACK_POWDER_TNT, TexturedModel.CUBE_BOTTOM_TOP);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MITHRIL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MITHRIL_MINECART, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MITHRIL, Models.GENERATED);

        itemModelGenerator.register(ModItems.MITHRIL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MITHRIL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MITHRIL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MITHRIL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MITHRIL_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.MITHRIL_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MITHRIL_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MITHRIL_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MITHRIL_BOOTS);
    }
}
