package alphaitems.blocks.venus.ores;

import net.minecraft.block.material.Material;
import alphaitems.blocks.venus.BlockVenusBase;

public class VenusBronzeOre extends BlockVenusBase {
	public VenusBronzeOre(int par1) {
		super(par1, Material.rock);
		this.setUnlocalizedName("venusbronzeore");
		this.setTextureName("awei:venusbronzeore");
		this.setBlockBreakXp(56);
	}
}