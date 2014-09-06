package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;

public class EnderFNOre extends Block {
	public EnderFNOre(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("fuel_ender_ore");
		this.setHardness(14.0F);
		this.setResistance(10.0F);
		this.setTextureName("awei:enderfnore");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 4);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z,
			int meta) {
		this.dropXpOnBlockBreak(world, x, y, z, 46);
	}
}