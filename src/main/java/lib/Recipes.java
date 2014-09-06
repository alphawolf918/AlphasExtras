package alphaitems.lib;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;
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
		
		// Amaranth Ingot (to nugget)
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
		
		/*
		 * Smelting
		 */
		
		int input = Blocks.spcOre.blockID;
		ItemStack output = new ItemStack(Items.spcItem, 2);
		float xp = 5F;
		GameRegistry.addSmelting(input, output, xp);
		
		int input2 = Blocks.spcNetherOre.blockID;
		ItemStack output2 = new ItemStack(Blocks.spcOre, 2);
		float xp2 = 10F;
		GameRegistry.addSmelting(input2, output2, xp2);
		
		int input3 = Item.rottenFlesh.itemID;
		ItemStack output3 = new ItemStack(Item.leather, 1);
		float xp3 = 2F;
		GameRegistry.addSmelting(input3, output3, xp3);
		
		int input4 = Block.gravel.blockID;
		ItemStack output4 = new ItemStack(Blocks.betterGlass, 1);
		float xp4 = 2F;
		GameRegistry.addSmelting(input4, output4, xp4);
		
		int input5 = Blocks.fnOre.blockID;
		ItemStack output5 = new ItemStack(Items.fuelonite, 1);
		float xp5 = 10F;
		GameRegistry.addSmelting(input5, output5, xp5);
		
		int input6 = Items.fuelonite.itemID;
		ItemStack output6 = new ItemStack(Items.fuelIngot, 2);
		float xp6 = 20F;
		GameRegistry.addSmelting(input6, output6, xp6);
		
		int input7 = Item.egg.itemID;
		ItemStack output7 = new ItemStack(Items.friedEgg,
				(new Random()).nextInt(2));
		float xp7 = 5F;
		GameRegistry.addSmelting(input7, output7, xp7);
		
		int input8 = Items.swampClayBall.itemID;
		ItemStack output8 = new ItemStack(Item.brick, 1);
		float xp8 = 5F;
		GameRegistry.addSmelting(input8, output8, xp8);
		
		int input9 = Blocks.swampClay.blockID;
		ItemStack output9 = new ItemStack(Block.brick, 1);
		float xp9 = 8F;
		GameRegistry.addSmelting(input9, output9, xp9);
		
		int input10 = Items.flour.itemID;
		ItemStack output10 = new ItemStack(Item.bread, 1);
		float xp10 = 8F;
		GameRegistry.addSmelting(input10, output10, xp10);
		
		int input11 = Blocks.amaranthOre.blockID;
		ItemStack output11 = new ItemStack(Items.ampIngot, 1);
		float xp11 = 15F;
		GameRegistry.addSmelting(input11, output11, xp11);
		
		int input12 = Items.ampDust.itemID;
		ItemStack output12 = new ItemStack(Items.ampIngot, 1);
		float xp12 = 20F;
		GameRegistry.addSmelting(input12, output12, xp12);
		
		int input13 = Blocks.amaranthNetherOre.blockID;
		ItemStack output13 = new ItemStack(Blocks.amaranthOre, 2);
		float xp13 = 30F;
		GameRegistry.addSmelting(input13, output13, xp13);
		
		int input14 = Blocks.amaranthEnderOre.blockID;
		ItemStack output14 = new ItemStack(Blocks.amaranthOre, 4);
		float xp14 = 40F;
		GameRegistry.addSmelting(input14, output14, xp14);
		
		int input15 = Blocks.saltBlock.blockID;
		ItemStack output15 = new ItemStack(Block.glass, 1);
		float xp15 = 5F;
		GameRegistry.addSmelting(input15, output15, xp15);
		
		int input16 = Items.dough.itemID;
		ItemStack output16 = new ItemStack(Items.biscuit, 1);
		float xp16 = 10F;
		GameRegistry.addSmelting(input16, output16, xp16);
		
		int input17 = Items.baconRaw.itemID;
		ItemStack output17 = new ItemStack(Items.baconCooked, 1);
		float xp17 = 10F;
		GameRegistry.addSmelting(input17, output17, xp17);
		
		int input18 = Blocks.redCobble.blockID;
		ItemStack output18 = new ItemStack(Blocks.redRock, 1);
		float xp18 = 4F;
		GameRegistry.addSmelting(input18, output18, xp18);
		
		int input19 = Items.duckRaw.itemID;
		ItemStack output19 = new ItemStack(Items.duckCooked, 1);
		float xp19 = 4F;
		GameRegistry.addSmelting(input19, output19, xp19);
		
		int input20 = Items.duckEgg.itemID;
		ItemStack output20 = new ItemStack(Items.friedEgg,
				(new Random()).nextInt(2));
		float xp20 = 4F;
		GameRegistry.addSmelting(input20, output20, xp20);
		
		// ========[PULVERIZERDATA]========
		
		// Regular SPC Ore
		NBTTagCompound spcSend = new NBTTagCompound();
		spcSend.setInteger("energy", 1600);
		spcSend.setCompoundTag("input", new NBTTagCompound());
		spcSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		spcSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.spcOre, 1)).writeToNBT(spcSend
				.getCompoundTag("input"));
		(new ItemStack(Items.spcItem, 2)).writeToNBT(spcSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Item.coal, 1)).writeToNBT(spcSend
				.getCompoundTag("secondaryOutput"));
		spcSend.setInteger("secondaryChance", 20);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				spcSend);
		
		// Nether SPC Ore
		NBTTagCompound spcnSend = new NBTTagCompound();
		spcnSend.setInteger("energy", 1800);
		spcnSend.setCompoundTag("input", new NBTTagCompound());
		spcnSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		spcnSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.spcNetherOre, 1)).writeToNBT(spcnSend
				.getCompoundTag("input"));
		(new ItemStack(Items.spcItem, 4)).writeToNBT(spcnSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Item.coal, 1)).writeToNBT(spcnSend
				.getCompoundTag("secondaryOutput"));
		spcnSend.setInteger("secondaryChance", 40);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				spcnSend);
		
		// Ender SPC Ore
		NBTTagCompound spceSend = new NBTTagCompound();
		spceSend.setInteger("energy", 2000);
		spceSend.setCompoundTag("input", new NBTTagCompound());
		spceSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		spceSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.enderSpcOre, 1)).writeToNBT(spceSend
				.getCompoundTag("input"));
		(new ItemStack(Items.spcItem, 6)).writeToNBT(spceSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Item.coal, 1)).writeToNBT(spcnSend
				.getCompoundTag("secondaryOutput"));
		spceSend.setInteger("secondaryChance", 60);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				spceSend);
		
		// Regular FN Ore
		NBTTagCompound fSend = new NBTTagCompound();
		fSend.setInteger("energy", 1800);
		fSend.setCompoundTag("input", new NBTTagCompound());
		fSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		fSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.fueltonium, 1)).writeToNBT(fSend
				.getCompoundTag("input"));
		(new ItemStack(Items.fuelonite, 2)).writeToNBT(fSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Items.spcItem, 1)).writeToNBT(fSend
				.getCompoundTag("secondaryOutput"));
		fSend.setInteger("secondaryChance", 5);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				fSend);
		
		// Nether FN Ore
		NBTTagCompound fnSend = new NBTTagCompound();
		fnSend.setInteger("energy", 2200);
		fnSend.setCompoundTag("input", new NBTTagCompound());
		fnSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		fSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.fnOre, 1)).writeToNBT(fnSend
				.getCompoundTag("input"));
		(new ItemStack(Items.fuelonite, 4)).writeToNBT(fnSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Items.spcItem, 1)).writeToNBT(fnSend
				.getCompoundTag("secondaryOutput"));
		fnSend.setInteger("secondaryChance", 10);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				fnSend);
		
		// Ender FN Ore
		NBTTagCompound feSend = new NBTTagCompound();
		feSend.setInteger("energy", 2300);
		feSend.setCompoundTag("input", new NBTTagCompound());
		feSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		fSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.enderFnOre, 1)).writeToNBT(feSend
				.getCompoundTag("input"));
		(new ItemStack(Items.fuelonite, 6)).writeToNBT(feSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Items.spcItem, 1)).writeToNBT(feSend
				.getCompoundTag("secondaryOutput"));
		feSend.setInteger("secondaryChance", 15);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				feSend);
		
		// Fueltonium Ingot
		NBTTagCompound fiSend = new NBTTagCompound();
		fiSend.setInteger("energy", 1000);
		fiSend.setCompoundTag("input", new NBTTagCompound());
		fiSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		
		(new ItemStack(Items.fuelIngot, 1)).writeToNBT(fiSend
				.getCompoundTag("input"));
		(new ItemStack(Items.fuelonite, 1)).writeToNBT(fiSend
				.getCompoundTag("primaryOutput"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				fiSend);
		
		// Salt Block
		NBTTagCompound saltSend = new NBTTagCompound();
		saltSend.setInteger("energy", 600);
		saltSend.setCompoundTag("input", new NBTTagCompound());
		saltSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.saltBlock, 1)).writeToNBT(saltSend
				.getCompoundTag("input"));
		(new ItemStack(Items.saltDust, 4)).writeToNBT(saltSend
				.getCompoundTag("primaryOutput"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				saltSend);
		
		// Wheat
		NBTTagCompound wheatSend = new NBTTagCompound();
		wheatSend.setInteger("energy", 500);
		wheatSend.setCompoundTag("input", new NBTTagCompound());
		wheatSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		
		(new ItemStack(Item.wheat, 1)).writeToNBT(wheatSend
				.getCompoundTag("input"));
		(new ItemStack(Items.flour, 2)).writeToNBT(wheatSend
				.getCompoundTag("primaryOutput"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				wheatSend);
		
		// Amaranth Ore
		NBTTagCompound ampSend = new NBTTagCompound();
		ampSend.setInteger("energy", 2800);
		ampSend.setCompoundTag("input", new NBTTagCompound());
		ampSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		ampSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.amaranthOre, 1)).writeToNBT(ampSend
				.getCompoundTag("input"));
		(new ItemStack(Items.ampDust, 2)).writeToNBT(ampSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Item.redstone, 1)).writeToNBT(ampSend
				.getCompoundTag("secondaryOutput"));
		ampSend.setInteger("secondaryChance", 5);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				ampSend);
		
		// Amaranth Nether Ore
		NBTTagCompound ampnSend = new NBTTagCompound();
		ampnSend.setInteger("energy", 3200);
		ampnSend.setCompoundTag("input", new NBTTagCompound());
		ampnSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		ampnSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.amaranthNetherOre, 1)).writeToNBT(ampnSend
				.getCompoundTag("input"));
		(new ItemStack(Items.ampDust, 4)).writeToNBT(ampnSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Item.redstone, 1)).writeToNBT(ampnSend
				.getCompoundTag("secondaryOutput"));
		ampnSend.setInteger("secondaryChance", 10);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				ampnSend);
		
		// Amaranth Ender Ore
		NBTTagCompound ampeSend = new NBTTagCompound();
		ampeSend.setInteger("energy", 3400);
		ampeSend.setCompoundTag("input", new NBTTagCompound());
		ampeSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		ampeSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Blocks.amaranthEnderOre, 1)).writeToNBT(ampeSend
				.getCompoundTag("input"));
		(new ItemStack(Items.ampDust, 6)).writeToNBT(ampeSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Item.redstone, 1)).writeToNBT(ampeSend
				.getCompoundTag("secondaryOutput"));
		ampeSend.setInteger("secondaryChance", 15);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				ampeSend);
		
		// Milk Bucket (to butter)
		NBTTagCompound milkSend = new NBTTagCompound();
		milkSend.setInteger("energy", 2300);
		milkSend.setCompoundTag("input", new NBTTagCompound());
		milkSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		fSend.setCompoundTag("secondaryOutput", new NBTTagCompound());
		
		(new ItemStack(Item.bucketMilk, 1)).writeToNBT(milkSend
				.getCompoundTag("input"));
		(new ItemStack(Items.butterItem, 4)).writeToNBT(milkSend
				.getCompoundTag("primaryOutput"));
		(new ItemStack(Item.bucketEmpty, 1)).writeToNBT(milkSend
				.getCompoundTag("secondaryOutput"));
		milkSend.setInteger("secondaryChance", 100);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				milkSend);
		
		// ========[/PULVERIZERDATA]========
		
		// ========[FUELDATA]========
		
		// Transposer Fill
		NBTTagCompound tFill = new NBTTagCompound();
		tFill.setInteger("energy", 800);
		tFill.setCompoundTag("input", new NBTTagCompound());
		tFill.setCompoundTag("output", new NBTTagCompound());
		tFill.setCompoundTag("fluid", new NBTTagCompound());
		
		new ItemStack(Items.bucketFuel, 1)
				.writeToNBT(tFill.getCompoundTag("input"));
		new ItemStack(Item.bucketEmpty, 1).writeToNBT(tFill
				.getCompoundTag("output"));
		tFill.setBoolean("reversible", true);
		new FluidStack(Blocks.fuel, FluidContainerRegistry.BUCKET_VOLUME)
				.writeToNBT(tFill.getCompoundTag("fluid"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"TransposerFillRecipe", tFill);
		
		// Transposer Extract
		NBTTagCompound tEx = new NBTTagCompound();
		tEx.setInteger("energy", 800);
		tEx.setCompoundTag("input", new NBTTagCompound());
		tEx.setCompoundTag("output", new NBTTagCompound());
		tEx.setCompoundTag("fluid", new NBTTagCompound());
		
		new ItemStack(Item.bucketEmpty, 1).writeToNBT(tEx
				.getCompoundTag("input"));
		new ItemStack(Items.bucketFuel, 1).writeToNBT(tEx
				.getCompoundTag("output"));
		tEx.setBoolean("reversible", true);
		tEx.setInteger("chance", 100);
		new FluidStack(Blocks.fuel, FluidContainerRegistry.BUCKET_VOLUME)
				.writeToNBT(tEx.getCompoundTag("fluid"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"TransposerExtractRecipe", tEx);
		
		// Compression Dynamo
		NBTTagCompound cDyn = new NBTTagCompound();
		cDyn.setString("fluidName", "Fueltonium");
		cDyn.setInteger("energy", 2000);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"CompressionFuel",
				cDyn);
		
		// ========[/FUELDATA]========
		
		// Sawmill Recipes
		sawMill(Blocks.acaciaLog, Blocks.acaciaPlanks);
	}
	
	public static void sawMill(Block input, Block output) {
		NBTTagCompound spcSend = new NBTTagCompound();
		spcSend.setInteger("energy", 2000);
		spcSend.setCompoundTag("input", new NBTTagCompound());
		spcSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		
		(new ItemStack(input, 1)).writeToNBT(spcSend
				.getCompoundTag("input"));
		(new ItemStack(output, 6)).writeToNBT(spcSend
				.getCompoundTag("primaryOutput"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"SawmillRecipe",
				spcSend);
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
	
	public static void addStairs(Block buildingBlock, Block stairBlock) {
		GameRegistry.addRecipe(new ItemStack(stairBlock, 3), new Object[] {
				"  C", " CC", "CCC", 'C', buildingBlock
		});
		GameRegistry.addRecipe(new ItemStack(stairBlock, 3), new Object[] {
				"C  ", "CC ", "CCC", 'C', buildingBlock
		});
	}
}