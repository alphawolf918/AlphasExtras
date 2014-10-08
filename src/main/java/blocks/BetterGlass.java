package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BetterGlass extends BlockGlass {
	public BetterGlass(int par1) {
		super(par1, Material.glass, false);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("betterglass");
		this.setHardness(0.3F);
		this.setStepSound(soundGlassFootstep);
	}
	
	public boolean canConnect(IBlockAccess world, int x, int y, int z)
	{
		int Id = world.getBlockId(x, y, z);
		
		if (Id != blockID)
		{
			Block block = Block.blocksList[Id];
			return block != null && block.blockMaterial == Material.glass;
		}
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "betterglass");
	}
}