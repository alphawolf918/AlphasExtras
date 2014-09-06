package alphaitems.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class SnowHills extends BiomeGenBase {
	
	public SnowHills(int id) {
		super(id);
		this.waterColorMultiplier = 0x0099dd;
		this.color = Biomes.biomeColor;
		this.temperature = 0F;
		this.rainfall = 0.2F;
		this.topBlock = (byte) Block.snow.blockID;
		this.fillerBlock = (byte) Block.grass.blockID;
		this.setMinMaxHeight(0.1F, 2.0F);
		this.setBiomeName("Snow Hills");
		this.setEnableSnow();
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
	}
}