package alphaitems.mobs.entities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import alphaitems.items.Items;

public class EntityHellduck extends EntityDuck implements IMob {
	
	public EntityHellduck(World par1World) {
		super(par1World);
		this.setSize(0.3F * 2.0F, 0.7F * 2.0F);
		this.tasks.addTask(8,
				new EntityAIAttackOnCollide(this, 6.0D, true));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(
				this,
				EntityPlayer.class, 6, true));
		this.isImmuneToFire = true;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setAttribute(10.0F);
	}
	
	@Override
	public void onLivingUpdate() {
		if (this.isInWater()) {
			this.attackEntityFrom(DamageSource.drown, 4.0F);
		}
		super.onLivingUpdate();
	}
	
	@Override
	protected void fall(float par1) {
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound()
	{
		return "awei:duck.say";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return "awei:duck.hurt";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "awei:duck.die";
	}
	
	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.chicken.step", 0.10F, 0.5F);
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected int getDropItemId()
	{
		return Item.feather.itemID;
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
		
		for (int k = 0; k < j; ++k)
		{
			this.dropItem(Items.duckFeather.itemID, 1);
		}
		
		if (this.isBurning())
		{
			this.dropItem(Items.duckCooked.itemID, 1);
		}
		else
		{
			this.dropItem(Items.duckRaw.itemID, 1);
		}
	}
	
	@Override
	public boolean isInWater()
	{
		return this.worldObj.handleMaterialAcceleration(
				this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D),
				Material.water, this);
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public boolean getCanSpawnHere()
	{
		return this.posY > 15.0D && this.posY < 93.0D
				&& this.worldObj.difficultySetting > 0
				&& this.isValidLightLevel()
				&& super.getCanSpawnHere();
	}
	
	protected boolean isValidLightLevel()
	{
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);
		
		if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand
				.nextInt(32))
		{
			return false;
		}
		else
		{
			int l = this.worldObj.getBlockLightValue(i, j, k);
			
			if (this.worldObj.isThundering())
			{
				int i1 = this.worldObj.skylightSubtracted;
				this.worldObj.skylightSubtracted = 10;
				l = this.worldObj.getBlockLightValue(i, j, k);
				this.worldObj.skylightSubtracted = i1;
			}
			
			return l <= this.rand.nextInt(8);
		}
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		player.attackEntityFrom(DamageSource.causeMobDamage(this),
				6.0F);
	}
}