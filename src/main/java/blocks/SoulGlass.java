package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import alphaitems.lib.Methods;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoulGlass extends BlockGlass {
	public SoulGlass(int par1) {
		super(par1, Material.glass, true);
		Methods.setTab(this);
		this.setUnlocalizedName("soulglass");
		Methods.setBlockRH(this, 10.0F, 0.3F);
		this.setTextureName("awei:soulglass");
		this.setStepSound(soundGlassFootstep);
		this.setLightValue(5.0F);
		this.setStepSound(Block.soundGlassFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "soulglass");
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}
}