package alphaitems.blocks.venus.ores;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import alphaitems.blocks.venus.BlockVenusBase;

public class VenusRedstoneOre extends BlockVenusBase {
	public VenusRedstoneOre(int par1) {
		super(par1, Material.rock);
		this.setUnlocalizedName("venusredstoneore");
		this.setTextureName("awei:venusredstoneore");
	}
	
	@Override
	public int idDropped(int i, Random random, int j) {
		return Item.redstone.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 4 + par1Random.nextInt(4);
	}
}