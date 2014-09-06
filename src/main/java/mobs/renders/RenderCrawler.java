package alphaitems.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import alphaitems.mobs.entities.boss.EntityCrawler;
import alphaitems.mobs.models.ModelCrawler;

public class RenderCrawler extends RenderLiving {
	public ModelCrawler model;
	float f6 = 5.0F;
	
	public RenderCrawler(ModelCrawler modelCrawler, float par2) {
		super(modelCrawler, par2);
		model = (ModelCrawler) mainModel;
		this.shadowSize *= f6;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awei:textures/entity/crawler.png");
	}
	
	public void renderTutorial(EntityCrawler entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(entity, true);
	}
	
	protected void scaleCrawler(EntityCrawler par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleCrawler((EntityCrawler) par1EntityLivingBase, par2);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityCrawler) par1EntityLiving, par2, par4, par6,
				par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityCrawler) par1Entity, par2, par4, par6, par8,
				par9);
	}
}