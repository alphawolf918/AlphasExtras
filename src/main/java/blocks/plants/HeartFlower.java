package alphaitems.blocks.plants;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;
import alphaitems.items.Items;

public class HeartFlower extends BlockFlower {
	
	public HeartFlower(int par1) {
		super(par1, Material.grass);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("heartflower");
		this.setTextureName("awei:heartflower");
		this.setResistance(0F);
		this.setHardness(0F);
		this.setStepSound(Block.soundGrassFootstep);
	}
	
	@Override
	public int idDropped(int par1, Random par2, int par3) {
		return (par2.nextInt(10) > 8) ? Items.heart.itemID
				: this.blockID;
	}
}