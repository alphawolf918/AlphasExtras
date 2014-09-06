package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class AmaranthNetherOre extends Block {
	
	public AmaranthNetherOre(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("oreAmaranthNether");
		this.setHardness(4.5F);
		this.setResistance(3.5F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setTextureName("awei:amaranthnetherore");
	}
}