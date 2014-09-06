package alphaitems.mobs.entities;

import java.util.Calendar;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMummy extends EntityMob {
	protected static final Attribute field_110186_bp = (new RangedAttribute(
			"mummy.spawnReinforcements", 0.0D, 0.0D, 1.0D));
	
	public EntityMummy(World par1World) {
		super(par1World);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 2.0D, false));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this,
				EntityVillager.class, 2.0D, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this,
				1.0D));
		this.tasks
				.addTask(5, new EntityAIMoveThroughVillage(this, 2.0D,
						false));
		this.tasks.addTask(6, new EntityAIWander(this, 2.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(
				this,
				EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(
				this,
				EntityVillager.class, 0, false));
	}
	
	@Override
	public int getTotalArmorValue()
	{
		int i = super.getTotalArmorValue() + 2;
		
		if (i > 20)
		{
			i = 20;
		}
		
		return i;
	}
	
	@Override
	public void onLivingUpdate()
	{
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote
				&& !this.isChild())
		{
			float f = this.getBrightness(1.0F);
			
			if (f > 0.5F
					&& this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F
					&& this.worldObj.canBlockSeeTheSky(
							MathHelper.floor_double(this.posX),
							MathHelper.floor_double(this.posY),
							MathHelper.floor_double(this.posZ)))
			{
				boolean flag = true;
				ItemStack itemstack = this.getCurrentItemOrArmor(4);
				
				if (itemstack != null)
				{
					if (itemstack.isItemStackDamageable())
					{
						itemstack.setItemDamage(itemstack
								.getItemDamageForDisplay()
								+ this.rand.nextInt(2));
						
						if (itemstack.getItemDamageForDisplay() >= itemstack
								.getMaxDamage())
						{
							this.renderBrokenItemStack(itemstack);
							this.setCurrentItemOrArmor(4, (ItemStack) null);
						}
					}
					
					flag = false;
				}
				
				if (flag)
				{
					this.setFire(8);
				}
			}
		}
		
		super.onLivingUpdate();
	}
	
	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource,
			float par2)
	{
		if (!super.attackEntityFrom(par1DamageSource, par2))
		{
			return false;
		}
		else
		{
			EntityLivingBase entitylivingbase = this.getAttackTarget();
			
			if (entitylivingbase == null
					&& this.getEntityToAttack() instanceof EntityLivingBase)
			{
				entitylivingbase = (EntityLivingBase) this
						.getEntityToAttack();
			}
			
			if (entitylivingbase == null
					&& par1DamageSource.getEntity() instanceof EntityLivingBase)
			{
				entitylivingbase = (EntityLivingBase) par1DamageSource
						.getEntity();
			}
			
			if (entitylivingbase != null
					&& this.worldObj.difficultySetting >= 3
					&& this.rand.nextFloat() < this
							.getEntityAttribute(field_110186_bp)
							.getAttributeValue())
			{
				int i = MathHelper.floor_double(this.posX);
				int j = MathHelper.floor_double(this.posY);
				int k = MathHelper.floor_double(this.posZ);
				EntityMummy entitymummy = new EntityMummy(this.worldObj);
				
				for (int l = 0; l < 50; ++l)
				{
					int i1 = i
							+ MathHelper.getRandomIntegerInRange(
									this.rand, 7,
									40)
							* MathHelper.getRandomIntegerInRange(
									this.rand, -1,
									1);
					int j1 = j
							+ MathHelper.getRandomIntegerInRange(
									this.rand, 7,
									40)
							* MathHelper.getRandomIntegerInRange(
									this.rand, -1,
									1);
					int k1 = k
							+ MathHelper.getRandomIntegerInRange(
									this.rand, 7,
									40)
							* MathHelper.getRandomIntegerInRange(
									this.rand, -1,
									1);
					
					if (this.worldObj.doesBlockHaveSolidTopSurface(i1,
							j1 - 1,
							k1)
							&& this.worldObj
									.getBlockLightValue(i1, j1, k1) < 10)
					{
						entitymummy.setPosition(i1, j1,
								k1);
						
						if (this.worldObj
								.checkNoEntityCollision(entitymummy.boundingBox)
								&& this.worldObj
										.getCollidingBoundingBoxes(
												entitymummy,
												entitymummy.boundingBox)
										.isEmpty()
								&& !this.worldObj
										.isAnyLiquid(entitymummy.boundingBox))
						{
							this.worldObj.spawnEntityInWorld(entitymummy);
							entitymummy.setAttackTarget(entitylivingbase);
							entitymummy
									.onSpawnWithEgg((EntityLivingData) null);
							this.getEntityAttribute(field_110186_bp)
									.applyModifier(
											new AttributeModifier(
													"Zombie reinforcement caller charge",
													-0.05000000074505806D,
													0));
							entitymummy
									.getEntityAttribute(field_110186_bp)
									.applyModifier(
											new AttributeModifier(
													"Zombie reinforcement callee charge",
													-0.05000000074505806D,
													0));
							break;
						}
					}
				}
			}
			
			return true;
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		boolean flag = super.attackEntityAsMob(par1Entity);
		
		if (flag
				&& this.getHeldItem() == null
				&& this.isBurning()
				&& this.rand.nextFloat() < this.worldObj.difficultySetting * 0.3F)
		{
			par1Entity.setFire(2 * this.worldObj.difficultySetting);
		}
		
		return flag;
	}
	
	@Override
	protected String getLivingSound()
	{
		return "awei:mummy.say";
	}
	
	@Override
	protected String getHurtSound()
	{
		return "awei:mummy.hurt";
	}
	
	@Override
	protected String getDeathSound()
	{
		return "awei:mummy.die";
	}
	
	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.zombie.step", 0.15F, 1.0F);
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	protected void dropRareDrop(int par1)
	{
		switch (this.rand.nextInt(3))
		{
			case 0:
				this.dropItem(Item.ingotGold.itemID, 1);
				break;
			case 1:
				this.dropItem(Item.paper.itemID, 1);
				break;
			case 2:
				this.dropItem(Item.potato.itemID, 1);
		}
	}
	
	@Override
	protected void addRandomArmor()
	{
		super.addRandomArmor();
		
		if (this.rand.nextFloat() < (this.worldObj.difficultySetting == 3 ? 0.05F
				: 0.01F))
		{
			int i = this.rand.nextInt(3);
			
			if (i == 0)
			{
				this.setCurrentItemOrArmor(0,
						new ItemStack(Item.swordDiamond));
			}
			else
			{
				this.setCurrentItemOrArmor(0, new ItemStack(
						Item.swordGold));
			}
		}
	}
	
	@Override
	protected int getDropItemId()
	{
		return Item.rottenFlesh.itemID;
	}
	
	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setAttribute(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setAttribute(5.0D);
		this.getAttributeMap()
				.func_111150_b(field_110186_bp)
				.setAttribute(
						this.rand.nextDouble() * 0.10000000149011612D);
	}
	
	@Override
	public EntityLivingData onSpawnWithEgg(
			EntityLivingData par1EntityLivingData) {
		this.addRandomArmor();
		this.enchantEquipment();
		
		if (this.getCurrentItemOrArmor(4) == null)
		{
			Calendar calendar = this.worldObj.getCurrentDate();
			
			if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31
					&& this.rand.nextFloat() < 0.25F)
			{
				this.setCurrentItemOrArmor(
						4,
						new ItemStack(
								this.rand.nextFloat() < 0.1F ? Block.pumpkinLantern
										: Block.pumpkin));
				this.equipmentDropChances[4] = 0.0F;
			}
		}
		
		this.getEntityAttribute(
				SharedMonsterAttributes.knockbackResistance)
				.applyModifier(
						new AttributeModifier(
								"Random spawn bonus",
								this.rand
										.nextDouble() * 0.05000000074505806D,
								0));
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.applyModifier(
						new AttributeModifier("Random zombie-spawn bonus",
								this.rand.nextDouble() * 1.5D, 2));
		return par1EntityLivingData;
	}
	
	@Override
	public void onKillEntity(EntityLivingBase par1EntityLivingBase)
	{
		super.onKillEntity(par1EntityLivingBase);
		
		if (this.worldObj.difficultySetting >= 2
				&& par1EntityLivingBase instanceof EntityVillager)
		{
			if (this.worldObj.difficultySetting == 2
					&& this.rand.nextBoolean())
			{
				return;
			}
			
			EntityMummy entitymummy = new EntityMummy(this.worldObj);
			entitymummy.copyLocationAndAnglesFrom(par1EntityLivingBase);
			this.worldObj.removeEntity(par1EntityLivingBase);
			entitymummy.onSpawnWithEgg((EntityLivingData) null);
			
			this.worldObj.spawnEntityInWorld(entitymummy);
			this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1016,
					(int) this.posX, (int) this.posY, (int) this.posZ, 0);
		}
	}
}