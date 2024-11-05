package com.github.theredbrain.minecrawl;

import com.github.theredbrain.minecrawl.registry.ClientPacketRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.spell_engine.api.render.CustomModels;

import java.util.List;
import java.util.Optional;

public class MinecrawlClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		CustomModels.registerModelIds(List.of(
				Minecrawl.identifier("projectile/generic_projectile")
		));

		// Packets
		ClientPacketRegistry.init();

		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(Minecrawl.MOD_ID);
		modContainer.ifPresent(container -> ResourceManagerHelper.registerBuiltinResourcePack(Minecrawl.identifier("rename_entity_interaction_range"), container, ResourcePackActivationType.DEFAULT_ENABLED));

	}
}