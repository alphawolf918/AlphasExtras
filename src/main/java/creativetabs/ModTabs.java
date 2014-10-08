package alphaitems.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModTabs {
	
	public static CreativeTabs aiTab = new AITab(CreativeTabs.getNextID(),
			"aiTab");
	public static CreativeTabs venusTab = new AITab(
			CreativeTabs.getNextID(),
			"venusTab");
	
	public static void init() {
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup." + "venusTab", "en_US", "Planet Venus");
	}
}