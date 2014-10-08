package alphaitems.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import alphaitems.blocks.tileentities.TileEntityAmpCell;

public class ContainerAmpCell extends Container {
	
	private final TileEntityAmpCell machine;
	
	public ContainerAmpCell(InventoryPlayer invPlayer,
			TileEntityAmpCell machine) {
		this.machine = machine;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return machine.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		return null;
	}
	
	public TileEntityAmpCell getMachine() {
		return machine;
	}
}