package alphaitems.blocks.venus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class VenusStone extends Block {
	public VenusStone(int par1Id) {
		super(par1Id, Material.rock);
		this.setCreativeTab(ModTabs.venusTab);
		this.setUnlocalizedName("venusRock");
		this.setTextureName("awei:venusrock");
		this.setHardness(1.4F);
		this.setResistance(6.5F);
		this.setStepSound(Block.soundStoneFootstep);
	}
}