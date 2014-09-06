package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class ItemDough extends Item {
	public ItemDough(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("dough");
		this.setTextureName("awei:dough");
	}
}