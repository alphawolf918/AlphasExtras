package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlackMarbleBlock extends Block {
	public BlackMarbleBlock(int par1Id) {
		super(par1Id, Material.iron);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("blackmarbleblock");
		this.setLightValue(0.6F);
		this.setHardness(5.6F);
		this.setResistance(9.9F);
		this.setStepSound(Block.soundMetalFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "blackmarble");
	}
}