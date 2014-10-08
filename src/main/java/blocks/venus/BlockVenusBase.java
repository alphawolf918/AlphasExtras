package alphaitems.blocks.venus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;

public class BlockVenusBase extends Block {
	
	private int blockBreakXP = 66;
	private String blockTexture = null;
	
	public BlockVenusBase(int par1) {
		this(par1, Material.rock);
	}
	
	public BlockVenusBase(int par1, Material par2) {
		super(par1, par2);
		this.setCreativeTab(ModTabs.venusTab);
		this.setHardness(1.4F);
		this.setResistance(4.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z,
			int meta) {
		this.dropXpOnBlockBreak(world, x, y, z, blockBreakXP);
	}
	
	public void setBlockBreakXp(int xp) {
		this.blockBreakXP = xp;
	}
	
	public int getBlockBreakXp() {
		return this.blockBreakXP;
	}
	
	public void setBlockTexture(String str) {
		this.blockTexture = "awei:" + str;
	}
	
	public String getBlockTexture() {
		return this.blockTexture;
	}
}