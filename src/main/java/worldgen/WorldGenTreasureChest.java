package alphaitems.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import alphaitems.blocks.Blocks;
import alphaitems.treasures.Treasures;

public class WorldGenTreasureChest extends WorldGenerator {
	int randInt = (int) (Math.random() * Math.floor(10));
	
	protected int[] GetValidSpawnBlocks() {
		return new int[] { Blocks.venusSand.blockID };
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
			} else if (blockID == Blocks.venusSand.blockID
					&& blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public WorldGenTreasureChest() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k)) {
			return false;
		}
		int randDist = rand.nextInt(10);
		int chestX = i + 0;
		int chestY = j - 2;
		int chestZ = k + 0;
		int chestRand = rand.nextInt(2);
		boolean isBigChest = (chestRand == 1) ? true : false;
		String chestString = chestX + " " + chestY + " " + chestZ;
		
		world.setBlock(chestX, chestY, chestZ, Block.chest.blockID);
		if (randInt == 5) {
			Treasures.spawnChest(world, rand, chestX, chestY, chestZ,
					isBigChest,
					Treasures.pickChestType());
			world.setBlock(i + randDist, j + 0, k + (randDist + 2),
					Blocks.lostCrystal.blockID);
			world.setBlock(i + randDist + 1, j + 1, k + (randDist + 1),
					Blocks.polishedCrystal.blockID);
			world.setBlock(i + randDist + 2, j + 1, k + (randDist + 2),
					Blocks.lostCrystal.blockID);
			world.setBlock(i + randDist + 3, j + 2, k + (randDist + 4),
					Blocks.polishedCrystal.blockID);
			world.setBlock(i + randDist + 4, j + 2, k + (randDist + 6),
					Blocks.polishedCrystal.blockID);
			world.setBlock(i + randDist + 5, j + 2, k + (randDist + 6),
					Blocks.polishedCrystal.blockID);
			world.setBlock(i + randDist + 6, j + 2, k + (randDist + 6),
					Blocks.polishedCrystal.blockID);
			if ((randInt + 1) == 2) {
				world.setBlock(i + (randDist + 4), j + randInt, k
						+ (randDist + 2),
						Blocks.lostCrystal.blockID);
				world.setBlock(i + randDist + 5, j + (randInt + 2), k
						+ (randDist + 2),
						Blocks.lostCrystal.blockID);
			}
		}
		return true;
	}
}