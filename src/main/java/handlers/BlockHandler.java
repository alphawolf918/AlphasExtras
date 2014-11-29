package alphaitems.handlers;

import alphaitems.blocks.plants.trees.acacia.AcaciaLog;
import alphaitems.blocks.renderers.RenderAcaciaLog;
import alphaitems.proxies.Proxies;

public class BlockHandler {
	public static void init() {
		AcaciaLog.setRenderId(Proxies.proxy
				.registerBlockHandler(new RenderAcaciaLog()));
	}
}