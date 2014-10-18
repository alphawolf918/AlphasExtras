package alphaitems.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import alphaitems.AlphaItemsMod;
import alphaitems.blocks.tiles.TileEntityAmpCell;
import alphaitems.creativetabs.ModTabs;
import alphaitems.lib.State;
import api.cofh.block.IBlockInfo;
import cpw.mods.fml.common.network.FMLNetworkHandler;

public class AMPCell extends BlockContainer implements IBlockInfo {
	
	protected int energyAmount = 600000;
	public State state = State.OFF;
	protected String textureSuffix = "off";
	protected boolean powered;
	
	public AMPCell(int par1, State state, String textSuff) {
		super(par1, Material.iron);
		this.setCreativeTab(ModTabs.aiTab);
		this.textureSuffix = (state == State.ON) ? "on" : "off";
		this.setUnlocalizedName("ampcell");
		this.setTextureSuffix(textSuff);
		if (state == State.ON) {
			this.setLightValue(1.0F);
		} else {
			this.setLightValue(0.0F);
		}
		this.setHardness(2F);
		this.setResistance(10);
		this.setStepSound(Block.soundMetalFootstep);
		this.setTickRandomly(true);
	}
	
	@Override
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return Blocks.ampCellOff.blockID;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Blocks.ampCellOff.blockID;
	}
	
	public void setTextureSuffix(String strSuffix) {
		this.textureSuffix = strSuffix;
		this.setTextureName("awei:ampblock_" + this.textureSuffix);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		if (!par1World.isRemote) {
			FMLNetworkHandler.openGui(par5EntityPlayer,
					AlphaItemsMod.INSTANCE, 0, par1World, par3, par4,
					par6);
		}
		return true;
	}
	
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		this.stateCheck(par1World, par2, par3, par4);
	}
	
	public void stateCheck(World par1World, int par2, int par3, int par4) {
		if (!par1World.isRemote) {
			if (this.state == State.ON
					&& !par1World.isBlockIndirectlyGettingPowered(par2,
							par3, par4)) {
				par1World.scheduleBlockUpdate(par2, par3, par4,
						this.blockID,
						0);
				par1World
						.setBlock(par2, par3, par4,
								Blocks.ampCellOff.blockID);
			} else if (this.state == State.OFF
					&& par1World.isBlockIndirectlyGettingPowered(par2,
							par3, par4)) {
				par1World
						.setBlock(par2, par3, par4,
								Blocks.ampCellOn.blockID);
			}
			if (this.state == State.OFF
					&& !par1World.isBlockIndirectlyGettingPowered(
							par2,
							par3, par4))
				par1World.setBlock(par2, par3, par4,
						Blocks.ampCellOff.blockID);
		}
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, int par5) {
		this.stateCheck(par1World, par2, par3, par4);
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		this.stateCheck(par1World, par2, par3, par4);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAmpCell();
	}
	
	@Override
	public void getBlockInfo(IBlockAccess world, int x, int y, int z,
			ForgeDirection side, EntityPlayer player, List<String> info,
			boolean debug) {
		info.add("Uses the power of amaranth to supply RF.");
	}
}