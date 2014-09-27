package alphaitems.items.food;

import net.minecraft.item.ItemFood;
import alphaitems.creativetabs.ModTabs;

public class CookedShrimp extends ItemFood {
	public CookedShrimp(int par1Id) {
		super(par1Id, 10, 10, false);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("shrimp_cooked");
		this.setTextureName("awei:cookedshrimp");
		this.setMaxStackSize(16);
	}
}