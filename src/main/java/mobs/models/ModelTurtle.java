package alphaitems.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTurtle extends ModelBase
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	
	public ModelTurtle()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		Shape1 = new ModelRenderer(this, 26, 22);
		Shape1.addBox(1F, 14F, -3F, 2, 2, 2);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 26, 22);
		Shape2.addBox(1F, 14F, 1F, 2, 2, 2);
		Shape2.setRotationPoint(0F, 0F, 0F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 26, 22);
		Shape3.addBox(-2.5F, 14F, -3F, 2, 2, 2);
		Shape3.setRotationPoint(0F, 0F, 0F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 26, 22);
		Shape4.addBox(-2.5F, 13F, 0F, 2, 2, 2);
		Shape4.setRotationPoint(0F, 1F, 1F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 32, 12);
		Shape5.addBox(-2F, 11F, -6F, 4, 4, 4);
		Shape5.setRotationPoint(0F, 0F, 0F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, -0.0174533F, 0F, 0F);
		Shape5.mirror = false;
		Shape6 = new ModelRenderer(this, 0, 22);
		Shape6.addBox(-3.5F, 13F, -3F, 7, 2, 6);
		Shape6.setRotationPoint(0F, 0F, 0F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0.0174533F, 1.570796F, 0F);
		Shape6.mirror = false;
		Shape7 = new ModelRenderer(this, 34, 22);
		Shape7.addBox(-3F, 12F, -2.5F, 6, 1, 5);
		Shape7.setRotationPoint(0F, 0F, 0F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 1.570796F, 0F);
		Shape7.mirror = false;
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		Shape1.render(par7);
		Shape2.render(par7);
		Shape3.render(par7);
		Shape4.render(par7);
		Shape5.render(par7);
		Shape6.render(par7);
		Shape7.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity par7Entity) {
		float f6 = (180F / (float) Math.PI);
		this.Shape1.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.Shape1.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.Shape2.rotateAngleX = ((float) Math.PI / 2F);
		this.Shape3.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.Shape4.rotateAngleX = MathHelper.cos(par1 * 0.6662F
				+ (float) Math.PI)
				* 1.4F * par2;
		this.Shape5.rotateAngleX = MathHelper.cos(par1 * 0.6662F
				+ (float) Math.PI)
				* 1.4F * par2;
		this.Shape6.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	}
}