package alphaitems.items;

import net.minecraft.item.ItemCoal;
import alphaitems.creativetabs.ModTabs;

public class SuperCoalItem extends ItemCoal {
	public SuperCoalItem(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("spcitem");
		this.setTextureName("awei:superchargedcoal");
	}
}