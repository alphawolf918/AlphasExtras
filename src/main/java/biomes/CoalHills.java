package alphaitems.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class CoalHills extends BiomeGenBase {
	public CoalHills(int par1) {
		super(par1);
		this.waterColorMultiplier = 0xaa0022;
		this.setColor(Biomes.biomeColor);
		this.setBiomeName("Coal Hills");
		this.temperature = 8F;
		this.setMinMaxHeight(0.0F, 1.5F);
		this.topBlock = (byte) Block.coalBlock.blockID;
		this.fillerBlock = (byte) Block.oreCoal.blockID;
	}
}