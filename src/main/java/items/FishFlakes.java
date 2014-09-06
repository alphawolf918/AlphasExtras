package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class FishFlakes extends Item {
	public FishFlakes(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("fishflakes");
		this.setTextureName("awei:fishflakes");
		this.setMaxStackSize(16);
	}
}