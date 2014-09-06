package alphaitems.biomes;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class StoneMountains extends BiomeGenBase {
	
	public StoneMountains(int par1) {
		super(par1);
		this.waterColorMultiplier = 0xffffff;
		this.temperature = 2F;
		this.rainfall = 0.40F;
		this.setBiomeName("Stone Mountains");
		this.setColor(Biomes.biomeColor);
		this.setMinMaxHeight(0.1F, 2.0F);
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(
				EntityIronGolem.class, 10,
				1, 2));
		this.topBlock = (byte) Block.stone.blockID;
		this.fillerBlock = (byte) Block.stone.blockID;
	}
}