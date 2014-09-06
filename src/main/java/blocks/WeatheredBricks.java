package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class WeatheredBricks extends Block {
	public WeatheredBricks(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("weatheredbricks");
		this.setTextureName("awei:weatheredbricks");
		this.setHardness(0.4F);
		this.setResistance(0.5F);
		this.setStepSound(Block.soundStoneFootstep);
	}
}