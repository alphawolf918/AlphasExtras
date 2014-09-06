package alphaitems.mobs.renders;

import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import alphaitems.mobs.entities.EntityDiamondGolem;

public class RenderDiamondGolem extends RenderLiving {
	public ModelIronGolem model;
	float f6 = 2.0F;
	
	public RenderDiamondGolem(ModelIronGolem par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelIronGolem) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awei:textures/entity/diamondgolem.png");
	}
	
	public void renderTutorial(EntityDiamondGolem entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityDiamondGolem) par1EntityLiving, par2, par4,
				par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityDiamondGolem) par1Entity, par2, par4, par6,
				par8, par9);
	}
	
	protected void scaleDiamondGolem(EntityDiamondGolem par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleDiamondGolem((EntityDiamondGolem) par1EntityLivingBase, par2);
	}
}