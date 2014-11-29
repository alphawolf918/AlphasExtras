package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class SuperCoalItem extends Item {
	public SuperCoalItem(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("spcitem");
		this.setTextureName("awei:superchargedcoal");
	}
}