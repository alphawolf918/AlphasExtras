package alphaitems.blocks.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import alphaitems.blocks.models.ModelTestBlock;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderTestBlock implements
		ISimpleBlockRenderingHandler {
	
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	public ModelTestBlock model;
	
	public RenderTestBlock(ModelTestBlock par1ModelBase, float par2) {
		model = par1ModelBase;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata,
			int modelID, RenderBlocks renderer) {
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y,
			int z, Block block, int modelId, RenderBlocks renderer) {
		Shape1 = new ModelRenderer(model, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 8, 7, 7);
		Shape1.setRotationPoint(-4F, 17F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(model, 0, 0);
		Shape2.addBox(0F, 0F, 0F, 2, 2, 2);
		Shape2.setRotationPoint(-1F, 15F, -1F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}
	
	public void render(Entity par1Entity, float par2, float par3,
			float par4,
			float par5, float par6, float par7) {
		Shape1.render(par7);
		Shape2.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public int getRenderId() {
		return 0;
	}
}