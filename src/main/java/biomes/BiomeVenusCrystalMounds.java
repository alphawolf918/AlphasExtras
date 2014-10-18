package alphaitems.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import alphaitems.blocks.Blocks;

public class BiomeVenusCrystalMounds extends BiomeGenBase {
	
	public BiomeVenusCrystalMounds(int par1) {
		super(par1);
		this.setBiomeName("Crystal Mounds");
		this.setColor(Biomes.biomeColor);
		this.setMinMaxHeight(1.0F, 2.0F);
		this.temperature = 5F;
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.waterColorMultiplier = 0x8b008b;
		this.topBlock = (byte) Blocks.lostCrystal.blockID;
		this.fillerBlock = (byte) Blocks.creepStone.blockID;
	}
}