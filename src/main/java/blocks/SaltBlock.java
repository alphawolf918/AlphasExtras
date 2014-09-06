package alphaitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import alphaitems.creativetabs.ModTabs;

public class SaltBlock extends BlockSand {
	
	public SaltBlock(int par1) {
		super(par1, Material.sand);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("saltblock");
		this.setHardness(0.2F);
		this.setResistance(0.0F);
		this.setStepSound(Block.soundSandFootstep);
		this.setTextureName("awei:salt");
		this.setTickRandomly(true);
	}
	
	@Override
	public boolean canSustainPlant(World world, int x, int y, int z,
			ForgeDirection direction, IPlantable plant) {
		int plantID = plant.getPlantID(world, x, y, z);
		return (plantID == Block.cactus.blockID
		|| plantID == Block.deadBush.blockID);
	}
}