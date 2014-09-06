package alphaitems.blocks.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import alphaitems.lib.Ids;

public class FluidFuel extends Fluid {
	
	public FluidFuel(String fluidName) {
		super(fluidName);
		this.setDensity(80);
		this.setViscosity(600);
		this.setBlockID(Ids.fuelLiquidID);
		this.setLuminosity(20);
		this.setUnlocalizedName("fuelFluid");
		this.setGaseous(true);
		this.setTemperature(800);
		this.rarity = rarity.uncommon;
		FluidRegistry.registerFluid(this);
	}
}