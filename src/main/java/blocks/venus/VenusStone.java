package alphaitems.blocks.venus;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.blocks.Blocks;
import alphaitems.creativetabs.ModTabs;

public class VenusStone extends Block {
	public VenusStone(int par1Id) {
		super(par1Id, Material.rock);
		this.setCreativeTab(ModTabs.venusTab);
		this.setUnlocalizedName("venusrock");
		this.setTextureName("awei:venusrock");
		this.setHardness(1.4F);
		this.setResistance(6.5F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Blocks.venusCobble.blockID;
	}
}