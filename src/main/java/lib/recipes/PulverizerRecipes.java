package alphaitems.lib.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;
import alphaitems.lib.modhelper.ThermalExpansionHelper;
import cpw.mods.fml.common.event.FMLInterModComms;

public class PulverizerRecipes {
	public static void init() {
		// Regular SPC Ore
		NBTTagCompound spcSend = new NBTTagCompound();
		int pulvEnergy = 1600;
		int pulvSecondaryChance = 30;
		ItemStack pulvInput = new ItemStack(Blocks.spcOre, 1);
		ItemStack pulvOutput = new ItemStack(Items.spcItem, 2);
		ItemStack pulvSecondaryOutput = new ItemStack(Item.coal, 2);
		ThermalExpansionHelper.addPulverizerRecipe(pulvEnergy, pulvInput,
				pulvSecondaryOutput, pulvSecondaryOutput,
				pulvSecondaryChance);
		
		// Nether SPC Ore
		NBTTagCompound spcnSend = new NBTTagCompound();
		int pulvEnergy1 = 1800;
		int pulvSecondaryChance1 = 60;
		ItemStack pulvInput1 = new ItemStack(Blocks.spcNetherOre, 1);
		ItemStack pulvOutput1 = new ItemStack(Items.spcItem, 4);
		ItemStack pulvSecondaryOutput1 = new ItemStack(Item.coal, 2);
		ThermalExpansionHelper.addPulverizerRecipe(pulvEnergy1,
				pulvInput1, pulvSecondaryOutput, pulvSecondaryOutput1,
				pulvSecondaryChance1);
		
		// Super Charged Ender Ore
		int pulvEnergy11 = 2000;
		int pulvSecondaryChance11 = 80;
		ItemStack pulvInput11 = new ItemStack(Blocks.enderSpcOre, 1);
		ItemStack pulvOutput11 = new ItemStack(Items.spcItem, 6);
		ItemStack pulvSecondaryOutput11 = new ItemStack(Item.coal, 2);
		ThermalExpansionHelper.addPulverizerRecipe(pulvEnergy11,
				pulvInput11, pulvSecondaryOutput1, pulvSecondaryOutput11,
				pulvSecondaryChance11);
		
		// Venus Iron
		ThermalExpansionHelper.addPulverizerRecipe(4000, new ItemStack(
				Blocks.venusIronOre, 6), new ItemStack(Block.oreIron, 4));
		
		// Venus Gold
		ThermalExpansionHelper.addPulverizerRecipe(4500, new ItemStack(
				Blocks.venusGoldOre, 6), new ItemStack(Block.oreGold, 4));
		
		// Venus Diamond
		ThermalExpansionHelper.addPulverizerRecipe(4550, new ItemStack(
				Blocks.venusDiamondOre, 1), new ItemStack(
				Block.oreDiamond, 6));
		
		// Venus Redstone
		ThermalExpansionHelper.addPulverizerRecipe(4510, new ItemStack(
				Blocks.venusRedstoneOre, 1), new ItemStack(
				Block.oreRedstone, 6));
		
		// Venus Coal
		ThermalExpansionHelper.addPulverizerRecipe(4010, new ItemStack(
				Blocks.venusCoalOre, 1), new ItemStack(
				Block.oreCoal, 6));
		
		// Venus Super Charged Coal
		ThermalExpansionHelper.addPulverizerRecipe(4010, new ItemStack(
				Blocks.venusSpcOre, 1), new ItemStack(
				Blocks.spcOre, 6));
		
		// Venus Fueltonium
		ThermalExpansionHelper.addPulverizerRecipe(4010, new ItemStack(
				Blocks.venusFnOre, 1), new ItemStack(
				Blocks.fueltonium, 6));
		
		// Venus Amaranth
		ThermalExpansionHelper.addPulverizerRecipe(4010, new ItemStack(
				Blocks.venusAmaranthOre, 1), new ItemStack(
				Blocks.amaranthOre, 6));
		
		// Venus Shard
		ThermalExpansionHelper.addPulverizerRecipe(4010, new ItemStack(
				Blocks.venusShardOre, 1), new ItemStack(
				Blocks.enderShardOre, 6));
		
		// Regular FN Ore
		NBTTagCompound fSend = new NBTTagCompound();
		int pulvEnergy111 = 2800;
		int pulvSecondaryChance111 = 10;
		ItemStack pulvInput111 = new ItemStack(Blocks.fueltonium, 1);
		ItemStack pulvOutput111 = new ItemStack(Items.fuelonite, 2);
		ItemStack pulvSecondaryOutput111 = new ItemStack(Items.spcItem, 2);
		ThermalExpansionHelper.addPulverizerRecipe(pulvEnergy111,
				pulvInput111, pulvSecondaryOutput11,
				pulvSecondaryOutput111, pulvSecondaryChance111);
		
		// Nether FN Ore
		NBTTagCompound fnSend = new NBTTagCompound();
		int pulvEnergy1111 = 2200;
		int pulvSecondaryChance1111 = 10;
		ItemStack pulvInput1111 = new ItemStack(Blocks.fueltonium, 1);
		ItemStack pulvOutput1111 = new ItemStack(Items.fuelonite, 2);
		ItemStack pulvSecondaryOutput1111 = new ItemStack(Items.spcItem, 2);
		ThermalExpansionHelper.addPulverizerRecipe(pulvEnergy1111,
				pulvInput1111, pulvSecondaryOutput1111,
				pulvSecondaryOutput1111, pulvSecondaryChance1111);
		
		// Shard Ore
		NBTTagCompound enderSend = new NBTTagCompound();
		int pulvEnergy11111 = 3200;
		int pulvSecondaryChance11111 = 10;
		ItemStack pulvInput11111 = new ItemStack(Blocks.enderShardOre, 1);
		ItemStack pulvOutput11111 = new ItemStack(Items.enderShard, 2);
		ThermalExpansionHelper.addPulverizerRecipe(pulvEnergy11111,
				pulvInput11111, pulvOutput11111);
		
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
		wheatSend.setInteger("energy", 1000);
		wheatSend.setCompoundTag("input", new NBTTagCompound());
		wheatSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		
		(new ItemStack(Item.wheat, 1)).writeToNBT(wheatSend
				.getCompoundTag("input"));
		(new ItemStack(Items.flour, 2)).writeToNBT(wheatSend
				.getCompoundTag("primaryOutput"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				wheatSend);
		
		// Shrimp
		NBTTagCompound shrimpSend = new NBTTagCompound();
		wheatSend.setInteger("energy", 1000);
		wheatSend.setCompoundTag("input", new NBTTagCompound());
		wheatSend.setCompoundTag("primaryOutput", new NBTTagCompound());
		
		(new ItemStack(Items.rawShrimp, 1)).writeToNBT(shrimpSend
				.getCompoundTag("input"));
		(new ItemStack(Items.fishFlakes, 2)).writeToNBT(shrimpSend
				.getCompoundTag("primaryOutput"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"PulverizerRecipe",
				shrimpSend);
		
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
	}
}