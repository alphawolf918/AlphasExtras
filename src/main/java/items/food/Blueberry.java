package alphaitems.items.food;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSeedFood;
import alphaitems.blocks.Blocks;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Blueberry extends ItemSeedFood {
	public Blueberry(int par1) {
		super(par1, 2, 4, Blocks.blueBerryPlant.blockID,
				Block.tilledField.blockID);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("blueberry");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "blueberry");
	}
}