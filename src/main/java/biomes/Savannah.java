package alphaitems.biomes;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import alphaitems.mobs.entities.EntityHog;
import alphaitems.mobs.entities.EntityTiger;

public class Savannah extends BiomeGenBase {
	public Savannah(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x0044aa;
		this.temperature = 7F;
		this.rainfall = 0F;
		this.setBiomeName("Savannah");
		this.setColor(Biomes.biomeColor);
		this.setMinMaxHeight(0.4F, 0.4F);
		this.setDisableRain();
		this.theBiomeDecorator.flowersPerChunk = 1;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 4;
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(
				EntityTiger.class, 5, 2, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(
				EntityOcelot.class, 5, 2, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(
				EntityCow.class, 15, 6, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(
				EntityHog.class, 5, 6, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(
				EntityPig.class, 5, 6, 10));
		this.topBlock = (byte) Block.grass.blockID;
		this.fillerBlock = (byte) Block.dirt.blockID;
	}
}