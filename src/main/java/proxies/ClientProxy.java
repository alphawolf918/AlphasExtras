package alphaitems.proxies;

import net.minecraft.client.model.ModelOcelot;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.managers.SoundManager;
import alphaitems.mobs.entities.EntityDiamondGolem;
import alphaitems.mobs.entities.EntityDuck;
import alphaitems.mobs.entities.EntityEnderSpider;
import alphaitems.mobs.entities.EntityFish;
import alphaitems.mobs.entities.EntityHog;
import alphaitems.mobs.entities.EntityHogZombie;
import alphaitems.mobs.entities.EntityJellyfish;
import alphaitems.mobs.entities.EntityMegaCreeper;
import alphaitems.mobs.entities.EntityMummy;
import alphaitems.mobs.entities.EntityPigshroom;
import alphaitems.mobs.entities.EntityScorpion;
import alphaitems.mobs.entities.EntityShadowSkeleton;
import alphaitems.mobs.entities.EntityShark;
import alphaitems.mobs.entities.EntitySpiderling;
import alphaitems.mobs.entities.EntityTiger;
import alphaitems.mobs.entities.boss.EntityCrawler;
import alphaitems.mobs.models.ModelCrawler;
import alphaitems.mobs.models.ModelDiamondGolem;
import alphaitems.mobs.models.ModelDuck;
import alphaitems.mobs.models.ModelEnderSpider;
import alphaitems.mobs.models.ModelFish;
import alphaitems.mobs.models.ModelHog;
import alphaitems.mobs.models.ModelHogZombie;
import alphaitems.mobs.models.ModelJellyfish;
import alphaitems.mobs.models.ModelMegaCreeper;
import alphaitems.mobs.models.ModelMummy;
import alphaitems.mobs.models.ModelPigshroom;
import alphaitems.mobs.models.ModelScorpion;
import alphaitems.mobs.models.ModelShadowSkeleton;
import alphaitems.mobs.models.ModelShark;
import alphaitems.mobs.models.ModelSpiderling;
import alphaitems.mobs.renders.RenderCrawler;
import alphaitems.mobs.renders.RenderDiamondGolem;
import alphaitems.mobs.renders.RenderDuck;
import alphaitems.mobs.renders.RenderEnderSpider;
import alphaitems.mobs.renders.RenderFish;
import alphaitems.mobs.renders.RenderHog;
import alphaitems.mobs.renders.RenderJellyfish;
import alphaitems.mobs.renders.RenderMegaCreeper;
import alphaitems.mobs.renders.RenderMummy;
import alphaitems.mobs.renders.RenderPigshroom;
import alphaitems.mobs.renders.RenderScorpion;
import alphaitems.mobs.renders.RenderShadowSkeleton;
import alphaitems.mobs.renders.RenderShark;
import alphaitems.mobs.renders.RenderSpiderling;
import alphaitems.mobs.renders.RenderTiger;
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
				EntityEnderSpider.class,
				new RenderEnderSpider(new ModelEnderSpider(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityShadowSkeleton.class,
				new RenderShadowSkeleton(new ModelShadowSkeleton(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityMummy.class,
				new RenderMummy(new ModelMummy(), 0.5F));
		
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