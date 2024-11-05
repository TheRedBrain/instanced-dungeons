package com.github.theredbrain.minecrawl;

import com.github.theredbrain.inventorysizeattributes.entity.player.DuckPlayerEntityMixin;
import com.github.theredbrain.minecrawl.config.ServerConfig;
import com.github.theredbrain.minecrawl.registry.BlockRegistry;
import com.github.theredbrain.minecrawl.registry.EventsRegistry;
import com.github.theredbrain.minecrawl.registry.ItemGroupRegistry;
import com.github.theredbrain.minecrawl.registry.ItemRegistry;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minecrawl implements ModInitializer {
	public static final String MOD_ID = "minecrawl";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ServerConfig.GeneralServerConfig generalServerConfig;

	public static final boolean isInventorySizeAttributesLoaded = FabricLoader.getInstance().isModLoaded("inventorysizeattributes");

	public static int getActiveInventorySize(PlayerEntity player) {
		return isInventorySizeAttributesLoaded ? ((DuckPlayerEntityMixin) player).inventorysizeattributes$getActiveInventorySlotAmount() : 27;
	}

	public static int getActiveHotbarSize(PlayerEntity player) {
		return isInventorySizeAttributesLoaded ? ((DuckPlayerEntityMixin) player).inventorysizeattributes$getActiveHotbarSlotAmount() : 9;
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Welcome to the Minecrawl dungeons!");

		// Config
		AutoConfig.register(ServerConfig.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
		generalServerConfig = ((ServerConfig) AutoConfig.getConfigHolder(ServerConfig.class).getConfig()).server;

		BlockRegistry.init();
		EventsRegistry.initializeEvents();
		ItemRegistry.init();
		ItemGroupRegistry.init();
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}