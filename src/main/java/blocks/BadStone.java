package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class BadStone extends Block {
	public BadStone(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("awei:badstone");
		this.setHardness(1.6F);
		this.setResistance(5.0F);
		this.setTextureName("awei:badstone");
	}
}