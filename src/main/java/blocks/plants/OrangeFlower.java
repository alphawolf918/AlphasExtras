package alphaitems.blocks.plants;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class OrangeFlower extends BlockFlower {
	
	public OrangeFlower(int par1) {
		super(par1, Material.grass);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("orangeflower");
		this.setTextureName("awei:orangeflower");
		this.setResistance(0F);
		this.setHardness(0F);
		this.setStepSound(Block.soundGrassFootstep);
	}
}