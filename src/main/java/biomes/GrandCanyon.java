package alphaitems.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import alphaitems.blocks.Blocks;

public class GrandCanyon extends BiomeGenBase {
	
	public GrandCanyon(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x000099;
		this.temperature = 6F;
		this.rainfall = 0.40F;
		this.setBiomeName("Grand Canyon");
		this.setColor(Biomes.biomeColor);
		this.setMinMaxHeight(0.1F, 2.0F);
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.mushroomsPerChunk = 1;
		this.spawnableCreatureList.clear();
		this.topBlock = (byte) Blocks.canyonRock.blockID;
		this.fillerBlock = (byte) Blocks.canyonRock.blockID;
	}
}