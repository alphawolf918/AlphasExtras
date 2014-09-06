package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class ItemButter extends Item {
	public ItemButter(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("butter");
		this.setTextureName("awei:butter");
		this.setMaxStackSize(16);
	}
}