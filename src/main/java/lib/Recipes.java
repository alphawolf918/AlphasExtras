package alphaitems.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;
import alphaitems.lib.recipes.CrucibleRecipes;
import alphaitems.lib.recipes.InductionRecipes;
import alphaitems.lib.recipes.PulverizerRecipes;
import alphaitems.lib.recipes.SmelterRecipes;
import alphaitems.lib.recipes.TransposerRecipes;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init() {

		/*
		 * Crafting
		 */

		// SPC Block (to super coal item)
		GameRegistry.addShapelessRecipe(new ItemStack(Items.spcItem, 9),
				new Object[] {
			Blocks.spcBlock
		});

		// SPC Item (to super coal block)
		GameRegistry.addRecipe(new ItemStack(Blocks.spcBlock, 1),
				new Object[] {
			"CCC", "CCC", "CCC", 'C', Items.spcItem
		});

		// Copper Ingot (to block)
		GameRegistry.addRecipe(new ItemStack(Blocks.copperBlock, 1),
				new Object[] {
			"CCC", "CCC", "CCC", 'C', Items.copperIngot
		});

		// Copper Block (to ingot)
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.copperIngot, 9), new Object[] {
					Blocks.copperBlock
				});

		// Zinc Ingot (to block)
		GameRegistry.addRecipe(new ItemStack(Blocks.zincBlock, 1),
				new Object[] {
			"CCC", "CCC", "CCC", 'C', Items.zincIngot
		});

		// Zinc Block (to ingot)
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.zincIngot, 9), new Object[] {
					Blocks.zincBlock
				});

		// Fueltonium Block (to fuelonite)
		GameRegistry.addShapelessRecipe(new ItemStack(Items.fuelIngot, 9),
				new Object[] {
			Blocks.fuelBlockID
		});

		// Fuelonite Item (to fueltonium block)
		GameRegistry.addRecipe(new ItemStack(Blocks.fuelBlockID, 1),
				new Object[] {
			"CCC", "CCC", "CCC", 'C', Items.fuelIngot
		});

		// Amaranth Block (to ingot)
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ampIngot, 9),
				new Object[] {
			Blocks.amaranthBlock
		});

		// Amaranth Ingot (to block)
		GameRegistry.addRecipe(new ItemStack(Blocks.amaranthBlock, 1),
				new Object[] {
			"CCC", "CCC", "CCC", 'C', Items.ampIngot
		});

		// Amaranth Ingot (to nugget)
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ampNugget, 9),
				new Object[] {
			Blocks.amaranthBlock
		});

		// Amaranth Nugget (to ingot)
		GameRegistry.addRecipe(new ItemStack(Items.ampIngot, 1),
				new Object[] {
			"CCC", "CCC", "CCC", 'C', Items.ampNugget
		});

		// Better Grass (from grass)
		GameRegistry.addRecipe(new ItemStack(Blocks.betterGrass, 1),
				new Object[] {
			"CCC", "CCC", "CCC", 'C', Block.grass
		});

		// Regular Grass (from the better grass)
		GameRegistry.addShapelessRecipe(new ItemStack(Block.grass, 9),
				new Object[] {
			Blocks.betterGrass
		});

		GameRegistry.addShapelessRecipe(new ItemStack(
				Blocks.blackMarbleBlock,
				1), new Object[] {
			Blocks.marbleBlock, new ItemStack(Item.dyePowder, 1, 0)
		});

		// Ender Shards to Ender Pearl
		GameRegistry.addRecipe(new ItemStack(Item.enderPearl, 1),
				new Object[] {
			"RRR", "R R", "RRR", 'R', Items.enderShard
		});

		// Ender Pearl to Ender Shards
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.enderShard, 8), new Object[] {
					Item.enderPearl
				});

		// //Colored Bricks
		// // (Ingots)
		// Blue
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbBlue, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 4) // 4
		});
		// Red
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbRed, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 1) // 1
		});
		// Green
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbGreen, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 2) // 2
		});
		// Purple
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbPurple, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 5) // 5
		});
		// Cyan
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbCyan, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 6) // 6
		});
		// Pink
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbPink, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 9) // 9
		});
		// Yellow
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbYellow, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 11) // 11
		});
		// Black
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbBlack, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 0)
		});
		// White
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbWhite, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 15)
		});
		// Lime
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbLime, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 10)
		});
		// Brown
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbBrown, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 3)
		});
		// Magenta
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbMagenta, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 13)
		});
		// Light Blue
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.cbLightBlue, 1),
				new Object[] {
					Item.brick, new ItemStack(Item.dyePowder, 1, 12)
				});
		// Light Gray
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.cbLightGray, 1),
				new Object[] {
					Item.brick, new ItemStack(Item.dyePowder, 1, 7)
				});
		// Orange
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbOrange, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 14)
		});
		// Gray
		GameRegistry.addShapelessRecipe(new ItemStack(Items.cbGray, 1),
				new Object[] {
			Item.brick, new ItemStack(Item.dyePowder, 1, 8)
		});

		GameRegistry.addRecipe(new ItemStack(Blocks.shineTorch, 4),
				new Object[] {
			"G  ", "S  ", 'G', Items.shineDust, 'S',
			Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.shineTorch, 4),
				new Object[] {
			" G ", " S ", 'G', Items.shineDust, 'S',
			Item.stick
		});

		GameRegistry.addRecipe(new ItemStack(Block.torchWood, 8),
				new Object[] {
			"G  ", "S  ", 'G', Items.spcItem, 'S',
			Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Block.torchWood, 8),
				new Object[] {
			" G ", " S ", 'G', Items.spcItem, 'S',
			Item.stick
		});

		// Heartforce Item
		GameRegistry.addRecipe(new ItemStack(Items.heartForce, 1),
				new Object[] {
			"HEH", " A ", "HEH", 'H', Items.heart, 'A',
			Items.ampIngot, 'E', Item.enderPearl
		});

		/*
		 * Sticks
		 */

		// White
		GameRegistry.addRecipe(new ItemStack(Items.marbleStick, 4),
				new Object[] {
			"G  ", "G  ", 'G', Blocks.marbleBlock
		});
		GameRegistry.addRecipe(new ItemStack(Items.marbleStick, 4),
				new Object[] {
			" G ", " G ", 'G', Blocks.marbleBlock
		});

		// Black
		GameRegistry.addRecipe(new ItemStack(Items.blackMarbleStick, 4),
				new Object[] {
			"G  ", "G  ", 'G', Blocks.blackMarbleBlock
		});
		GameRegistry.addRecipe(new ItemStack(Items.blackMarbleStick, 4),
				new Object[] {
			" G ", " G ", 'G', Blocks.blackMarbleBlock
		});

		/*
		 * Railings
		 */

		// White
		GameRegistry.addRecipe(new ItemStack(Blocks.marbleRailing, 3),
				new Object[] {
			"SSS", "SSS", "   ", 'S', Items.marbleStick
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.marbleRailing, 3),
				new Object[] {
			"   ", "SSS", "SSS", 'S', Items.marbleStick
		});

		// Black
		GameRegistry.addRecipe(
				new ItemStack(Blocks.blackMarbleRailing, 3),
				new Object[] {
					"SSS", "SSS", "   ", 'S', Items.blackMarbleStick
				});
		GameRegistry.addRecipe(
				new ItemStack(Blocks.blackMarbleRailing, 3),
				new Object[] {
					"   ", "SSS", "SSS", 'S', Items.blackMarbleStick
				});

		// Pickaxe
		GameRegistry.addRecipe(new ItemStack(Items.ampPickaxe, 1),
				new Object[] {
			"RRR", "RSR", " S ", 'R', Items.ampIngot, 'S',
			Items.blackMarbleStick
		});

		// Saddle
		GameRegistry.addRecipe(new ItemStack(Item.saddle, 1),
				new Object[] {
			"LLL", "L L", "I I", 'L', Item.leather, 'I',
			Item.ingotIron
		});

		// Diamond Head
		GameRegistry.addRecipe(new ItemStack(Blocks.diamondHead, 1),
				new Object[] {
			"DDD", "RDR", "DDD", 'D', Block.blockDiamond, 'R',
			Block.blockRedstone
		});

		// Lapis Stick
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.lapisStick, 1),
				new Object[] {
					Block.blockLapis, Items.blackMarbleStick
				});

		// Shark Sword
		GameRegistry.addRecipe(new ItemStack(Items.sharkSword, 1),
				new Object[] {
			"S  ", "S  ", "L  ", 'S', Items.sharkTooth, 'L',
			Items.lapisStick
		});

		// Dough
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dough, 4),
				new Object[] {
			Item.egg, Items.flour, Items.butterItem
		});

		// Name Tag
		GameRegistry.addRecipe(new ItemStack(Item.nameTag, 2),
				new Object[] {
			"  I", " S ", "S  ", 'S', Items.swampClayBall,
			'I',
			Item.ingotIron
		});

		// Soul Sand
		GameRegistry.addShapelessRecipe(new ItemStack(Block.slowSand, 2),
				new Object[] {
			Block.dirt, Block.netherrack
		});

		addBricks(Items.cbBlue, Blocks.cbBlue);
		addBricks(Items.cbRed, Blocks.cbRed);
		addBricks(Items.cbGreen, Blocks.cbGreen);
		addBricks(Items.cbPurple, Blocks.cbPurple);
		addBricks(Items.cbCyan, Blocks.cbCyan);
		addBricks(Items.cbPink, Blocks.cbPink);
		addBricks(Items.cbYellow, Blocks.cbYellow);
		addBricks(Items.cbWhite, Blocks.cbWhite);
		addBricks(Items.cbBlack, Blocks.cbBlack);
		addBricks(Items.cbOrange, Blocks.cbOrange);
		addBricks(Items.cbBrown, Blocks.cbBrown);
		addBricks(Items.cbMagenta, Blocks.cbMagenta);
		addBricks(Items.cbLightBlue, Blocks.cbLightBlue);
		addBricks(Items.cbGray, Blocks.cbGray);
		addBricks(Items.cbLightGray, Blocks.cbLightGray);
		addBricks(Items.cbLime, Blocks.cbLime);

		addBricks(Items.shineDust, Blocks.shineStone);
		addBricks(Items.swampClayBall, Blocks.swampClay);
		addOWBricks(Items.saltDust, Blocks.saltBlock);
		addOWBricks(Blocks.venusRock, Blocks.venusBrick);

		addStairs(Blocks.cbBlue, Blocks.cbBlueStairs);
		addStairs(Blocks.cbRed, Blocks.cbRedStairs);
		addStairs(Blocks.cbGreen, Blocks.cbGreenStairs);
		addStairs(Blocks.cbPurple, Blocks.cbPurpleStairs);
		addStairs(Blocks.cbCyan, Blocks.cbCyanStairs);
		addStairs(Blocks.cbPink, Blocks.cbPinkStairs);
		addStairs(Blocks.cbYellow, Blocks.cbYellowStairs);
		addStairs(Blocks.cbWhite, Blocks.cbWhiteStairs);
		addStairs(Blocks.cbBlack, Blocks.cbBlackStairs);
		addStairs(Blocks.cbOrange, Blocks.cbOrangeStairs);
		addStairs(Blocks.cbBrown, Blocks.cbBrownStairs);
		addStairs(Blocks.cbMagenta, Blocks.cbMagentaStairs);
		addStairs(Blocks.cbLightBlue, Blocks.cbLightBlueStairs);
		addStairs(Blocks.cbGray, Blocks.cbGrayStairs);
		addStairs(Blocks.cbLightGray, Blocks.cbLightGrayStairs);
		addStairs(Blocks.cbLime, Blocks.cbLimeStairs);
		addStairs(Blocks.marbleBlock, Blocks.marbleStairs);
		addStairs(Blocks.blackMarbleBlock, Blocks.blackMarbleStairs);
		addStairs(Block.blockIron, Blocks.ironStairs);

		addDye(Blocks.aster, Item.dyePowder, 4);
		addDye(Blocks.cosmos, Item.dyePowder, 9);
		addDye(Blocks.lilac, Item.dyePowder, 5);
		addDye(Blocks.orangeFlower, Item.dyePowder, 14);

		// Slime Block
		GameRegistry.addRecipe(new ItemStack(Blocks.slimeBlock, 1),
				new Object[] { "SSS", "SSS", "SSS", 'S', Item.slimeBall });
		GameRegistry.addShapelessRecipe(new ItemStack(Item.slimeBall, 9),
				new Object[] { Blocks.slimeBlock });

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.acaciaPlanks,
				4), new Object[] {
			Blocks.acaciaLog
		});

		// Magma Slime Block
		GameRegistry
		.addRecipe(new ItemStack(Blocks.magmaSlime, 1),
				new Object[] { "SSS", "SSS", "SSS", 'S',
			Item.magmaCream });
		GameRegistry.addShapelessRecipe(new ItemStack(Item.magmaCream, 9),
				new Object[] { Blocks.magmaSlime });

		// Red Rock
		ItemStack rrb = new ItemStack(Blocks.redRockBrick, 4);
		GameRegistry.addRecipe(rrb, new Object[] { "SS ", "SS ", "   ",
				'S',
				Blocks.redRock });

		/*
		 * Fences
		 */

		// Birch Fence
		GameRegistry.addRecipe(new ItemStack(Blocks.fenceBirch, 1),
				new Object[] {
			"OOO", "OFO", "OOO", 'O',
			new ItemStack(Block.planks, 1, 2), 'F',
			Block.fence
		});

		// Spruce Fence
		GameRegistry.addRecipe(new ItemStack(Blocks.fenceSpruce, 1),
				new Object[] {
			"OOO", "OFO", "OOO", 'O',
			new ItemStack(Block.planks, 1, 1), 'F',
			Block.fence
		});

		// Jungle Fence
		GameRegistry.addRecipe(new ItemStack(Blocks.fenceJungle, 1),
				new Object[] {
			"OOO", "OFO", "OOO", 'O',
			new ItemStack(Block.planks, 1, 3), 'F',
			Block.fence
		});

		// Acacia Fence
		GameRegistry.addRecipe(new ItemStack(Blocks.fenceAcacia, 1),
				new Object[] {
			"OOO", "OFO", "OOO", 'O',
			new ItemStack(Blocks.acaciaPlanks, 1), 'F',
			Block.fence
		});

		// Oak
		addFence(Block.fence, 0, Blocks.fenceSpruce);
		addFence(Block.fence, 0, Blocks.fenceBirch);
		addFence(Block.fence, 0, Blocks.fenceJungle);
		addFence(Block.fence, 0, Blocks.fenceAcacia);

		// Cold Smoothstone
		ItemStack css = new ItemStack(Blocks.coldSandStone, 4);
		GameRegistry.addRecipe(css, new Object[] { "CC ", "CC ", "   ",
				'C',
				Blocks.coldSand });

		// Redrock Wall
		GameRegistry.addRecipe(new ItemStack(Blocks.redRockCobbleWall, 6),
				new Object[] {
			"RRR", "RRR", "   ", 'R', Blocks.redCobble
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.redRockCobbleWall, 6),
				new Object[] {
			"   ", "RRR", "RRR", 'R', Blocks.redCobble
		});

		GameRegistry.addRecipe(new ItemStack(Items.fishFood, 1),
				new Object[] {
			"FFF", "FFF", "FFF", 'F', Items.fishFlakes
		});
		TERecipes();
	}

	private static void addOWBricks(Block blockInput, Block blockOutput) {
		GameRegistry.addRecipe(new ItemStack(blockOutput, 4),
				new Object[] {
			"CC ", "CC ", "   ", 'C', blockInput
		});
	}

	public static void TERecipes() {
		SmelterRecipes.init();
		PulverizerRecipes.init();
		TransposerRecipes.init();
		CrucibleRecipes.init();
		InductionRecipes.init();
	}

	public static void sawMill(Block input, Block output) {
		NBTTagCompound spcSend = new NBTTagCompound();
		spcSend.setInteger("energy", 2000);
		spcSend.setCompoundTag("input", new NBTTagCompound());
		spcSend.setCompoundTag("primaryOutput", new NBTTagCompound());

		new ItemStack(input, 1).writeToNBT(spcSend
				.getCompoundTag("input"));
		new ItemStack(output, 6).writeToNBT(spcSend
				.getCompoundTag("primaryOutput"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"SawmillRecipe",
				spcSend);
	}

	public static void addDye(Block flower, Item dye, int damage) {
		GameRegistry.addShapelessRecipe(new ItemStack(dye, 4, damage),
				new Object[] {
			flower
		});
	}

	public static void addBricks(Item coloredBrick, Block coloredBlock) {
		GameRegistry.addRecipe(new ItemStack(coloredBlock, 1),
				new Object[] {
			"CC ", "CC ", "   ", 'C', coloredBrick
		});
		GameRegistry.addShapelessRecipe(new ItemStack(coloredBrick, 4),
				new Object[] {
			coloredBlock
		});
	}

	public static void addOWBricks(Item coloredBrick, Block coloredBlock) {
		GameRegistry.addRecipe(new ItemStack(coloredBlock, 1),
				new Object[] {
			"CC ", "CC ", "   ", 'C', coloredBrick
		});
	}

	public static void addFence(Block output, int metadata,
			Block inputFenceType) {
		GameRegistry.addRecipe(new ItemStack(output, 1),
				new Object[] {
			"OOO", "OFO", "OOO", 'O',
			new ItemStack(Block.planks, 1, metadata), 'F',
			inputFenceType
		});
	}

	public static void addStairs(Block buildingBlock, Block stairBlock) {
		GameRegistry.addRecipe(new ItemStack(stairBlock, 3), new Object[] {
			"  C", " CC", "CCC", 'C', buildingBlock
		});
		GameRegistry.addRecipe(new ItemStack(stairBlock, 3), new Object[] {
			"C  ", "CC ", "CCC", 'C', buildingBlock
		});
	}
}