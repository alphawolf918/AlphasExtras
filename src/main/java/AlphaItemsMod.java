package alphaitems;

import alphaitems.biomes.Biomes;
import alphaitems.blocks.Blocks;
import alphaitems.creativetabs.ModTabs;
import alphaitems.events.Events;
import alphaitems.handlers.Handlers;
import alphaitems.items.Items;
import alphaitems.lib.ModInfo;
import alphaitems.lib.OreDict;
import alphaitems.lib.Recipes;
import alphaitems.mobs.Mobs;
import alphaitems.proxies.Proxies;
import alphaitems.treasures.Treasures;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = { ModInfo.CHANNEL }, clientSideRequired = true,
		serverSideRequired = true)
public class AlphaItemsMod {
	
	public static AlphaItemsMod INSTANCE;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		Proxies.init();
		Events.init();
		ModTabs.init();
		Biomes.init();
		Handlers.init();
		Items.init();
		Blocks.init();
		OreDict.init();
		Recipes.init();
		Treasures.init();
		Mobs.init();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
	}
}