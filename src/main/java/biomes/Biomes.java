package alphaitems.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.GameRegistry;

public class Biomes {
	
	public static int biomeColor = 1204859;
	
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
	
	public static void init() {
		GameRegistry.addBiome(saltLake);
		GameRegistry.addBiome(greenMeadow);
		GameRegistry.addBiome(rainForest);
		GameRegistry.addBiome(coldDesert);
		GameRegistry.addBiome(floweryField);
		GameRegistry.addBiome(iceMountains);
		GameRegistry.addBiome(slimeLands);
		GameRegistry.addBiome(redRockMountains);
		GameRegistry.addBiome(redShroomPlains);
		GameRegistry.addBiome(stoneMountains);
		GameRegistry.addBiome(magmaLands);
		GameRegistry.addBiome(spongeField);
		GameRegistry.addBiome(savannah);
		GameRegistry.addBiome(minersLand);
		GameRegistry.addBiome(coalHills);
		GameRegistry.addBiome(badLands);
		GameRegistry.addBiome(snowHills);
		GameRegistry.addBiome(grandCanyon);
		GameRegistry.addBiome(mudSwamp);
		GameRegistry.addBiome(mushroomForest);
	}
}