package alphaitems.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import alphaitems.mobs.entities.EntityTurtle;
import alphaitems.mobs.models.ModelTurtle;

public class RenderTurtle extends RenderLiving {
	public ModelTurtle model;
	
	public RenderTurtle(ModelTurtle modelTurtle, float par2) {
		super(modelTurtle, par2);
		model = (ModelTurtle) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awei:textures/entity/turtle.png");
	}
	
	public void renderTutorial(EntityTurtle entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityTurtle) par1EntityLiving, par2, par4, par6,
				par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityTurtle) par1Entity, par2, par4, par6, par8,
				par9);
	}
}