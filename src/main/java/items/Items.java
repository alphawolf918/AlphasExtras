package alphaitems.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import alphaitems.blocks.Blocks;
import alphaitems.creativetabs.ModTabs;
import alphaitems.items.coloredbricks.ColoredBrickBlack;
import alphaitems.items.coloredbricks.ColoredBrickBlue;
import alphaitems.items.coloredbricks.ColoredBrickBrown;
import alphaitems.items.coloredbricks.ColoredBrickCyan;
import alphaitems.items.coloredbricks.ColoredBrickGray;
import alphaitems.items.coloredbricks.ColoredBrickGreen;
import alphaitems.items.coloredbricks.ColoredBrickLightBlue;
import alphaitems.items.coloredbricks.ColoredBrickLightGray;
import alphaitems.items.coloredbricks.ColoredBrickLime;
import alphaitems.items.coloredbricks.ColoredBrickMagenta;
import alphaitems.items.coloredbricks.ColoredBrickOrange;
import alphaitems.items.coloredbricks.ColoredBrickPink;
import alphaitems.items.coloredbricks.ColoredBrickPurple;
import alphaitems.items.coloredbricks.ColoredBrickRed;
import alphaitems.items.coloredbricks.ColoredBrickWhite;
import alphaitems.items.coloredbricks.ColoredBrickYellow;
import alphaitems.items.food.BaconCooked;
import alphaitems.items.food.BaconRaw;
import alphaitems.items.food.Biscuit;
import alphaitems.items.food.Blackberry;
import alphaitems.items.food.Blueberry;
import alphaitems.items.food.CookedDuckMeat;
import alphaitems.items.food.CookedShrimp;
import alphaitems.items.food.EnderBerry;
import alphaitems.items.food.FriedEggItem;
import alphaitems.items.food.RawDuckMeat;
import alphaitems.items.tools.AmaranthAxe;
import alphaitems.items.venus.BronzeDust;
import alphaitems.items.venus.BronzeIngot;
import alphaitems.items.venus.CopperDust;
import alphaitems.items.venus.CopperIngot;
import alphaitems.items.venus.ZincDust;
import alphaitems.items.venus.ZincIngot;
import alphaitems.lib.Ids;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static final Item spcItem = new SuperCoalItem(Ids.superCoalID);
	public static final Item cbBlue = new ColoredBrickBlue(
			Ids.coloredBricksBlueID);
	public static final Item cbCyan = new ColoredBrickCyan(
			Ids.coloredBricksCyanID);
	public static final Item cbGreen = new ColoredBrickGreen(
			Ids.coloredBricksGreenID);
	public static final Item cbPink = new ColoredBrickPink(
			Ids.coloredBricksPinkID);
	public static final Item cbPurple = new ColoredBrickPurple(
			Ids.coloredBricksPurpleID);
	public static final Item cbRed = new ColoredBrickRed(
			Ids.coloredBricksRedID);
	public static final Item cbYellow = new ColoredBrickYellow(
			Ids.coloredBricksYellowID);
	public static final Item cbWhite = new ColoredBrickWhite(
			Ids.coloredBricksWhiteID);
	public static final Item cbBlack = new ColoredBrickBlack(
			Ids.coloredBricksBlackID);
	public static final Item cbOrange = new ColoredBrickOrange(
			Ids.coloredBricksOrangeID);
	public static final Item cbBrown = new ColoredBrickBrown(
			Ids.coloredBricksBrownID);
	public static final Item cbGray = new ColoredBrickGray(
			Ids.coloredBricksGrayID);
	public static final Item cbLightGray = new ColoredBrickLightGray(
			Ids.coloredBricksLightGrayID);
	public static final Item cbMagenta = new ColoredBrickMagenta(
			Ids.coloredBricksMagentaID);
	public static final Item cbLightBlue = new ColoredBrickLightBlue(
			Ids.coloredBricksLightBlueID);
	public static final Item cbLime = new ColoredBrickLime(
			Ids.coloredBricksLimeID);
	public static final Item fuelonite = new Fuelonite(Ids.fueltoniumID);
	public static final Item blackBerry = new Blackberry(Ids.blackBerryID);
	public static final Item blueBerry = new Blueberry(Ids.blueBerryID);
	public static final Item shineDust = new ShineDust(Ids.shineDustID);
	public static final Item marbleStick = new MarbleStick(
			Ids.marbleStickID);
	public static final Item blackMarbleStick = new BlackMarbleStick(
			Ids.blackMarbleStickID);

	public static final Item fuelIngot = new FuelIngot(Ids.fuelIngotID);
	public static final Item friedEgg = new FriedEggItem(Ids.friedEggID);
	public static final Item heart = new ItemHeart(Ids.heartID);
	public static final Item swampClayBall = new ItemSwampClay(
			Ids.swampClayBallID);
	public static final Item saltDust = new ItemSalt(Ids.saltDustID);
	public static final Item flour = new ItemFlour(Ids.flourID);
	public static final Item ampIngot = new AmaranthIngot(Ids.ampIngotID);
	public static final Item ampDust = new AmaranthDust(Ids.ampDustID);
	public static final Item ampNugget = new AmaranthNugget(
			Ids.ampNuggetID);
	public static final Item ampPickaxe = new AmaranthPickaxe(
			Ids.ampPickaxe);
	public static final Item heartForce = new ItemHeartForce(
			Ids.heartForceID);
	public static final Item sharkLeather = new SharkLeather(
			Ids.sharkLeatherID);
	public static final Item sharkTooth = new SharkTooth(Ids.sharkToothID);
	public static final Item butterItem = new ItemButter(Ids.butterID);
	public static final Item lapisStick = new LapisStick(Ids.lapisStickID);
	public static final Item sharkSword = new SharkSword(Ids.sharkSwordID);
	public static final Item dough = new ItemDough(Ids.doughID);
	public static final Item biscuit = new Biscuit(Ids.biscuitID);
	public static final Item baconRaw = new BaconRaw(Ids.baconRawID);
	public static final Item baconCooked = new BaconCooked(
			Ids.baconCookedID);
	public static final Item enderBerry = new EnderBerry(Ids.enderBerryID);
	public static final Item enderSeed = new EnderSeed(Ids.enderSeedID,
			Blocks.enderPlant.blockID, Blocks.enderDirt.blockID);
	public static final Item duckRaw = new RawDuckMeat(Ids.duckRawID);
	public static final Item duckCooked = new CookedDuckMeat(
			Ids.duckCookedID);
	public static final Item duckFeather = new DuckFeather(
			Ids.duckFeatherID);
	public static final DuckEgg duckEgg = new DuckEgg(Ids.duckEggID);
	public static final Item shadowBone = new ShadowBone(Ids.shadowBoneID);
	public static final Item fishFlakes = new FishFlakes(Ids.fishFlakesID);
	public static final Item fishFood = new FishFood(Ids.fishFoodID);
	public static final Item enderShard = new EnderShard(Ids.enderShardID);
	public static final Item rawShrimp = new RawShrimp(Ids.shrimpRawID);
	public static final Item cookedShrimp = new CookedShrimp(
			Ids.shrimpCookedID);

	public static final Item amaranthAxe = new AmaranthAxe(
			Ids.amaranthAxeID, EnumToolMaterial.EMERALD);

	public static final Item zincIngot = new ZincIngot(Ids.zincIngotID);
	public static final Item copperIngot = new CopperIngot(
			Ids.copperIngotID);
	public static final Item bronzeIngot = new BronzeIngot(
			Ids.bronzeIngotID);

	public static final Item zincDust = new ZincDust(Ids.zincDustID);
	public static final Item copperDust = new CopperDust(Ids.copperDustID);
	public static final Item bronzeDust = new BronzeDust(Ids.bronzeDustID);

	public static Item bucketHotWater = new ItemBucket(
			Ids.hotWaterBucketID,
			Blocks.hotWaterBlock.blockID).setCreativeTab(ModTabs.aiTab)
			.setUnlocalizedName("hotwaterbucket").setContainerItem(
					Item.bucketEmpty)
					.setTextureName("awei:hotwaterbucket");
	public static Item bucketFuel = new ItemBucket(Ids.fuelBucketID,
			Blocks.fuelLiquidBlock.blockID).setCreativeTab(ModTabs.aiTab)
			.setUnlocalizedName("fueltoniumBucket").setContainerItem(
					Item.bucketEmpty)
					.setTextureName("awei:fuelbucket");

	public static void init() {
		addItem(spcItem, "Super Charged Coal");
		addItem(cbBlue, "Blue Brick Ingot");
		addItem(cbCyan, "Cyan Brick Ingot");
		addItem(cbGreen, "Green Brick Ingot");
		addItem(cbPink, "Pink Brick Ingot");
		addItem(cbPurple, "Purple Brick Ingot");
		addItem(cbRed, "Red Brick Ingot");
		addItem(cbYellow, "Yellow Brick Ingot");
		addItem(cbWhite, "White Brick Ingot");
		addItem(cbBlack, "Black Brick Ingot");
		addItem(cbOrange, "Orange Brick Ingot");
		addItem(cbBrown, "Brown Brick Ingot");
		addItem(cbGray, "Gray Brick Ingot");
		addItem(cbLightGray, "Light Gray Brick Ingot");
		addItem(cbLightBlue, "Light Blue Brick Ingot");
		addItem(cbLime, "Lime Brick Ingot");
		addItem(cbMagenta, "Magenta Bricks");
		addItem(fuelonite, "Fuelonite");
		addItem(blackBerry, "Blackberry");
		addItem(blueBerry, "Blueberry");
		addItem(shineDust, "Shinestone Dust");
		addItem(marbleStick, "Marble Stick");
		addItem(blackMarbleStick, "Black Marble Stick");
		addItem(fuelIngot, "Fueltonium Ingot");
		addItem(friedEgg, "Fried Egg");
		addItem(heart, "Healing Heart");
		addItem(bucketHotWater, "Hot Spring Water Bucket");
		addItem(swampClayBall, "Swamp Clay Ball");
		addItem(saltDust, "Salt");
		addItem(flour, "Wheat Flour");
		addItem(ampIngot, "Amaranth Ingot");
		addItem(ampDust, "Amaranth Dust");
		addItem(ampNugget, "Amaranth Nugget");
		addItem(ampPickaxe, "Amaranth Pickaxe");
		addItem(heartForce, "Heartforce");
		addItem(bucketFuel, "Fueltonium Bucket");
		addItem(sharkLeather, "Shagreen");
		addItem(sharkTooth, "Shark Tooth");
		addItem(butterItem, "Butter Ingot");
		addItem(lapisStick, "Lapis Rod");
		addItem(sharkSword, "Sharktooth Blade");
		addItem(dough, "Dough");
		addItem(biscuit, "Biscuit");
		addItem(baconRaw, "Raw Bacon");
		addItem(baconCooked, "Cooked Bacon");
		addItem(enderBerry, "Ender Berry");
		addItem(enderSeed, "Ender Seed");
		addItem(duckRaw, "Raw Duck Meat");
		addItem(duckCooked, "Cooked Duck Meat");
		addItem(duckFeather, "Duck Feather");
		addItem(duckEgg, "Duck Egg");
		addItem(shadowBone, "Shadow Bone");
		addItem(fishFlakes, "Fish Flakes");
		addItem(fishFood, "Fish Food");
		addItem(enderShard, "Ender Shard");
		addItem(rawShrimp, "Raw Shrimp");
		addItem(cookedShrimp, "Cooked Shrimp");
		addItem(amaranthAxe, "Amaranth Axe");
		addItem(zincIngot, "Zinc Ingot");
		addItem(copperIngot, "Copper Ingot");
		addItem(bronzeIngot, "Bronze Ingot");
		addItem(copperDust, "Copper Dust");
		addItem(zincDust, "Zinc Dust");
		addItem(bronzeDust, "Bronze Dust");
	}

	public static void addItem(Item item, String name) {
		LanguageRegistry.addName(item, name);
	}
}