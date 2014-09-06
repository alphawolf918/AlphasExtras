package alphaitems.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Fuelonite extends Item {
	public Fuelonite(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("fuelonite");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "fuelonite");
	}
}