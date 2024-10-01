package net.sleepykairo.dwarfmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.sleepykairo.dwarfmod.block.ModBlocks;
import net.sleepykairo.dwarfmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> MITHRIL_SMELTABLES = List.of(ModItems.RAW_MITHRIL, ModBlocks.MITHRIL_ORE, ModBlocks.DEEPSLATE_MITHRIL_ORE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.MITHRIL_MINECART)
                .pattern("OOO")
                .pattern("MCM")
                .pattern("OOO")
                .input('M', ModItems.MITHRIL_INGOT)
                .input('C', Items.MINECART)
                .input('O', Blocks.OBSIDIAN)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MITHRIL_SWORD)
                .pattern(" M ")
                .pattern(" M ")
                .pattern(" S ")
                .input('M', ModItems.MITHRIL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MITHRIL_SHOVEL)
                .pattern(" M ")
                .pattern(" S ")
                .pattern(" S ")
                .input('M', ModItems.MITHRIL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MITHRIL_PICKAXE)
                .pattern("MMM")
                .pattern(" S ")
                .pattern(" S ")
                .input('M', ModItems.MITHRIL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MITHRIL_AXE)
                .pattern("MM ")
                .pattern("MS ")
                .pattern(" S ")
                .input('M', ModItems.MITHRIL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MITHRIL_HOE)
                .pattern("MM ")
                .pattern(" S ")
                .pattern(" S ")
                .input('M', ModItems.MITHRIL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MITHRIL_HELMET)
                .pattern("MMM")
                .pattern("M M")
                .pattern("   ")
                .input('M', ModItems.MITHRIL_INGOT)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MITHRIL_CHESTPLATE)
                .pattern("M M")
                .pattern("MMM")
                .pattern("MMM")
                .input('M', ModItems.MITHRIL_INGOT)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MITHRIL_LEGGINGS)
                .pattern("MMM")
                .pattern("M M")
                .pattern("M M")
                .input('M', ModItems.MITHRIL_INGOT)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MITHRIL_BOOTS)
                .pattern("   ")
                .pattern("M M")
                .pattern("M M")
                .input('M', ModItems.MITHRIL_INGOT)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);

        //blocks

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MITHRIL_BLOCK);

        //smelting/other

        offerSmelting(exporter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 1.5f, 400, "mithril_ingot");
        offerBlasting(exporter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 1.5f, 200, "mithril_ingot");
    }
}
