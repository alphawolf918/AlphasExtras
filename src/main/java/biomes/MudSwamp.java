package alphaitems.biomes;

import java.util.Random;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;
import alphaitems.blocks.Blocks;

public class MudSwamp extends BiomeGenBase {
	
	public MudSwamp(int par1) {
		super(par1);
		this.temperature = 4F;
		this.setColor(Biomes.biomeColor);
		this.setBiomeName("Mud Swamp");
		this.theBiomeDecorator.treesPerChunk = 2;
		this.theBiomeDecorator.flowersPerChunk = 1;
		this.theBiomeDecorator.deadBushPerChunk = 1;
		this.theBiomeDecorator.mushroomsPerChunk = 10;
		this.theBiomeDecorator.reedsPerChunk = 10;
		this.theBiomeDecorator.clayPerChunk = 1;
		this.theBiomeDecorator.waterlilyPerChunk = 4;
		this.waterColorMultiplier = 14745518;
		this.spawnableMonsterList.add(new SpawnListEntry(
				EntitySlime.class, 1, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(
				EntityWitch.class, 1, 0, 1));
		this.topBlock = (byte) Blocks.swampClay.blockID;
		this.fillerBlock = (byte) Blocks.swampClay.blockID;
		this.theBiomeDecorator.waterlilyPerChunk = 2;
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return this.worldGeneratorSwamp;
	}
	
	@Override
	public int getBiomeFoliageColor() {
		return 0x22bb00;
	}
	
	@Override
	public int getBiomeGrassColor() {
		return 0x22bb00;
	}
	
	@Override
	public int getSkyColorByTemp(float par1)
	{
		return 0xdddddd;
	}
}
