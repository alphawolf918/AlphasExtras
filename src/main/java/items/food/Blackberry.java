package alphaitems.items.food;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSeedFood;
import alphaitems.blocks.Blocks;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Blackberry extends ItemSeedFood {
	public Blackberry(int par1) {
		super(par1, 2, 4, Blocks.blackBerryPlant.blockID,
				Block.tilledField.blockID);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("blackberry");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "blackberry");
	}
}