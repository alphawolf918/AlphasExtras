package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;
import alphaitems.items.Items;
import alphaitems.lib.EnumToolClass;
import alphaitems.lib.Methods;

public class EnderShardOre extends Block {
	public EnderShardOre(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("shard_ender_ore");
		this.setHardness(11.0F);
		this.setResistance(8.0F);
		this.setTextureName("awei:endershardore");
		Methods.ForgeSetToolClass(this, "pickaxe", EnumToolClass.AMARANTH);
	}
	
	@Override
	public int idDropped(int i, Random random, int j) {
		return Items.enderShard.itemID;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z,
			int meta) {
		this.dropXpOnBlockBreak(world, x, y, z, 86);
	}
}