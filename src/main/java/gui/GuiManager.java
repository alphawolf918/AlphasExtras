package alphaitems.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import alphaitems.blocks.tileentities.TileEntityAmpCell;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiManager implements IGuiHandler {
	
	public GuiManager() {
		
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player,
			World world, int x, int y, int z) {
		switch (ID) {
			case 0:
				TileEntity te = world.getBlockTileEntity(x, y, z);
				if (te != null && te instanceof TileEntityAmpCell) {
					return new ContainerAmpCell(player.inventory,
							(TileEntityAmpCell) te);
				}
				break;
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player,
			World world, int x, int y, int z) {
		return null;
	}
}