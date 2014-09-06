package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import alphaitems.creativetabs.ModTabs;

public class BlockCoral extends BlockFlower {
	public BlockCoral(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("coral");
		this.setTextureName("awei:coral");
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int par1) {
		return (par1 == Block.sponge.blockID || par1 == Block.waterStill.blockID);
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z) {
		return EnumPlantType.Water;
	}
}