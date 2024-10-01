package net.sleepykairo.dwarfmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sleepykairo.dwarfmod.DwarfMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_MITHRIL_TOOL = createTag("incorrect_for_mithril_tool");
        public static final TagKey<Block> INCORRECT_FOR_COBALT_TOOL = createTag("incorrect_for_cobalt_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(DwarfMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(DwarfMod.MOD_ID, name));
        }
    }
}
