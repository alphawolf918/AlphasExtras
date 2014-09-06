package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class RedRockBricks extends Block {
	public RedRockBricks(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("redrockbrick");
		this.setStepSound(Block.soundStoneFootstep);
		this.setHardness(5F);
		this.setResistance(6F);
		this.setTextureName("awei:redrockbrick");
	}
}