package alphaitems.mobs.renders;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import alphaitems.items.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDuckEgg extends Render
{
	private Item field_94151_a;
	private int field_94150_f;
	public static ResourceLocation eggTexture = new ResourceLocation(
			"awei:textures/items/duckegg.png");
	
	public RenderDuckEgg(Item par1Item, int par2)
	{
		this.field_94151_a = par1Item;
		this.field_94150_f = par2;
	}
	
	public RenderDuckEgg(Item par1Item)
	{
		this(par1Item, 0);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2,
			double par4,
			double par6, float par8, float par9)
	{
		Icon icon = Items.duckEgg
				.getIconFromDamage(this.field_94150_f);
		
		if (icon != null)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float) par2, (float) par4, (float) par6);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			this.bindEntityTexture(par1Entity);
			this.bindTexture(eggTexture);
			Tessellator tessellator = Tessellator.instance;
			this.func_77026_a(tessellator, icon);
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
		}
	}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return eggTexture;
	}
	
	private void func_77026_a(Tessellator par1Tessellator, Icon par2Icon)
	{
		float f = par2Icon.getMinU();
		float f1 = par2Icon.getMaxU();
		float f2 = par2Icon.getMinV();
		float f3 = par2Icon.getMaxV();
		float f4 = 1.0F;
		float f5 = 0.5F;
		float f6 = 0.25F;
		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F,
				1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		par1Tessellator.startDrawingQuads();
		par1Tessellator.setNormal(0.0F, 1.0F, 0.0F);
		par1Tessellator.addVertexWithUV(0.0F - f5, 0.0F - f6, 0.0D, f, f3);
		par1Tessellator.addVertexWithUV(f4 - f5, 0.0F - f6, 0.0D, f1, f3);
		par1Tessellator.addVertexWithUV(f4 - f5, f4 - f6, 0.0D, f1, f2);
		par1Tessellator.addVertexWithUV(0.0F - f5, f4 - f6, 0.0D, f, f2);
		par1Tessellator.draw();
	}
}