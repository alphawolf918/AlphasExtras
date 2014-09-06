package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;
import alphaitems.items.Items;
import alphaitems.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SuperCoalNetherOre extends Block {
	public SuperCoalNetherOre(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("spc_nether_ore");
		this.setHardness(13.0F);
		this.setResistance(9.0F);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 3);
	}
	
	@Override
	public int idDropped(int i, Random random, int j) {
		return Items.spcItem.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 2;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z,
			int meta) {
		this.dropXpOnBlockBreak(world, x, y, z, 35);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "spcnetherore");
	}
}