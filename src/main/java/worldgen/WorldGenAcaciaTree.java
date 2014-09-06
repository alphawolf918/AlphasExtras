package alphaitems.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import alphaitems.blocks.Blocks;

public class WorldGenAcaciaTree extends WorldGenerator {
	protected int[] GetValidSpawnBlocks() {
		return new int[] { Block.dirt.blockID, Block.grass.blockID,
				Blocks.betterGrass.blockID, Block.snow.blockID };
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
	
	public WorldGenAcaciaTree() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		if (!LocationIsValidSpawn(world, i, j, k))
		{
			return false;
		}
		
		world.setBlock(i + 1, j + 4, k + 3,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 1, j + 4, k + 4,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 1, j + 4, k + 5,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 1, j + 4, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 1, j + 4, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 1, j + 4, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 1, j + 4, k + 9,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 1, j + 4, k + 10,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 1, j + 4, k + 11,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 2, j + 4, k + 3,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 2, j + 4, k + 4, Blocks.acaciaLog.blockID);
		world.setBlock(i + 2, j + 4, k + 5, Blocks.acaciaLog.blockID);
		world.setBlock(i + 2, j + 4, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 2, j + 4, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 2, j + 4, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 2, j + 4, k + 9, Blocks.acaciaLog.blockID);
		world.setBlock(i + 2, j + 4, k + 10, Blocks.acaciaLog.blockID);
		world.setBlock(i + 2, j + 4, k + 11,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 2, j + 5, k + 4,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 2, j + 5, k + 5,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 2, j + 5, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 2, j + 5, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 2, j + 5, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 2, j + 5, k + 9,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 2, j + 5, k + 10,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 3, j + 4, k + 3,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 3, j + 4, k + 4, Blocks.acaciaLog.blockID);
		world.setBlock(i + 3, j + 4, k + 10, Blocks.acaciaLog.blockID);
		world.setBlock(i + 3, j + 4, k + 11,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 3, j + 5, k + 4,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 3, j + 5, k + 5, Blocks.acaciaLog.blockID);
		world.setBlock(i + 3, j + 5, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 3, j + 5, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 3, j + 5, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 3, j + 5, k + 9, Blocks.acaciaLog.blockID);
		world.setBlock(i + 3, j + 5, k + 10,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 3, j + 6, k + 5,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 3, j + 6, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 3, j + 6, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 3, j + 6, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 3, j + 6, k + 9,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 4, k + 3,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 4, k + 4, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 4, k + 10, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 4, k + 11,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 5, k + 4,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 5, k + 5, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 5, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 5, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 5, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 5, k + 9, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 5, k + 10,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 6, k + 5,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 6, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 6, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 6, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 4, j + 6, k + 9,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 7, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 7, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 7, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 4, j + 8, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 0, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 1, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 2, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 3, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 4, k + 3,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 4, k + 4, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 4, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 4, k + 10, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 4, k + 11,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 5, k + 4,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 5, k + 5, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 5, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 5, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 5, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 5, k + 9, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 5, k + 10,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 6, k + 5,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 6, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 6, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 6, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 6, k + 9,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 7, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 7, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 5, j + 7, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 8, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 8, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 8, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 5, j + 9, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 4, k + 3,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 4, k + 4, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 4, k + 10, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 4, k + 11,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 5, k + 4,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 5, k + 5, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 5, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 5, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 5, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 5, k + 9, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 5, k + 10,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 6, k + 5,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 6, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 6, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 6, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 6, j + 6, k + 9,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 7, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 7, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 7, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 6, j + 8, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 7, j + 4, k + 3,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 7, j + 4, k + 4, Blocks.acaciaLog.blockID);
		world.setBlock(i + 7, j + 4, k + 10, Blocks.acaciaLog.blockID);
		world.setBlock(i + 7, j + 4, k + 11,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 7, j + 5, k + 4,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 7, j + 5, k + 5, Blocks.acaciaLog.blockID);
		world.setBlock(i + 7, j + 5, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 7, j + 5, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 7, j + 5, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 7, j + 5, k + 9, Blocks.acaciaLog.blockID);
		world.setBlock(i + 7, j + 5, k + 10,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 7, j + 6, k + 5,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 7, j + 6, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 7, j + 6, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 7, j + 6, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 7, j + 6, k + 9,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 8, j + 4, k + 3,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 8, j + 4, k + 4, Blocks.acaciaLog.blockID);
		world.setBlock(i + 8, j + 4, k + 5, Blocks.acaciaLog.blockID);
		world.setBlock(i + 8, j + 4, k + 6, Blocks.acaciaLog.blockID);
		world.setBlock(i + 8, j + 4, k + 7, Blocks.acaciaLog.blockID);
		world.setBlock(i + 8, j + 4, k + 8, Blocks.acaciaLog.blockID);
		world.setBlock(i + 8, j + 4, k + 9, Blocks.acaciaLog.blockID);
		world.setBlock(i + 8, j + 4, k + 10, Blocks.acaciaLog.blockID);
		world.setBlock(i + 8, j + 4, k + 11,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 8, j + 5, k + 4,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 8, j + 5, k + 5,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 8, j + 5, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 8, j + 5, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 8, j + 5, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 8, j + 5, k + 9,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 8, j + 5, k + 10,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 9, j + 4, k + 3,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 9, j + 4, k + 4,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 9, j + 4, k + 5,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 9, j + 4, k + 6,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 9, j + 4, k + 7,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 9, j + 4, k + 8,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 9, j + 4, k + 9,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 9, j + 4, k + 10,
				Blocks.acaciaLeaves.blockID);
		world.setBlock(i + 9, j + 4, k + 11,
				Blocks.acaciaLeaves.blockID);
		return true;
	}
}