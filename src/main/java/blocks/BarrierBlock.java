package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class BarrierBlock extends Block {
	public BarrierBlock(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("barrier");
		this.setTextureName("awei:barrierblock");
		this.setBlockUnbreakable();
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}