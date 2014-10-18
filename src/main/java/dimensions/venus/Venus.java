package alphaitems.dimensions.venus;

import net.minecraftforge.common.DimensionManager;
import alphaitems.dimensions.providers.WorldProviderVenus;

public class Venus {
	
	public static int dimId = DimensionManager.getNextFreeDimId();
	
	public static void init() {
		DimensionManager.registerProviderType(dimId,
				WorldProviderVenus.class,
				false);
		DimensionManager.registerDimension(dimId, dimId);
	}
}