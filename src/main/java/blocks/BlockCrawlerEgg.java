package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.BlockDragonEgg;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;
import alphaitems.mobs.entities.EntitySpiderling;

public class BlockCrawlerEgg extends BlockDragonEgg
{
	
	public static int ticksExisted = 0;
	
	public BlockCrawlerEgg(int par1)
	{
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("crawleregg");
		this.setTextureName("awei:crawleregg");
		this.setBlockBounds(0.0525F, 0.0F, 0.0525F, 0.9475F, 1.0F, 0.9475F);
		this.setHardness(6.0F);
		this.setResistance(10.0F);
		this.setTickRandomly(true);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 4);
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);
		par1World.playSoundEffect(par2 + 1.5D, par3 + 1.5D, par4 + 1.5D,
				"awei:crawler.heartbeat", 1.5F,
				par1World.rand.nextFloat() * 0.1F + 0.9F);
		if (this.ticksExisted >= 100) {
			this.hatchSpider(par1World, par2, par3, par4);
			par1World.setBlock(par2, par3, par4, 0);
			ticksExisted = 0;
		} else {
			ticksExisted += 10;
		}
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2,
			int par3,
			int par4, int par5) {
		this.hatchSpider(par1World, par2, par3, par4);
	}
	
	public void hatchSpider(World world, int par2, int par3, int par4) {
		if ((new Random()).nextInt(10000) != 1) {
			for (int i = 1; i < (new Random()).nextInt(6); i++) {
				Entity spider = new EntitySpiderling(world);
				spider.setLocationAndAngles(par2 + i, par3 + i,
						par4 + i, spider.rotationYaw, spider.rotationPitch);
				world.spawnEntityInWorld(spider);
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		return true;
	}
	
	@Override
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return this.blockID;
	}
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3,
			int par4,
			EntityPlayer par5EntityPlayer) {
	}
}