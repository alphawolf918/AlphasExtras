package alphaitems.items.food;

import net.minecraft.item.ItemFood;
import alphaitems.creativetabs.ModTabs;

public class BaconRaw extends ItemFood {
	public BaconRaw(int par1) {
		super(par1, 1, 1, false);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("baconRaw");
		this.setTextureName("awei:baconraw");
	}
}