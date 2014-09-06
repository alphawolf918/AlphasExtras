package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class AmaranthBlock extends Block {
	public AmaranthBlock(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("blockAmaranth");
		this.setHardness(3.5F);
		this.setResistance(4.5F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setTextureName("awei:amaranthblock");
	}
}