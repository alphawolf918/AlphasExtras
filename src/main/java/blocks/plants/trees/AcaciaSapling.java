package alphaitems.blocks.plants.trees;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;
import alphaitems.worldgen.WorldGenAcaciaTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AcaciaSapling extends BlockSapling
{
	public static final String[] WOOD_TYPES = new String[] { "acacia" };
	@SideOnly(Side.CLIENT)
	private Icon[] saplingIcon;
	
	public AcaciaSapling(int par1)
	{
		super(par1);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F,
				0.5F + f);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("acaciasapling");
		this.setHardness(0.0F);
		this.setResistance(0.0F);
		this.setStepSound(Block.soundGrassFootstep);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random)
	{
		if (!par1World.isRemote)
		{
			super.updateTick(par1World, par2, par3, par4, par5Random);
			
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9
					&& par5Random.nextInt(7) == 0)
			{
				this.markOrGrowMarked(par1World, par2, par3, par4,
						par5Random);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}
	
	@Override
	public void markOrGrowMarked(World par1World, int par2, int par3,
			int par4,
			Random par5Random)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		
		if ((l & 8) == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8,
					4);
		}
		else
		{
			this.growTree(par1World, par2, par3, par4, par5Random);
		}
	}
	
	/**
	 * Determines if the same sapling is present at the given location.
	 */
	@Override
	public boolean isSameSapling(World par1World, int par2, int par3,
			int par4,
			int par5)
	{
		return par1World.getBlockId(par2, par3, par4) == this.blockID
				&& (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
	}
	
	@Override
	public void growTree(World par1World, int par2, int par3, int par4,
			Random par5Random)
	{
		par1World.setBlock(par2, par3, par4, 0);
		(new WorldGenAcaciaTree()).generate(par1World, par5Random, par2,
				par3, par4);
	}
	
	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int par1)
	{
		return par1 & 3;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
			List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister
				.registerIcon("awei:acaciasapling");
	}
}