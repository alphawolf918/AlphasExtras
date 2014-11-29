package alphaitems.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import alphaitems.mobs.entities.EntityFox;
import alphaitems.mobs.models.ModelFox;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderFox extends RenderLiving {
	public ModelFox model;
	float f6 = 0.9F;
	
	public RenderFox(ModelFox par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelFox) mainModel;
	}
	
	protected void scaleFox(EntityFox par1EntityCaveSpider,
			float par2) {
		GL11.glScalef((f6 - 0.1F), f6, f6);
	}
	
	@Override
	protected void preRenderCallback(
			EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleFox((EntityFox) par1EntityLivingBase, par2);
	}
	
	protected float getTailRotation(EntityFox par1EntityFox, float par2) {
		return par1EntityFox.getTailRotation();
	}
	
	protected int func_82447_a(EntityFox par1EntityFox, int par2,
			float par3)
	{
		float f1;
		
		if (par2 == 0 && par1EntityFox.getWolfShaking())
		{
			f1 = par1EntityFox.getBrightness(par3)
					* par1EntityFox.getShadingWhileShaking(par3);
			GL11.glColor3f(f1, f1, f1);
			return 1;
		}
		else if (par2 == 1 && par1EntityFox.isTamed())
		{
			f1 = 1.0F;
			int j = par1EntityFox.getCollarColor();
			GL11.glColor3f(f1 * EntitySheep.fleeceColorTable[j][0], f1
					* EntitySheep.fleeceColorTable[j][1], f1
					* EntitySheep.fleeceColorTable[j][2]);
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	@Override
	protected float handleRotationFloat(
			EntityLivingBase par1EntityLivingBase, float par2)
	{
		return this.getTailRotation((EntityFox) par1EntityLivingBase,
				par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awei:textures/entity/fox.png");
	}
	
	@SideOnly(Side.CLIENT)
	public float getTailRotation() {
		return 0.4F;
	}
	
	public void renderTutorial(EntityFox entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityFox) par1EntityLiving, par2, par4,
				par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityFox) par1Entity, par2, par4, par6,
				par8,
				par9);
	}
}