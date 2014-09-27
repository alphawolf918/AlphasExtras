package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.lib.Methods;

public class AmaranthBlock extends Block {
	public AmaranthBlock(int par1) {
		super(par1, Material.rock);
		Methods.setTab(this);
		this.setUnlocalizedName("blockAmaranth");
		Methods.setBlockRH(this, 3.5F, 4.5F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setTextureName("awei:amaranthblock");
	}
}