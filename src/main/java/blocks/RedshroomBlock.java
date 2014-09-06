package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import alphaitems.creativetabs.ModTabs;

public class RedshroomBlock extends Block {
	
	public RedshroomBlock(int par1) {
		super(par1, Material.coral);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("redshroomblock");
		this.setHardness(3F);
		this.setResistance(0F);
		this.setStepSound(Block.soundPowderFootstep);
		this.setTextureName("awei:shroomblock");
	}
	
	@Override
	public boolean canSustainPlant(World world, int x, int y, int z,
			ForgeDirection direction, IPlantable plant) {
		int plantID = plant.getPlantID(world, x, y, z);
		return (plantID == Block.mushroomBrown.blockID || plantID == Block.mushroomRed.blockID);
	}
}