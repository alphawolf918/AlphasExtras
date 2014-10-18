package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class ColdSand extends BlockSand {
	
	public ColdSand(int par1) {
		super(par1, Material.sand);
		this.setCreativeTab(ModTabs.aiTab);
		this.setStepSound(Block.soundSandFootstep);
		this.setHardness(0.5F);
		this.setUnlocalizedName("coldsand");
		this.setTextureName("awei:coldsand");
	}
}