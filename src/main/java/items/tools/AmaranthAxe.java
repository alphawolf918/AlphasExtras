package alphaitems.items.tools;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import alphaitems.creativetabs.ModTabs;

public class AmaranthAxe extends ItemAxe
{
	
	public AmaranthAxe(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("ampAxe");
		this.setTextureName("awei:amaranth_axe");
	}
	
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return 4.0F;
	}
}