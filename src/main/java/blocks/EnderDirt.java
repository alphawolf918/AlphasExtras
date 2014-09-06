package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;

public class EnderDirt extends Block {
	public EnderDirt(int par1) {
		super(par1, Material.grass);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("enderdirt");
		this.setHardness(0.6F);
		this.setResistance(1.0F);
		this.setTextureName("awei:enderdirt");
		this.setStepSound(Block.soundGravelFootstep);
		MinecraftForge.setBlockHarvestLevel(this, "shovel", 2);
	}
	
	@Override
	public boolean canSustainPlant(World world, int x, int y, int z,
			ForgeDirection direction, IPlantable plant)
	{
		int plantID = plant.getPlantID(world, x, y + 1, z);
		return (plantID == Blocks.enderPlant.blockID);
	}
}