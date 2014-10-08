package alphaitems.blocks.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;

public class Tiles {
	public static void init() {
		GameRegistry
				.registerTileEntity(TileEntityAmpCell.class, "ampCell");
	}
}