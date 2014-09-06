package alphaitems.biomes;

import net.minecraft.block.Block;

public class MinersLand extends StoneMountains {
	
	public MinersLand(int par1) {
		super(par1);
		this.temperature = 6F;
		this.setBiomeName("Miner's Land");
		this.setColor(Biomes.biomeColor);
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.topBlock = (byte) Block.stone.blockID;
		this.fillerBlock = (byte) Block.stone.blockID;
	}
}