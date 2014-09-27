package alphaitems.biomes;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import alphaitems.blocks.Blocks;
import alphaitems.mobs.entities.EntityPigshroom;
import alphaitems.mobs.entities.EntityShadowSkeleton;

public class MushroomForest extends BiomeGenBase {
	
	public MushroomForest(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x00008b;
		this.temperature = 4F;
		this.setBiomeName("Mushroom Forest");
		this.setColor(Biomes.biomeColor);
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(
				EntityWitch.class, 2, 0, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(
				EntityShadowSkeleton.class, 2, 0, 1));
		this.spawnableCreatureList.add(new SpawnListEntry(
				EntityMooshroom.class, 4, 2, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(
				EntityPigshroom.class, 4, 2, 6));
		this.rainfall = 1F;
		this.theBiomeDecorator.flowersPerChunk = 4;
		this.theBiomeDecorator.treesPerChunk = 6;
		this.theBiomeDecorator.grassPerChunk = 5;
		this.theBiomeDecorator.reedsPerChunk = 2;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = 100;
		this.theBiomeDecorator.bigMushroomsPerChunk = 80;
		this.theBiomeDecorator.clayPerChunk = 2;
		this.theBiomeDecorator.generateLakes = true;
		this.topBlock = (byte) Blocks.betterGrass.blockID;
		this.fillerBlock = (byte) Block.dirt.blockID;
	}
	
	@Override
	public int getBiomeGrassColor() {
		return 0x2e0854;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return 0x2e0854;
	}
}