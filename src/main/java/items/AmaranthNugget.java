package alphaitems.items;

import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;

public class AmaranthNugget extends Item {
	
	public AmaranthNugget(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("nuggetAmaranth");
		this.setTextureName("awei:amaranthnugget");
	}
}