package alphaitems.mobs.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpiderEffectsGroupData;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityScorpion extends EntityCaveSpider
{
	public EntityScorpion(World par1World)
	{
		super(par1World);
		this.setSize(1.2F, 0.9F);
		this.setHealth(60F);
		this.setAIMoveSpeed(2.8F);
		this.experienceValue = 80;
		this.scoreValue = 450;
		this.stepHeight = 2F;
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if (!this.worldObj.isRemote)
		{
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setAttribute(60.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.900000001920930D);
	}
	
	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * PigZombies).
	 */
	@Override
	protected Entity findPlayerToAttack()
	{
		float f = this.getBrightness(1.0F);
		
		if (f < 0.3F)
		{
			double d0 = 16.0D;
			return this.worldObj.getClosestVulnerablePlayerToEntity(this,
					d0);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound()
	{
		return "mob.spider.say";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return "mob.spider.say";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.spider.death";
	}
	
	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.spider.step", 0.25F, 2.0F);
	}
	
	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden
	 * by each mob to define their attack.
	 */
	@Override
	protected void attackEntity(Entity par1Entity, float par2)
	{
		float f1 = this.getBrightness(1.0F);
		
		if (f1 > 0.3F && this.rand.nextInt(100) == 0)
		{
			this.entityToAttack = null;
		}
		else
		{
			if (par2 > 2.0F && par2 < 6.0F && this.rand.nextInt(10) == 0)
			{
				if (this.onGround)
				{
					double d0 = par1Entity.posX - this.posX;
					double d1 = par1Entity.posZ - this.posZ;
					float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
					this.motionX = d0 / f2 * 0.5D * 0.800000011920929D
							+ this.motionX * 0.20000000298023224D;
					this.motionZ = d1 / f2 * 0.5D * 0.800000011920929D
							+ this.motionZ * 0.20000000298023224D;
					this.motionY = 0.4000000059604645D;
				}
			}
			else
			{
				super.attackEntity(par1Entity, par2);
			}
		}
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected int getDropItemId()
	{
		return Item.silk.itemID;
	}
	
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		super.dropFewItems(par1, par2);
		
		if (par1
				&& (this.rand.nextInt(3) == 0 || this.rand
						.nextInt(1 + par2) > 0))
		{
			this.dropItem(Item.spiderEye.itemID, 1);
		}
	}
	
	/**
	 * returns true if this entity is by a ladder, false otherwise
	 */
	@Override
	public boolean isOnLadder()
	{
		return this.isBesideClimbableBlock();
	}
	
	/**
	 * Sets the Entity inside a web block.
	 */
	@Override
	public void setInWeb() {
	}
	
	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public EntityLivingData onSpawnWithEgg(
			EntityLivingData par1EntityLivingData)
	{
		Object par1EntityLivingData1 = super
				.onSpawnWithEgg(par1EntityLivingData);
		
		if (this.worldObj.rand.nextInt(100) == 0)
		{
			EntitySkeleton entityskeleton = new EntitySkeleton(
					this.worldObj);
			entityskeleton.setLocationAndAngles(this.posX, this.posY,
					this.posZ, this.rotationYaw, 0.0F);
			entityskeleton.onSpawnWithEgg((EntityLivingData) null);
			this.worldObj.spawnEntityInWorld(entityskeleton);
			entityskeleton.mountEntity(this);
		}
		
		if (par1EntityLivingData1 == null)
		{
			par1EntityLivingData1 = new SpiderEffectsGroupData();
			
			if (this.worldObj.difficultySetting > 2
					&& this.worldObj.rand.nextFloat() < 0.1F * this.worldObj
							.getLocationTensionFactor(this.posX,
									this.posY,
									this.posZ))
			{
				((SpiderEffectsGroupData) par1EntityLivingData1)
						.func_111104_a(this.worldObj.rand);
			}
		}
		
		if (par1EntityLivingData1 instanceof SpiderEffectsGroupData)
		{
			int i = ((SpiderEffectsGroupData) par1EntityLivingData1).field_111105_a;
			
			if (i > 0 && Potion.potionTypes[i] != null)
			{
				this.addPotionEffect(new PotionEffect(i, Integer.MAX_VALUE));
			}
		}
		
		return (EntityLivingData) par1EntityLivingData1;
	}
}