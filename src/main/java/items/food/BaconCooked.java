package alphaitems.items.food;

import net.minecraft.item.ItemFood;
import alphaitems.creativetabs.ModTabs;

public class BaconCooked extends ItemFood {
	public BaconCooked(int par1) {
		super(par1, 15, 15, true);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("baconcooked");
		this.setTextureName("awei:baconcooked");
	}
}