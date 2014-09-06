package alphaitems.blocks.plants.trees.acacia;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import alphaitems.creativetabs.ModTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AcaciaPlanks extends BlockWood
{
	
	public static final String[] woodType = new String[] { "acacia" };
	private static Icon blockIcon;
	
	public AcaciaPlanks(int par1)
	{
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("acaciaplanks");
		this.setHardness(2.5F);
		this.setResistance(9.5F);
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
	public Icon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}
	
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister
				.registerIcon("awei:acaciaplanks");
	}
}
