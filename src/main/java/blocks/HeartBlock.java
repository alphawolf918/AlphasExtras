package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.items.Items;
import alphaitems.lib.EnumToolClass;
import alphaitems.lib.Methods;

public class HeartBlock extends Block {
	
	public HeartBlock(int par1) {
		super(par1, Material.rock);
		Methods.setTab(this);
		this.setUnlocalizedName("heartblock");
		Methods.setBlockRH(this, 10.0F, 8.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setTextureName("awei:heartblock");
		Methods.ForgeSetToolClass(this, "pickaxe", EnumToolClass.AMARANTH);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Items.heart.itemID;
	}
}