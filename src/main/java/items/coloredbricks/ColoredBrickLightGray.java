package alphaitems.items.coloredbricks;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ColoredBrickLightGray extends Item {
	public ColoredBrickLightGray(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("brickingot_lightgray");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "brickingot_lightgray");
	}
}