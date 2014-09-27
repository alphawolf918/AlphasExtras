package alphaitems.blocks.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Fluids {
	
	public static Fluid fueltonium = new FluidFuel("fuelFluid");
	
	public static void init() {
		FluidRegistry.registerFluid(fueltonium);
		LanguageRegistry.instance().addStringLocalization(
				"fluid.fluidFuel", "en_US", "Fueltonium");
	}
}