package alphaitems.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import alphaitems.mobs.entities.EntityHog;
import alphaitems.mobs.models.ModelHog;

public class RenderHog extends RenderLiving {
	public ModelHog model;
	float f6 = 1.5F;
	
	public RenderHog(ModelHog par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelHog) mainModel;
		this.shadowSize *= f6;
	}
	
	protected void scaleHog(EntityHog par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleHog((EntityHog) par1EntityLivingBase, par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awei:textures/entity/hog.png");
	}
	
	public void renderTutorial(EntityHog entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityHog) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityHog) par1Entity, par2, par4, par6, par8,
				par9);
	}
}