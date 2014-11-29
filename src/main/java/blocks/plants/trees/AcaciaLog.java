package alphaitems.blocks.plants.trees;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AcaciaLog extends BlockWood
{
	@SideOnly(Side.CLIENT)
	private Icon acaciaLogTopIcon;
	@SideOnly(Side.CLIENT)
	private Icon acaciaLogBottomIcon;
	
	/** The type of tree this block came from. */
	public static final String[] woodType = new String[] { "acacia" };
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	
	public AcaciaLog(int par1)
	{
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("acacialog");
		this.setHardness(2.5F);
		this.setResistance(8.0F);
		this.setStepSound(Block.soundWoodFootstep);
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