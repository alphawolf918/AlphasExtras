package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class ColdSandstone extends Block {
	public ColdSandstone(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("coldsandsmooth");
		this.setTextureName("awei:coldsandsmooth");
		this.setResistance(4F);
		this.setHardness(4F);
		this.setStepSound(Block.soundStoneFootstep);
	}
}
