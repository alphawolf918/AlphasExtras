package alphaitems.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import alphaitems.blocks.Blocks;

public class WandererHouse extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] { Blocks.venusSand.blockID,
				Blocks.venusRock.blockID };
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
			} else if (blockID == Blocks.venusRock.blockID
					&& blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public WandererHouse() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k))
		{
			return false;
		}
		
		world.setBlock(i + 0, j + 0, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 0, k + 1,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 0, k + 3,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 0, k + 4,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 0, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 1, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 1, k + 1,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 1, k + 3,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 1, k + 4,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 1, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 2, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 2, k + 1,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 2, k + 2,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 2, k + 3,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 2, k + 4,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 2, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 1, j + 0, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 1, j + 0, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 1, j + 1, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 1, j + 1, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 1, j + 2, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 1, j + 2, k + 1, Blocks.shineStone.blockID);
		world.setBlock(i + 1, j + 2, k + 2, Blocks.shineStone.blockID);
		world.setBlock(i + 1, j + 2, k + 3, Blocks.shineStone.blockID);
		world.setBlock(i + 1, j + 2, k + 4, Blocks.shineStone.blockID);
		world.setBlock(i + 1, j + 2, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 2, j + 0, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 2, j + 0, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 2, j + 1, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 2, j + 1, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 2, j + 2, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 2, j + 2, k + 1, Blocks.shineStone.blockID);
		world.setBlock(i + 2, j + 2, k + 2, Blocks.shineStone.blockID);
		world.setBlock(i + 2, j + 2, k + 3, Blocks.shineStone.blockID);
		world.setBlock(i + 2, j + 2, k + 4, Blocks.shineStone.blockID);
		world.setBlock(i + 2, j + 2, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 3, j + 0, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 3, j + 0, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 3, j + 1, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 3, j + 1, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 3, j + 2, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 3, j + 2, k + 1, Blocks.shineStone.blockID);
		world.setBlock(i + 3, j + 2, k + 2, Blocks.shineStone.blockID);
		world.setBlock(i + 3, j + 2, k + 3, Blocks.shineStone.blockID);
		world.setBlock(i + 3, j + 2, k + 4, Blocks.shineStone.blockID);
		world.setBlock(i + 3, j + 2, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 4, j + 0, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 4, j + 0, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 4, j + 1, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 4, j + 1, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 4, j + 2, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 4, j + 2, k + 1, Blocks.shineStone.blockID);
		world.setBlock(i + 4, j + 2, k + 2, Blocks.shineStone.blockID);
		world.setBlock(i + 4, j + 2, k + 3, Blocks.shineStone.blockID);
		world.setBlock(i + 4, j + 2, k + 4, Blocks.shineStone.blockID);
		world.setBlock(i + 4, j + 2, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 0, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 0, k + 1,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 0, k + 2,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 0, k + 3,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 0, k + 4,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 0, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 1, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 1, k + 1,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 1, k + 2,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 1, k + 3,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 1, k + 4,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 1, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 2, k + 0,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 2, k + 1,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 2, k + 2,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 2, k + 3,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 2, k + 4,
				Blocks.venusRock.blockID);
		world.setBlock(i + 5, j + 2, k + 5,
				Blocks.venusRock.blockID);
		world.setBlock(i + 0, j + 1, k + 2, Block.doorWood.blockID);
		System.out.println("Wanderer House spawned at: " + i + " " + j
				+ " " + k);
		return true;
	}
}