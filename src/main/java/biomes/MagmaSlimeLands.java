package alphaitems.biomes;

import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import alphaitems.blocks.Blocks;

public class MagmaSlimeLands extends BiomeGenBase {
	public MagmaSlimeLands(int par1) {
		super(par1);
		this.waterColorMultiplier = 0xaa0022;
		this.setColor(Biomes.biomeColor);
		this.setBiomeName("Magma Slime Lands");
		this.temperature = 10F;
		this.setMinMaxHeight(0.1F, 0.1F);
		this.setDisableRain();
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class,
				10,
				2, 6));
		this.topBlock = (byte) Blocks.magmaSlime.blockID;
		this.fillerBlock = (byte) Blocks.magmaSlime.blockID;
	}
}