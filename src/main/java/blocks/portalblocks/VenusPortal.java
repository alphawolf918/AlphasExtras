package alphaitems.blocks.portalblocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import alphaitems.dimensions.teleporter.TeleporterVenus;
import alphaitems.dimensions.venus.Venus;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VenusPortal extends BlockPortal {
	
	public VenusPortal(int par1) {
		super(par1);
		this.setTickRandomly(true);
		this.setUnlocalizedName("venusportal");
		this.setLightValue(1F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random)
	{
		if (par5Random.nextInt(100) == 0)
		{
			par1World.playSound(par2 + 0.8D, par3 + 0.8D, par4 + 0.8D,
					"awei:portal.portalsound", 0.8F,
					par5Random.nextFloat() * 0.6F + 1.0F, false);
		}
		
		for (int l = 0; l < 4; ++l)
		{
			double d0 = par2 + par5Random.nextFloat();
			double d1 = par3 + par5Random.nextFloat();
			double d2 = par4 + par5Random.nextFloat();
			double d3 = 0.0D;
			double d4 = 1.5D;
			double d5 = 0.0D;
			int i1 = par5Random.nextInt(2) * 2 - 1;
			d3 = (par5Random.nextFloat() - 0.5D) * 0.5D;
			d4 = (par5Random.nextFloat() - 1.5D) * 1.5D;
			d5 = (par5Random.nextFloat() - 0.5D) * 0.5D;
			
			if (par1World.getBlockId(par2 - 1, par3, par4) != this.blockID
					&& par1World.getBlockId(par2 + 1, par3, par4) != this.blockID)
			{
				d0 = par2 + 1.5D + 0.45D * i1;
				d3 = par5Random.nextFloat() * 4.0F * i1;
			}
			else
			{
				d2 = par4 + 0.5D + 0.45D * i1;
				d5 = par5Random.nextFloat() * 2.0F * i1;
			}
			
			par1World.spawnParticle("portal", 0.5F, 1.0F, 0.5F, 0.5F,
					1.0F,
					0.5F);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "venusportal");
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random)
	{
	}
	
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2,
			int par3,
			int par4, Entity par5Entity)
	{
		if ((par5Entity.ridingEntity == null)
				&& (par5Entity.riddenByEntity == null)
				&& ((par5Entity instanceof EntityPlayerMP)))
		{
			EntityPlayerMP player = (EntityPlayerMP) par5Entity;
			ModLoader.getMinecraftServerInstance();
			MinecraftServer mServer = MinecraftServer.getServer();
			
			if (player.timeUntilPortal > 0)
			{
				player.timeUntilPortal = 10;
			}
			else if (player.dimension != Venus.dimId)
			{
				player.timeUntilPortal = 10;
				
				player.mcServer
						.getConfigurationManager()
						.transferPlayerToDimension(
								player,
								Venus.dimId,
								new TeleporterVenus(
										mServer.worldServerForDimension(Venus.dimId)));
			}
			else
			{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager()
						.transferPlayerToDimension(
								player,
								0,
								new TeleporterVenus(mServer
										.worldServerForDimension(1)));
			}
		}
	}
	
	/**
	 * Checks to see if this location is valid to create a portal and will
	 * return True if it does. Args: world, x, y, z
	 */
	
	@Override
	public boolean tryToCreatePortal(World par1World, int par2, int par3,
			int par4)
	{
		byte b0 = 0;
		byte b1 = 0;
		
		if (par1World.getBlockId(par2 - 1, par3, par4) == Block.obsidian.blockID
				|| par1World.getBlockId(par2 + 1, par3, par4) == Block.obsidian.blockID)
		{
			b0 = 1;
		}
		
		if (par1World.getBlockId(par2, par3, par4 - 1) == Block.obsidian.blockID
				|| par1World.getBlockId(par2, par3, par4 + 1) == Block.obsidian.blockID)
		{
			b1 = 1;
		}
		
		if (b0 == b1)
		{
			return false;
		}
		else
		{
			if (par1World.isAirBlock(par2 - b0, par3, par4 - b1))
			{
				par2 -= b0;
				par4 -= b1;
			}
			
			int l;
			int i1;
			
			for (l = -1; l <= 2; ++l)
			{
				for (i1 = -1; i1 <= 3; ++i1)
				{
					boolean flag = l == -1 || l == 2 || i1 == -1
							|| i1 == 3;
					
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
					{
						int j1 = par1World.getBlockId(par2 + b0 * l, par3
								+ i1,
								par4 + b1 * l);
						boolean isAirBlock = par1World.isAirBlock(
								par2 + b0 * l, par3 + i1, par4 + b1 * l);
						
						if (flag)
						{
							if (j1 != Block.obsidian.blockID)
							{
								return false;
							}
						}
						else if (!isAirBlock && j1 != Block.fire.blockID)
						{
							return false;
						}
					}
				}
			}
			
			for (l = 0; l < 2; ++l)
			{
				for (i1 = 0; i1 < 3; ++i1)
				{
					par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1
							* l,
							this.blockID, 0, 2);
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, int par5)
	{
	}
	
}