package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class SeaLamp extends Block {
	public SeaLamp(int par1) {
		super(par1, Material.glass);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("sealamp");
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setTextureName("awei:sealamp");
		this.setLightValue(1.0F);
		this.setLightOpacity(0);
		this.setStepSound(Block.soundGlassFootstep);
	}
}