package net.sleepykairo.dwarfmod.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.sleepykairo.dwarfmod.DwarfMod;
import net.sleepykairo.dwarfmod.block.custom.BlackPowderTntBlock;

public class ModBlocks {

    public static final Block MITHRIL_BLOCK = registerBlock("mithril_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block MITHRIL_ORE = registerBlock("mithril_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(5, 10), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block DEEPSLATE_MITHRIL_ORE = registerBlock("deepslate_mithril_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(5, 10), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final Block BLACK_POWDER_TNT = registerBlock(
            "black_powder_tnt",
            new BlackPowderTntBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.BLACK).breakInstantly().sounds(BlockSoundGroup.GRASS).burnable().solidBlock(Blocks::never)
            )
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DwarfMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DwarfMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DwarfMod.LOGGER.info("Registering Mod Blocks for " + DwarfMod.MOD_ID + "!!!");
    }
}
