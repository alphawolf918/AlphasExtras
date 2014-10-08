package alphaitems.lib.recipes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmelterRecipes {
	public static void init() {
		addSmelting(Blocks.spcOre, new ItemStack(Items.spcItem, 2), 5F);
		addSmelting(Blocks.spcNetherOre, new ItemStack(Blocks.spcOre, 2),
				10F);
		addSmelting(Item.rottenFlesh, Item.leather, 2F);
		addSmelting(Block.gravel, Blocks.betterGlass, 2F);
		addSmelting(Blocks.fnOre, Items.fuelonite, 10F);
		addSmelting(Items.fuelonite, new ItemStack(Items.fuelIngot, 2),
				20F);
		addSmelting(Item.egg,
				new ItemStack(Items.friedEgg, (new Random()).nextInt(2)),
				5F);
		addSmelting(Items.swampClayBall, Item.brick, 5F);
		addSmelting(Blocks.swampClay, Block.brick, 8F);
		addSmelting(Items.flour, Item.bread, 8F);
		addSmelting(Blocks.amaranthOre, Items.ampIngot, 15F);
		addSmelting(Items.ampDust, Items.ampIngot, 20F);
		addSmelting(Blocks.amaranthNetherOre, new ItemStack(
				Blocks.amaranthOre, 2), 30F);
		addSmelting(Blocks.amaranthEnderOre, new ItemStack(
				Blocks.amaranthOre, 4), 40F);
		addSmelting(Blocks.saltBlock, Block.glass, 5F);
		addSmelting(Items.dough, Items.biscuit, 10F);
		addSmelting(Items.baconRaw, Items.baconCooked, 10F);
		addSmelting(Blocks.redCobble, Blocks.redRock, 4F);
		addSmelting(Items.duckRaw, Items.duckCooked, 4F);
		addSmelting(Items.duckEgg, new ItemStack(Items.friedEgg,
				(new Random()).nextInt(2)), 4F);
		addSmelting(Block.slowSand, Blocks.resistanceGlass, 8F);
		addSmelting(Items.rawShrimp, Items.cookedShrimp, 8F);
		addSmelting(Blocks.venusIronOre, new ItemStack(Block.oreIron, 4),
				15F);
		addSmelting(Blocks.venusGoldOre, new ItemStack(Block.oreGold, 4),
				15F);
		addSmelting(Blocks.venusDiamondOre, new ItemStack(
				Block.oreDiamond, 4),
				15F);
		addSmelting(Blocks.venusRedstoneOre, new ItemStack(
				Block.oreRedstone, 4),
				15F);
		addSmelting(Blocks.venusCoalOre, new ItemStack(Block.oreCoal, 4),
				15F);
		addSmelting(Blocks.venusSpcOre, new ItemStack(Blocks.spcOre, 4),
				15F);
		addSmelting(Blocks.venusFnOre, new ItemStack(Blocks.fnOre, 4),
				15F);
		addSmelting(Blocks.venusAmaranthOre, new ItemStack(
				Blocks.amaranthOre, 4),
				15F);
		addSmelting(Blocks.venusShardOre, new ItemStack(
				Blocks.enderShardOre, 4),
				15F);
	}
	
	private static void addSmelting(Block input, Item output, float xp) {
		addSmelting(input, new ItemStack(output, 1), xp);
	}
	
	public static void addSmelting(Item input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input.itemID, output, xp);
	}
	
	public static void addSmelting(Item input, Item output, float xp) {
		addSmelting(input, new ItemStack(output, 1), xp);
	}
	
	public static void addSmelting(Block input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input.blockID, output, xp);
	}
	
	public static void addSmelting(Block input, Block output, float xp) {
		addSmelting(input, new ItemStack(output, 1), xp);
	}
}