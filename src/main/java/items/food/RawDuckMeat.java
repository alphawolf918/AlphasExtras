package alphaitems.items.food;

import net.minecraft.item.ItemFood;
import alphaitems.creativetabs.ModTabs;

public class RawDuckMeat extends ItemFood {
	public RawDuckMeat(int par1) {
		super(par1, 1, 1, false);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("rawduck");
		this.setTextureName("awei:duck_raw");
	}
}