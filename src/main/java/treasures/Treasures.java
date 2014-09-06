package alphaitems.treasures;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import alphaitems.items.Items;

public final class Treasures {
	
	public static ArrayList<String> chestTypes = new ArrayList<String>();
	
	private static WeightedRandomChestContent item1 = new WeightedRandomChestContent(
			new ItemStack(Items.spcItem, 1), 1, 10, 2);
	private static WeightedRandomChestContent item2 = new WeightedRandomChestContent(
			new ItemStack(Items.fuelonite, 1), 1, 10, 2);
	private static WeightedRandomChestContent item3 = new WeightedRandomChestContent(
			new ItemStack(Items.ampIngot, 1), 1, 10, 2);
	private static WeightedRandomChestContent item4 = new WeightedRandomChestContent(
			new ItemStack(Items.heart, 1), 1, 1, 2);
	
	public static void init() {
		addChestTypes();
		addItems();
	}
	
	private static void addItems() {
		addChestItem(item1);
		addChestItem(item2);
		addChestItem(item3);
		addChestItem(item4);
	}
	
	private static void addChestItem(WeightedRandomChestContent item) {
		int i;
		for (i = 0; i < chestTypes.size(); i++) {
			ChestGenHooks.addItem(chestTypes.get(i), item);
		}
	}
	
	public static void addChest(int i, int j, int k, Random rand,
			World world,
			String chestType) {
		int chestX = i;
		int chestY = j;
		int chestZ = k;
		boolean isBigChest = (rand.nextInt(4) == 1) ? true : false;
		spawnChest(world, rand, chestX, chestY, chestZ,
				isBigChest,
				chestType);
	}
	
	public static void spawnChest(World world, Random rand, int i, int j,
			int k,
			boolean isBigChest, String chestType) {
		world.setBlock(i, j, k, Block.chest.blockID);
		if (isBigChest) {
			world.setBlock(i + 1, j, k, Block.chest.blockID);
		}
		TileEntityChest tileentitychest = (TileEntityChest) world
				.getBlockTileEntity(i, j, k);
		tileentitychest.setChestGuiName("Underground Chest");
		if (tileentitychest != null) {
			ChestGenHooks info = ChestGenHooks.getInfo(chestType);
			WeightedRandomChestContent.generateChestContents(rand,
					info.getItems(rand), tileentitychest,
					info.getCount(rand));
		}
	}
	
	public static void addChestTypes() {
		chestTypes.add(ChestGenHooks.DUNGEON_CHEST);
		chestTypes.add(ChestGenHooks.MINESHAFT_CORRIDOR);
		chestTypes.add(ChestGenHooks.PYRAMID_DESERT_CHEST);
		chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CORRIDOR);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CROSSING);
		chestTypes.add(ChestGenHooks.STRONGHOLD_LIBRARY);
		chestTypes.add(ChestGenHooks.VILLAGE_BLACKSMITH);
	}
	
	public static String pickChestType() {
		return chestTypes.get((int) (Math.random() * chestTypes.size()));
	}
}