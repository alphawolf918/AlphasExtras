package alphaitems.blocks.venus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class VenusSand extends Block {
	
	public VenusSand(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.venusTab);
		this.setUnlocalizedName("venussand");
		this.setStepSound(Block.soundStoneFootstep);
		this.setHardness(0.5F);
		this.setTextureName("awei:venussand");
	}
}