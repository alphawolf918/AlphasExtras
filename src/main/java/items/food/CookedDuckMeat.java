package alphaitems.items.food;

import net.minecraft.item.ItemFood;
import alphaitems.creativetabs.ModTabs;

public class CookedDuckMeat extends ItemFood {
	public CookedDuckMeat(int par1) {
		super(par1, 10, 8, false);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("cookedduck");
		this.setTextureName("awei:duck_cooked");
	}
}