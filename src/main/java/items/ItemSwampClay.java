package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class ItemSwampClay extends Item {
	public ItemSwampClay(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("swampclayball");
		this.setTextureName("awei:swampclayball");
	}
}