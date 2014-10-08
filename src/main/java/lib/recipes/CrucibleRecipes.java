package alphaitems.lib.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;
import alphaitems.lib.modhelper.ThermalExpansionHelper;

public class CrucibleRecipes {
	public static void init() {
		// Fueltonium Liquid From Ingot
		ThermalExpansionHelper.addCrucibleRecipe(5000, new ItemStack(
				Items.fuelIngot, 1),
				new FluidStack(Blocks.fuel,
						FluidContainerRegistry.BUCKET_VOLUME));
	}
}