package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class CanyonRock extends Block {
	public CanyonRock(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("canyonrock");
		this.setTextureName("awei:canyonrock");
		this.setHardness(1.4F);
		this.setResistance(9.9F);
		this.setStepSound(Block.soundStoneFootstep);
	}
}