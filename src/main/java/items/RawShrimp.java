package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class RawShrimp extends Item {
	public RawShrimp(int par1Id) {
		super(par1Id);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("shrimp_raw");
		this.setTextureName("awei:rawshrimp");
		this.setMaxStackSize(16);
	}
}