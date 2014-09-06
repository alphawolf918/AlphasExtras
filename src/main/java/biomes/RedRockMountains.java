package alphaitems.biomes;

import alphaitems.blocks.Blocks;

public class RedRockMountains extends StoneMountains {
	
	public RedRockMountains(int par1) {
		super(par1);
		this.temperature = 9F;
		this.setDisableRain();
		this.setBiomeName("Redrock Mountains");
		this.setMinMaxHeight(-0.5F, 2.0F);
		this.topBlock = (byte) Blocks.redRock.blockID;
		this.fillerBlock = (byte) Blocks.redRock.blockID;
	}
}