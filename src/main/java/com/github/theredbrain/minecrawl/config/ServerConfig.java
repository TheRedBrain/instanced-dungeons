package com.github.theredbrain.minecrawl.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(
		name = "scriptblocks"
)
public class ServerConfig extends PartitioningSerializer.GlobalData {
	@ConfigEntry.Category("general_server")
	@ConfigEntry.Gui.Excluded
	public GeneralServerConfig server = new GeneralServerConfig();

	public ServerConfig() {
	}

	@Config(
			name = "general_server"
	)
	public static class GeneralServerConfig implements ConfigData {
		@Comment("When set to 'false', uncommon items are not visible in the creative menu")
		public boolean add_uncommon_items_to_item_groups = false;
		@Comment("When set to 'false', rare items are not visible in the creative menu")
		public boolean add_rare_items_to_item_groups = false;
		@Comment("When set to 'false', epic items are not visible in the creative menu")
		public boolean add_epic_items_to_item_groups = false;
//		@Comment("When set to 'false', melding items will add all their modifiers. When set to 'true', similar modifiers (same id, same slot, same operation) will be averaged.")
//		public boolean melding_averages_similar_modifiers = true;

		public GeneralServerConfig() {

		}
	}

}
