package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class BaconRaw extends Item {
	public BaconRaw(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("baconRaw");
		this.setTextureName("awei:baconraw");
	}
}