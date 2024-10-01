package net.sleepykairo.dwarfmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MITHRIL_MINECART)
                .pattern("OOO")
                .pattern("MCM")
                .pattern("OOO")
                .input('M', ModItems.MITHRIL_INGOT)
                .input('C', Items.MINECART)
                .input('O', Blocks.OBSIDIAN)
                .criterion(hasItem(ModItems.MITHRIL_INGOT), conditionsFromItem(ModItems.MITHRIL_INGOT))
                .offerTo(exporter);


        offerSmelting(exporter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 1.5f, 400, "mithril_ingot");
        offerBlasting(exporter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 1.5f, 200, "mithril_ingot");
    }
}
