package alphaitems.items.food;

import net.minecraft.item.ItemFood;
import alphaitems.creativetabs.ModTabs;

public class Biscuit extends ItemFood {
	public Biscuit(int par1) {
		super(par1, 10, 10, false);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("biscuit");
		this.setTextureName("awei:biscuit");
		this.setMaxStackSize(16);
	}
}