package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;
import alphaitems.mobs.entities.EntityDiamondGolem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDiamondHead extends Block {
	
	private static Icon field_94475_c;
	private static Icon field_94474_b;
	
	public BlockDiamondHead(int par1) {
		super(par1, Material.iron);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("diamondhead");
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
		this.setHardness(4.5F);
		this.setResistance(10.0F);
		this.setTextureName("awei:dh");
		this.setStepSound(Block.soundAnvilFootstep);
	}
	
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		if (par1World.getBlockId(par2, par3 - 1, par4) == Block.blockDiamond.blockID
				&& par1World.getBlockId(par2, par3 - 2, par4) == Block.blockDiamond.blockID)
		{
			boolean flag = par1World.getBlockId(par2 - 1, par3 - 1, par4) == Block.blockDiamond.blockID
					&& par1World.getBlockId(par2 + 1, par3 - 1, par4) == Block.blockDiamond.blockID;
			boolean flag1 = par1World.getBlockId(par2, par3 - 1, par4 - 1) == Block.blockDiamond.blockID
					&& par1World.getBlockId(par2, par3 - 1, par4 + 1) == Block.blockDiamond.blockID;
			
			if (flag || flag1)
			{
				par1World.setBlock(par2, par3, par4, 0, 0, 2);
				par1World.setBlock(par2, par3 - 1, par4, 0, 0, 2);
				par1World.setBlock(par2, par3 - 2, par4, 0, 0, 2);
				
				if (flag)
				{
					par1World.setBlock(par2 - 1, par3 - 1, par4, 0, 0, 2);
					par1World.setBlock(par2 + 1, par3 - 1, par4, 0, 0, 2);
				}
				else
				{
					par1World.setBlock(par2, par3 - 1, par4 - 1, 0, 0, 2);
					par1World.setBlock(par2, par3 - 1, par4 + 1, 0, 0, 2);
				}
				
				EntityDiamondGolem entitydiamondgolem = new EntityDiamondGolem(
						par1World);
				entitydiamondgolem.setPlayerCreated(true);
				entitydiamondgolem.setLocationAndAngles(par2 + 0.5D,
						par3 - 1.95D,
						par4 + 0.5D, 0.0F, 0.0F);
				par1World.spawnEntityInWorld(entitydiamondgolem);
				
				for (int i1 = 0; i1 < 120; ++i1)
				{
					par1World.spawnParticle("snowballpoof", par2
							+ par1World.rand.nextDouble(), par3 - 2
							+ par1World.rand.nextDouble() * 3.9D, par4
							+ par1World.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
				
				par1World.notifyBlockChange(par2, par3, par4, 0);
				par1World.notifyBlockChange(par2, par3 - 1, par4, 0);
				par1World.notifyBlockChange(par2, par3 - 2, par4, 0);
				
				if (flag)
				{
					par1World.notifyBlockChange(par2 - 1, par3 - 1, par4, 0);
					par1World.notifyBlockChange(par2 + 1, par3 - 1, par4, 0);
				}
				else
				{
					par1World.notifyBlockChange(par2, par3 - 1, par4 - 1, 0);
					par1World.notifyBlockChange(par2, par3 - 1, par4 + 1, 0);
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.field_94475_c = par1IconRegister.registerIcon(this
				.getTextureName() + "_face");
		this.field_94474_b = par1IconRegister.registerIcon(this
				.getTextureName() + "_top");
		this.blockIcon = par1IconRegister.registerIcon(this.getTextureName()
				+ "_side");
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.field_94474_b : (par1 == 0 ? this.field_94474_b
				: (par2 == 2 && par1 == 2 ? this.field_94475_c : (par2 == 3
						&& par1 == 5 ? this.field_94475_c : (par2 == 0
						&& par1 == 3 ? this.field_94475_c : (par2 == 1
						&& par1 == 4 ? this.field_94475_c : this.blockIcon)))));
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return true;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4)
	{
		int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 7;
		
		switch (l)
		{
		case 1:
		default:
			this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
			break;
		case 2:
			this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
			break;
		case 3:
			this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
			break;
		case 4:
			this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
			break;
		case 5:
			this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		}
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4)
	{
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3,
				par4);
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int l = MathHelper
				.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return this.blockID;
	}
}