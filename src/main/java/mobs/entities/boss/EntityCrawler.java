package alphaitems.mobs.entities.boss;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import alphaitems.blocks.Blocks;
import alphaitems.items.Items;

public class EntityCrawler extends EntitySpider implements
		IBossDisplayData {
	
	public static int deathTicks = 0;
	public static int ticksExisted = 0;
	
	public EntityCrawler(World par1World) {
		super(par1World);
		this.setSize(this.width * 2, this.height * 2);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 4.5D, true));
		this.tasks.addTask(1, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(3, new EntityAIWander(this, 6.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(
				this,
				EntityPlayer.class, 0, true));
		this.setHealth(this.getMaxHealth());
		this.experienceValue = 1000;
		this.scoreValue = 1000;
		this.ignoreFrustumCheck = true;
	}
	
	@Override
	protected String getLivingSound() {
		return "awei:crawler.say";
	}
	
	@Override
	protected String getHurtSound() {
		return "awei:crawler.hurt";
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setAttribute(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setAttribute(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setAttribute(360.0D);
	}
	
	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.spider.step", 1.15F, 0.5F);
	}
	
	@Override
	protected void entityInit()
	{
		super.entityInit();
	}
	
	public int getAttackStrength(Entity par1Entity)
	{
		return 6;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	public int getTotalArmorValue()
	{
		return 10;
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}
	
	@Override
	protected int getDropItemId() {
		return Items.heartForce.itemID;
	}
	
	// Randomly spawn spiders and cave spiders.
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		Random rand = new Random();
		int randInt = rand.nextInt(10);
		int randIntI = rand.nextInt(4);
		
		if (ticksExisted >= 1500) {
			Entity spider;
			spider = (randInt >= 5) ? new EntitySpider(this.worldObj)
					: new EntityCaveSpider(this.worldObj);
			spider.setLocationAndAngles(this.posX, this.posY,
					this.posZ, this.rotationYaw, this.rotationPitch);
			for (int i = 1; i < randIntI; i++) {
				this.worldObj.spawnEntityInWorld(spider);
				this.heal(randIntI * 10.0F);
			}
			ticksExisted = 0;
		}
		ticksExisted++;
		if (rand.nextInt(1000) == 5) {
			this.worldObj.setBlock((int) this.posX, (int) this.posY,
					(int) this.posZ,
					Blocks.crawlerEgg.blockID);
			this.heal(randIntI * 10.0F);
		}
	}
	
	@Override
	protected void onDeathUpdate()
	{
		++this.deathTicks;
		if (this.deathTicks >= 180 && this.deathTicks <= 200)
		{
			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle("hugeexplosion", this.posX + f,
					this.posY + 2.0D + f1, this.posZ + f2, 0.0D, 0.0D,
					0.0D);
		}
		int i;
		int j;
		if (!this.worldObj.isRemote)
		{
			if (this.deathTicks > 150 && this.deathTicks % 5 == 0)
			{
				i = 1000;
				
				while (i > 0)
				{
					j = EntityXPOrb.getXPSplit(i);
					i -= j;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(
							this.worldObj, this.posX, this.posY,
							this.posZ, j));
				}
			}
		}
		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;
		if (this.deathTicks == 200 && !this.worldObj.isRemote)
		{
			i = 2000;
			while (i > 0)
			{
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(
						this.worldObj,
						this.posX, this.posY, this.posZ, j));
			}
			this.setDead();
		}
	}
	
	public World func_82194_d()
	{
		return this.worldObj;
	}
	
	@Override
	protected void despawnEntity() {
	}
}