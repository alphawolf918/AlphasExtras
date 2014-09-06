package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import alphaitems.creativetabs.ModTabs;

public class Brimstone extends Block {
	public Brimstone(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("brimstone");
		this.setTextureName("awei:brimstone");
		this.setHardness(4.0F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z,
			int metadata,
			ForgeDirection side) {
		return true;
	}
	
	public static void setBurnProperties(int id, int encouragement,
			int flammability)
	{
		blockFireSpreadSpeed[id] = encouragement;
		blockFlammability[id] = flammability;
	}
}