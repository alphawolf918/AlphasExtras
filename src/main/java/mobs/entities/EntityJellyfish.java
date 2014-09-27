package alphaitems.mobs.entities;

import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import alphaitems.lib.DSource;

public class EntityJellyfish extends EntitySquid implements IMob, IAnimals {
	
	public EntityJellyfish(World par1World) {
		super(par1World);
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		player.attackEntityFrom(DSource.deathJellyfish,
				4.0F);
	}
}