package alphaitems.blocks.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import alphaitems.api.cofh.energy.EnergyStorage;
import alphaitems.api.cofh.energy.IEnergyStorage;
import alphaitems.api.cofh.energy.TileEnergyHandler;
import alphaitems.api.cofh.transport.IItemConduitConnection;

public class TileEntityAmpCell extends TileEnergyHandler implements
		IEnergyStorage, ISidedInventory, IItemConduitConnection

{
	
	protected int energy;
	protected int capacity;
	protected int maxReceive;
	protected int maxExtract;
	protected int maxPower = 60000000;
	protected EnergyStorage storage = new EnergyStorage(maxPower);
	private String field_94130_e;
	
	public TileEntityAmpCell() {
		this.setCapacity(maxPower);
		this.setMaxTransfer(maxPower);
		this.setWorldObj(worldObj);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.energy = nbt.getInteger("Energy");
		
		if (energy > capacity) {
			energy = capacity;
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		
		if (energy < 0) {
			energy = 0;
		}
		nbt.setInteger("Energy", energy);
	}
	
	public void setCapacity(int capacity) {
		
		this.capacity = capacity;
		
		if (energy > capacity) {
			energy = capacity;
		}
	}
	
	public void setMaxTransfer(int maxTransfer) {
		setMaxReceive(maxTransfer);
		setMaxExtract(maxTransfer);
	}
	
	public void setMaxReceive(int maxReceive) {
		
		this.maxReceive = maxReceive;
	}
	
	public void setMaxExtract(int maxExtract) {
		
		this.maxExtract = maxExtract;
	}
	
	public int getMaxReceive() {
		
		return maxReceive;
	}
	
	public int getMaxExtract() {
		
		return maxExtract;
	}
	
	/**
	 * This function is included to allow for server -> client sync. Do not call
	 * this externally to the containing Tile Entity, as not all IEnergyHandlers
	 * are guaranteed to have it.
	 * 
	 * @param energy
	 */
	public void setEnergyStored(int energy) {
		
		this.energy = energy;
		
		if (this.energy > capacity) {
			this.energy = capacity;
		} else if (this.energy < 0) {
			this.energy = 0;
		}
	}
	
	/**
	 * This function is included to allow the containing tile to directly and
	 * efficiently modify the energy contained in the EnergyStorage. Do not rely
	 * on this externally, as not all IEnergyHandlers are guaranteed to have it.
	 * 
	 * @param energy
	 */
	public void modifyEnergyStored(int energy) {
		
		this.energy += energy;
		
		if (this.energy > capacity) {
			this.energy = capacity;
		} else if (this.energy < 0) {
			this.energy = 0;
		}
	}
	
	/* IEnergyStorage */
	@Override
	public int receiveEnergy(int maxReceive, boolean simulate) {
		
		int energyReceived = Math.min(capacity - energy,
				Math.min(this.maxReceive, maxReceive));
		
		if (!simulate) {
			energy += energyReceived;
		}
		return energyReceived;
	}
	
	@Override
	public int extractEnergy(int maxExtract, boolean simulate) {
		
		int energyExtracted = Math.min(energy,
				Math.min(this.maxExtract, maxExtract));
		
		if (!simulate) {
			energy -= energyExtracted;
		}
		return energyExtracted;
	}
	
	@Override
	public int getEnergyStored() {
		return energy;
	}
	
	@Override
	public int getMaxEnergyStored() {
		return capacity;
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}
	
	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ItemStack decrStackSize(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getInvName() {
		return this.isInvNameLocalized() ? this.field_94130_e
				: "container.ampcell";
	}
	
	@Override
	public boolean isInvNameLocalized() {
		return this.field_94130_e != null
				&& this.field_94130_e.length() > 0;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord,
				this.zCoord) != this ? false : entityplayer
				.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D,
						this.zCoord + 0.5D) <= 64.0D;
	}
	
	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}
	
	public void setGuiDisplayName(String par1Str)
	{
		this.field_94130_e = par1Str;
	}
	
	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean canConduitConnect(ForgeDirection from) {
		return true;
	}
}