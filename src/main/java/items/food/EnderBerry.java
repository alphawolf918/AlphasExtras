package alphaitems.items.food;

import net.minecraft.item.ItemFood;
import alphaitems.creativetabs.ModTabs;

public class EnderBerry extends ItemFood {
	public EnderBerry(int par1) {
		super(par1, 8, 4, false);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("enderberry");
		this.setTextureName("awei:enderberry");
	}
}