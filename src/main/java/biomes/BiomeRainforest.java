package alphaitems.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import alphaitems.blocks.Blocks;

public class BiomeRainforest extends BiomeGenBase {
	
	public BiomeRainforest(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x000044;
		this.setColor(Biomes.biomeColor);
		this.setBiomeName("Rainforest");
		this.topBlock = (byte) Blocks.betterGrass.blockID;
		this.fillerBlock = (byte) Blocks.swampClay.blockID;
		this.temperature = 6F;
		this.rainfall = 10F;
		this.theBiomeDecorator.grassPerChunk = 0;
		this.theBiomeDecorator.flowersPerChunk = 10;
		this.theBiomeDecorator.treesPerChunk = 15;
		this.theBiomeDecorator.clayPerChunk = 2;
		this.theBiomeDecorator.reedsPerChunk = 4;
		this.maxHeight = 1.0F;
		this.minHeight = 0.5F;
	}
}