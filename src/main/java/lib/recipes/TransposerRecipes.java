package alphaitems.lib.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;
import cpw.mods.fml.common.event.FMLInterModComms;

public class TransposerRecipes {
	public static void init() {
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
	}
}