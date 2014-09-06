package alphaitems.items;

import net.minecraft.item.ItemSeeds;
import alphaitems.creativetabs.ModTabs;

public class EnderSeed extends ItemSeeds {
	
	public EnderSeed(int par1, int par2, int par3) {
		super(par1, par2, par3);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("enderseed");
		this.setTextureName("awei:enderseed");
	}
}