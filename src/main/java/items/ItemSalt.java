package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class ItemSalt extends Item {
	
	public ItemSalt(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("saltdust");
		this.setTextureName("awei:saltdust");
	}
}