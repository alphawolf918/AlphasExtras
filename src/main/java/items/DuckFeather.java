package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class DuckFeather extends Item {
	public DuckFeather(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("duckfeather");
		this.setTextureName("awei:duckfeather");
	}
}