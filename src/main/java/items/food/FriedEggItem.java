package alphaitems.items.food;

import net.minecraft.item.ItemFood;
import alphaitems.creativetabs.ModTabs;

public class FriedEggItem extends ItemFood {
	
	public FriedEggItem(int par1) {
		super(par1, 10, 8, false);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("friedegg");
		this.setTextureName("awei:friedegg");
	}
}