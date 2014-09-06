package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import alphaitems.creativetabs.ModTabs;

public class RedCobble extends BlockStone {
	public RedCobble(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setHardness(2.0F);
		this.setResistance(10F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setUnlocalizedName("redcobble");
		this.setTextureName("awei:redcobble");
	}
}