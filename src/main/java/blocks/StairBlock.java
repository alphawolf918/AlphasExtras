package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import alphaitems.creativetabs.ModTabs;

public class StairBlock extends BlockStairs {
	public StairBlock(int par1, Block par2Block, int par3) {
		super(par1, par2Block, par3);
		this.setCreativeTab(ModTabs.aiTab);
	}
}