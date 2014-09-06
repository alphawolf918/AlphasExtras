package alphaitems.blocks.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import alphaitems.lib.Ids;

public class FluidHotWater extends Fluid {
	
	public FluidHotWater(String fluidName) {
		super(fluidName);
		this.setDensity(40);
		this.setViscosity(500);
		this.setBlockID(Ids.hotSpringBlockID);
		this.setLuminosity(15);
		this.setUnlocalizedName("hotspringblock");
		this.setGaseous(true);
		this.setTemperature(300);
		this.rarity = rarity.uncommon;
		FluidRegistry.registerFluid(this);
	}
}