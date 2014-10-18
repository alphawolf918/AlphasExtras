package alphaitems.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class Biomes {
	
	public static int biomeColor = 1204859;
	public static BiomeDictionary.Type biomeType;
	
	public static BiomeGenBase saltLake = new BiomeSaltLake(74);
	public static BiomeGenBase greenMeadow = new BiomeMeadow(85);
	
	public static BiomeGenBase rainForest = new BiomeRainforest(86);
	public static BiomeGenBase coldDesert = new ColdDesert(87);
	public static BiomeGenBase floweryField = new FloweryField(88);
	public static BiomeGenBase iceMountains = new IceMountains(89);
	public static BiomeGenBase slimeLands = new SlimeLands(90);
	public static BiomeGenBase redRockMountains = new RedRockMountains(91);
	public static BiomeGenBase redShroomPlains = new RedshroomPlains(92);
	public static BiomeGenBase stoneMountains = new StoneMountains(93);
	public static BiomeGenBase magmaLands = new MagmaSlimeLands(94);
	public static BiomeGenBase spongeField = new BiomeSpongeField(95);
	public static BiomeGenBase savannah = new Savannah(96);
	public static BiomeGenBase minersLand = new MinersLand(97);
	public static BiomeGenBase coalHills = new CoalHills(98);
	public static BiomeGenBase badLands = new BadLands(99);
	public static BiomeGenBase snowHills = new SnowHills(100);
	public static BiomeGenBase grandCanyon = new GrandCanyon(101);
	public static BiomeGenBase mudSwamp = new MudSwamp(102);
	public static BiomeGenBase mushroomForest = new MushroomForest(103);
	
	public static BiomeGenBase venus = new BiomeVenus(104);
	public static BiomeGenBase crystalMounds = new BiomeVenusCrystalMounds(
			105);
	
	public static void init() {
		addBiome(saltLake, biomeType.DESERT);
		addBiome(greenMeadow, biomeType.PLAINS);
		addBiome(rainForest, biomeType.FOREST);
		addBiome(coldDesert, biomeType.DESERT);
		addBiome(floweryField, biomeType.HILLS);
		addBiome(iceMountains, biomeType.FROZEN);
		addBiome(slimeLands, biomeType.WASTELAND);
		addBiome(redRockMountains, biomeType.MOUNTAIN);
		addBiome(redShroomPlains, biomeType.MUSHROOM);
		addBiome(stoneMountains, biomeType.MOUNTAIN);
		addBiome(magmaLands, biomeType.NETHER);
		addBiome(spongeField, biomeType.WATER);
		addBiome(savannah, biomeType.JUNGLE);
		addBiome(minersLand, biomeType.MOUNTAIN);
		addBiome(coalHills, biomeType.MOUNTAIN);
		addBiome(badLands, biomeType.DESERT);
		addBiome(snowHills, biomeType.FROZEN);
		addBiome(grandCanyon, biomeType.MOUNTAIN);
		addBiome(mudSwamp, biomeType.SWAMP);
		addBiome(mushroomForest, biomeType.MAGICAL);
		BiomeDictionary.registerBiomeType(venus,
				biomeType.WASTELAND);
	}
	
	public static void addBiome(BiomeGenBase biome) {
		GameRegistry.addBiome(biome);
		BiomeManager.addVillageBiome(biome, true);
		BiomeManager.addStrongholdBiome(biome);
		BiomeManager.addSpawnBiome(biome);
	}
	
	public static void addBiome(BiomeGenBase biome, BiomeDictionary.Type x) {
		addBiome(biome);
		BiomeDictionary.registerBiomeType(biome, x);
	}
}