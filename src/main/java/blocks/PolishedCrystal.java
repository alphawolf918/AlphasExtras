package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class PolishedCrystal extends Block {
	public PolishedCrystal(int par1) {
		super(par1, Material.glass);
		this.setCreativeTab(ModTabs.venusTab);
		this.setUnlocalizedName("polishedcrystal");
		this.setTextureName("awei:polishedcrystal");
		this.setResistance(6F);
		this.setHardness(1.8F);
		this.setLightValue(1.0F);
		this.setStepSound(Block.soundGlassFootstep);
	}
}