package alphaitems.proxies;

import alphaitems.AlphaItemsMod;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkRegistry;

public class Proxies {
	
	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy",
			serverSide = ModInfo.PROXY_LOCATION
					+ ".CommonProxy")
	public static CommonProxy proxy;
	
	public static void init() {
		proxy.initRenderers();
		proxy.initSounds();
		proxy.registerKeyBindings();
		NetworkRegistry.instance().registerGuiHandler(
				AlphaItemsMod.INSTANCE, proxy);
	}
}