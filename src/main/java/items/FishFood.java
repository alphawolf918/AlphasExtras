package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class FishFood extends Item {
	public FishFood(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("fishfood");
		this.setTextureName("awei:fishfood");
		this.setMaxDamage(10);
		this.setMaxStackSize(1);
	}
}