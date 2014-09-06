package alphaitems.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import alphaitems.items.Items;

public class AITab extends CreativeTabs {
	
	public AITab(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return Items.spcItem.itemID;
	}
}