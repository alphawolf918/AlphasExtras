package alphaitems.biomes;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import alphaitems.blocks.Blocks;

public class SlimeLands extends BiomeGenBase {
	public SlimeLands(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x008b00;
		this.setColor(Biomes.biomeColor);
		this.setBiomeName("Slime Lands");
		this.temperature = 8F;
		this.rainfall = 2F;
		this.setMinMaxHeight(0.1F, 0.1F);
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 10,
				8, 10));
		this.topBlock = (byte) Blocks.slimeBlock.blockID;
		this.fillerBlock = (byte) Blocks.slimeBlock.blockID;
	}
}