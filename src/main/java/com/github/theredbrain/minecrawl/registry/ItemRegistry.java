package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.mergeditems.MergedItems;
import com.github.theredbrain.mergeditems.component.type.ItemMergingUtilityComponent;
import com.github.theredbrain.mergeditems.component.type.MergedItemsComponent;
import com.github.theredbrain.minecrawl.Minecrawl;
import com.github.theredbrain.spellengineextension.SpellEngineExtension;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsAttributeModifiersComponent;
import net.fabric_extras.ranged_weapon.api.CustomBow;
import net.fabric_extras.ranged_weapon.api.EntityAttributes_RangedWeapon;
import net.fabric_extras.ranged_weapon.api.RangedConfig;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ItemRegistry {
	public static final Identifier MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID = Minecrawl.identifier("main_hand_player_entity_interaction_range");
	public static final Identifier MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID = Minecrawl.identifier("main_hand_generic_magic_damage");
	public static final Identifier RING_1_PULL_TIME_MODIFIER_ID = Minecrawl.identifier("ring_1/ring_pull_time");
	public static final Identifier RING_2_PULL_TIME_MODIFIER_ID = Minecrawl.identifier("ring_2/ring_pull_time");
	public static final boolean ADD_UNCOMMON_ITEMS_TO_ITEM_GROUPS = Minecrawl.generalServerConfig.add_uncommon_items_to_item_groups;
	public static final boolean ADD_RARE_ITEMS_TO_ITEM_GROUPS = Minecrawl.generalServerConfig.add_rare_items_to_item_groups;
	public static final boolean ADD_EPIC_ITEMS_TO_ITEM_GROUPS = Minecrawl.generalServerConfig.add_epic_items_to_item_groups;

	// Item
	public static Item[] registerItemSet(String id, String possible_merging_items, AttributeModifiersComponent[] attributeModifiersComponents, RegistryKey<ItemGroup> itemGroup) {
		if (attributeModifiersComponents.length != 4) {
			return new Item[]{};
		}
		return new Item[]{
				registerItem(id + "_common", new Item(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.COMMON)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.attributeModifiers(attributeModifiersComponents[0])
						),
						itemGroup
				),
				registerItem(id + "_uncommon", new Item(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.UNCOMMON)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.attributeModifiers(attributeModifiersComponents[1])
						),
						ADD_UNCOMMON_ITEMS_TO_ITEM_GROUPS ? itemGroup : null
				),
				registerItem(id + "_rare", new Item(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.RARE)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.attributeModifiers(attributeModifiersComponents[2])
						),
						ADD_RARE_ITEMS_TO_ITEM_GROUPS ? itemGroup : null
				),
				registerItem(id + "_epic", new Item(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.EPIC)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.attributeModifiers(attributeModifiersComponents[3])
						),
						ADD_EPIC_ITEMS_TO_ITEM_GROUPS ? itemGroup : null
				)
		};
	}

	// --- main hand weapons ---
	//region curved dagger
	public static final Item[] CURVED_DAGGERS = registerItemSet(
			"curved_dagger",
			"minecrawl:possible_merging_items/for_curved_daggers",
			new AttributeModifiersComponent[]{
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											3.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											-0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											6.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											-0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											9.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											-0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											12.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											-0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build()
			},
			ItemGroupRegistry.MINECRAWL_WEAPONS
	);
	//endregion curved dagger
	//region short sword
	public static final Item[] SHORT_SWORDS = registerItemSet(
			"short_sword",
			"minecrawl:possible_merging_items/for_short_swords",
			new AttributeModifiersComponent[]{
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											3.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.4F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											6.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.4F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											9.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.4F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											12.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.4F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build()
			},
			ItemGroupRegistry.MINECRAWL_WEAPONS
	);
	//endregion short sword
	//region long sword
	public static final Item[] LONG_SWORDS = registerItemSet(
			"long_sword",
			"minecrawl:possible_merging_items/for_long_swords",
			new AttributeModifiersComponent[]{
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											3.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.4F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											6.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.4F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											9.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.4F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											12.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.4F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build()
			},
			ItemGroupRegistry.MINECRAWL_WEAPONS
	);
	//endregion long sword
	//region gnarly staff
	public static final Item[] GNARLY_STAFFS = registerItemSet(
			"gnarly_staff",
			"minecrawl:possible_merging_items/for_gnarly_staffs",
			new AttributeModifiersComponent[]{
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											2.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(SpellEngineExtension.GENERIC_MAGIC_DAMAGE,
									new EntityAttributeModifier(
											MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID,
											3.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-3.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											1.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											2.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(SpellEngineExtension.GENERIC_MAGIC_DAMAGE,
									new EntityAttributeModifier(
											MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID,
											6.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-3.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											1.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											2.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(SpellEngineExtension.GENERIC_MAGIC_DAMAGE,
									new EntityAttributeModifier(
											MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID,
											9.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-3.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											1.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											2.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(SpellEngineExtension.GENERIC_MAGIC_DAMAGE,
									new EntityAttributeModifier(
											MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID,
											12.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-3.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											1.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build()
			},
			ItemGroupRegistry.MINECRAWL_WEAPONS
	);
	//endregion gnarly staff
	//region ashen staff
	public static final Item[] ASHEN_STAFFS = registerItemSet(
			"ashen_staff",
			"minecrawl:possible_merging_items/for_ashen_staffs",
			new AttributeModifiersComponent[]{
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											2.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(SpellEngineExtension.GENERIC_MAGIC_DAMAGE,
									new EntityAttributeModifier(
											MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID,
											3.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-3.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											1.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											2.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(SpellEngineExtension.GENERIC_MAGIC_DAMAGE,
									new EntityAttributeModifier(
											MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID,
											6.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-3.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											1.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											2.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(SpellEngineExtension.GENERIC_MAGIC_DAMAGE,
									new EntityAttributeModifier(
											MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID,
											9.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-3.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											1.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											2.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(SpellEngineExtension.GENERIC_MAGIC_DAMAGE,
									new EntityAttributeModifier(
											MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID,
											12.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-3.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											1.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build()
			},
			ItemGroupRegistry.MINECRAWL_WEAPONS
	);
	//endregion ashen staff

	// --- offhand weapons ---
	//region throwing dagger
	public static final Item[] THROWING_DAGGERS = registerItemSet(
			"throwing_dagger",
			"minecrawl:possible_merging_items/for_throwing_daggers",
			new AttributeModifiersComponent[]{
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											3.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											-0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											6.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											-0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											9.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											-0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build(),
					AttributeModifiersComponent.builder()
							.add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
											12.0,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.GENERIC_ATTACK_SPEED,
									new EntityAttributeModifier(
											Item.BASE_ATTACK_SPEED_MODIFIER_ID,
											-2.0F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
									new EntityAttributeModifier(
											MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID,
											-0.5F,
											EntityAttributeModifier.Operation.ADD_VALUE
									), AttributeModifierSlot.MAINHAND)
							.build()
			},
			ItemGroupRegistry.MINECRAWL_WEAPONS
	);
	//endregion throwing dagger

	// CustomBow
	public static Item[] registerCustomBowSet(String id, String possible_merging_items, AttributeModifiersComponent[] attributeModifiersComponents, RangedConfig[] rangedConfigs, RegistryKey<ItemGroup> itemGroup) {
		if (attributeModifiersComponents.length != 4 || rangedConfigs.length != 4) {
			return new Item[]{};
		}
		return new Item[]{
				registerItem(id + "_common", new CustomBow(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.COMMON)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.attributeModifiers(attributeModifiersComponents[0]),
								rangedConfigs[0],
								() -> Ingredient.EMPTY
						),
						itemGroup
				),
				registerItem(id + "_uncommon", new CustomBow(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.UNCOMMON)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.attributeModifiers(attributeModifiersComponents[1]),
								rangedConfigs[1],
								() -> Ingredient.EMPTY
						),
						ADD_UNCOMMON_ITEMS_TO_ITEM_GROUPS ? itemGroup : null
				),
				registerItem(id + "_rare", new CustomBow(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.RARE)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.attributeModifiers(attributeModifiersComponents[2]),
								rangedConfigs[2],
								() -> Ingredient.EMPTY
						),
						ADD_RARE_ITEMS_TO_ITEM_GROUPS ? itemGroup : null
				),
				registerItem(id + "_epic", new CustomBow(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.EPIC)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.attributeModifiers(attributeModifiersComponents[3]),
								rangedConfigs[3],
								() -> Ingredient.EMPTY
						),
						ADD_EPIC_ITEMS_TO_ITEM_GROUPS ? itemGroup : null
				)
		};
	}
	//region short bow
	public static final Item[] SHORT_BOWS = registerCustomBowSet(
			"short_bow",
			"minecrawl:possible_merging_items/for_short_bows",
			new AttributeModifiersComponent[]{
					AttributeModifiersComponent.builder()
							.build(),
					AttributeModifiersComponent.builder()
							.build(),
					AttributeModifiersComponent.builder()
							.build(),
					AttributeModifiersComponent.builder()
							.build()
			},
			new RangedConfig[]{
					new RangedConfig(3.0F, -0.2F, 0.0F),
					new RangedConfig(6.0F, -0.2F, 0.0F),
					new RangedConfig(9.0F, -0.2F, 0.0F),
					new RangedConfig(12.0F, -0.2F, 0.0F),
			},
			ItemGroupRegistry.MINECRAWL_WEAPONS
	);
	//endregion short bow
	//region long bow
	public static final Item[] LONG_BOWS = registerCustomBowSet(
			"long_bow",
			"minecrawl:possible_merging_items/for_long_bows",
			new AttributeModifiersComponent[]{
					AttributeModifiersComponent.builder()
							.build(),
					AttributeModifiersComponent.builder()
							.build(),
					AttributeModifiersComponent.builder()
							.build(),
					AttributeModifiersComponent.builder()
							.build()
			},
			new RangedConfig[]{
					new RangedConfig(6.0F, 0.6F, 0.0F),
					new RangedConfig(12.0F, 0.6F, 0.0F),
					new RangedConfig(18.0F, 0.6F, 0.0F),
					new RangedConfig(24.0F, 0.6F, 0.0F),
			},
			ItemGroupRegistry.MINECRAWL_WEAPONS
	);
	//endregion long bow

	// --- trinkets ---
	public static Item[] registerTrinketSet(String id, String possible_merging_items, TrinketsAttributeModifiersComponent[] trinketsAttributeModifiersComponents, RegistryKey<ItemGroup> itemGroup) {
		if (trinketsAttributeModifiersComponents.length != 4) {
			return new Item[]{};
		}
		return new Item[]{
				registerItem(id + "_common", new TrinketItem(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.COMMON)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.component(TrinketsAttributeModifiersComponent.TYPE, trinketsAttributeModifiersComponents[0])
						),
						itemGroup
				),
				registerItem(id + "_uncommon", new TrinketItem(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.UNCOMMON)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.component(TrinketsAttributeModifiersComponent.TYPE, trinketsAttributeModifiersComponents[1])
						),
						ADD_UNCOMMON_ITEMS_TO_ITEM_GROUPS ? itemGroup : null
				),
				registerItem(id + "_rare", new TrinketItem(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.RARE)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.component(TrinketsAttributeModifiersComponent.TYPE, trinketsAttributeModifiersComponents[2])
						),
						ADD_RARE_ITEMS_TO_ITEM_GROUPS ? itemGroup : null
				),
				registerItem(id + "_epic", new TrinketItem(new Item.Settings()
								.maxCount(1)
								.rarity(Rarity.EPIC)
								.component(MergedItems.ITEM_MERGING_UTILITY_COMPONENT_TYPE, new ItemMergingUtilityComponent(possible_merging_items))
								.component(MergedItems.MERGED_ITEMS_COMPONENT_TYPE, MergedItemsComponent.DEFAULT)
								.component(TrinketsAttributeModifiersComponent.TYPE, trinketsAttributeModifiersComponents[3])
						),
						ADD_EPIC_ITEMS_TO_ITEM_GROUPS ? itemGroup : null
				)
		};
	}
	// ring
	//region falcon ring
	public static final Item[] FALCON_RINGS = registerTrinketSet(
			"falcon_ring",
			"minecrawl:possible_merging_items/for_falcon_rings",
			new TrinketsAttributeModifiersComponent[]{
					TrinketsAttributeModifiersComponent.builder()
							.add(
									EntityAttributes_RangedWeapon.PULL_TIME.entry,
									new EntityAttributeModifier(
											RING_1_PULL_TIME_MODIFIER_ID,
											-0.05F,
											EntityAttributeModifier.Operation.ADD_VALUE
									),
									Optional.of("ring_1/ring")
							)
							.add(
									EntityAttributes_RangedWeapon.PULL_TIME.entry,
									new EntityAttributeModifier(
											RING_2_PULL_TIME_MODIFIER_ID,
											-0.05F,
											EntityAttributeModifier.Operation.ADD_VALUE
									),
									Optional.of("ring_2/ring")
							).build(),
					TrinketsAttributeModifiersComponent.builder()
							.add(
									EntityAttributes_RangedWeapon.PULL_TIME.entry,
									new EntityAttributeModifier(
											RING_1_PULL_TIME_MODIFIER_ID,
											-0.1F,
											EntityAttributeModifier.Operation.ADD_VALUE
									),
									Optional.of("ring_1/ring")
							)
							.add(
									EntityAttributes_RangedWeapon.PULL_TIME.entry,
									new EntityAttributeModifier(
											RING_2_PULL_TIME_MODIFIER_ID,
											-0.1F,
											EntityAttributeModifier.Operation.ADD_VALUE
									),
									Optional.of("ring_2/ring")
							).build(),
					TrinketsAttributeModifiersComponent.builder()
							.add(
									EntityAttributes_RangedWeapon.PULL_TIME.entry,
									new EntityAttributeModifier(
											RING_1_PULL_TIME_MODIFIER_ID,
											-0.15F,
											EntityAttributeModifier.Operation.ADD_VALUE
									),
									Optional.of("ring_1/ring")
							)
							.add(
									EntityAttributes_RangedWeapon.PULL_TIME.entry,
									new EntityAttributeModifier(
											RING_2_PULL_TIME_MODIFIER_ID,
											-0.15F,
											EntityAttributeModifier.Operation.ADD_VALUE
									),
									Optional.of("ring_2/ring")
							).build(),
					TrinketsAttributeModifiersComponent.builder()
							.add(
									EntityAttributes_RangedWeapon.PULL_TIME.entry,
									new EntityAttributeModifier(
											RING_1_PULL_TIME_MODIFIER_ID,
											-0.2F,
											EntityAttributeModifier.Operation.ADD_VALUE
									),
									Optional.of("ring_1/ring")
							)
							.add(
									EntityAttributes_RangedWeapon.PULL_TIME.entry,
									new EntityAttributeModifier(
											RING_2_PULL_TIME_MODIFIER_ID,
											-0.2F,
											EntityAttributeModifier.Operation.ADD_VALUE
									),
									Optional.of("ring_2/ring")
							).build()
			},
			ItemGroupRegistry.MINECRAWL_ACCESSORIES
	);
	//endregion falcon ring

	/*
	//region weapons
	sword, series of slashes around wielder
	dagger, can be thrown (spell)
		fast, low damage attack
		when crit system: high crit chance
		when precision/evasion system: high precision
	mace, calls a heavenly strike
	great hammer, casts a shock wave around wielder
	wand, casts a fireball

	//endregion weapons
	//region armor
	epic belt that increases hotbar size


	epic chest piece that increases food slots
		"It's as if you eat for two..."
	//endregion armor

	// --- attributes ---
	minecraft:max_health
	minecraft:armor
	minecraft:armor_toughness
	minecraft:attack_damage
	minecraft:attack_knockback
	minecraft:attack_speed
	minecraft:burning_time
	minecraft:explosion_knockback_resistance
	minecraft:knockback_resistance
	minecraft:luck
	minecraft:movement_efficiency
	minecraft:movement_speed
	minecraft:safe_fall_distance
	minecraft:scale
	minecraft:sneaking_speed
	minecraft:step_height
	minecraft:entity_interaction_range

	ranged_weapon_api:damage
	ranged_weapon_api:pull_time
	ranged_weapon_api:haste
	ranged_weapon_api:velocity

	rpginventory:magic_damage
	rpginventory:health_spell_cost_multiplier
	rpginventory:mana_spell_cost_multiplier
	rpginventory:stamina_spell_cost_multiplier
	rpginventory:extra_launch_count
	rpginventory:extra_launch_delay
	rpginventory:extra_velocity
	rpginventory:extra_ricochet
	rpginventory:extra_ricochet_range
	rpginventory:extra_bounce
	rpginventory:extra_pierce
	rpginventory:extra_chain_reaction_size
	rpginventory:extra_chain_reaction_triggers

	manaattributes:max_mana
	manaattributes:mana_regeneration
	manaattributes:mana_tick_threshold
	manaattributes:mana_regeneration_delay_threshold
	manaattributes:depleted_mana_regeneration_delay_threshold

	staminaattributes:max_stamina
	staminaattributes:stamina_regeneration
	staminaattributes:stamina_tick_threshold
	staminaattributes:stamina_regeneration_delay_threshold
	staminaattributes:depleted_stamina_regeneration_delay_threshold

	healthregenerationoverhaul:health_regeneration
	healthregenerationoverhaul:health_tick_threshold
	healthregenerationoverhaul:health_regeneration_delay_threshold

	overhauleddamage:additional_bashing_damage
	overhauleddamage:increased_bashing_damage
	overhauleddamage:bashing_resistance
	overhauleddamage:additional_piercing_damage
	overhauleddamage:increased_piercing_damage
	overhauleddamage:piercing_resistance
	overhauleddamage:additional_slashing_damage
	overhauleddamage:increased_slashing_damage
	overhauleddamage:slashing_resistance
	overhauleddamage:blocked_physical_damage
	overhauleddamage:max_bleeding_build_up
	overhauleddamage:bleeding_duration
	overhauleddamage:bleeding_tick_threshold
	overhauleddamage:bleeding_build_up_reduction
	overhauleddamage:additional_frost_damage
	overhauleddamage:increased_frost_damage
	overhauleddamage:blocked_frost_damage
	overhauleddamage:frost_resistance
	overhauleddamage:max_freeze_build_up
	overhauleddamage:freeze_duration
	overhauleddamage:freeze_tick_threshold
	overhauleddamage:freeze_build_up_reduction
	overhauleddamage:additional_fire_damage
	overhauleddamage:increased_fire_damage
	overhauleddamage:blocked_fire_damage
	overhauleddamage:fire_resistance
	overhauleddamage:max_burn_build_up
	overhauleddamage:burn_duration // redundant with minecraft:burning_time ?
	overhauleddamage:burn_tick_threshold
	overhauleddamage:burn_build_up_reduction
	overhauleddamage:additional_lightning_damage
	overhauleddamage:increased_lightning_damage
	overhauleddamage:blocked_lightning_damage
	overhauleddamage:lightning_resistance
	overhauleddamage:max_shock_build_up
	overhauleddamage:shock_duration
	overhauleddamage:shock_tick_threshold
	overhauleddamage:shock_build_up_reduction
	overhauleddamage:additional_poison_damage
	overhauleddamage:increased_poison_damage
	overhauleddamage:blocked_poison_damage
	overhauleddamage:poison_resistance
	overhauleddamage:max_poison_build_up
	overhauleddamage:poison_duration
	overhauleddamage:poison_tick_threshold
	overhauleddamage:poison_build_up_reduction
	overhauleddamage:max_stagger_build_up
	overhauleddamage:stagger_duration
	overhauleddamage:stagger_tick_threshold
	overhauleddamage:stagger_build_up_reduction
	overhauleddamage:block_force
	overhauleddamage:parry_bonus
	overhauleddamage:parry_window
	overhauleddamage:parry_stamina_cost
	overhauleddamage:damage_taken_from_mana_multiplier
	overhauleddamage:damage_taken_from_stamina_multiplier

	bettercombatextension:attack_stamina_cost

	spellengineextension:active_spell_slot_amount

	equipmentweight:equipment_weight
	equipmentweight:max_equipment_weight

	combatroll:distance
	combatroll:recharge
	combatroll:count

	combatrollextension:roll_invulnerable_ticks
	combatrollextension:roll_stamina_cost

	inventorysizeattributes:hotbar_slot_amount
	inventorysizeattributes:inventory_slot_amount

	backpackattribute:backpack_capacity

	foodoverhaul:max_food_effects

	spell_power:haste

	 */

	private static Item registerItem(String name, Item item, @Nullable RegistryKey<ItemGroup> itemGroup) {

		if (itemGroup != null) {
			ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> {
				content.add(item);
			});
		}
		return Registry.register(Registries.ITEM, Minecrawl.identifier(name), item);
	}

	public static void init() {
	}
}
