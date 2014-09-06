package alphaitems.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import alphaitems.mobs.entities.EntityJellyfish;

public class BiomeSpongeField extends BiomeGenBase {
	
	public BiomeSpongeField(int par1) {
		super(par1);
		this.waterColorMultiplier = 0xdd00ff;
		this.setColor(Biomes.biomeColor);
		this.temperature = 5F;
		this.setBiomeName("Coral Reef");
		this.setMinMaxHeight(-0.4F, 0.9F);
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.add(new SpawnListEntry(
				EntityJellyfish.class, 20, 2, 4));
		this.theBiomeDecorator.clayPerChunk = 4;
		this.topBlock = (byte) Block.sponge.blockID;
		this.fillerBlock = (byte) Block.sponge.blockID;
	}
}