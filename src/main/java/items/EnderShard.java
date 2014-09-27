package alphaitems.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import alphaitems.creativetabs.ModTabs;

public class EnderShard extends Item {
	public EnderShard(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("endershard");
		this.setTextureName("awei:endershard");
		this.setMaxStackSize(16);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}
}