package alphaitems.biomes;

import java.awt.Color;

import net.minecraft.world.biome.BiomeGenBase;
import alphaitems.blocks.Blocks;

public class BiomeSaltLake extends BiomeGenBase {
	
	public BiomeSaltLake(int par1) {
		super(par1);
		this.waterColorMultiplier = 0xffffff;
		this.theBiomeDecorator.generateLakes = false;
		this.setDisableRain();
		this.setColor(Biomes.biomeColor);
		this.setBiomeName("Salt Lake");
		this.topBlock = (byte) Blocks.saltBlock.blockID;
		this.fillerBlock = (byte) Blocks.saltBlock.blockID;
		this.temperature = 10F;
		this.rainfall = 0F;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = 4;
		this.theBiomeDecorator.cactiPerChunk = 4;
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.maxHeight = 1.0F;
		this.minHeight = 1.0F;
	}
	
	@Override
	public int getSkyColorByTemp(float par1)
	{
		par1 /= 3.0F;
		
		if (par1 < -1.0F)
		{
			par1 = -1.0F;
		}
		
		if (par1 > 1.0F)
		{
			par1 = 1.0F;
		}
		
		return Color.getHSBColor(0.62222224F - par1 * 1.05F,
				0.5F + par1 * 1.1F, 1.5F).getRGB();
	}
	
	@Override
	public boolean canSpawnLightningBolt() {
		return false;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.0F;
	}
}