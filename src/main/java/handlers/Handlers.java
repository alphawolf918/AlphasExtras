package alphaitems.handlers;

import alphaitems.managers.EventManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class Handlers {
	public static void init() {
		GameRegistry.registerFuelHandler(new SuperCoalFuelHandler());
		GameRegistry.registerWorldGenerator(new EventManager());
		BlockHandler.init();
	}
}