package alphaitems.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import alphaitems.blocks.Blocks;

public class BadLands extends BiomeGenBase {
	public BadLands(int par1) {
		super(par1);
		this.waterColorMultiplier = 0xaa0022;
		this.setColor(Biomes.biomeColor);
		this.setBiomeName("Bad Lands");
		this.temperature = 8F;
		this.setMinMaxHeight(0.6F, 0.6F);
		this.topBlock = (byte) Blocks.badStone.blockID;
		this.fillerBlock = (byte) Blocks.badStone.blockID;
	}
}