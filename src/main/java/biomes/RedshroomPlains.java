package alphaitems.biomes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import alphaitems.blocks.Blocks;

public class RedshroomPlains extends BiomeGenBase {
	
	public RedshroomPlains(int par1) {
		super(par1);
		this.waterColorMultiplier = 0xdd00ff;
		this.setColor(Biomes.biomeColor);
		this.temperature = 4F;
		this.spawnableMonsterList.clear();
		this.setBiomeName("Redshroom Plains");
		this.setMinMaxHeight(0.3F, 0.4F);
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(
				EntityMooshroom.class, 5, 6, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class,
				1, 1, 2));
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = 2;
		this.theBiomeDecorator.bigMushroomsPerChunk = 5;
		this.topBlock = (byte) Blocks.redShroomBlock.blockID;
		this.fillerBlock = (byte) Blocks.redShroomStem.blockID;
	}
}
