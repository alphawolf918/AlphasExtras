package alphaitems.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModTabs {
	
	public static CreativeTabs aiTab = new AITab(CreativeTabs.getNextID(),
			"aiTab");
	
	public static void init() {
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup." + "aiTab", "en_US", "Alpha's Extras");
	}
}