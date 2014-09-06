package alphaitems.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import alphaitems.blocks.Blocks;

public class ColdDesert extends BiomeGenBase {
	public ColdDesert(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x0099ff;
		this.setBiomeName("Cold Desert");
		this.setColor(Biomes.biomeColor);
		this.setEnableSnow();
		this.temperature = 0F;
		this.rainfall = 0.5F;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.theBiomeDecorator.generateLakes = true;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.cactiPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.topBlock = (byte) Blocks.coldSand.blockID;
		this.fillerBlock = (byte) Blocks.coldSandStone.blockID;
	}
}