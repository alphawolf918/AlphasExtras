package alphaitems.dimensions.venus;

import alphaitems.dimensions.providers.WorldProviderVenus;
import net.minecraftforge.common.DimensionManager;

public class Venus {
	
	public static int dimId = -21;
	
	public static void init() {
		DimensionManager.registerProviderType(dimId,
				WorldProviderVenus.class,
				false);
		DimensionManager.registerDimension(dimId, dimId);
	}
}