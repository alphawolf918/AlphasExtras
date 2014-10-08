package alphaitems.dimensions.venus;

import net.minecraft.world.gen.feature.WorldGenMinable;
import alphaitems.blocks.Blocks;

public class WorldGenMinableVenus extends WorldGenMinable {
	
	public WorldGenMinableVenus(int par1, int par2) {
		super(par1, par2, Blocks.venusSand.blockID);
	}
	
	public WorldGenMinableVenus(int par1, int par2, int par3) {
		super(par1, par2, par3);
	}
}