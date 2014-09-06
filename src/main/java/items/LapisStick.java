package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class LapisStick extends Item {
	public LapisStick(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("lapis_stick");
		this.setTextureName("awei:lapis_stick");
	}
}