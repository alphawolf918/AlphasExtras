package alphaitems.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import alphaitems.blocks.Blocks;

public class VenusTab extends CreativeTabs {
	
	public VenusTab(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return Blocks.venusSand.blockID;
	}
}