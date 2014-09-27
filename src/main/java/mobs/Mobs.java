package alphaitems.mobs;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DungeonHooks;
import alphaitems.biomes.Biomes;
import alphaitems.mobs.entities.EntityDiamondGolem;
import alphaitems.mobs.entities.EntityDuck;
import alphaitems.mobs.entities.EntityEnderSpider;
import alphaitems.mobs.entities.EntityFish;
import alphaitems.mobs.entities.EntityHellduck;
import alphaitems.mobs.entities.EntityHog;
import alphaitems.mobs.entities.EntityHogZombie;
import alphaitems.mobs.entities.EntityJellyfish;
import alphaitems.mobs.entities.EntityMegaCreeper;
import alphaitems.mobs.entities.EntityMummy;
import alphaitems.mobs.entities.EntityPigshroom;
import alphaitems.mobs.entities.EntityScorpion;
import alphaitems.mobs.entities.EntityShadowSkeleton;
import alphaitems.mobs.entities.EntityShark;
import alphaitems.mobs.entities.EntityShrimp;
import alphaitems.mobs.entities.EntitySpiderling;
import alphaitems.mobs.entities.EntityTiger;
import alphaitems.mobs.entities.boss.EntityCrawler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Mobs {
	
	static int startEntityId = 300;
	
	/**
	 * This list stores the entities that are to be added to the Dungeon mob
	 * spawn list.
	 */
	public static ArrayList<String> entityList = new ArrayList<String>();
	
	public static void init() {
		
		// Crawler
		EntityRegistry
				.registerGlobalEntityID(EntityCrawler.class, "crawler",
						24);
		LanguageRegistry.instance().addStringLocalization(
				"entity.crawler.name", "en_US", "Crawler");
		registerEntityEgg(EntityCrawler.class, 0xdddddd, 0x444444);
		
		// Spiderling
		EntityRegistry
				.registerGlobalEntityID(EntitySpiderling.class,
						"spiderling",
						25);
		LanguageRegistry.instance().addStringLocalization(
				"entity.spiderling.name", "en_US", "Spiderling");
		registerEntityEgg(EntitySpiderling.class, 0x000000, 0xff8b00);
		
		// Tiger
		EntityRegistry
				.registerGlobalEntityID(EntityTiger.class, "tiger",
						26);
		LanguageRegistry.instance().addStringLocalization(
				"entity.tiger.name", "en_US", "Tiger");
		EntityRegistry.addSpawn(EntityTiger.class, 50, 1, 2,
				EnumCreatureType.creature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				Biomes.greenMeadow, Biomes.rainForest);
		registerEntityEgg(EntityTiger.class, 0xff8b00, 0x000000);
		
		// Mega Creeper
		EntityRegistry.registerGlobalEntityID(EntityMegaCreeper.class,
				"megacreeper", 27);
		LanguageRegistry.instance().addStringLocalization(
				"entity.megacreeper.name", "en_US", "Mega Creeper");
		EntityRegistry.addSpawn(EntityMegaCreeper.class, 3, 0, 1,
				EnumCreatureType.monster, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.ocean,
				Biomes.greenMeadow, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills,
				BiomeGenBase.river, BiomeGenBase.beach,
				BiomeGenBase.forestHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.jungleHills,
				BiomeGenBase.taigaHills, Biomes.greenMeadow,
				Biomes.rainForest, Biomes.saltLake, Biomes.coldDesert,
				Biomes.floweryField, Biomes.iceMountains,
				Biomes.redRockMountains, Biomes.redShroomPlains,
				Biomes.slimeLands, Biomes.stoneMountains, Biomes.savannah,
				Biomes.minersLand, Biomes.spongeField, Biomes.coalHills,
				Biomes.magmaLands, Biomes.mudSwamp, Biomes.grandCanyon,
				Biomes.savannah, Biomes.slimeLands);
		registerEntityEgg(EntityMegaCreeper.class, 0xee00ee, 0x00ee00);
		entityList.add("Mega Creeper");
		
		// Scorpion
		EntityRegistry.registerGlobalEntityID(EntityScorpion.class,
				"scorpion", 28);
		LanguageRegistry.instance().addStringLocalization(
				"entity.scorpion.name", "en_US", "Scorpion");
		EntityRegistry.addSpawn(EntityScorpion.class, 3, 0, 1,
				EnumCreatureType.monster, BiomeGenBase.desert,
				BiomeGenBase.desertHills, Biomes.coldDesert,
				Biomes.grandCanyon,
				Biomes.badLands);
		registerEntityEgg(EntityScorpion.class, 0xf5eeb3, 0x8b9900);
		entityList.add("Scorpion");
		
		// Diamond Golem
		EntityRegistry
				.registerGlobalEntityID(EntityDiamondGolem.class,
						"diamondgolem",
						29);
		LanguageRegistry.instance().addStringLocalization(
				"entity.diamondgolem.name", "en_US", "Diamond Golem");
		
		// Shark
		EntityRegistry.registerGlobalEntityID(EntityShark.class, "shark",
				73);
		LanguageRegistry.instance().addStringLocalization(
				"entity.shark.name",
				"en_US",
				"Blood Shark");
		EntityRegistry.addSpawn(EntityShark.class, 1, 0, 1,
				EnumCreatureType.waterCreature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.ocean,
				Biomes.greenMeadow, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills,
				BiomeGenBase.river, BiomeGenBase.beach,
				BiomeGenBase.forestHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.jungleHills,
				BiomeGenBase.taigaHills, Biomes.greenMeadow,
				Biomes.rainForest, Biomes.saltLake, Biomes.coldDesert,
				Biomes.floweryField, Biomes.iceMountains,
				Biomes.redRockMountains, Biomes.redShroomPlains,
				Biomes.slimeLands, Biomes.stoneMountains, Biomes.savannah,
				Biomes.minersLand, Biomes.spongeField, Biomes.coalHills,
				Biomes.magmaLands, Biomes.mudSwamp, Biomes.grandCanyon,
				Biomes.savannah, Biomes.slimeLands);
		registerEntityEgg(EntityShark.class, 0x444444, 0x8b2222);
		
		// Hog
		EntityRegistry.registerGlobalEntityID(EntityHog.class, "hog", 74);
		LanguageRegistry.instance().addStringLocalization(
				"entity.hog.name",
				"en_US",
				"Hog");
		EntityRegistry.addSpawn(EntityHog.class, 15, 4, 8,
				EnumCreatureType.creature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.ocean);
		registerEntityEgg(EntityHog.class, 0x8b5a00, 0xf5eeb3);
		
		// Hog Zombie
		EntityRegistry.registerGlobalEntityID(EntityHogZombie.class,
				"hogzombie", 75);
		LanguageRegistry.instance().addStringLocalization(
				"entity.hogzombie.name", "en_US", "Zombie Hogman");
		EntityRegistry.addSpawn(EntityHogZombie.class, 25, 8, 10,
				EnumCreatureType.monster, BiomeGenBase.hell);
		registerEntityEgg(EntityHogZombie.class, 0x8b9900, 0x00ee00);
		
		// Fish
		EntityRegistry
				.registerGlobalEntityID(EntityFish.class, "fish", 76);
		LanguageRegistry.instance().addStringLocalization(
				"entity.fish.name",
				"en_US",
				"Fish");
		EntityRegistry.addSpawn(EntityFish.class, 70, 10, 20,
				EnumCreatureType.waterCreature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.ocean,
				Biomes.greenMeadow, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills,
				BiomeGenBase.river, BiomeGenBase.beach,
				BiomeGenBase.forestHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.taigaHills, Biomes.greenMeadow,
				Biomes.rainForest, Biomes.saltLake, Biomes.coldDesert,
				Biomes.floweryField, Biomes.iceMountains,
				Biomes.redRockMountains, Biomes.redShroomPlains,
				Biomes.slimeLands, Biomes.stoneMountains, Biomes.savannah,
				Biomes.minersLand, Biomes.spongeField, Biomes.coalHills,
				Biomes.magmaLands);
		registerEntityEgg(EntityFish.class, 0x0099ff, 0x00008b);
		
		// Pigshroom
		EntityRegistry
				.registerGlobalEntityID(EntityPigshroom.class,
						"pigshroom", 78);
		LanguageRegistry.instance().addStringLocalization(
				"entity.pigshroom.name",
				"en_US",
				"Pigshroom");
		EntityRegistry.addSpawn(EntityPigshroom.class, 8, 2, 4,
				EnumCreatureType.creature, BiomeGenBase.mushroomIsland,
				Biomes.redShroomPlains);
		registerEntityEgg(EntityPigshroom.class, 0x990000, 0xeeeeee);
		
		// Jellyfish
		EntityRegistry
				.registerGlobalEntityID(EntityJellyfish.class,
						"jellyfish", 77);
		LanguageRegistry.instance().addStringLocalization(
				"entity.jellyfish.name",
				"en_US",
				"Jellyfish");
		EntityRegistry.addSpawn(EntityJellyfish.class, 40, 5, 10,
				EnumCreatureType.waterCreature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.ocean,
				Biomes.greenMeadow, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills,
				BiomeGenBase.river, BiomeGenBase.beach,
				BiomeGenBase.forestHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.taigaHills, Biomes.greenMeadow,
				Biomes.rainForest, Biomes.saltLake, Biomes.coldDesert,
				Biomes.floweryField, Biomes.iceMountains,
				Biomes.redRockMountains, Biomes.redShroomPlains,
				Biomes.slimeLands, Biomes.stoneMountains);
		registerEntityEgg(EntityJellyfish.class, 0xed08b5, 0x9b0476);
		
		// Duck
		EntityRegistry
				.registerGlobalEntityID(EntityDuck.class, "duck",
						80);
		LanguageRegistry.instance().addStringLocalization(
				"entity.duck.name", "en_US", "Duck");
		EntityRegistry.addSpawn(EntityDuck.class, 50, 1, 2,
				EnumCreatureType.creature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.taiga,
				Biomes.greenMeadow, Biomes.rainForest, BiomeGenBase.ocean,
				BiomeGenBase.river, Biomes.greenMeadow, Biomes.mudSwamp);
		registerEntityEgg(EntityDuck.class, 0x008b00, 0x8b2200);
		
		// Ender Spider
		EntityRegistry.registerGlobalEntityID(EntityEnderSpider.class,
				"enderspider", 90);
		LanguageRegistry.instance().addStringLocalization(
				"entity.enderspider.name", "en_US", "Ender Spider");
		EntityRegistry.addSpawn(EntityEnderSpider.class, 4, 1, 4,
				EnumCreatureType.monster, BiomeGenBase.sky);
		registerEntityEgg(EntityEnderSpider.class, 0x444444, 0x22aa22);
		
		// Witch (makes it spawn in swamps and its similar biomes)
		EntityRegistry.addSpawn(EntityWitch.class, 2, 0, 1,
				EnumCreatureType.monster, BiomeGenBase.swampland,
				Biomes.mudSwamp);
		entityList.add("Witch");
		
		// Shadow Skeleton
		EntityRegistry.registerGlobalEntityID(EntityShadowSkeleton.class,
				"shadowskeleton", 84);
		LanguageRegistry.instance().addStringLocalization(
				"entity.shadowskeleton.name", "en_US", "Shadow Skeleton");
		EntityRegistry.addSpawn(EntityShadowSkeleton.class, 2, 0, 1,
				EnumCreatureType.monster, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.ocean,
				Biomes.greenMeadow, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills,
				BiomeGenBase.river, BiomeGenBase.beach,
				BiomeGenBase.forestHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.jungleHills,
				BiomeGenBase.taigaHills, Biomes.greenMeadow,
				Biomes.rainForest, Biomes.saltLake, Biomes.coldDesert,
				Biomes.floweryField, Biomes.iceMountains,
				Biomes.redRockMountains, Biomes.redShroomPlains,
				Biomes.slimeLands, Biomes.stoneMountains, Biomes.savannah,
				Biomes.minersLand, Biomes.spongeField, Biomes.coalHills,
				Biomes.magmaLands, Biomes.mudSwamp, Biomes.grandCanyon,
				Biomes.savannah, Biomes.slimeLands);
		registerEntityEgg(EntityShadowSkeleton.class, 0xeeeeee, 0x00009e);
		entityList.add("Shadow Skeleton");
		
		// Mummy
		EntityRegistry.registerGlobalEntityID(EntityMummy.class,
				"mummy", 86);
		LanguageRegistry.instance().addStringLocalization(
				"entity.mummy.name", "en_US", "Mummy");
		EntityRegistry.addSpawn(EntityMummy.class, 2, 0, 1,
				EnumCreatureType.monster, BiomeGenBase.desert,
				BiomeGenBase.desertHills, Biomes.coldDesert,
				Biomes.badLands);
		registerEntityEgg(EntityMummy.class, 0x8b9900, 0xf5eeb3);
		entityList.add("Mummy");
		
		// Hell Duck
		EntityRegistry
				.registerGlobalEntityID(EntityHellduck.class, "hellduck",
						88);
		LanguageRegistry.instance().addStringLocalization(
				"entity.hellduck.name", "en_US", "Hell Duck");
		EntityRegistry.addSpawn(EntityHellduck.class, 2, 1, 2,
				EnumCreatureType.monster, BiomeGenBase.hell);
		registerEntityEgg(EntityHellduck.class, 0x8b0000, 0x000000);
		
		// Shrimp
		EntityRegistry
				.registerGlobalEntityID(EntityShrimp.class, "shrimp",
						91);
		LanguageRegistry.instance().addStringLocalization(
				"entity.shrimp.name", "en_US", "Shrimp");
		EntityRegistry.addSpawn(EntityShrimp.class, 2, 1, 2,
				EnumCreatureType.waterCreature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.desert,
				BiomeGenBase.extremeHills, BiomeGenBase.jungle,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.ocean,
				Biomes.greenMeadow, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills,
				BiomeGenBase.river, BiomeGenBase.beach,
				BiomeGenBase.forestHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.taigaHills, Biomes.greenMeadow,
				Biomes.rainForest, Biomes.saltLake, Biomes.coldDesert,
				Biomes.floweryField, Biomes.iceMountains,
				Biomes.redRockMountains, Biomes.redShroomPlains,
				Biomes.slimeLands, Biomes.stoneMountains);
		registerEntityEgg(EntityShrimp.class, 0xdd00aa, 0xff00aa);
		
		// Adds the necessary mobs to the dungeon spawn chance.
		addSpawners();
	}
	
	/**
	 * Adds mobs to dungeon spawners..
	 */
	public static void addSpawners() {
		for (int i = 0; i < entityList.size(); i++) {
			DungeonHooks.addDungeonMob(entityList.get(i), 100);
		}
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity,
			int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,
				secondaryColor));
	}
	
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId;
	}
}