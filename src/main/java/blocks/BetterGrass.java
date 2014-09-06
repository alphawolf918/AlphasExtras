package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BetterGrass extends Block {
	public BetterGrass(int par1) {
		super(par1, Material.ground);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("bettergrass");
		this.setTickRandomly(true);
		this.setHardness(0.4F);
		this.setTextureName("awei:bettergrass2");
		this.setStepSound(Block.soundGrassFootstep);
		MinecraftForge.setBlockHarvestLevel(this, "shovel", 0);
		this.setLightOpacity(255);
	}
	
	@Override
	public boolean canSustainPlant(World world, int x, int y, int z,
			ForgeDirection direction, IPlantable plant)
	{
		int plantID = plant.getPlantID(world, x, y + 1, z);
		EnumPlantType plantType = plant.getPlantType(world, x, y + 1, z);
		if (plantType == EnumPlantType.Plains) {
			return true;
		}
		return false;
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random)
	{
		if (!par1World.isRemote)
		{
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4
					&& par1World
							.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
			{
				par1World.setBlock(par2, par3, par4, Block.dirt.blockID);
			}
			else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
			{
				for (int l = 0; l < 4; ++l)
				{
					int i1 = par2 + par5Random.nextInt(3) - 1;
					int j1 = par3 + par5Random.nextInt(5) - 3;
					int k1 = par4 + par5Random.nextInt(3) - 1;
					int l1 = par1World.getBlockId(i1, j1 + 1, k1);
					
					if (par1World.getBlockId(i1, j1, k1) == Block.dirt.blockID
							&& par1World
									.getBlockLightValue(i1, j1 + 1, k1) >= 4
							&& par1World.getBlockLightOpacity(i1, j1 + 1,
									k1) <= 2)
					{
						par1World.setBlock(i1, j1, k1, this.blockID);
					}
				}
			}
		}
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return Block.dirt.idDropped(0, par2Random, par3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerGrass.getGrassColor(d0, d1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int par1)
	{
		return this.getBlockColor();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4)
	{
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		
		for (int k1 = -1; k1 <= 1; ++k1)
		{
			for (int l1 = -1; l1 <= 1; ++l1)
			{
				int i2 = par1IBlockAccess.getBiomeGenForCoords(par2 + l1,
						par4 + k1).getBiomeGrassColor();
				l += (i2 & 16711680) >> 16;
				i1 += (i2 & 65280) >> 8;
				j1 += i2 & 255;
			}
		}
		
		return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
	}
}