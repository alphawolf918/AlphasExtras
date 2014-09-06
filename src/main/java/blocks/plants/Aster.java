package alphaitems.blocks.plants;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class Aster extends BlockFlower {
	
	public Aster(int par1) {
		super(par1, Material.grass);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("aster");
		this.setTextureName("awei:aster");
		this.setResistance(0F);
		this.setHardness(0F);
		this.setStepSound(Block.soundGrassFootstep);
	}
}