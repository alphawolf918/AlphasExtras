package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;

public class Crystal extends Block {
	public Crystal(int par1) {
		super(par1, Material.glass);
		this.setCreativeTab(ModTabs.venusTab);
		this.setUnlocalizedName("lostcrystal");
		this.setResistance(4F);
		this.setHardness(0.8F);
		this.setLightValue(0.4F);
		this.setTextureName("awei:lostcrystal");
		this.setStepSound(Block.soundGlassFootstep);
	}
}