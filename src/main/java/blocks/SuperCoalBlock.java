package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SuperCoalBlock extends Block {
	public SuperCoalBlock(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("spcblock");
		this.setHardness(8.0F);
		this.setResistance(7.0F);
		this.setStepSound(Block.soundStoneFootstep);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "spcblock");
	}
}