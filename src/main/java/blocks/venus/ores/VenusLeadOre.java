package alphaitems.blocks.venus.ores;

import net.minecraft.block.material.Material;
import alphaitems.blocks.venus.BlockVenusBase;

public class VenusLeadOre extends BlockVenusBase {
	public VenusLeadOre(int par1) {
		super(par1, Material.rock);
		this.setUnlocalizedName("venusleadore");
		this.setTextureName("awei:venusleadore");
		this.setBlockBreakXp(64);
	}
}