package alphaitems.mobs.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import alphaitems.managers.EventManager;
import alphaitems.structures.WandererHouse;

public class EntityWanderer extends EntityMob {
	
	public static int dangerSense = 0;
	public static boolean shouldBuildHouse = false;
	public static boolean hasHouse = false;
	public static boolean dangerSenseReached = false;
	public static boolean canInteract = true;
	public static ArrayList<String> sayings = new ArrayList<String>();
	private static int randNameInt = (new Random()).nextInt(5000);
	public static String customName = (randNameInt == 1) ? "Herobrine"
			: "Wanderer";
	public static int angerLevel = (customName == "Herobrine") ? 800 : 0;
	public static float maxHealth;
	
	public EntityWanderer(World par1World) {
		super(par1World);
		this.healthSet(20F, 40F);
		this.setHealth(maxHealth);
		this.setAIMoveSpeed(0.2F);
		this.scoreValue = 70;
		this.experienceValue = 80;
		this.getNavigator().setAvoidsWater(true);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(1, new EntityAIWatchClosest(this,
				EntityWanderer.class, 6.0F));
		this.tasks.addTask(2,
				new EntityAIWander(this, this.getAIMoveSpeed()));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D,
				Item.ingotGold.itemID, false));
		this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this
				.getAIMoveSpeed(), false));
		this.tasks.addTask(6, new EntityAIMoveIndoors(this));
		this.tasks.addTask(7, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(8, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(9, new EntityAIMoveTowardsRestriction(this,
				0.6D));
		this.tasks.addTask(10, new EntityAIAttackOnCollide(this,
				EntityMob.class, this.getAIMoveSpeed(), false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(
				this, EntityMob.class, 0, true));
		this.setCustomNameTag(customName);
		this.addSayings();
		this.addRandomArmor();
	}
	
	protected final void healthSet(float par1Max, float par2Min) {
		int randInt = (new Random()).nextInt((int) par1Max);
		float returnedHealth = (randInt < par2Min) ? par2Min : randInt;
		this.maxHealth = returnedHealth;
		Attribute mHealth = SharedMonsterAttributes.maxHealth;
		AttributeInstance attr = this
				.getEntityAttribute(mHealth);
		attr.setAttribute(this.maxHealth);
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("Anger", (short) this.angerLevel);
	}
	
	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.angerLevel = par1NBTTagCompound.getShort("Anger");
	}
	
	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * Wanderers).
	 */
	@Override
	protected Entity findPlayerToAttack()
	{
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setAttribute(5.0D);
	}
	
	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource,
			float par2)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			Entity entity = par1DamageSource.getEntity();
			
			if (entity instanceof Entity)
			{
				List list = this.worldObj
						.getEntitiesWithinAABBExcludingEntity(
								this, this.boundingBox.expand(32.0D,
										32.0D, 32.0D));
				
				for (int i = 0; i < list.size(); ++i)
				{
					Entity entity1 = (Entity) list.get(i);
					
					if (entity1 instanceof EntityWanderer)
					{
						EntityWanderer entitywanderer = (EntityWanderer) entity1;
						entitywanderer.becomeAngryAt(entity);
					}
				}
				
				this.becomeAngryAt(entity);
			}
			
			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}
	
	/**
	 * Causes this Wanderer to become angry at the supplied Entity (which will
	 * be a player).
	 */
	private void becomeAngryAt(Entity par1Entity)
	{
		this.entityToAttack = par1Entity;
		this.angerLevel = 400 + this.rand.nextInt(400);
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
		if (!this.worldObj.isDaytime()) {
			if (!dangerSenseReached && dangerSense < 51) {
				dangerSense++;
			} else {
				dangerSense = 0;
			}
		}
		if (dangerSense >= 50) {
			dangerSenseReached = true;
			shouldBuildHouse = true;
		}
		if (shouldBuildHouse && !hasHouse) {
			this.buildHouse(worldObj, rand, this);
			dangerSense = 0;
			shouldBuildHouse = false;
			hasHouse = true;
		}
		
		if (this.angerLevel >= 400) {
			this.tasks.addTask(12, new EntityAIAttackOnCollide(this,
					EntityPlayer.class, this.getAIMoveSpeed(), false));
			this.targetTasks.addTask(8,
					new EntityAINearestAttackableTarget(
							this, EntityPlayer.class, 0, true));
		}
	}
	
	public static void buildHouse(World world, Random random,
			EntityWanderer entity) {
		if (entity.posY >= 60) {
			int entX = (int) entity.posX + 2;
			int entY = (int) entity.posY;
			int entZ = (int) entity.posZ + 2;
			EventManager.spawnStructure(18, 20, world, random, entX,
					entY,
					entZ,
					(new WandererHouse()));
			entity.setHomeArea(entX, entY, entZ, 5);
		}
	}
	
	public static void addSayings() {
		addSaying("Hello.");
		addSaying("How are you today?");
		addSaying("I sure do love mining.");
		addSaying("Dude, Mega Creepers freak me out.");
		addSaying("I'm so, like, bummed.");
		addSaying("The moon is full tonight.");
		addSaying("Fear the Venus, lest it consume you.");
		addSaying("Legend says that Crystal Towers spawn, and that chests lie within them.");
		addSaying("alphawolf918 is my creator.");
		addSaying("You are of no interest to me.");
		if (hasHouse) {
			addSaying("I should get home...");
		} else {
			addSaying("I need a house...");
		}
		addSaying("Sometimes chests can be found underneath the dirt. There are usually crystals nearby.");
		addSaying("I need more zinc in my diet.");
		addSaying("Ugh, I seriously need water.");
		addSaying("I love acacia trees.");
		addSaying("I am a busy, busy man.");
		addSaying("You're ugly.");
		addSaying("Well, look who crawled out from under a rock.");
		addSaying("You don't belong here.");
		addSaying("Welcome to the Venus!");
		addSaying("Have you ever thought about exercising?");
		addSaying("Wow, you sure look good. *cough*");
	}
	
	public static void addSaying(String par1Saying) {
		sayings.add(par1Saying);
	}
	
	public static String pickSaying() {
		return sayings.get((new Random()).nextInt(sayings.size()));
	}
	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer) {
		ChatMessageComponent txt = ChatMessageComponent.createFromText("<"
				+ this.getCustomNameTag() + "> "
				+ this.pickSaying());
		if (!worldObj.isRemote) {
			par1EntityPlayer.sendChatToPlayer(txt);
			return true;
		}
		return false;
	}
	
	@Override
	public void onDeath(DamageSource ds) {
		super.onDeath(ds);
		if (!this.worldObj.isRemote && !this.worldObj.isDaytime()) {
			EntityZombie zombie = new EntityZombie(this.worldObj);
			zombie.setLocationAndAngles(this.posX, this.posY,
					this.posZ, this.rotationYaw, this.rotationPitch);
			if (this.hasCustomNameTag()) {
				zombie.setCustomNameTag(this.getCustomNameTag()
						+ " Zombie");
			}
			zombie.setCanPickUpLoot(true);
			this.worldObj.spawnEntityInWorld(zombie);
		}
		this.setDead();
	}
	
	@Override
	public boolean canDespawn()
	{
		return this.hasHome();
	}
	
	@Override
	public boolean canPickUpLoot() {
		return true;
	}
	
	@Override
	protected boolean isAIEnabled() {
		return true;
	}
	
	/**
	 * Makes entity wear random armor based on difficulty
	 */
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
						Item.swordIron));
			}
		}
	}
	
	@Override
	public EntityLivingData onSpawnWithEgg(
			EntityLivingData par1EntityLivingData) {
		super.onSpawnWithEgg(par1EntityLivingData);
		this.addRandomArmor();
		this.enchantEquipment();
		return par1EntityLivingData;
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
}