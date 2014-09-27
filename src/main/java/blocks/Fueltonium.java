package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.EnumToolClass;
import alphaitems.lib.Methods;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Fueltonium extends Block {
	public Fueltonium(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("fueltonium");
		this.setHardness(13.0F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundStoneFootstep);
		Methods.ForgeSetToolClass(this, "pickaxe", EnumToolClass.AMARANTH);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z,
			int meta) {
		this.dropXpOnBlockBreak(world, x, y, z, 60);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "fueltonium");
	}
}