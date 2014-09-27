package alphaitems.lib;

import net.minecraft.util.DamageSource;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DSource extends DamageSource {
	
	public static DSource deathFuel = new DSource("fueltonium");
	public static DSource deathJellyfish = new DSource("jellyfishsting");
	
	public DSource(String par1) {
		super(par1);
	}
	
	public static void init() {
		LanguageRegistry.instance().addStringLocalization(
				"death.attack.fueltonium", "en_US",
				"%1$s was submerged in fueltonium.");
		LanguageRegistry.instance().addStringLocalization(
				"death.attack.fueltonium.player", "en_US",
				"%1$s was submerged in fueltonium by %2$s.");
		LanguageRegistry
				.instance()
				.addStringLocalization(
						"death.attack.fueltonium.item", "en_US",
						"%1$s was submerged in fueltonium by %2$s using %3$s.");
		
		LanguageRegistry.instance().addStringLocalization(
				"death.attack.jellyfishsting", "en_US",
				"%1$s was stung by a jellyfish.");
		LanguageRegistry.instance().addStringLocalization(
				"death.attack.jellyfishsting.player", "en_US",
				"%1$s was stung by a jellyfish thanks to %2$s.");
		LanguageRegistry
				.instance()
				.addStringLocalization(
						"death.attack.jellyfishsting.item", "en_US",
						"%1$swas stung by a jellyfish thanks to %2$s by %2$s using %3$s.");
	}
}