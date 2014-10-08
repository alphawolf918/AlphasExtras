package alphaitems.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import alphaitems.blocks.Blocks;

public class BiomeVenus extends BiomeGenBase {
	
	public BiomeVenus(int par1) {
		super(par1);
		this.setBiomeName("Venus");
		this.setColor(Biomes.biomeColor);
		this.setMinMaxHeight(0.1F, 2.0F);
		this.temperature = 8F;
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.waterColorMultiplier = 0xff8011;
		this.topBlock = (byte) Blocks.venusSand.blockID;
		this.fillerBlock = (byte) Blocks.venusRock.blockID;
	}
}