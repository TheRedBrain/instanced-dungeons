package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.minecrawl.Minecrawl;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class ItemGroupRegistry {
	public static final RegistryKey<ItemGroup> MINECRAWL_ACCESSORIES = RegistryKey.of(RegistryKeys.ITEM_GROUP, Minecrawl.identifier("minecrawl_accessories"));
	public static final RegistryKey<ItemGroup> MINECRAWL_BLOCKS = RegistryKey.of(RegistryKeys.ITEM_GROUP, Minecrawl.identifier("minecrawl_blocks"));
	public static final RegistryKey<ItemGroup> MINECRAWL_WEAPONS = RegistryKey.of(RegistryKeys.ITEM_GROUP, Minecrawl.identifier("minecrawl_weapons"));

	public static void init() {
		Registry.register(Registries.ITEM_GROUP, MINECRAWL_ACCESSORIES, FabricItemGroup.builder()
				.icon(() -> new ItemStack(ItemRegistry.FALCON_RINGS[0]))
				.displayName(Text.translatable("itemGroup.minecrawl.minecrawl_accessories"))
				.build());
		Registry.register(Registries.ITEM_GROUP, MINECRAWL_BLOCKS, FabricItemGroup.builder()
				.icon(() -> new ItemStack(BlockRegistry.ITEM_MERGING_BLOCK_LEVEL_1))
				.displayName(Text.translatable("itemGroup.minecrawl.minecrawl_blocks"))
				.build());
		Registry.register(Registries.ITEM_GROUP, MINECRAWL_WEAPONS, FabricItemGroup.builder()
				.icon(() -> new ItemStack(ItemRegistry.CURVED_DAGGERS[0]))
				.displayName(Text.translatable("itemGroup.minecrawl.minecrawl_weapons"))
				.build());
	}
}
