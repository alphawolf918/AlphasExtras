package alphaitems.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import alphaitems.blocks.Blocks;

public class WorldGenBerries extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] { Block.dirt.blockID, Block.grass.blockID,
				Block.sand.blockID, Block.gravel.blockID };
	}
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);
		
		while (checkID != 0) {
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}
		
		if (distanceToAir > 3) {
			return false;
		}
		j += distanceToAir - 1;
		
		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j + 1, k);
		int blockIDBelow = world.getBlockId(i, j - 1, k);
		for (int x : GetValidSpawnBlocks()) {
			if (blockIDAbove != 0) {
				return false;
			}
			if (blockID == x) {
				return true;
			} else if (blockID == Block.snow.blockID && blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public WorldGenBerries() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k))
		{
			return false;
		}
		
		world.setBlock(i + 1, j + 0, k + 1, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 5, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 7, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 8, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 9, Block.tilledField.blockID);
		world.setBlock(i + 1, j + 0, k + 10, Block.tilledField.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Block.tilledField.blockID);
		world.setBlock(i + 2, j + 0, k + 10, Block.tilledField.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Block.waterStill.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Block.waterStill.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Block.waterStill.blockID);
		world.setBlock(i + 2, j + 0, k + 5, Block.waterStill.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Block.waterStill.blockID);
		world.setBlock(i + 2, j + 0, k + 7, Block.waterStill.blockID);
		world.setBlock(i + 2, j + 0, k + 8, Block.waterStill.blockID);
		world.setBlock(i + 2, j + 0, k + 9, Block.waterStill.blockID);
		world.setBlock(i + 2, j + 0, k + 10, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 5, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 7, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 8, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 9, Block.tilledField.blockID);
		world.setBlock(i + 3, j + 0, k + 10, Block.tilledField.blockID);
		
		world.setBlock(i + 1, j + 1, k + 1, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 1, j + 1, k + 2, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 1, j + 1, k + 3, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 1, j + 1, k + 4, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 1, j + 1, k + 5, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 1, j + 1, k + 6, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 1, j + 1, k + 7, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 1, j + 1, k + 8, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 1, j + 1, k + 9, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 1, j + 1, k + 10, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 2, j + 1, k + 1, Blocks.blueBerryPlant.blockID);
		world.setBlock(i + 2, j + 1, k + 10, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 1, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 2, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 3, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 4, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 5, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 6, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 7, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 8, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 9, Blocks.blackBerryPlant.blockID);
		world.setBlock(i + 3, j + 1, k + 10, Blocks.blackBerryPlant.blockID);
		
		world.setBlock(i + 1, j - 1, k + 1, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 2, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 3, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 4, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 5, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 6, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 7, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 8, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 9, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 10, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 1, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 2, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 3, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 4, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 5, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 6, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 7, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 8, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 9, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 10, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 1, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 2, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 3, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 4, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 5, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 6, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 7, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 8, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 9, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 10, Block.dirt.blockID);
		
		world.setBlock(i + 1, j - 1, k + 1, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 2, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 3, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 4, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 5, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 6, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 7, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 8, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 9, Block.dirt.blockID);
		world.setBlock(i + 1, j - 1, k + 10, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 1, Block.dirt.blockID);
		world.setBlock(i + 2, j - 1, k + 10, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 1, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 2, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 3, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 4, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 5, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 6, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 7, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 8, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 9, Block.dirt.blockID);
		world.setBlock(i + 3, j - 1, k + 10, Block.dirt.blockID);
		return true;
	}
}