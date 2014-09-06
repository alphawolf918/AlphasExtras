package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;
import alphaitems.items.Items;

public class EnderSPCOre extends Block {
	public EnderSPCOre(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("spc_ender_ore");
		this.setHardness(13.0F);
		this.setResistance(9.0F);
		this.setTextureName("awei:enderspcore");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 3);
	}
	
	@Override
	public int idDropped(int i, Random random, int j) {
		return Items.spcItem.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 1 + par1Random.nextInt(3);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z,
			int meta) {
		this.dropXpOnBlockBreak(world, x, y, z, 66);
	}
}