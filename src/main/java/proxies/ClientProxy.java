package alphaitems.proxies;

import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.items.Items;
import alphaitems.managers.SoundManager;
import alphaitems.mobs.entities.EntityDiamondGolem;
import alphaitems.mobs.entities.EntityDuck;
import alphaitems.mobs.entities.EntityFish;
import alphaitems.mobs.entities.EntityFox;
import alphaitems.mobs.entities.EntityHellduck;
import alphaitems.mobs.entities.EntityHog;
import alphaitems.mobs.entities.EntityHogZombie;
import alphaitems.mobs.entities.EntityJellyfish;
import alphaitems.mobs.entities.EntityMegaCreeper;
import alphaitems.mobs.entities.EntityMummy;
import alphaitems.mobs.entities.EntityPigshroom;
import alphaitems.mobs.entities.EntityPowerBlaze;
import alphaitems.mobs.entities.EntityScorpion;
import alphaitems.mobs.entities.EntityShadowSkeleton;
import alphaitems.mobs.entities.EntityShark;
import alphaitems.mobs.entities.EntityShrimp;
import alphaitems.mobs.entities.EntitySpiderling;
import alphaitems.mobs.entities.EntityTiger;
import alphaitems.mobs.entities.EntityWanderer;
import alphaitems.mobs.entities.boss.EntityCrawler;
import alphaitems.mobs.entities.projectiles.EntityDuckEgg;
import alphaitems.mobs.models.ModelCrawler;
import alphaitems.mobs.models.ModelDiamondGolem;
import alphaitems.mobs.models.ModelDuck;
import alphaitems.mobs.models.ModelFish;
import alphaitems.mobs.models.ModelFox;
import alphaitems.mobs.models.ModelHog;
import alphaitems.mobs.models.ModelHogZombie;
import alphaitems.mobs.models.ModelJellyfish;
import alphaitems.mobs.models.ModelMegaCreeper;
import alphaitems.mobs.models.ModelMummy;
import alphaitems.mobs.models.ModelPigshroom;
import alphaitems.mobs.models.ModelPowerBlaze;
import alphaitems.mobs.models.ModelScorpion;
import alphaitems.mobs.models.ModelShadowSkeleton;
import alphaitems.mobs.models.ModelShark;
import alphaitems.mobs.models.ModelShrimp;
import alphaitems.mobs.models.ModelSpiderling;
import alphaitems.mobs.models.ModelWanderer;
import alphaitems.mobs.renders.RenderCrawler;
import alphaitems.mobs.renders.RenderDiamondGolem;
import alphaitems.mobs.renders.RenderDuck;
import alphaitems.mobs.renders.RenderDuckEgg;
import alphaitems.mobs.renders.RenderFish;
import alphaitems.mobs.renders.RenderFox;
import alphaitems.mobs.renders.RenderHellDuck;
import alphaitems.mobs.renders.RenderHog;
import alphaitems.mobs.renders.RenderJellyfish;
import alphaitems.mobs.renders.RenderMegaCreeper;
import alphaitems.mobs.renders.RenderMummy;
import alphaitems.mobs.renders.RenderPigshroom;
import alphaitems.mobs.renders.RenderPowerBlaze;
import alphaitems.mobs.renders.RenderScorpion;
import alphaitems.mobs.renders.RenderShadowSkeleton;
import alphaitems.mobs.renders.RenderShark;
import alphaitems.mobs.renders.RenderShrimp;
import alphaitems.mobs.renders.RenderSpiderling;
import alphaitems.mobs.renders.RenderTiger;
import alphaitems.mobs.renders.RenderWanderer;
import alphaitems.mobs.renders.RenderZombieHogman;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void initRenderers() {
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityCrawler.class, new RenderCrawler(
						new ModelCrawler(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntitySpiderling.class, new RenderSpiderling(
						new ModelSpiderling(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityTiger.class,
				new RenderTiger(new ModelOcelot(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityScorpion.class,
				new RenderScorpion(new ModelScorpion(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityMegaCreeper.class,
				new RenderMegaCreeper(new ModelMegaCreeper(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityDiamondGolem.class,
				new RenderDiamondGolem(new ModelDiamondGolem(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityShark.class,
				new RenderShark(new ModelShark(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityHog.class,
				new RenderHog(new ModelHog(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityHogZombie.class,
				new RenderZombieHogman(new ModelHogZombie(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityFish.class,
				new RenderFish(new ModelFish(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityJellyfish.class,
				new RenderJellyfish(new ModelJellyfish(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityPigshroom.class,
				new RenderPigshroom(new ModelPigshroom(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityDuck.class,
				new RenderDuck(new ModelDuck(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityShadowSkeleton.class,
				new RenderShadowSkeleton(new ModelShadowSkeleton(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityMummy.class,
				new RenderMummy(new ModelMummy(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityHellduck.class,
				new RenderHellDuck(new ModelDuck(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityWanderer.class, new RenderWanderer(
						new ModelWanderer(0.5F), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityShrimp.class, new RenderShrimp(
						new ModelShrimp(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityPowerBlaze.class, new RenderPowerBlaze(
						new ModelPowerBlaze(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityFox.class, new RenderFox(
						new ModelFox(), 0.5F));
		
		RenderManager.instance.entityRenderMap.put(EntityDuckEgg.class,
				new RenderDuckEgg(Items.duckEgg));
	}
	
	@Override
	public int registerBlockHandler(ISimpleBlockRenderingHandler handler)
	{
		final int renderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(renderId, handler);
		return renderId;
	}
	
	@Override
	public void initSounds() {
		MinecraftForge.EVENT_BUS.register(new SoundManager());
	}
}