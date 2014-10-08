package alphaitems.blocks.plants.trees.acacia;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AcaciaLog extends BlockLog
{
	@SideOnly(Side.CLIENT)
	private Icon acaciaLogTopIcon;
	@SideOnly(Side.CLIENT)
	private Icon acaciaLogBottomIcon;
	
	/** The type of tree this block came from. */
	public static final String[] woodType = new String[] { "acacia" };
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	private static int renderId = 33;
	
	public AcaciaLog(int par1)
	{
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("acacialog");
		this.setHardness(2.6F);
		this.setResistance(8.0F);
		this.setStepSound(Block.soundWoodFootstep);
	}
	
	public static void setRenderId(int renderId) {
		AcaciaLog.renderId = renderId;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int unused)
	{
		return blockID;
	}
	
	//
	public boolean canConnect(IBlockAccess world, int x, int y, int z)
	{
		int Id = world.getBlockId(x, y, z);
		
		if (Id != blockID)
		{
			Block block = Block.blocksList[Id];
			return block != null && block.blockMaterial == Material.leaves;
		}
		
		return true;
	}
	
	@Override
	public int getRenderType() {
		return renderId;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockID, CreativeTabs par2CreativeTabs,
			List list)
	{
		list.add(new ItemStack(blockID, 1, 0));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.acaciaLogTopIcon : (par1 == 0
				? this.acaciaLogBottomIcon
				: this.blockIcon);
	}
	
	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z) {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.acaciaLogTopIcon = par1IconRegister
				.registerIcon("awei:acacialog_top");
		this.acaciaLogBottomIcon = par1IconRegister
				.registerIcon("awei:acacialog_top");
		this.blockIcon = par1IconRegister.registerIcon("awei:acacialog");
	}
}