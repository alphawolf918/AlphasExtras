package alphaitems.managers;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import alphaitems.biomes.Biomes;
import alphaitems.blocks.Blocks;
import alphaitems.dimensions.venus.Venus;
import alphaitems.dimensions.venus.gen.WorldGenMinableVenus;
import alphaitems.dimensions.venus.gen.structure.WorldGenCrystalTower;
import alphaitems.dimensions.venus.gen.structure.WorldGenVenusRuins;
import alphaitems.lib.Ids;
import alphaitems.worldgen.WorldGenAcaciaTree;
import alphaitems.worldgen.WorldGenBerries;
import alphaitems.worldgen.WorldGenEnderMinable;
import alphaitems.worldgen.WorldGenEnderPlant;
import alphaitems.worldgen.WorldGenNetherMinable;
import alphaitems.worldgen.WorldGenSeaLamp;
import alphaitems.worldgen.WorldGenShinestone;
import alphaitems.worldgen.WorldGenSwampClay;
import alphaitems.worldgen.WorldGenTreasureChest;
import alphaitems.worldgen.WorldGenVenusTree;
import cpw.mods.fml.common.IWorldGenerator;

public class EventManager implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ,
			World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case -1:
				this.generateNether(world, random, chunkX * 16,
						chunkZ * 16);
				break;
			case 0:
				this.generateSurface(world, random, chunkX * 16,
						chunkZ * 16);
				break;
			case 1:
				this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
				break;
		}
		
		if (world.provider.dimensionId == Venus.dimId) {
			this.generateVenus(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	private void generateSurface(World world, Random random, int x, int z) {
		// Super Charged Coal Ore
		this.addOreSpawn(Blocks.spcOre, world, random, x, z, 16, 16,
				4 + random.nextInt(10), 15, 4, 22);
		
		// Amaranth Ore
		this.addOreSpawn(Blocks.amaranthOre, world, random, x, z, 16, 16,
				1 + random.nextInt(4), 15, 2, 28);
		
		// Shard Ore
		this.addOreSpawn(Blocks.enderShardOre, world, random, x, z, 16,
				16,
				2 + random.nextInt(2), 15, 6, 48);
		
		// Fine Marble
		this.addOreSpawn(Blocks.marbleBlock, world, random, x, z, 16, 16,
				
				10 + random.nextInt(10), 10, 24, 42);
		
		// Shinestone
		this.addOreSpawn(Blocks.shineStone, world, random, x, z, 16, 16,
				5 + random.nextInt(10), 10, 14, 32);
		
		// Fueltonium
		this.addOreSpawn(Blocks.fueltonium, world, random, x, z, 16, 16,
				4 + random.nextInt(4), 10, 2, 10);
		
		// Heart Block
		this.addOreSpawn(Blocks.heartBlock, world, random, x, z, 16, 16,
				1 + random.nextInt(1), 15, 2, 20);
		
		// Spider Egg
		this.addOreSpawn(Blocks.crawlerEgg, world, random, x, z, 16, 16,
				1, 5, 10, 16);
		
		// Berry Farm
		BiomeGenBase currentBiome = world.getBiomeGenForCoords(x, z);
		int y = world.getHeightValue(x, z);
		if (currentBiome.equals(BiomeGenBase.plains)
				|| currentBiome.equals(BiomeGenBase.extremeHills)
				|| currentBiome.equals(BiomeGenBase.extremeHillsEdge)) {
			this.spawnStructure(2, 520, world, random, x, y, z,
					new WorldGenBerries());
			
			// Hot Springs
			if (currentBiome.equals(BiomeGenBase.desert)
					|| currentBiome.equals(BiomeGenBase.desertHills)
					|| currentBiome.equals(Biomes.badLands)) {
				if (random.nextInt(1000) <= 10) {
					new WorldGenLakes(Blocks.hotWaterBlock.blockID)
							.generate(
									world, random, x, y, z);
				}
			}
		}
		
		// Swamp Clay
		if (currentBiome.equals(BiomeGenBase.swampland)) {
			this.addBlockSpawn(Blocks.swampClay, world, random, x, z, 16,
					16,
					1 + random.nextInt(8), 20, 59, 68);
		}
		
		// Sea Lamp
		if (currentBiome.equals(BiomeGenBase.river)) {
			this.addBlockSpawn(Blocks.seaLamp, world, random, x, z, 16,
					16,
					1 + random.nextInt(4), 20, 28, 68);
		}
		
		// Sea Lamp & Salt
		if (currentBiome.equals(BiomeGenBase.ocean)) {
			this.addBlockSpawn(Blocks.seaLamp, world, random, x, z, 16,
					16,
					4 + random.nextInt(4), 40, 28, 68);
			this.addBlockSpawn(Blocks.saltBlock, world, random, x, z, 16,
					16,
					1 + random.nextInt(4), 15, 28, 48);
		}
		
		if (currentBiome.equals(Biomes.floweryField)) {
			this.spawnStructure(10, 11, world, random, x, y, z,
					new WorldGenFlowers(Blocks.lilac.blockID));
			this.spawnStructure(10, 12, world, random, x, y, z,
					new WorldGenFlowers(Blocks.orangeFlower.blockID));
			this.spawnStructure(10, 13, world, random, x, y, z,
					new WorldGenFlowers(Blocks.aster.blockID));
			this.spawnStructure(10, 14, world, random, x, y, z,
					new WorldGenFlowers(Blocks.heartFlower.blockID));
			this.spawnStructure(10, 15, world, random, x, y, z,
					new WorldGenFlowers(Blocks.cosmos.blockID));
		}
		
		if (currentBiome.equals(BiomeGenBase.forest)) {
			this.spawnStructure(10, 12, world, random, x, y, z,
					new WorldGenFlowers(Blocks.cosmos.blockID));
			this.spawnStructure(10, 11, world, random, x, y, z,
					new WorldGenFlowers(Blocks.lilac.blockID));
		}
		
		if (currentBiome.equals(Biomes.savannah)) {
			this.spawnStructure(7, 10, world, random, x, y, z,
					new WorldGenAcaciaTree());
			this.spawnStructure(10, 12, world, random, x, y, z,
					new WorldGenFlowers(Blocks.orangeFlower.blockID));
			this.spawnStructure(10, 12, world, random, x, y, z,
					new WorldGenFlowers(Blocks.aster.blockID));
		}
		
		if (currentBiome.equals(Biomes.minersLand)) {
			// Super Charged Coal Ore
			this.addOreSpawn(Blocks.spcOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 10, 2, 40);
			// Amaranth
			this.addOreSpawn(Blocks.amaranthOre, world, random, x, z, 16,
					16,
					4 + random.nextInt(8), 10, 2, 40);
			// Fueltonium
			this.addOreSpawn(Blocks.fueltonium, world, random, x, z, 16,
					16,
					4 + random.nextInt(8), 10, 2, 40);
			// Heart Ore
			this.addOreSpawn(Blocks.heartBlock, world, random, x, z, 16,
					16,
					4 + random.nextInt(8), 10, 2, 40);
			
			// Vanilla Ores
			this.addOreSpawn(Block.oreCoal, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 10, 2, 40);
			this.addOreSpawn(Block.oreIron, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 10, 2, 40);
			this.addOreSpawn(Block.oreGold, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 10, 2, 40);
			this.addOreSpawn(Block.oreRedstone, world, random, x, z, 16,
					16,
					4 + random.nextInt(8), 10, 2, 40);
			this.addOreSpawn(Block.oreDiamond, world, random, x, z, 16,
					16,
					4 + random.nextInt(8), 10, 2, 40);
			this.addOreSpawn(Block.oreLapis, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 10, 2, 40);
			this.addOreSpawn(Block.oreEmerald, world, random, x, z, 16,
					16,
					4 + random.nextInt(8), 10, 2, 40);
			this.spawnStructure(5, 10, world, random, x, y, z,
					new WorldGenLakes(Block.obsidian.blockID));
		}
		
		if (currentBiome.equals(Biomes.badLands)) {
			this.spawnStructure(8, 10, world, random, x, y, z,
					new WorldGenLakes(Block.lavaStill.blockID));
		}
		
		if (currentBiome.equals(Biomes.snowHills)) {
			this.spawnStructure(5, 10, world, random, x, y, z,
					new WorldGenLakes(Block.ice.blockID));
		}
		
		if (currentBiome.equals(Biomes.spongeField)) {
			this.spawnStructure(14, 15, world, random, x, y, z,
					new WorldGenFlowers(Blocks.coral.blockID));
		}
		
		if (currentBiome.equals(Biomes.rainForest)) {
			this.spawnStructure(14, 15, world, random, x, y, z,
					new WorldGenHugeTrees(true, 40, 4, 4));
		}
		
		if (currentBiome.equals(Biomes.mudSwamp)) {
			this.spawnStructure(5, 10, world, random, x, y, z,
					new WorldGenLakes(Block.dirt.blockID));
		}
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16);
		int Ycoord = 10 + random.nextInt(80);
		int Zcoord = z + random.nextInt(16);
		
		// Ender Super Coal Ore
		new WorldGenEnderMinable(Blocks.enderSpcOre.blockID, 1, 4)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
		
		// Ender Fueltonium Ore
		new WorldGenEnderMinable(Blocks.enderFnOre.blockID, 1, 2)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
		
		// Ender Amaranth Ore
		new WorldGenEnderMinable(Blocks.amaranthEnderOre.blockID, 1, 2)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
		
		// Ender Dirt
		new WorldGenEnderMinable(Blocks.enderDirt.blockID, 4, 16)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
		
		// Ender Berries
		this.spawnStructure(2, 120, world, random, x, Ycoord, z,
				new WorldGenEnderPlant());
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16);
		int Ycoord = 10 + random.nextInt(128);
		int Zcoord = z + random.nextInt(16);
		
		// Nether Super Coal Ore
		new WorldGenNetherMinable(Blocks.spcNetherOre.blockID, 2, 4)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
		
		// Nether Fueltonium Ore
		new WorldGenNetherMinable(Blocks.fnOre.blockID, 2, 4)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
		
		// Magma Slime
		new WorldGenNetherMinable(Blocks.magmaSlime.blockID, 2, 4)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
		
		// Nether Amaranth Ore
		new WorldGenNetherMinable(Blocks.amaranthNetherOre.blockID, 1, 5)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
		
		// Nether Dirt Ore
		new WorldGenNetherMinable(Blocks.netherDirt.blockID, 10, 25)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
		
		// Brimstone
		new WorldGenNetherMinable(Blocks.brimStone.blockID, 20, 45)
				.generate(
						world, random, Xcoord, Ycoord, Zcoord);
	}
	
	private void generateVenus(World world, Random random, int x, int z) {
		// Venus Rock
		this.addVenusOreSpawn(Blocks.venusRock, world, random, x, z,
				16, 16,
				10 + random.nextInt(48), 86, 2, 56);
		
		// Iron Ore
		this.addVenusOreSpawn(Blocks.venusIronOre, world, random, x, z,
				16, 16,
				4 + random.nextInt(4), 10, 1, 50);
		
		// Gold Ore
		this.addVenusOreSpawn(Blocks.venusGoldOre, world, random, x, z,
				16, 16,
				4 + random.nextInt(4), 5, 1, 35);
		
		// Bronze Ore
		this.addVenusOreSpawn(Blocks.bronzeOre, world, random, x, z,
				16, 16,
				2 + random.nextInt(4), 4, 10, 26);
		
		// Lead Ore
		this.addVenusOreSpawn(Blocks.leadOre, world, random, x, z,
				16, 16,
				2 + random.nextInt(4), 5, 6, 32);
		
		// Ferrous Ore
		this.addVenusOreSpawn(Blocks.ferrousOre, world, random, x, z,
				16, 16,
				2 + random.nextInt(2), 5, 6, 32);
		
		// Silver Ore
		this.addVenusOreSpawn(Blocks.silverOre, world, random, x, z,
				16, 16,
				2 + random.nextInt(2), 5, 6, 32);
		
		// Tin Ore
		this.addVenusOreSpawn(Blocks.tinOre, world, random, x, z,
				16, 16,
				2 + random.nextInt(2), 6, 6, 32);
		
		// Diamond Ore
		this.addVenusOreSpawn(Blocks.venusDiamondOre, world, random, x, z,
				16, 16,
				1 + random.nextInt(4), 2, 4, 16);
		
		// Emerald Ore
		this.addVenusOreSpawn(Blocks.venusEmeraldOre, world, random, x, z,
				16, 16,
				1 + random.nextInt(1), 2, 10, 14);
		
		// Redstone Ore
		this.addVenusOreSpawn(Blocks.venusRedstoneOre, world, random, x,
				z,
				16, 16,
				1 + random.nextInt(4), 4, 4, 36);
		
		// Coal Ore
		this.addVenusOreSpawn(Blocks.venusCoalOre, world, random, x,
				z,
				16, 16,
				4 + random.nextInt(10), 35, 4, 48);
		
		// Super Coal Ore
		this.addVenusOreSpawn(Blocks.venusSpcOre, world, random, x,
				z,
				16, 16,
				2 + random.nextInt(8), 4, 4, 48);
		
		// Shard Ore
		this.addVenusOreSpawn(Blocks.venusShardOre, world, random, x,
				z,
				16, 16,
				2 + random.nextInt(8), 2, 4, 48);
		
		// Fueltonium Ore
		this.addVenusOreSpawn(Blocks.venusFnOre, world, random, x,
				z,
				16, 16,
				1 + random.nextInt(4), 2, 4, 24);
		
		// Zinc Ore
		this.addVenusOreSpawn(Blocks.venusZincOre, world, random, x,
				z,
				16, 16,
				2 + random.nextInt(4), 8, 2, 44);
		
		// Copper Ore
		this.addVenusOreSpawn(Blocks.venusCopperOre, world, random, x,
				z,
				16, 16,
				2 + random.nextInt(4), 14, 2, 59);
		
		// Better Grass
		this.addVenusOreSpawn(Blocks.betterGrass, world, random, x,
				z,
				16, 16,
				10 + random.nextInt(14), 20, 62, 68);
		
		// Creep Stone
		this.addVenusOreSpawn(Blocks.creepStone, world, random, x,
				z,
				16, 16,
				10 + random.nextInt(10), 15, 4, 46);
		
		// Chest Gen
		if (random.nextInt(10) <= 4) {
			this.spawnStructure(10, 136, world, random, x,
					world.getHeightValue(x, z), z,
					new WorldGenTreasureChest());
		}
		
		int y = world.getHeightValue(x, z);
		
		// Crystal Tower
		if (random.nextInt(15) <= 2) {
			this.spawnStructure(10, 436, world, random, x,
					y - 10, z,
					new WorldGenCrystalTower());
		}
		
		// Grass Gen
		this.spawnStructure(5, 6, world, random, x, y, z,
				new WorldGenLakes(Blocks.betterGrass.blockID));
		
		// Tree Gen
		this.spawnStructure(5, 8, world, random, x, y, z,
				new WorldGenVenusTree(true, 40));
		
		// Shinestone Gen
		this.spawnStructure(5, 10, world, random, x, y, z,
				new WorldGenShinestone());
		
		// Ruins
		if (random.nextInt(10) <= 4) {
			this.spawnStructure(10, 836, world, random, x,
					y - 10, z,
					new WorldGenVenusRuins());
		}
	}
	
	/**
	 * Spawns a structure in the world
	 *
	 * @author Alpha Wolf
	 * @param minChance
	 *            The minimum chance that the structure has to spawn.
	 * @param maxChance
	 *            The maximum chance that the structure has to spawn.
	 * @param world
	 *            The world for the structure to spawn in.
	 * @param random
	 *            Needed for randomization and comparison.
	 * @param x
	 *            The X coordinate to spawn in at.
	 * @param y
	 *            The Y coordinate to spawn in at.
	 * @param z
	 * @param wg
	 *            The structure.
	 */
	public static void spawnStructure(int minChance, int maxChance,
			World world,
			Random random, int x, int y, int z, WorldGenerator wg) {
		if (random.nextInt(maxChance) == minChance) {
			wg.generate(world, random, x, y, z);
		}
	}
	
	public void addVenusOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ,
			int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		int maxPossY = minY + maxY - 1;
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block.blockID, maxVeinSize).generate(
					world, random, posX, posY, posZ);
		}
		
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinableVenus(block.blockID, maxVeinSize,
					Ids.venusRockID)
					.generate(
							world, random, posX, posY, posZ);
		}
		
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinableVenus(block.blockID, maxVeinSize)
					.generate(
							world, random, posX, posY, posZ);
		}
	}
	
	public void addOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ,
			int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		int maxPossY = minY + maxY - 1;
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block.blockID, maxVeinSize).generate(
					world,
					random, posX, posY, posZ);
		}
	}
	
	public void addBlockSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ,
			int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		WorldGenerator wg = null;
		int maxPossY = minY + maxY - 1;
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			if (block.equals(Blocks.swampClay)
					|| block.equals(Blocks.betterGrass)) {
				wg = new WorldGenSwampClay(block.blockID, maxVeinSize);
			} else if (block.equals(Blocks.seaLamp)) {
				wg = new WorldGenSeaLamp(block.blockID, maxVeinSize);
			} else {
				wg = new WorldGenMinable(block.blockID, maxVeinSize);
			}
			wg.generate(world,
					random, posX, posY, posZ);
		}
	}
}