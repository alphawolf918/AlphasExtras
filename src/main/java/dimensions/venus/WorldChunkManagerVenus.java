package alphaitems.dimensions.venus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import alphaitems.biomes.Biomes;
import alphaitems.dimensions.venus.gen.GenLayerVenus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldChunkManagerVenus extends WorldChunkManager
{
	
	private GenLayer genBiomes;
	private GenLayer biomeIndexLayer;
	private BiomeCache biomeCache;
	private List<BiomeGenBase> biomesToSpawnIn;
	
	public WorldChunkManagerVenus()
	{
		this.biomeCache = new BiomeCache(this);
		this.biomesToSpawnIn = new ArrayList<BiomeGenBase>();
		this.biomesToSpawnIn.add(Biomes.venus);
	}
	
	public WorldChunkManagerVenus(World world)
	{
		this(world.getSeed(), world.provider.terrainType);
	}
	
	public WorldChunkManagerVenus(long seed, WorldType worldtype)
	{
		this();
		GenLayer[] agenlayer = GenLayerVenus.makeTheWorld(seed);
		this.genBiomes = agenlayer[0];
		this.biomeIndexLayer = agenlayer[1];
	}
	
	/**
	 * Gets the list of valid biomes for the player to spawn in.
	 */
	@Override
	public List<BiomeGenBase> getBiomesToSpawnIn()
	{
		return this.biomesToSpawnIn;
	}
	
	@Override
	public BiomeGenBase getBiomeGenAt(int x, int z)
	{
		BiomeGenBase biome = this.biomeCache.getBiomeGenAt(x, z);
		if (biome == null)
		{
			return Biomes.venus;
		}
		
		return biome;
	}
	
	@Override
	public float[] getRainfall(float[] par1ArrayOfFloat, int par2,
			int par3, int par4, int par5)
	{
		IntCache.resetIntCache();
		
		if (par1ArrayOfFloat == null
				|| par1ArrayOfFloat.length < par4 * par5)
		{
			par1ArrayOfFloat = new float[par4 * par5];
		}
		
		int[] aint = this.biomeIndexLayer
				.getInts(par2, par3, par4, par5);
		
		for (int i1 = 0; i1 < par4 * par5; ++i1)
		{
			float f = BiomeGenBase.biomeList[aint[i1]].getIntRainfall() / 65536.0F;
			
			if (f > 1.0F) {
				f = 1.0F;
			}
			
			par1ArrayOfFloat[i1] = f;
		}
		
		return par1ArrayOfFloat;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Return an adjusted version of a given temperature based on the y height
	 */
	public float getTemperatureAtHeight(float par1, int par2)
	{
		return par1;
	}
	
	/**
	 * Returns a list of temperatures to use for the specified blocks. Args:
	 * listToReuse, x, y, width, length
	 */
	@Override
	public float[] getTemperatures(float[] par1ArrayOfFloat, int par2,
			int par3, int par4, int par5)
	{
		IntCache.resetIntCache();
		
		if (par1ArrayOfFloat == null
				|| par1ArrayOfFloat.length < par4 * par5)
		{
			par1ArrayOfFloat = new float[par4 * par5];
		}
		
		int[] aint = this.biomeIndexLayer.getInts(par2, par3, par4, par5);
		
		for (int i1 = 0; i1 < par4 * par5; ++i1)
		{
			float f = BiomeGenBase.biomeList[aint[i1]]
					.getIntTemperature() / 65536.0F;
			
			if (f > 1.0F)
			{
				f = 1.0F;
			}
			
			par1ArrayOfFloat[i1] = f;
		}
		
		return par1ArrayOfFloat;
	}
	
	@Override
	public BiomeGenBase[] getBiomeGenAt(
			BiomeGenBase[] par1ArrayOfBiomeGenBase, int x, int y,
			int width, int length, boolean cacheFlag) {
		IntCache.resetIntCache();
		
		if (par1ArrayOfBiomeGenBase == null
				|| par1ArrayOfBiomeGenBase.length < width * length) {
			par1ArrayOfBiomeGenBase = new BiomeGenBase[width * length];
		}
		
		if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0
				&& (y & 15) == 0) {
			BiomeGenBase[] abiomegenbase1 = this.biomeCache
					.getCachedBiomes(x, y);
			System.arraycopy(abiomegenbase1, 0, par1ArrayOfBiomeGenBase,
					0, width * length);
			return par1ArrayOfBiomeGenBase;
		} else {
			int[] aint = this.biomeIndexLayer.getInts(x, y, width,
					length);
			
			for (int i = 0; i < width * length; ++i) {
				if (aint[i] >= 0) {
					par1ArrayOfBiomeGenBase[i] = BiomeGenBase.biomeList[aint[i]];
				} else {
					// Change this to a biome
					par1ArrayOfBiomeGenBase[i] = Biomes.venus;
				}
			}
			
			return par1ArrayOfBiomeGenBase;
		}
	}
	
	/**
	 * Returns an array of biomes for the location input.
	 */
	@Override
	public BiomeGenBase[] getBiomesForGeneration(
			BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3,
			int par4, int par5) {
		IntCache.resetIntCache();
		
		if (par1ArrayOfBiomeGenBase == null
				|| par1ArrayOfBiomeGenBase.length < par4 * par5) {
			par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
		}
		
		int[] aint = this.genBiomes.getInts(par2, par3, par4, par5);
		
		for (int i = 0; i < par4 * par5; ++i) {
			if (aint[i] >= 0) {
				par1ArrayOfBiomeGenBase[i] = BiomeGenBase.biomeList[aint[i]];
			} else {
				par1ArrayOfBiomeGenBase[i] = Biomes.venus;
			}
		}
		
		return par1ArrayOfBiomeGenBase;
	}
	
	@Override
	public BiomeGenBase[] loadBlockGeneratorData(
			BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3,
			int par4, int par5) {
		return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3,
				par4, par5, true);
	}
	
	@Override
	public boolean areBiomesViable(int par1, int par2, int par3,
			List par4List) {
		IntCache.resetIntCache();
		int l = par1 - par3 >> 2;
		int i1 = par2 - par3 >> 2;
		int j1 = par1 + par3 >> 2;
		int k1 = par2 + par3 >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.genBiomes.getInts(l, i1, l1, i2);
		
		for (int j2 = 0; j2 < l1 * i2; ++j2) {
			BiomeGenBase biomegenbase = BiomeGenBase.biomeList[aint[j2]];
			
			if (!par4List.contains(biomegenbase)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public ChunkPosition findBiomePosition(int par1, int par2, int par3,
			List par4List, Random par5Random) {
		IntCache.resetIntCache();
		int l = par1 - par3 >> 2;
		int i1 = par2 - par3 >> 2;
		int j1 = par1 + par3 >> 2;
		int k1 = par2 + par3 >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.genBiomes.getInts(l, i1, l1, i2);
		ChunkPosition chunkposition = null;
		int j2 = 0;
		
		for (int k2 = 0; k2 < l1 * i2; ++k2) {
			int l2 = l + k2 % l1 << 2;
			int i3 = i1 + k2 / l1 << 2;
			BiomeGenBase biomegenbase = BiomeGenBase.biomeList[aint[k2]];
			
			if (par4List.contains(biomegenbase)
					&& (chunkposition == null || par5Random
							.nextInt(j2 + 1) == 0)) {
				chunkposition = new ChunkPosition(l2, 0, i3);
				++j2;
			}
		}
		
		return chunkposition;
	}
	
	@Override
	public void cleanupCache()
	{
		this.biomeCache.cleanupCache();
	}
	
	/*
	 * @Override public GenLayer[] getModdedBiomeGenerators(WorldType worldType,
	 * long seed, GenLayer[] original) { WorldTypeEvent.InitBiomeGens event =
	 * new WorldTypeEvent.InitBiomeGens( worldType, seed, original);
	 * MinecraftForge.TERRAIN_GEN_BUS.post(event); return event.newBiomeGens; }
	 */
}