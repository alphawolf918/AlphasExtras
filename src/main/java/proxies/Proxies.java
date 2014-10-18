package alphaitems.proxies;

import alphaitems.lib.ModInfo;
import cpw.mods.fml.common.SidedProxy;

public class Proxies {
	
	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy",
			serverSide = ModInfo.PROXY_LOCATION
					+ ".CommonProxy")
	public static CommonProxy proxy;
	
	public static void init() {
		proxy.initRenderers();
		proxy.initSounds();
	}
}