package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class ShadowBone extends Item {
	public ShadowBone(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("shadowbone");
		this.setTextureName("awei:shadowbone");
	}
}