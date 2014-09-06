package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;

public class NetherDirt extends Block {
	public NetherDirt(int par1) {
		super(par1, Material.grass);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("netherdirt");
		this.setHardness(0.2F);
		this.setResistance(0.5F);
		this.setTextureName("awei:netherdirt");
		this.setStepSound(Block.soundGravelFootstep);
		MinecraftForge.setBlockHarvestLevel(this, "shovel", 2);
	}
	
	@Override
	public boolean canSustainPlant(World world, int x, int y, int z,
			ForgeDirection direction, IPlantable plant)
	{
		int plantID = plant.getPlantID(world, x, y + 1, z);
		EnumPlantType plantType = plant.getPlantType(world, x, y + 1, z);
		if (plantType == EnumPlantType.Nether) {
			return true;
		}
		return false;
	}
}