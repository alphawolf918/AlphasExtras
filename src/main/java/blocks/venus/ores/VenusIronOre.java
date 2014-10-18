package alphaitems.blocks.venus.ores;

import net.minecraft.block.material.Material;
import alphaitems.blocks.venus.BlockVenusBase;

public class VenusIronOre extends BlockVenusBase {
	public VenusIronOre(int par1) {
		super(par1, Material.rock);
		this.setUnlocalizedName("venusironoreblock");
		this.setTextureName("awei:venusironore");
	}
}