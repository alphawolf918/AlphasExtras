package alphaitems.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import alphaitems.blocks.Blocks;

public class BiomeMeadow extends BiomeGenBase {
	
	public BiomeMeadow(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x0000ff;
		this.setColor(Biomes.biomeColor);
		this.setBiomeName("Green Meadow");
		this.topBlock = (byte) Blocks.betterGrass.blockID;
		this.fillerBlock = (byte) Blocks.betterGrass.blockID;
		this.temperature = 5F;
		this.theBiomeDecorator.grassPerChunk = 2;
		this.theBiomeDecorator.flowersPerChunk = 6;
		this.theBiomeDecorator.treesPerChunk = 2;
		this.maxHeight = 1.0F;
		this.minHeight = 1.0F;
	}
}