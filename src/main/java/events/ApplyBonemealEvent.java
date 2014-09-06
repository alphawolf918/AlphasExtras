package alphaitems.events;

import net.minecraft.block.BlockSapling;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class ApplyBonemealEvent
{
	
	private final BlockSapling sapling;
	
	public ApplyBonemealEvent(BlockSapling sapling)
	{
		this.sapling = sapling;
	}
	
	@ForgeSubscribe
	public void onBonemealEvent(BonemealEvent e)
	{
		if (e.getResult() == Result.DEFAULT && e.ID == sapling.blockID)
		{
			if (!e.world.isRemote)
			{
				if (e.world.rand.nextFloat() < 0.45D)
				{
					sapling.markOrGrowMarked(e.world, e.X, e.Y, e.Z,
							e.world.rand);
				}
				
				e.setResult(Result.ALLOW);
			}
		}
	}
}