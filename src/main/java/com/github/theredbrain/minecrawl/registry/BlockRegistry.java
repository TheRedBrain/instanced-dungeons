package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.mergeditems.block.ItemMergingBlock;
import com.github.theredbrain.minecrawl.Minecrawl;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

import java.util.List;

public class BlockRegistry {

	public static final Block ITEM_MERGING_BLOCK_LEVEL_1 = registerBlock(
			"item_merging_block_level_1",
			new ItemMergingBlock(
					1,
					"gui.item_merging.title",
					List.of(
							Minecrawl.identifier("item_merging/rings")
					),
					Block.Settings.create().mapColor(MapColor.OAK_TAN).requiresTool().strength(-1.0f, 3600000.0f).nonOpaque().dropsNothing()
			), ItemGroupRegistry.MINECRAWL_BLOCKS);
	public static final Block ITEM_MERGING_BLOCK_LEVEL_2 = registerBlock(
			"item_merging_block_level_2",
			new ItemMergingBlock(
					1,
					"gui.item_merging.title",
					List.of(
							Minecrawl.identifier("item_merging/rings"),
							Minecrawl.identifier("item_merging/gloves"),
							Minecrawl.identifier("item_merging/necklaces")
					),
					Block.Settings.create().mapColor(MapColor.OAK_TAN).requiresTool().strength(-1.0f, 3600000.0f).nonOpaque().dropsNothing()
			), ItemGroupRegistry.MINECRAWL_BLOCKS);
	public static final Block ITEM_MERGING_BLOCK_LEVEL_3 = registerBlock(
			"item_merging_block_level_3",
			new ItemMergingBlock(
					1,
					"gui.item_merging.title",
					List.of(
							Minecrawl.identifier("item_merging/rings"),
							Minecrawl.identifier("item_merging/gloves"),
							Minecrawl.identifier("item_merging/necklaces"),
							Minecrawl.identifier("item_merging/belts"),
							Minecrawl.identifier("item_merging/shoulders")
					),
					Block.Settings.create().mapColor(MapColor.OAK_TAN).requiresTool().strength(-1.0f, 3600000.0f).nonOpaque().dropsNothing()
			), ItemGroupRegistry.MINECRAWL_BLOCKS);
	public static final Block ITEM_MERGING_BLOCK_LEVEL_4 = registerBlock(
			"item_merging_block_level_4",
			new ItemMergingBlock(
					1,
					"gui.item_merging.title",
					List.of(
							Minecrawl.identifier("item_merging/rings"),
							Minecrawl.identifier("item_merging/gloves"),
							Minecrawl.identifier("item_merging/necklaces"),
							Minecrawl.identifier("item_merging/belts"),
							Minecrawl.identifier("item_merging/shoulders"),
							Minecrawl.identifier("item_merging/boots"),
							Minecrawl.identifier("item_merging/leggings")
					),
					Block.Settings.create().mapColor(MapColor.OAK_TAN).requiresTool().strength(-1.0f, 3600000.0f).nonOpaque().dropsNothing()
			), ItemGroupRegistry.MINECRAWL_BLOCKS);
	public static final Block ITEM_MERGING_BLOCK_LEVEL_5 = registerBlock(
			"item_merging_block_level_5",
			new ItemMergingBlock(
					1,
					"gui.item_merging.title",
					List.of(
							Minecrawl.identifier("item_merging/rings"),
							Minecrawl.identifier("item_merging/gloves"),
							Minecrawl.identifier("item_merging/necklaces"),
							Minecrawl.identifier("item_merging/belts"),
							Minecrawl.identifier("item_merging/shoulders"),
							Minecrawl.identifier("item_merging/boots"),
							Minecrawl.identifier("item_merging/leggings"),
							Minecrawl.identifier("item_merging/chests"),
							Minecrawl.identifier("item_merging/hats")
					),
					Block.Settings.create().mapColor(MapColor.OAK_TAN).requiresTool().strength(-1.0f, 3600000.0f).nonOpaque().dropsNothing()
			), ItemGroupRegistry.MINECRAWL_BLOCKS);
	public static final Block ITEM_MERGING_BLOCK_LEVEL_6 = registerBlock(
			"item_merging_block_level_6",
			new ItemMergingBlock(
					1,
					"gui.item_merging.title",
					List.of(
							Minecrawl.identifier("item_merging/rings"),
							Minecrawl.identifier("item_merging/gloves"),
							Minecrawl.identifier("item_merging/necklaces"),
							Minecrawl.identifier("item_merging/belts"),
							Minecrawl.identifier("item_merging/shoulders"),
							Minecrawl.identifier("item_merging/boots"),
							Minecrawl.identifier("item_merging/leggings"),
							Minecrawl.identifier("item_merging/chests"),
							Minecrawl.identifier("item_merging/hats"),
							Minecrawl.identifier("item_merging/weapons")
					),
					Block.Settings.create().mapColor(MapColor.OAK_TAN).requiresTool().strength(-1.0f, 3600000.0f).nonOpaque().dropsNothing()
			), ItemGroupRegistry.MINECRAWL_BLOCKS);

	private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> itemGroup) {
		Registry.register(Registries.ITEM, Minecrawl.identifier(name), new BlockItem(block, new Item.Settings()));
		ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(block));
		return Registry.register(Registries.BLOCK, Minecrawl.identifier(name), block);
	}

	public static void init() {
	}
}
