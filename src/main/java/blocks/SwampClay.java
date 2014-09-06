package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;
import alphaitems.items.Items;

public class SwampClay extends Block {
	
	public SwampClay(int par1) {
		super(par1, Material.clay);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("swampclay");
		this.setHardness(1.5F);
		this.setResistance(0.1F);
		this.setStepSound(Block.soundGravelFootstep);
		this.setTextureName("awei:swampclay");
		MinecraftForge.setBlockHarvestLevel(this, "shovel", 0);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Items.swampClayBall.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 4;
	}
}