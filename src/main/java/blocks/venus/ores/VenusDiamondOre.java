package alphaitems.blocks.venus.ores;

import net.minecraft.block.material.Material;
import alphaitems.blocks.venus.BlockVenusBase;

public class VenusDiamondOre extends BlockVenusBase {
	public VenusDiamondOre(int par1) {
		super(par1, Material.rock);
		this.setUnlocalizedName("venusDiamondOre");
		this.setTextureName("awei:venusdiamondore");
		this.setBlockBreakXp(86);
	}
}