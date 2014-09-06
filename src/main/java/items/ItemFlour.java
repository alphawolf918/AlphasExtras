package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class ItemFlour extends Item {
	
	public ItemFlour(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("flour");
		this.setTextureName("awei:flour");
	}
}