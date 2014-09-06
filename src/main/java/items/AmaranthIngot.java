package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class AmaranthIngot extends Item {
	public AmaranthIngot(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("ingotAmaranth");
		this.setTextureName("awei:amaranthingot");
	}
}