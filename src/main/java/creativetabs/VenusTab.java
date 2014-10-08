package alphaitems.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import alphaitems.items.Items;

public class VenusTab extends CreativeTabs {
	
	public VenusTab(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return Items.spcItem.itemID;
	}
}