package alphaitems.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIDefendVillage;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookAtVillager;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityDiamondGolem extends EntityIronGolem
{
	/** deincrements, and a distance-to-home check is done at 0 */
	private int homeCheckTimer;
	Village villageObj;
	private int attackTimer;
	private int holdRoseTick;
	
	public EntityDiamondGolem(World par1World)
	{
		super(par1World);
		this.setSize(this.height, this.width);
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
		this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6D, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(5, new EntityAILookAtVillager(this));
		this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIDefendVillage(this));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this,
				EntityLiving.class, 0, false, true, IMob.mobSelector));
	}
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	@Override
	protected void updateAITick()
	{
		if (--this.homeCheckTimer <= 0)
		{
			this.homeCheckTimer = 70 + this.rand.nextInt(50);
			this.villageObj = this.worldObj.villageCollectionObj
					.findNearestVillage(MathHelper.floor_double(this.posX),
							MathHelper.floor_double(this.posY),
							MathHelper.floor_double(this.posZ), 32);
			
			if (this.villageObj == null)
			{
				this.detachHome();
			}
			else
			{
				ChunkCoordinates chunkcoordinates = this.villageObj.getCenter();
				this.setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY,
						chunkcoordinates.posZ,
						(int) (this.villageObj.getVillageRadius() * 1.2F));
			}
		}
		
		super.updateAITick();
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setAttribute(200.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.35D);
	}
	
	/**
	 * Decrements the entity's air supply when underwater
	 */
	@Override
	protected int decreaseAirSupply(int par1)
	{
		return par1;
	}
	
	@Override
	protected void collideWithEntity(Entity par1Entity)
	{
		if (par1Entity instanceof IMob && this.getRNG().nextInt(20) == 0)
		{
			this.setAttackTarget((EntityLivingBase) par1Entity);
		}
		
		super.collideWithEntity(par1Entity);
	}
	
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		
		if (this.attackTimer > 0)
		{
			--this.attackTimer;
		}
		
		if (this.holdRoseTick > 0)
		{
			--this.holdRoseTick;
		}
		
		if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D
				&& this.rand.nextInt(5) == 0)
		{
			int i = MathHelper.floor_double(this.posX);
			int j = MathHelper.floor_double(this.posY - 0.20000000298023224D
					- this.yOffset);
			int k = MathHelper.floor_double(this.posZ);
			int l = this.worldObj.getBlockId(i, j, k);
			
			if (l > 0)
			{
				this.worldObj.spawnParticle("tilecrack_" + l + "_"
						+ this.worldObj.getBlockMetadata(i, j, k), this.posX
						+ (this.rand.nextFloat() - 0.5D)
						* this.width, this.boundingBox.minY + 0.1D,
						this.posZ + (this.rand.nextFloat() - 0.5D)
								* this.width,
						4.0D * (this.rand.nextFloat() - 0.5D), 0.5D,
						(this.rand.nextFloat() - 0.5D) * 4.0D);
			}
		}
	}
	
	/**
	 * Returns true if this entity can attack entities of the specified class.
	 */
	@Override
	public boolean canAttackClass(Class par1Class)
	{
		return this.isPlayerCreated()
				&& EntityPlayer.class.isAssignableFrom(par1Class) ? false
				: super.canAttackClass(par1Class);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		this.attackTimer = 10;
		this.worldObj.setEntityState(this, (byte) 4);
		boolean flag = par1Entity.attackEntityFrom(
				DamageSource.causeMobDamage(this),
				8 + this.rand.nextInt(15));
		
		if (flag)
		{
			par1Entity.motionY += 0.6000000059604645D;
		}
		
		this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		return flag;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1)
	{
		if (par1 == 4)
		{
			this.attackTimer = 10;
			this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		}
		else if (par1 == 11)
		{
			this.holdRoseTick = 400;
		}
		else
		{
			super.handleHealthUpdate(par1);
		}
	}
	
	@Override
	public Village getVillage()
	{
		return this.villageObj;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getAttackTimer()
	{
		return this.attackTimer;
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound()
	{
		return "none";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return "mob.irongolem.hit";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.irongolem.death";
	}
	
	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.irongolem.walk", 1.0F, 1.0F);
	}
	
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		int j = this.rand.nextInt(3);
		int k;
		
		for (k = 0; k < j; ++k)
		{
			this.dropItem(Block.plantRed.blockID, 1);
		}
		
		k = 3 + this.rand.nextInt(3);
		
		for (int l = 0; l < k; ++l)
		{
			this.dropItem(Item.diamond.itemID, 1);
		}
	}
	
	@Override
	public int getHoldRoseTick()
	{
		return this.holdRoseTick;
	}
	
	/**
	 * Called when the mob's health reaches 0.
	 */
	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		if (!this.isPlayerCreated() && this.attackingPlayer != null
				&& this.villageObj != null)
		{
			this.villageObj.setReputationForPlayer(
					this.attackingPlayer.getCommandSenderName(), -5);
		}
		
		super.onDeath(par1DamageSource);
	}
}