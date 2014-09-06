package alphaitems.blocks.fluid;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHotWater extends BlockFluidClassic {
	
	public BlockHotWater(int id, Fluid fluid) {
		super(id, fluid, Material.water);
		this.setCreativeTab((CreativeTabs) null);
		this.setUnlocalizedName("hotwaterblock");
	}
	
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random) {
		double d0 = par2 + 0.5D + (par5Random.nextFloat() - 0.5D) * 0.2D;
		double d1 = par3 + 0.0625F;
		double d2 = par4 + 0.5D + (par5Random.nextFloat() - 0.5D) * 0.2D;
		par1World.spawnParticle("largesmoke", d0, d1,
				d2, 0.5D, 0.5D, 1.0D);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("awei:hotwater");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return this.blockIcon;
	}
	
	@Override
	public int colorMultiplier(IBlockAccess iblockaccess, int x, int y,
			int z)
	{
		return 0x0099ff;
	}
}