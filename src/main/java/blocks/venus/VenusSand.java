package alphaitems.blocks.venus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class VenusSand extends Block {
	
	public VenusSand(int par1) {
		super(par1, Material.grass);
		this.setCreativeTab(ModTabs.aiTab);
		this.setStepSound(Block.soundGrassFootstep);
		this.setHardness(0.5F);
		this.setUnlocalizedName("venusSand");
		this.setTextureName("awei:venussand");
	}
}