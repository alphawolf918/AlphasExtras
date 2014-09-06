package alphaitems.handlers;

import net.minecraft.item.ItemStack;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;
import cpw.mods.fml.common.IFuelHandler;

public class SuperCoalFuelHandler implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.itemID == Items.spcItem.itemID) {
			return 262144;
		} else if (fuel.itemID == Blocks.spcBlock.blockID) {
			return 843200;
		} else if (fuel.itemID == Items.fuelonite.itemID) {
			return 3107200;
		} else if (fuel.itemID == Blocks.fuelBlockID.blockID) {
			return 3886080;
		}
		return 0;
	}
}