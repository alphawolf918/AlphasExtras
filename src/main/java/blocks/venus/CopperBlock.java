package alphaitems.blocks.venus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class CopperBlock extends Block {
	public CopperBlock(int par1) {
		super(par1, Material.iron);
		this.setCreativeTab(ModTabs.venusTab);
		this.setUnlocalizedName("awei_copperBlock");
		this.setTextureName("awei:copperblock");
		this.setHardness(1.8F);
		this.setResistance(4.0F);
		this.setStepSound(Block.soundMetalFootstep);
	}
}