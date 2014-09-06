package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;
import alphaitems.items.Items;

public class HeartBlock extends Block {
	
	public HeartBlock(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("heartblock");
		this.setResistance(10.0F);
		this.setHardness(8.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setTextureName("awei:heartblock");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 4);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Items.heart.itemID;
	}
}