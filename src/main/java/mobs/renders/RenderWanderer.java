package alphaitems.mobs.renders;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import alphaitems.mobs.entities.EntityWanderer;
import alphaitems.mobs.models.ModelWanderer;

public class RenderWanderer extends RenderBiped {
	public ModelWanderer model;
	private final ModelBiped modelArmorChestplate;
	private final ModelBiped modelArmor;
	
	public RenderWanderer(ModelBiped par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelWanderer) mainModel;
		this.modelArmorChestplate = new ModelBiped(1.0F);
		this.modelArmor = new ModelBiped(0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awei:textures/entity/wanderer.png");
	}
	
	public void renderTutorial(EntityWanderer entity, double par2,
			double par4,
			double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityWanderer) par1EntityLiving, par2, par4,
				par6,
				par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityWanderer) par1Entity, par2, par4, par6,
				par8,
				par9);
	}
}