package alphaitems.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEnderSpider extends EntitySpider {
	public EntityEnderSpider(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setAttribute(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.2D);
	}
	
	@Override
	public void onLivingUpdate() {
		int i;
		for (i = 0; i < 2; ++i) {
			this.worldObj.spawnParticle("portal",
					this.posX + (this.rand.nextDouble() - 0.5D)
							* this.width,
					this.posY + this.rand.nextDouble() * this.height
							- 0.25D,
					this.posZ
							+ (this.rand.nextDouble() - 0.5D)
							* this.width,
					(this.rand.nextDouble() - 0.5D) * 2.0D,
					-this.rand.nextDouble(),
					(this.rand.nextDouble() - 0.5D) * 2.0D);
		}
		float f = this.getBrightness(1.0F);
		
		if (f > 0.5F
				&& this.worldObj.canBlockSeeTheSky(
						MathHelper.floor_double(this.posX),
						MathHelper.floor_double(this.posY),
						MathHelper.floor_double(this.posZ))
				&& this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
			this.entityToAttack = null;
			this.teleportRandomly();
		}
	}
	
	protected boolean teleportRandomly() {
		double d0 = this.posX + (this.rand.nextDouble() - 1.5D) * 64.0D;
		double d1 = this.posY + (this.rand.nextInt(64) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 1.5D) * 64.0D;
		return this.teleportTo(d0, d1, d2);
	}
	
	protected boolean teleportTo(double par1, double par3, double par5) {
		EnderTeleportEvent event = new EnderTeleportEvent(this, par1,
				par3,
				par5, 0);
		if (MinecraftForge.EVENT_BUS.post(event)) {
			return false;
		}
		
		double d3 = this.posX;
		double d4 = this.posY;
		double d5 = this.posZ;
		this.posX = event.targetX;
		this.posY = event.targetY;
		this.posZ = event.targetZ;
		boolean flag = false;
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);
		int l;
		
		if (this.worldObj.blockExists(i, j, k)) {
			boolean flag1 = false;
			
			while (!flag1 && j > 0) {
				l = this.worldObj.getBlockId(i, j - 1, k);
				
				if (l != 0 && Block.blocksList
						
						[l].blockMaterial.blocksMovement()) {
					flag1 = true;
				} else {
					--this.posY;
					--j;
				}
			}
			
			if (flag1) {
				this.setPosition(this.posX, this.posY, this.posZ);
				
				if (this.worldObj.getCollidingBoundingBoxes(this,
						this.boundingBox).isEmpty()
						&& !this.worldObj.isAnyLiquid
								
								(this.boundingBox)) {
					flag = true;
				}
			}
		}
		
		if (!flag) {
			this.setPosition(d3, d4, d5);
			return false;
		} else {
			short short1 = 128;
			
			for (l = 0; l < short1; ++l) {
				double d6 = l / (short1 - 1.0D);
				float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				double d7 = d3 + (this.posX - d3) * d6
						+ (this.rand.nextDouble() - 0.5D) * this.width
						* 2.0D;
				double d8 = d4 + (this.posY - d4) * d6
						+ this.rand.nextDouble
								
								() * this.height;
				double d9 = d5 + (this.posZ - d5) * d6
						+ (this.rand.nextDouble() - 0.5D) * this.width
						* 2.0D;
				this.worldObj.spawnParticle("portal", d7, d8, d9, f,
						f1, f2);
			}
			
			this.worldObj.playSoundEffect(d3, d4, d5,
					"mob.endermen.portal",
					1.0F, 1.0F);
			this.playSound("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected int getDropItemId() {
		return Item.silk.itemID;
	}
	
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
		
		if (par1
				&& (this.rand.nextInt(3) == 0 || this.rand
						.nextInt(1 + par2) > 0)) {
			this.dropItem(Item.spiderEye.itemID, 1);
			this.dropItem(Item.enderPearl.itemID, 1);
		}
	}
}