package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import alphaitems.creativetabs.ModTabs;

public class RedRock extends BlockStone {
	public RedRock(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setHardness(1.6F);
		this.setResistance(10F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setUnlocalizedName("redrock");
		this.setTextureName("awei:redrock");
	}
	
	@Override
	public int idDropped(int i, Random random, int j) {
		return Blocks.redCobble.blockID;
	}
}