package alphaitems.lib.recipes;

import net.minecraft.nbt.NBTTagCompound;
import alphaitems.lib.modhelper.ThermalExpansionHelper;
import cpw.mods.fml.common.event.FMLInterModComms;

public class CDynamoRecipes {
	public static void init() {
		// Compression Dynamo
		ThermalExpansionHelper.addCompressionFuel("fuel", 4000);
		NBTTagCompound cDyn = new NBTTagCompound();
		cDyn.setString("fluidName", "fuelFluid");
		cDyn.setInteger("energy", 4000);
		FMLInterModComms.sendMessage("ThermalExpansion",
				"CompressionFuel",
				cDyn);
	}
}