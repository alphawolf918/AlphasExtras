package alphaitems.items.venus;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class ItemIngotBase extends Item {
	public ItemIngotBase(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.venusTab);
	}
}