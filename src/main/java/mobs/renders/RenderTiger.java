package alphaitems.mobs.renders;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import alphaitems.mobs.entities.EntityTiger;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTiger extends RenderLiving
{
	float f6 = 2.5F;
	float f7 = 1.1F;
	
	public RenderTiger(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}
	
	public void renderLivingTiger(EntityTiger par1EntityTiger,
			double par2,
			double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(par1EntityTiger, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation func_110874_a(EntityTiger par1EntityTiger)
	{
		return new ResourceLocation("awei:textures/entity/Tiger.png");
	}
	
	/**
	 * Pre-Renders the Tiger.
	 */
	protected void preRenderTiger(EntityTiger par1EntityTiger, float par2)
	{
		super.preRenderCallback(par1EntityTiger, par2);
		if (!par1EntityTiger.isChild()) {
			GL11.glScalef(f6, f6, f6);
		} else {
			GL11.glScalef(f7, f7, f7);
		}
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9)
	{
		this.renderLivingTiger((EntityTiger) par1EntityLiving, par2, par4,
				par6, par8, par9);
	}
	
	/**
	 * Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime
	 */
	@Override
	protected void preRenderCallback(
			EntityLivingBase par1EntityLivingBase,
			float par2)
	{
		this.preRenderTiger((EntityTiger) par1EntityLivingBase, par2);
	}
	
	@Override
	public void renderPlayer(EntityLivingBase par1EntityLivingBase,
			double par2, double par4, double par6, float par8, float par9)
	{
		this.renderLivingTiger((EntityTiger) par1EntityLivingBase, par2,
				par4, par6, par8, par9);
	}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.func_110874_a((EntityTiger) par1Entity);
	}
	
	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9)
	{
		this.renderLivingTiger((EntityTiger) par1Entity, par2, par4, par6,
				par8, par9);
	}
}