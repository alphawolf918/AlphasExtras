package alphaitems.mobs.entities;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBird extends EntityFlying implements IAnimals {
	
	int stillTimer = 0;
	int maxFlightHeight = 5;
	double moveSpeed = 0.22D;
	double maxHealth = 5.0D;
	
	public EntityBird(World par1) {
		super(par1);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWatchClosest(this,
				EntityPlayer.class, 10.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
	}
	
	public boolean defaultGrounded() {
		return false;
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setAttribute(this.maxHealth);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(this.moveSpeed);
	}
}