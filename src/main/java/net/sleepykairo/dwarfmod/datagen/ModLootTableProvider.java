package net.sleepykairo.dwarfmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.sleepykairo.dwarfmod.block.ModBlocks;
import net.sleepykairo.dwarfmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MITHRIL_ORE, block -> oreDropsNoFortune(ModBlocks.MITHRIL_ORE, ModItems.RAW_MITHRIL));
        addDrop(ModBlocks.DEEPSLATE_MITHRIL_ORE, block -> oreDropsNoFortune(ModBlocks.DEEPSLATE_MITHRIL_ORE, ModItems.RAW_MITHRIL));
        addDrop(ModBlocks.MITHRIL_BLOCK);
    }

    public LootTable.Builder oreDropsNoFortune(Block withSilkTouch, Item withoutSilkTouch) {
//        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return dropsWithSilkTouch(
                withSilkTouch,
                applyExplosionDecay(
                        withSilkTouch, ItemEntry.builder(withoutSilkTouch)));
    }
}
