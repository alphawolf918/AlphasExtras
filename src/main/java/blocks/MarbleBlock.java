package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;

public class MarbleBlock extends Block {
	public MarbleBlock(int par1Id) {
		super(par1Id, Material.iron);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("marbleblock");
		this.setLightValue(0.8F);
		this.setHardness(3.6F);
		this.setResistance(9.9F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setTextureName("awei:marble");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
	}
}