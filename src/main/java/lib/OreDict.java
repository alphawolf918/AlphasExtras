package alphaitems.lib;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;

public class OreDict {
	public static void init() {
		
		// Better Glass
		OreDictionary
				.registerOre("glass", new ItemStack(Blocks.betterGlass, 1));
		OreDictionary
				.registerOre("glass", new ItemStack(
						Blocks.resistanceGlass, 1));
		
		// Fueltonium Ingot
		OreDictionary.registerOre("ingotUranium", new ItemStack(
				Items.fuelIngot, 1));
		
		// Butter Ingot
		OreDictionary.registerOre("ingotButter", Items.butterItem);
		
		// Swamp Clay
		OreDictionary.registerOre("clay", new ItemStack(
				Items.swampClayBall, 1));
		
		// Bricks
		
		// Trees
		OreDictionary.registerOre("logWood", Blocks.acaciaLog);
		OreDictionary.registerOre("plankWood", Blocks.acaciaPlanks);
		OreDictionary.registerOre("treeSapling", Blocks.acaciaSapling);
		OreDictionary.registerOre("treeLeaves", Blocks.acaciaLeaves);
		
		// Fences
		OreDictionary.registerOre("fenceWood", Blocks.fenceAcacia);
		OreDictionary.registerOre("fenceWood", Blocks.fenceSpruce);
		OreDictionary.registerOre("fenceWood", Blocks.fenceBirch);
		OreDictionary.registerOre("fenceWood", Blocks.fenceJungle);
		OreDictionary.registerOre("fenceWood", Block.fence);
	}
}