package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.EnumToolClass;
import alphaitems.lib.Methods;

public class RedshroomStem extends Block {
	
	public RedshroomStem(int par1) {
		super(par1, Material.coral);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("redstem");
		this.setHardness(1.2F);
		this.setResistance(0.2F);
		this.setStepSound(Block.soundPowderFootstep);
		this.setTextureName("awei:redstem");
		Methods.ForgeSetToolClass(this, "pickaxe", EnumToolClass.WOOD);
	}
}