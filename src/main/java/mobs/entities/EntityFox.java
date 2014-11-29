package alphaitems.mobs.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityFox extends EntityWolf {
	
	public EntityFox(World par1World) {
		super(par1World);
		this.setSize(this.width, this.height);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(4,
				new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F,
				2.0F));
		this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIBeg(this, 8.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		tasks.addTask(10, new EntityAIFollowOwner(this, 1.0f, 10.0F, 2.0F));
		
		tasks.addTask(11, new EntityAIMate(this, 1.0f));
		tasks.addTask(12, new EntityAITempt(this, 1.2f, Item.egg.itemID,
				false));
		tasks.addTask(13, new EntityAIFollowParent(this, 1.1f));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(3, new EntityAITargetNonTamed(this,
				EntitySheep.class, 200, false));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this,
				EntityChicken.class, 200, false));
		this.targetTasks.addTask(5, new EntityAITargetNonTamed(this,
				EntityDuck.class, 200, false));
		this.setTamed(false);
	}
	
	public boolean isValidTamingItem(ItemStack itemStack) {
		if (itemStack == null) {
			return false;
		}
		
		if (itemStack.getItem() instanceof ItemEgg) {
			return true;
		}
		return false;
	}
	
	@Override
	public int getTotalArmorValue() {
		return 2;
	}
	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		if (this.isTamed())
		{
			if (itemstack != null)
			{
				if (Item.itemsList[itemstack.itemID] instanceof ItemFood)
				{
					ItemFood itemfood = (ItemFood) Item.itemsList[itemstack.itemID];
					if (itemfood.isWolfsFavoriteMeat()
							&& this.dataWatcher
									.getWatchableObjectFloat(18) < 20.0F)
					{
						if (!par1EntityPlayer.capabilities.isCreativeMode)
						{
							--itemstack.stackSize;
						}
						this.heal(itemfood.getHealAmount());
						if (itemstack.stackSize <= 0)
						{
							par1EntityPlayer.inventory
									.setInventorySlotContents(
											par1EntityPlayer.inventory.currentItem,
											(ItemStack) null);
						}
						return true;
					}
				}
			}
			if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(
					this.getOwnerName())
					&& !this.worldObj.isRemote
					&& !this.isBreedingItem(itemstack))
			{
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity) null);
				this.setTarget((Entity) null);
				this.setAttackTarget((EntityLivingBase) null);
			}
		}
		else if (itemstack != null && itemstack.itemID == Item.egg.itemID
				&& !this.isAngry())
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
					this.setPathToEntity((PathEntity) null);
					this.setAttackTarget((EntityLivingBase) null);
					this.aiSit.setSitting(true);
					this.setHealth(20.0F);
					this.setOwner(par1EntityPlayer.getCommandSenderName());
					this.playTameEffect(true);
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
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
	}
	
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
		else if (!(par1EntityAnimal instanceof EntityFox))
		{
			return false;
		}
		else
		{
			EntityFox entityfox = (EntityFox) par1EntityAnimal;
			return !entityfox.isTamed() ? false
					: (entityfox.isSitting() ? false : this.isInLove()
							&& entityfox.isInLove());
		}
	}
	
	@Override
	public boolean func_142018_a(EntityLivingBase par1EntityLivingBase,
			EntityLivingBase par2EntityLivingBase)
	{
		if (!(par1EntityLivingBase instanceof EntityCreeper)
				&& !(par1EntityLivingBase instanceof EntityGhast))
		{
			if (par1EntityLivingBase instanceof EntityFox)
			{
				EntityFox entityfox = (EntityFox) par1EntityLivingBase;
				
				if (entityfox.isTamed()
						&& entityfox.func_130012_q() == par2EntityLivingBase)
				{
					return false;
				}
			}
			
			return par1EntityLivingBase instanceof EntityPlayer
					&& par2EntityLivingBase instanceof EntityPlayer
					&& !((EntityPlayer) par2EntityLivingBase)
							.canAttackPlayer((EntityPlayer) par1EntityLivingBase) ? false
					: !(par1EntityLivingBase instanceof EntityHorse)
							|| !((EntityHorse) par1EntityLivingBase)
									.isTame();
		}
		else
		{
			return false;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getTailRotation() {
		return 0.62F;
	}
	
	protected boolean shouldPanic() {
		return !this.isTamed();
	}
	
	@Override
	public EntityFox spawnBabyAnimal(EntityAgeable par1EntityAgeable)
	{
		EntityFox entityfox = new EntityFox(this.worldObj);
		String s = this.getOwnerName();
		
		if (s != null && s.trim().length() > 0)
		{
			entityfox.setOwner(s);
			entityfox.setTamed(true);
		}
		
		return entityfox;
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
	{
		return this.spawnBabyAnimal(par1EntityAgeable);
	}
}