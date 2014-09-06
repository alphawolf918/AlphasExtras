package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import alphaitems.creativetabs.ModTabs;
import alphaitems.items.Items;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Shinestone extends Block {
	public Shinestone(int par1Id) {
		super(par1Id, Material.glass);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("shinestoneblock");
		this.setLightValue(1.0F);
		this.setHardness(0.5F);
		this.setResistance(0.4F);
		this.setStepSound(Block.soundGlassFootstep);
	}
	
	@Override
	public boolean canSilkHarvest() {
		return true;
	}
	
	@Override
	public int idDropped(int par1Id, Random par2Random, int par3) {
		return Items.shineDust.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		int r = par1Random.nextInt(4);
		r = (r == 0) ? 1 : r;
		return r;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "shinestone");
	}
}