package alphaitems.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class IceMountains extends BiomeGenBase {
	
	public IceMountains(int id) {
		super(id);
		this.waterColorMultiplier = 0x0099ff;
		this.color = Biomes.biomeColor;
		this.temperature = 0F;
		this.rainfall = 0.5F;
		this.topBlock = (byte) Block.ice.blockID;
		this.fillerBlock = (byte) Block.ice.blockID;
		this.setMinMaxHeight(0.9F, 2.0F);
		this.setBiomeName("Ice Mountains");
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