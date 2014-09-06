package alphaitems.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import alphaitems.mobs.entities.EntityFish;
import alphaitems.mobs.models.ModelFish;

public class RenderFish extends RenderLiving {
	public ModelFish model;
	
	public RenderFish(ModelFish par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelFish) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awei:textures/entity/shark.png");
	}
	
	public void renderTutorial(EntityFish entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityFish) par1EntityLiving, par2, par4,
				par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityFish) par1Entity, par2, par4, par6,
				par8,
				par9);
	}
}