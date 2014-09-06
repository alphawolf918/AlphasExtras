package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WallBlock extends BlockWall
{
	
	public WallBlock(int par1, Block par2Block)
	{
		super(par1, par2Block);
		this.setHardness(par2Block.blockHardness);
		this.setResistance(par2Block.blockResistance / 3.0F);
		this.setStepSound(par2Block.stepSound);
		this.setCreativeTab(ModTabs.aiTab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2)
	{
		return Blocks.redCobble.getBlockTextureFromSide(par1);
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return 32;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean getBlocksMovement(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4)
	{
		return false;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4)
	{
		boolean flag = this.canConnectWallTo(par1IBlockAccess, par2, par3,
				par4 - 1);
		boolean flag1 = this.canConnectWallTo(par1IBlockAccess, par2,
				par3, par4 + 1);
		boolean flag2 = this.canConnectWallTo(par1IBlockAccess, par2 - 1,
				par3, par4);
		boolean flag3 = this.canConnectWallTo(par1IBlockAccess, par2 + 1,
				par3, par4);
		float f = 0.25F;
		float f1 = 0.75F;
		float f2 = 0.25F;
		float f3 = 0.75F;
		float f4 = 1.0F;
		
		if (flag)
		{
			f2 = 0.0F;
		}
		
		if (flag1)
		{
			f3 = 1.0F;
		}
		
		if (flag2)
		{
			f = 0.0F;
		}
		
		if (flag3)
		{
			f1 = 1.0F;
		}
		
		if (flag && flag1 && !flag2 && !flag3)
		{
			f4 = 0.8125F;
			f = 0.3125F;
			f1 = 0.6875F;
		}
		else if (!flag && !flag1 && flag2 && flag3)
		{
			f4 = 0.8125F;
			f2 = 0.3125F;
			f3 = 0.6875F;
		}
		
		this.setBlockBounds(f, 0.0F, f2, f1, f4, f3);
	}
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4)
	{
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		this.maxY = 1.5D;
		return super.getCollisionBoundingBoxFromPool(par1World, par2,
				par3, par4);
	}
	
	/**
	 * Return whether an adjacent block can connect to a wall.
	 */
	@Override
	public boolean canConnectWallTo(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4)
	{
		int l = par1IBlockAccess.getBlockId(par2, par3, par4);
		
		if (l != this.blockID && l != Block.fenceGate.blockID)
		{
			Block block = Block.blocksList[l];
			return block != null && block.blockMaterial.isOpaque()
					&& block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin
					: false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates.  Args: blockAccess, x, y, z, side
	 */
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4, int par5)
	{
		return par5 == 0 ? super.shouldSideBeRendered(par1IBlockAccess,
				par2, par3, par4, par5) : true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
	}
}