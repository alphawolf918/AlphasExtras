package alphaitems.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.creativetabs.ModTabs;

public class Methods {
	
	/**
	 * Sets the block/ore to require a defined tool class to be harvested.
	 * 
	 * @param block
	 *            The block to harvest.
	 * @param tool
	 * @param toolClass
	 *            The EnumToolClass variant to be used.
	 */
	public static void ForgeSetToolClass(Block block, String tool,
			EnumToolClass toolClass) {
		MinecraftForge.setBlockHarvestLevel(block, tool,
				EnumToolClass.getToolClassValue(toolClass));
	}
	
	/**
	 * Sets the creative tab for a block.
	 * 
	 * @param block
	 *            The block to add to the creative tab.
	 */
	public static void setTab(Block block) {
		block.setCreativeTab(ModTabs.aiTab);
	}
	
	/**
	 * Sets the creative tab for an item.
	 * 
	 * @param item
	 *            The item to add to the creative tab.
	 */
	public static void setTab(Item item) {
		item.setCreativeTab(ModTabs.aiTab);
	}
	
	/**
	 * Sets a block's hardness and resistance.
	 * 
	 * @param block
	 * @param blockResistance
	 *            The resistance of the block.
	 * @param blockHardness
	 *            The hardness of the block.
	 */
	public static void setBlockRH(Block block, float blockResistance,
			float blockHardness) {
		block.setResistance(blockResistance);
		block.setHardness(blockHardness);
	}
	
	/**
	 * Sets a block's hardness and resistance to the same value.
	 * 
	 * @param block
	 * @param blockRH
	 *            The block's hardness and resistance.
	 */
	public static void setBlockRH(Block block, float blockRH) {
		block.setResistance(blockRH);
		block.setHardness(blockRH);
	}
}