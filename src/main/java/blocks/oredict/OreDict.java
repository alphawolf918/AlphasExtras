package alphaitems.blocks.oredict;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;

public class OreDict {
	public static void init() {
		
		// Better Glass
		OreDictionary
				.registerOre("glass", new ItemStack(Blocks.betterGlass, 1));
		
		// Fueltonium Ingot
		OreDictionary.registerOre("ingotUranium", new ItemStack(
				Items.fuelIngot, 1));
	}
}