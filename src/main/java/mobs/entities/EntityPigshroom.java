package alphaitems.mobs.entities;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class EntityPigshroom extends EntityPig implements IShearable {
	public EntityPigshroom(World par1) {
		super(par1);
		this.setSize(this.width, this.height);
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	public boolean isShearable(ItemStack item, World world, int X, int Y,
			int Z)
	{
		return getGrowingAge() >= 0;
	}
	
	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, World world,
			int X, int Y, int Z, int fortune)
	{
		setDead();
		EntityPig entitypig = new EntityPig(worldObj);
		entitypig.setLocationAndAngles(posX, posY, posZ, rotationYaw,
				rotationPitch);
		entitypig.setHealth(this.getHealth());
		entitypig.renderYawOffset = renderYawOffset;
		worldObj.spawnEntityInWorld(entitypig);
		worldObj.spawnParticle("largeexplode", posX, posY + height / 2.0F,
				posZ, 0.0D, 0.0D, 0.0D);
		
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		for (int x = 0; x < 5; x++)
		{
			ret.add(new ItemStack(Block.mushroomRed));
		}
		return ret;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setAttribute(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.50D);
	}
	
	@Override
	public void onStruckByLightning(
			EntityLightningBolt par1EntityLightningBolt) {
	}
	
	@Override
	public EntityPigshroom spawnBabyAnimal(EntityAgeable par1EntityAgeable)
	{
		return new EntityPigshroom(this.worldObj);
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
	{
		return this.spawnBabyAnimal(par1EntityAgeable);
	}
}