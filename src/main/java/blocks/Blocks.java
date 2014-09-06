package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import alphaitems.blocks.coloredbricks.ColoredBricksBlack;
import alphaitems.blocks.coloredbricks.ColoredBricksBlue;
import alphaitems.blocks.coloredbricks.ColoredBricksBrown;
import alphaitems.blocks.coloredbricks.ColoredBricksCyan;
import alphaitems.blocks.coloredbricks.ColoredBricksGray;
import alphaitems.blocks.coloredbricks.ColoredBricksGreen;
import alphaitems.blocks.coloredbricks.ColoredBricksLightBlue;
import alphaitems.blocks.coloredbricks.ColoredBricksLightGray;
import alphaitems.blocks.coloredbricks.ColoredBricksLime;
import alphaitems.blocks.coloredbricks.ColoredBricksMagenta;
import alphaitems.blocks.coloredbricks.ColoredBricksOrange;
import alphaitems.blocks.coloredbricks.ColoredBricksPink;
import alphaitems.blocks.coloredbricks.ColoredBricksPurple;
import alphaitems.blocks.coloredbricks.ColoredBricksRed;
import alphaitems.blocks.coloredbricks.ColoredBricksWhite;
import alphaitems.blocks.coloredbricks.ColoredBricksYellow;
import alphaitems.blocks.fluid.BlockFuel;
import alphaitems.blocks.fluid.BlockHotWater;
import alphaitems.blocks.fluid.FluidFuel;
import alphaitems.blocks.fluid.FluidHotWater;
import alphaitems.blocks.plants.Aster;
import alphaitems.blocks.plants.Cosmos;
import alphaitems.blocks.plants.HeartFlower;
import alphaitems.blocks.plants.Lilac;
import alphaitems.blocks.plants.OrangeFlower;
import alphaitems.blocks.plants.PlantBlackberry;
import alphaitems.blocks.plants.PlantBlueberry;
import alphaitems.blocks.plants.PlantEnder;
import alphaitems.blocks.plants.trees.acacia.AcaciaLeaves;
import alphaitems.blocks.plants.trees.acacia.AcaciaLog;
import alphaitems.blocks.plants.trees.acacia.AcaciaPlanks;
import alphaitems.blocks.plants.trees.acacia.AcaciaSapling;
import alphaitems.lib.Ids;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static final Block spcOre = new SuperCoalOre(Ids.superCoalOreID);
	public static final Block spcBlock = new SuperCoalBlock(
			Ids.superCoalBlockID);
	public static final Block spcNetherOre = new SuperCoalNetherOre(
			Ids.superCoalNetherOreID);
	
	public static final Block cbBlue = new ColoredBricksBlue(
			Ids.cbBlockBlueID);
	public static final Block cbRed = new ColoredBricksRed(
			Ids.cbBlockRedID);
	public static final Block cbYellow = new ColoredBricksYellow(
			Ids.cbBlockYellowID);
	public static final Block cbGreen = new ColoredBricksGreen(
			Ids.cbBlockGreenID);
	public static final Block cbCyan = new ColoredBricksCyan(
			Ids.cbBlockCyanID);
	public static final Block cbPurple = new ColoredBricksPurple(
			Ids.cbBlockPurpleID);
	public static final Block cbPink = new ColoredBricksPink(
			Ids.cbBlockPinkID);
	public static final Block cbWhite = new ColoredBricksWhite(
			Ids.cbBlockWhiteID);
	public static final Block cbBlack = new ColoredBricksBlack(
			Ids.cbBlockBlackID);
	public static final Block cbOrange = new ColoredBricksOrange(
			Ids.cbBlockOrangeID);
	public static final Block cbBrown = new ColoredBricksBrown(
			Ids.cbBlockBrownID);
	public static final Block cbGray = new ColoredBricksGray(
			Ids.cbBlockGrayID);
	public static final Block cbLime = new ColoredBricksLime(
			Ids.cbBlockLimeID);
	public static final Block cbMagenta = new ColoredBricksMagenta(
			Ids.cbBlockMagentaID);
	public static final Block cbLightGray = new ColoredBricksLightGray(
			Ids.cbBlockLightGrayID);
	public static final Block cbLightBlue = new ColoredBricksLightBlue(
			Ids.cbBlockLightBlueID);
	
	public static final Block cbBlueStairs = new StairBlock(
			Ids.blueBrickStairsID, cbBlue, 1)
			.setUnlocalizedName("bluebrickstairs");
	public static final Block cbRedStairs = new StairBlock(
			Ids.redBrickStairsID, cbRed, 1)
			.setUnlocalizedName("redbrickstairs");
	public static final Block cbGreenStairs = new StairBlock(
			Ids.greenBrickStairsID, cbGreen, 1)
			.setUnlocalizedName("greenbrickstairs");
	public static final Block cbPurpleStairs = new StairBlock(
			Ids.purpleBrickStairsID, cbPurple, 1)
			.setUnlocalizedName("purplebrickstairs");
	public static final Block cbYellowStairs = new StairBlock(
			Ids.yellowBrickStairsID, cbYellow, 1)
			.setUnlocalizedName("yellowbrickstairs");
	public static final Block cbCyanStairs = new StairBlock(
			Ids.cyanBrickStairsID, cbCyan, 1)
			.setUnlocalizedName("cyanbrickstairs");
	public static final Block cbBlackStairs = new StairBlock(
			Ids.blackBrickStairsID, cbBlack, 1)
			.setUnlocalizedName("blackbrickstairs");
	public static final Block cbWhiteStairs = new StairBlock(
			Ids.whiteBrickStairsID, cbWhite, 1)
			.setUnlocalizedName("whitebrickstairs");
	public static final Block cbPinkStairs = new StairBlock(
			Ids.pinkBrickStairsID, cbPink, 2)
			.setUnlocalizedName("pinkbrickstairs");
	public static final Block cbBrownStairs = new StairBlock(
			Ids.brownBrickStairsID, cbBrown, 1)
			.setUnlocalizedName("brownbrickstairs");
	public static final Block cbLightBlueStairs = new StairBlock(
			Ids.lightBlueBrickStairsID, cbLightBlue, 1)
			.setUnlocalizedName("lightbluebrickstairs");
	public static final Block cbGrayStairs = new StairBlock(
			Ids.grayBrickStairsID, cbGray, 1)
			.setUnlocalizedName("graybrickstairs");
	public static final Block cbLightGrayStairs = new StairBlock(
			Ids.lightGrayBrickStairsID, cbLightGray, 1)
			.setUnlocalizedName("lightgraybrickstairs");
	public static final Block cbLimeStairs = new StairBlock(
			Ids.limeBrickStairsID, cbLime, 1)
			.setUnlocalizedName("limebrickstairs");
	public static final Block cbMagentaStairs = new StairBlock(
			Ids.magentaBrickStairsID, cbMagenta, 1)
			.setUnlocalizedName("magentabrickstairs");
	public static final Block cbOrangeStairs = new StairBlock(
			Ids.orangeBrickStairsID, cbOrange, 2)
			.setUnlocalizedName("orangebrickstairs");
	
	public static final Block fueltonium = new Fueltonium(
			Ids.fueltoniumBlockID);
	public static final Block fuelBlockID = new FueltoniumBlock(
			Ids.blockOfFueltoniumID);
	public static final BlockGlass betterGlass = new BetterGlass(
			Ids.betterGlassID);
	public static final Block fnOre = new FuelNetherOre(
			Ids.fuelNetherOreID);
	public static final Block blueBerryPlant = new PlantBlueberry(
			Ids.blueBerryPlantID);
	public static final Block blackBerryPlant = new PlantBlackberry(
			Ids.blackBerryPlantID);
	public static final Block marbleBlock = new MarbleBlock(
			Ids.marbleBlockID);
	public static final Block shineStone = new Shinestone(Ids.shineStoneID);
	public static final Block shineTorch = new Shinetorch(Ids.shineTorchID);
	
	public static final Block marbleStairs = new StairBlock(
			Ids.marbleStairsID, marbleBlock, 0)
			.setUnlocalizedName("marblestairs");
	public static final Block marbleRailing = (new RailingBlock(
			Ids.marbleRailing,
			"awei:marble",
			Material.iron)).setHardness(3.0F).setResistance(8.8F)
			.setStepSound(Block.soundMetalFootstep)
			.setUnlocalizedName("marblerailing");
	
	public static final Block blackMarbleBlock = new BlackMarbleBlock(
			Ids.blackMarbleID);
	public static final Block blackMarbleStairs = new StairBlock(
			Ids.blackMarbleStairsID, blackMarbleBlock, 0)
			.setUnlocalizedName("blackmarblestairs");
	public static final Block blackMarbleRailing = (new RailingBlock(
			Ids.blackMarbleRailingID,
			"awei:blackmarble",
			Material.iron)).setHardness(3.0F).setResistance(8.8F)
			.setStepSound(Block.soundMetalFootstep)
			.setUnlocalizedName("blackmarblerailing");
	
	public static final Block swampClay = new SwampClay(Ids.swampClayID);
	public static final Block seaLamp = new SeaLamp(Ids.seaLampID);
	public static final Block enderSpcOre = new EnderSPCOre(
			Ids.enderSPCOreID);
	public static final Block enderFnOre = new EnderFNOre(Ids.enderFNOreID);
	public static final Block saltBlock = new SaltBlock(Ids.saltBlockID);
	public static final Block heartBlock = new HeartBlock(Ids.heartOreID);
	public static final Block amaranthOre = new AmaranthOre(Ids.ampOreID);
	public static final Block amaranthBlock = new AmaranthBlock(
			Ids.ampBlockID);
	public static final Block amaranthWire = new AmaranthWire(
			Ids.ampWireID);
	public static final Block amaranthNetherOre = new AmaranthNetherOre(
			Ids.ampNetherOre);
	public static final Block amaranthEnderOre = new AmaranthEnderOre(
			Ids.ampEnderOre);
	public static final Block crawlerEgg = new BlockCrawlerEgg(
			Ids.crawlerEggID);
	public static final Block netherDirt = new NetherDirt(Ids.netherDirtID);
	public static final Block enderDirt = new EnderDirt(Ids.enderDirtID);
	public static final Block diamondHead = new BlockDiamondHead(
			Ids.diamondHeadID);
	public static final Block betterGrass = new BetterGrass(
			Ids.betterGrassID);
	public static final Block enderPlant = new PlantEnder(Ids.enderPlantID);
	public static final Block redCobble = new RedCobble(
			Ids.redRockCobbleID);
	public static final Block redRock = new RedRock(Ids.redRockID);
	public static final Block redRockBrick = new RedRockBricks(
			Ids.redRockBrick);
	public static final Block coldSand = new ColdSand(Ids.coldSandID);
	public static final Block coldSandStone = new ColdSandstone(
			Ids.coldSandStoneID);
	public static final Block magmaSlime = new MagmaSlimeBlock(
			Ids.magmaBlock);
	public static final Block redShroomBlock = new RedshroomBlock(
			Ids.redshroomID);
	public static final Block redShroomStem = new RedshroomStem(
			Ids.redstemID);
	public static final Block slimeBlock = new SlimeBlock(Ids.slimeBlock);
	public static final Block lilac = new Lilac(Ids.lilacID);
	public static final Block orangeFlower = new OrangeFlower(
			Ids.orangeFlowerID);
	public static final Block aster = new Aster(Ids.asterID);
	public static final Block heartFlower = new HeartFlower(
			Ids.heartFlowerID);
	public static final Block cosmos = new Cosmos(Ids.cosmosID);
	public static final Block acaciaLog = new AcaciaLog(Ids.acaciaLogID);
	public static final Block acaciaLeaves = new AcaciaLeaves(
			Ids.acaciaLeavesID);
	public static final Block acaciaPlanks = new AcaciaPlanks(
			Ids.acaciaPlanksID);
	public static final Block acaciaSapling = new AcaciaSapling(
			Ids.acaciaSaplingID);
	public static final Block badStone = new BadStone(Ids.badStoneID);
	public static final Block canyonRock = new CanyonRock(Ids.canyonRockID);
	public static final Block coral = new BlockCoral(Ids.coralID);
	public static final Block barrier = new BarrierBlock(Ids.barrierID);
	public static final Block acaciaStairs = new StairBlock(
			Ids.acaciaStairsID, acaciaPlanks, 0)
			.setUnlocalizedName("acaciastairs");
	public static final Block redRockBrickStairs = new StairBlock(
			Ids.redRockBrickStairsID, redRockBrick, 0)
			.setUnlocalizedName("redrockbrickstairs");
	public static final Block redRockCobbleWall = new WallBlock(
			Ids.redRockWallID, redCobble)
			.setUnlocalizedName("redrockcobblewall");
	public static final Block ironStairs = new StairBlock(
			Ids.ironStairsID, Block.blockIron, 0);
	public static final Block weatheredBricks = new WeatheredBricks(
			Ids.weatheredBricksID);
	public static final Block brimStone = new Brimstone(Ids.brimStoneID);
	
	public static Fluid hotWater = new FluidHotWater("HotWater");
	public static Block hotWaterBlock = new BlockHotWater(
			Ids.hotSpringBlockID,
			hotWater);
	public static Fluid fuel = new FluidFuel("LiqidFuel");
	public static Block fuelLiquidBlock = new BlockFuel(Ids.fuelLiquidID,
			fuel);
	
	public static void init() {
		addBlock(spcOre, "Super Charged Coal Ore");
		addBlock(spcBlock, "Super Charged Coal Block");
		addBlock(spcNetherOre, "Nether Super Charged Coal Ore");
		addBlock(cbBlue, "Blue Bricks");
		addBlock(cbRed, "Red Bricks");
		addBlock(cbYellow, "Yellow Bricks");
		addBlock(cbGreen, "Green Bricks");
		addBlock(cbCyan, "Cyan Bricks");
		addBlock(cbPurple, "Purple Bricks");
		addBlock(cbPink, "Pink Bricks");
		addBlock(cbWhite, "White Bricks");
		addBlock(cbBlack, "Black Bricks");
		addBlock(cbOrange, "Orange Bricks");
		addBlock(cbBrown, "Brown Bricks");
		addBlock(cbGray, "Gray Bricks");
		addBlock(cbLime, "Lime Bricks");
		addBlock(cbMagenta, "Magenta Bricks");
		addBlock(cbLightGray, "Light Gray Bricks");
		addBlock(cbLightBlue, "Light Blue Bricks");
		addBlock(fueltonium, "Fueltonium");
		addBlock(fuelBlockID, "Block of Fueltonium");
		addBlock(fnOre, "Nether Fueltonium");
		addBlock(betterGlass, "Better Glass");
		addBlock(marbleBlock, "Fine Marble");
		addBlock(marbleStairs, "Fine Marble Stairs");
		addBlock(marbleRailing, "Fine Marble Rail");
		addBlock(shineStone, "Shinestone");
		addBlock(shineTorch, "Shine Torch");
		addBlock(cbBlueStairs, "Blue Brick Stairs");
		addBlock(cbRedStairs, "Red Brick Stairs");
		addBlock(cbPurpleStairs, "Purple Brick Stairs");
		addBlock(cbGreenStairs, "Green Brick Stairs");
		addBlock(cbYellowStairs, "Yellow Brick Stairs");
		addBlock(cbCyanStairs, "Cyan Brick Stairs");
		addBlock(cbBlackStairs, "Black Brick Stairs");
		addBlock(cbWhiteStairs, "White Brick Stairs");
		addBlock(cbPinkStairs, "Pink Brick Stairs");
		addBlock(cbBrownStairs, "Brown Brick Stairs");
		addBlock(cbLightBlueStairs, "Light Blue Brick Stairs");
		addBlock(cbGrayStairs, "Gray Brick Stairs");
		addBlock(cbLightGrayStairs, "Light Gray Brick Stairs");
		addBlock(cbLimeStairs, "Lime Brick Stairs");
		addBlock(cbOrangeStairs, "Orange Brick Stairs");
		addBlock(cbMagentaStairs, "Magenta Brick Stairs");
		addBlock(blackMarbleBlock, "Fine Black Marble");
		addBlock(blackMarbleStairs, "Fine Black Marble Stairs");
		addBlock(blackMarbleRailing, "Fine Black Marble Rail");
		addBlock(swampClay, "Swamp Clay");
		addBlock(seaLamp, "Sea Lamp");
		addBlock(enderSpcOre, "Ender Super Charged Coal Ore");
		addBlock(enderFnOre, "Ender Fueltonium");
		addBlock(saltBlock, "Salt Block");
		addBlock(heartBlock, "Heart Block");
		addBlock(amaranthOre, "Amaranth Ore");
		addBlock(amaranthBlock, "Amaranth Block");
		addBlock(amaranthNetherOre, "Nether Amaranth Ore");
		addBlock(amaranthEnderOre, "Ender Amaranth Ore");
		addBlock(crawlerEgg, "Spider Sac");
		addBlock(hotWaterBlock, "Hot Water");
		addBlock(fuelLiquidBlock, "Fueltonium Fluid");
		addBlock(netherDirt, "Nether Dirt");
		addBlock(enderDirt, "Ender Dirt");
		addBlock(diamondHead, "Diamond Head");
		addBlock(betterGrass, "Better Grass");
		addBlock(blackBerryPlant, "Blackberries");
		addBlock(blueBerryPlant, "Blueberries");
		addBlock(enderPlant, "Ender Berries");
		addBlock(redCobble, "Redrock Cobblestone");
		addBlock(redRock, "Redrock");
		addBlock(coldSand, "Cold Sand");
		addBlock(coldSandStone, "Cold Sandstone");
		addBlock(magmaSlime, "Magma Block");
		addBlock(redShroomBlock, "Redshroom");
		addBlock(redShroomStem, "Redshroom Stem");
		addBlock(slimeBlock, "Slime Block");
		addBlock(redRockBrick, "Redrock Bricks");
		addBlock(lilac, "Lilac");
		addBlock(orangeFlower, "Crocosmia");
		addBlock(aster, "Aster");
		addBlock(heartFlower, "Heart Flower");
		addBlock(cosmos, "Cosmos");
		addBlock(acaciaLog, "Acacia Log");
		addBlock(acaciaLeaves, "Acacia Leaves");
		addBlock(acaciaPlanks, "Acacia Planks");
		addBlock(acaciaSapling, "Acacia Sapling");
		addBlock(badStone, "Badstone");
		addBlock(canyonRock, "Canyon Rock");
		addBlock(coral, "Coral");
		addBlock(barrier, "Barrier Block");
		addBlock(acaciaStairs, "Acacia Wood Stairs");
		addBlock(redRockBrickStairs, "Redrock Brick Stairs");
		addBlock(redRockCobbleWall, "Redrock Cobble Wall");
		addBlock(ironStairs, "Iron Stairs");
		addBlock(weatheredBricks, "Weathered Bricks");
		addBlock(brimStone, "Brimstone");
	}
	
	public static void addBlock(Block par1Block, String par2Name) {
		GameRegistry.registerBlock(par1Block, par2Name);
		LanguageRegistry.addName(par1Block, par2Name);
	}
}