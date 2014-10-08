package alphaitems.blocks.venus.ores;

import net.minecraft.block.material.Material;
import alphaitems.blocks.venus.BlockVenusBase;

public class VenusGoldOre extends BlockVenusBase {
	public VenusGoldOre(int par1) {
		super(par1, Material.rock);
		this.setUnlocalizedName("venusGoldOre");
		this.setTextureName("awei:venusgoldore");
		this.setBlockBreakXp(76);
	}
}