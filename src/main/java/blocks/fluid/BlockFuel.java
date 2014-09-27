package alphaitems.blocks.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import alphaitems.lib.DSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFuel extends BlockFluidClassic {
	
	public BlockFuel(int id, Fluid fluid) {
		super(id, fluid, Material.water);
		this.setCreativeTab((CreativeTabs) null);
		this.setUnlocalizedName("fuelFluidBlock");
		this.setLightValue(1.0F);
	}
	
	public void blockEffects(World par1World, int par2,
			int par3,
			int par4, Entity par5Entity) {
		par5Entity.attackEntityFrom(DSource.deathFuel, 6.0F);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2,
			int par3,
			int par4, Entity par5Entity) {
		this.blockEffects(par1World, par2, par3, par4, par5Entity);
	}
	
	@Override
	public void onEntityWalking(World par1World, int par2,
			int par3,
			int par4, Entity par5Entity) {
		this.blockEffects(par1World, par2, par3, par4, par5Entity);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("awei:fuel");
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
		return 0x009c00;
	}
}