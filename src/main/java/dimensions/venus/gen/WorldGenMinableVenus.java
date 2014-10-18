package alphaitems.dimensions.venus.gen;

import net.minecraft.world.gen.feature.WorldGenMinable;
import alphaitems.lib.Ids;

public class WorldGenMinableVenus extends WorldGenMinable {
	
	public WorldGenMinableVenus(int par1, int par2) {
		super(par1, par2, Ids.venusSandID);
	}
	
	public WorldGenMinableVenus(int par1, int par2, int par3) {
		super(par1, par2, par3);
	}
}