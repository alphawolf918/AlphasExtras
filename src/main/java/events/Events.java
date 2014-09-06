package alphaitems.events;

import net.minecraft.block.BlockSapling;
import net.minecraftforge.common.MinecraftForge;
import alphaitems.blocks.Blocks;

public class Events {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new HotWaterBucketEvent());
		MinecraftForge.EVENT_BUS.register(new FuelBucketEvent());
		MinecraftForge.EVENT_BUS.register(new BetterGrassHoeEvent());
		MinecraftForge.EVENT_BUS.register(new ApplyBonemealEvent(
				(BlockSapling) Blocks.acaciaSapling));
	}
}