package com.github.theredbrain.minecrawl.mixin.item;

import com.github.theredbrain.minecrawl.registry.ItemRegistry;
import com.github.theredbrain.spellengineextension.SpellEngineExtension;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public class ItemStackMixin {

	@Inject(
			method = "appendAttributeModifierTooltip",
			at = @At("HEAD"),
			cancellable = true
	)
	private void minecrawl$appendAttributeModifierTooltip(Consumer<Text> textConsumer, @Nullable PlayerEntity player, RegistryEntry<EntityAttribute> attribute, EntityAttributeModifier modifier, CallbackInfo ci) {
		if (player != null) {
			if (attribute == SpellEngineExtension.GENERIC_MAGIC_DAMAGE && modifier.idMatches(ItemRegistry.MAIN_HAND_GENERIC_MAGIC_DAMAGE_MODIFIER_ID) && modifier.operation().equals(EntityAttributeModifier.Operation.ADD_VALUE)) {
				double value = modifier.value() + player.getAttributeBaseValue(SpellEngineExtension.GENERIC_MAGIC_DAMAGE);
				this.appendAttributeModifiedBaseValueTooltip(textConsumer, attribute, modifier, value);
				ci.cancel();
			}

			if (attribute == EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE && modifier.idMatches(ItemRegistry.MAIN_HAND_PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID) && modifier.operation().equals(EntityAttributeModifier.Operation.ADD_VALUE)) {
				double value = modifier.value() + player.getAttributeBaseValue(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE);
				this.appendAttributeModifiedBaseValueTooltip(textConsumer, attribute, modifier, value);
				ci.cancel();
			}
		}

	}

	@Unique
	private void appendAttributeModifiedBaseValueTooltip(Consumer<Text> textConsumer, RegistryEntry<EntityAttribute> attribute, EntityAttributeModifier modifier, double decimalValue) {
		textConsumer.accept(
				ScreenTexts.space()
						.append(
								Text.translatable(
										"attribute.modifier.equals." + modifier.operation().getId(),
										AttributeModifiersComponent.DECIMAL_FORMAT.format(decimalValue),
										Text.translatable(attribute.value().getTranslationKey())
								)
						)
						.formatted(Formatting.DARK_GREEN)
		);
	}
}
