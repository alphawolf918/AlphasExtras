package alphaitems.mobs.entities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import alphaitems.blocks.Blocks;

public class EntitySpiderling extends EntityCaveSpider {
	
	private static int ticksExisted = 0;
	
	public EntitySpiderling(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setAttribute(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.820000011920929D);
	}
	
	// Spawn cobwebs
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		this.ticksExisted++;
		Random rand = new Random();
		if (rand.nextInt(100) == 5) {
			this.worldObj.setBlock((int) this.posX, (int) this.posY,
					(int) this.posZ,
					Block.web.blockID);
		}
		if (this.ticksExisted >= 1100) {
			if (rand.nextInt(100) == 5) {
				this.worldObj.setBlock((int) this.posX, (int) this.posY,
						(int) this.posZ,
						Blocks.crawlerEgg.blockID);
				this.killSpider();
			}
		}
	}
	
	public void killSpider() {
		this.ticksExisted = 0;
		this.setDead();
	}
	
	@Override
	protected Entity findPlayerToAttack()
	{
		double d0 = 16.0D;
		return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
	}
	
	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.spider.step", 1.15F, 2.0F);
	}
	
	@Override
	protected void attackEntity(Entity par1Entity, float par2)
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
	
	@Override
	protected float getSoundPitch() {
		return 2.0F;
	}
	
	@Override
	protected float getSoundVolume() {
		return 1.15F;
	}
}