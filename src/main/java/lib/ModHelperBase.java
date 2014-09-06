package alphaitems.lib;

import cpw.mods.fml.common.Loader;

public class ModHelperBase {
	
	public static boolean useCofh;
	public static boolean useBuildcraftTools;
	public static boolean useBuildcraftTransport;
	
	public void register() {
	}
	
	public static void detectMods() {
		useCofh = Loader.isModLoaded("CoFHCore");
		
	}
}