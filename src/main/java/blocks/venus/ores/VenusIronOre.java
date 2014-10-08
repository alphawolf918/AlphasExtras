package alphaitems.blocks.venus.ores;

import alphaitems.blocks.venus.BlockVenusBase;
import net.minecraft.block.material.Material;

public class VenusIronOre extends BlockVenusBase {
	public VenusIronOre(int par1) {
		super(par1, Material.rock);
		this.setUnlocalizedName("venusIronOreBlock");
		this.setTextureName("awei:venusironore");
	}
}