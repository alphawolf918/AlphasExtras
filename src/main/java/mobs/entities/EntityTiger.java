package alphaitems.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOcelotAttack;
import net.minecraft.entity.ai.EntityAIOcelotSit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTiger extends EntityOcelot
{
	/**
	 * The tempt AI task for this mob, used to prevent taming while it is
	 * fleeing.
	 */
	private EntityAITempt aiTempt;
	
	public EntityTiger(World par1World)
	{
		super(par1World);
		this.setSize(this.width, this.height);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, this.aiTempt = new EntityAITempt(this, 0.6D,
				Item.beefRaw.itemID, true));
		this.tasks.addTask(3, this.aiTempt = new EntityAITempt(this, 0.6D,
				Item.porkRaw.itemID, true));
		this.tasks.addTask(3, this.aiTempt = new EntityAITempt(this, 0.6D,
				Item.fishRaw.itemID, true));
		this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
		this.tasks.addTask(5, new EntityAIOcelotSit(this, 1.33D));
		this.tasks.addTask(6, new EntityAILeapAtTarget(this, 0.6F));
		this.tasks.addTask(7, new EntityAIOcelotAttack(this));
		this.tasks.addTask(8, new EntityAIMate(this, 0.8D));
		this.tasks.addTask(9, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(10, new EntityAIWatchClosest(this,
				EntityPlayer.class, 10.0F));
		this.targetTasks.addTask(1, new EntityAITargetNonTamed(this,
				EntityChicken.class, 750, false));
		this.targetTasks.addTask(1, new EntityAITargetNonTamed(this,
				EntitySheep.class, 750, false));
		this.targetTasks.addTask(1, new EntityAITargetNonTamed(this,
				EntityCow.class, 750, false));
		this.targetTasks.addTask(1, new EntityAITargetNonTamed(this,
				EntityPig.class, 750, false));
		this.targetTasks.addTask(1, new EntityAITargetNonTamed(this,
				EntityHorse.class, 750, false));
		this.targetTasks.addTask(1, new EntityAITargetNonTamed(this,
				EntityHog.class, 750, false));
		this.targetTasks.addTask(1, new EntityAITargetNonTamed(this,
				EntityFish.class, 750, false));
	}
	
	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	@Override
	public void updateAITick()
	{
		if (this.getMoveHelper().isUpdating())
		{
			double d0 = this.getMoveHelper().getSpeed();
			
			if (d0 == 0.6D)
			{
				this.setSneaking(true);
				this.setSprinting(false);
			}
			else if (d0 == 1.33D)
			{
				this.setSneaking(false);
				this.setSprinting(true);
			}
			else
			{
				this.setSneaking(false);
				this.setSprinting(false);
			}
		}
		else
		{
			this.setSneaking(false);
			this.setSprinting(false);
		}
	}
	
	/**
	 * Determines if an entity can be despawned, used on idle far away entities
	 */
	@Override
	protected boolean canDespawn()
	{
		return !this.isTamed() && this.ticksExisted > 2600;
	}
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
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
				.setAttribute(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.30000002192092896D);
	}
	
	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	@Override
	protected void fall(float par1) {
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound()
	{
		return this.isTamed() ? (this.isInLove() ? "mob.cat.purr" : (this.rand
				.nextInt(4) == 0 ? "mob.cat.purreow" : "mob.cat.meow")) : "";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return "mob.cat.hitt";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.cat.hitt";
	}
	
	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume()
	{
		return 0.9F;
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected int getDropItemId()
	{
		return 0;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this),
				6.0F);
	}
	
	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			this.aiSit.setSitting(false);
			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}
	
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean par1, int par2) {
	}
	
	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		
		if (this.isTamed())
		{
			if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(
					this.getOwnerName())
					&& !this.worldObj.isRemote
					&& !this.isBreedingItem(itemstack))
			{
				this.aiSit.setSitting(!this.isSitting());
			}
		}
		else if (this.aiTempt.isRunning() && itemstack != null
				&& itemstack.itemID == Item.fishRaw.itemID
				&& par1EntityPlayer.getDistanceSqToEntity(this) < 6.0D)
		{
			if (!par1EntityPlayer.capabilities.isCreativeMode)
			{
				--itemstack.stackSize;
			}
			
			if (itemstack.stackSize <= 0)
			{
				par1EntityPlayer.inventory.setInventorySlotContents(
						par1EntityPlayer.inventory.currentItem,
						(ItemStack) null);
			}
			
			if (!this.worldObj.isRemote)
			{
				if (this.rand.nextInt(3) == 0)
				{
					this.setTamed(true);
					this.setOwner(par1EntityPlayer.getCommandSenderName());
					this.playTameEffect(true);
					this.aiSit.setSitting(true);
					this.worldObj.setEntityState(this, (byte) 7);
				}
				else
				{
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte) 6);
				}
			}
			
			return true;
		}
		
		return super.interact(par1EntityPlayer);
	}
	
	/**
	 * This function is used when two same-species animals in 'love mode' breed
	 * to generate the new baby animal.
	 */
	@Override
	public EntityTiger spawnBabyAnimal(EntityAgeable par1EntityAgeable)
	{
		EntityTiger entityocelot = new EntityTiger(this.worldObj);
		
		if (this.isTamed())
		{
			entityocelot.setOwner(this.getOwnerName());
			entityocelot.setTamed(true);
			entityocelot.setTameSkin(this.getTameSkin());
		}
		
		return entityocelot;
	}
	
	/**
	 * Checks if the parameter is an item which this animal can be fed to breed
	 * it (wheat, carrots or seeds depending on the animal type)
	 */
	@Override
	public boolean isBreedingItem(ItemStack par1ItemStack)
	{
		return par1ItemStack != null
				&& par1ItemStack.itemID == Item.fishRaw.itemID;
	}
	
	/**
	 * Returns true if the mob is currently able to mate with the specified mob.
	 */
	@Override
	public boolean canMateWith(EntityAnimal par1EntityAnimal)
	{
		if (par1EntityAnimal == this)
		{
			return false;
		}
		else if (!this.isTamed())
		{
			return false;
		}
		else if (!(par1EntityAnimal instanceof EntityOcelot))
		{
			return false;
		}
		else
		{
			EntityOcelot entityocelot = (EntityOcelot) par1EntityAnimal;
			return !entityocelot.isTamed() ? false : this.isInLove()
					&& entityocelot.isInLove();
		}
	}
	
	@Override
	public void setTameSkin(int par1)
	{
	}
	
	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	@Override
	public boolean getCanSpawnHere()
	{
		if (this.worldObj.rand.nextInt(3) == 0)
		{
			return false;
		}
		else
		{
			if (this.worldObj.checkNoEntityCollision(this.boundingBox)
					&& this.worldObj.getCollidingBoundingBoxes(this,
							this.boundingBox).isEmpty()
					&& !this.worldObj.isAnyLiquid(this.boundingBox))
			{
				int i = MathHelper.floor_double(this.posX);
				int j = MathHelper.floor_double(this.boundingBox.minY);
				int k = MathHelper.floor_double(this.posZ);
				
				if (j < 63)
				{
					return false;
				}
				
				int l = this.worldObj.getBlockId(i, j - 1, k);
				Block block = Block.blocksList[l];
				
				if (l == Block.grass.blockID
						|| (block != null && block.isLeaves(worldObj, i, j - 1,
								k)))
				{
					return true;
				}
			}
			
			return false;
		}
	}
	
	/**
	 * Gets the username of the entity.
	 */
	@Override
	public String getEntityName()
	{
		return this.hasCustomNameTag() ? this.getCustomNameTag() : (this
				.isTamed() ? "entity.tiger.name" : super.getEntityName());
	}
	
	@Override
	public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData)
	{
		par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
		
		if (this.worldObj.rand.nextInt(7) == 0)
		{
			for (int i = 0; i < 2; ++i)
			{
				EntityTiger entityocelot = new EntityTiger(this.worldObj);
				entityocelot.setLocationAndAngles(this.posX, this.posY,
						this.posZ, this.rotationYaw, 0.0F);
				entityocelot.setGrowingAge(-24000);
				this.worldObj.spawnEntityInWorld(entityocelot);
			}
		}
		
		return par1EntityLivingData;
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
	{
		return this.spawnBabyAnimal(par1EntityAgeable);
	}
}
