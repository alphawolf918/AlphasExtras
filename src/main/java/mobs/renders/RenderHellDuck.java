package alphaitems.mobs.renders;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import alphaitems.mobs.entities.EntityHellduck;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHellDuck extends RenderLiving
{
	private static final ResourceLocation chickenTextures = new ResourceLocation(
			"awei:textures/entity/hellduck.png");
	float f6 = 2.0F;
	
	public RenderHellDuck(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}
	
	protected void scaleHellDuck(EntityHellduck par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(
			EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleHellDuck((EntityHellduck) par1EntityLivingBase, par2);
	}
	
	public void renderDuck(EntityHellduck par1EntityHellduck,
			double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(par1EntityHellduck, par2, par4, par6, par8,
				par9);
	}
	
	protected ResourceLocation getDuckTextures(
			EntityHellduck par1EntityHellduck)
	{
		return chickenTextures;
	}
	
	protected float getWingRotation(EntityHellduck par1EntityHellduck,
			float par2)
	{
		float f1 = par1EntityHellduck.field_70888_h
				+ (par1EntityHellduck.field_70886_e - par1EntityHellduck.field_70888_h)
				* par2;
		float f2 = par1EntityHellduck.field_70884_g
				+ (par1EntityHellduck.destPos - par1EntityHellduck.field_70884_g)
				* par2;
		return (MathHelper.sin(f1) + 1.0F) * f2;
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9)
	{
		this.renderDuck((EntityHellduck) par1EntityLiving, par2, par4,
				par6, par8, par9);
	}
	
	@Override
	protected float handleRotationFloat(
			EntityLivingBase par1EntityLivingBase, float par2)
	{
		return this.getWingRotation((EntityHellduck) par1EntityLivingBase,
				par2);
	}
	
	@Override
	public void renderPlayer(EntityLivingBase par1EntityLivingBase,
			double par2, double par4, double par6, float par8, float par9)
	{
		this.renderDuck((EntityHellduck) par1EntityLivingBase, par2,
				par4, par6, par8, par9);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getDuckTextures((EntityHellduck) par1Entity);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9)
	{
		this.renderDuck((EntityHellduck) par1Entity, par2, par4, par6,
				par8, par9);
	}
}