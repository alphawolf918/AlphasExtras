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

		// <ingots>
		// Ingots and ores for other mods.
		// ******************
		// Coal
		OreDictionary.registerOre("oreCoal", Blocks.venusCoalOre);
		
		// Iron
		OreDictionary.registerOre("oreIron", Blocks.venusIronOre);
		
		// Gold
		OreDictionary.registerOre("oreGold", Blocks.venusGoldOre);

		// Redstone
		OreDictionary.registerOre("oreRedstone", Blocks.venusRedstoneOre);

		// Diamond
		OreDictionary.registerOre("oreDiamond", Blocks.venusDiamondOre);
		
		// Emerald
		OreDictionary.registerOre("oreEmerald", Blocks.venusEmeraldOre);
		
		// Copper
		OreDictionary.registerOre("ingotCopper", Items.copperIngot);
		OreDictionary.registerOre("oreCopper", Blocks.venusCopperOre);
		OreDictionary.registerOre("dustCopper", Items.copperDust);

		// Lead
		OreDictionary.registerOre("oreLead", Blocks.leadOre);
		
		// Ferrous
		OreDictionary.registerOre("oreFerrous", Blocks.ferrousOre);

		// Silver
		OreDictionary.registerOre("oreSilver", Blocks.silverOre);
		
		// Tin
		OreDictionary.registerOre("oreTin", Blocks.tinOre);
		
		// Bronze
		OreDictionary.registerOre("ingotBronze", Items.bronzeIngot);
		OreDictionary.registerOre("oreBronze", Blocks.bronzeOre);
		OreDictionary.registerOre("dustBronze", Items.bronzeDust);
		
		// Zinc
		OreDictionary.registerOre("ingotZinc", Items.zincIngot);
		OreDictionary.registerOre("oreZinc", Blocks.venusZincOre);
		OreDictionary.registerOre("dustZinc", Items.zincDust);
		// ********************
		// </ingots>

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

		// Axe
		OreDictionary.registerOre("itemAxe", new ItemStack(
				Items.amaranthAxe, 1));
	}
}