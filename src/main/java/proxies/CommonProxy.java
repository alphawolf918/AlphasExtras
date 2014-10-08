package alphaitems.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import alphaitems.gui.GuiBasic;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public void initRenderers() {
		
	}
	
	public void initSounds() {
		
	}
	
	public int registerBlockHandler(ISimpleBlockRenderingHandler handler)
	{
		return 0;
	}
	
	public void registerKeyBindings() {
		
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player,
			World world, int x, int y, int z) {
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player,
			World world, int x, int y, int z) {
		if (ID == GuiBasic.GUI_ID) {
			return new GuiBasic();
		}
		return null;
	}
}