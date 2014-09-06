package alphaitems.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import alphaitems.mobs.entities.EntityEnderSpider;
import alphaitems.mobs.models.ModelEnderSpider;

public class RenderEnderSpider extends RenderLiving {
	public ModelEnderSpider model;
	
	public RenderEnderSpider(ModelEnderSpider par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelEnderSpider) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awei:textures/entity/enderspider.png");
	}
	
	public void renderTutorial(EntityEnderSpider entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityEnderSpider) par1EntityLiving, par2, par4,
				par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityEnderSpider) par1Entity, par2, par4, par6,
				par8,
				par9);
	}
}