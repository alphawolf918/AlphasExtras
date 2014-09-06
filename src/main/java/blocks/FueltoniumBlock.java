package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FueltoniumBlock extends Block {
	public FueltoniumBlock(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("fueltoniumblock");
		this.setHardness(9.0F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundStoneFootstep);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "fueltoniumblock");
	}
}