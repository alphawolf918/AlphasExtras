package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class AmaranthEnderOre extends Block {
	
	public AmaranthEnderOre(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("oreAmaranthEnder");
		this.setTextureName("awei:amaranthenderore");
		this.setHardness(4.8F);
		this.setResistance(6.8F);
		this.setStepSound(Block.soundStoneFootstep);
	}
}