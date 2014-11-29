package alphaitems.blocks.plants.trees.maple;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MapleWood extends Block {
	/** The type of tree this log came from. */
	public static final String[] MaplewoodType = new String[] { "Maple" };
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	@SideOnly(Side.CLIENT)
	private Icon tree_top;
	private final int blockIndexTexture;
	
	protected MapleWood(int par1) {
		super(par1, Material.wood);
		this.blockIndexTexture = 1;
		this.setCreativeTab(ModTabs.aiTab);
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return 31;
	}
	
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}
	
	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4,
			int par5, int par6) {
		byte b0 = 4;
		int j1 = b0 + 1;
		
		if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2
				+ j1, par3 + j1, par4 + j1)) {
			for (int k1 = -b0; k1 <= b0; ++k1) {
				for (int l1 = -b0; l1 <= b0; ++l1) {
					for (int i2 = -b0; i2 <= b0; ++i2) {
						int j2 = par1World.getBlockId(par2 + k1, par3 + l1,
								par4 + i2);
						
						if (Block.blocksList[j2] != null) {
							Block.blocksList[j2].beginLeavesDecay(par1World,
									par2 + k1, par3 + l1, par4 + i2);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4,
			int par5, float par6, float par7, float par8, int par9) {
		int j1 = par9 & 3;
		byte b0 = 0;
		
		switch (par5) {
		case 0:
		case 1:
			b0 = 0;
			break;
		case 2:
		case 3:
			b0 = 8;
			break;
		case 4:
		case 5:
			b0 = 4;
		}
		
		return j1 | b0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	public int damageDropped(int par1) {
		return par1 & 3;
	}
	
	/**
	 * returns a number between 0 and 3
	 */
	public static int limitToValidMetadata(int par0) {
		return par0 & 3;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
	}
	
	/**
	 * Returns an item stack containing a single instance of the current block
	 * type. 'i' is the block's subtype/damage and is ignored for blocks which
	 * do not support subtypes. Blocks which cannot be harvested should return
	 * null.
	 */
	@Override
	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(this.blockID, 1, limitToValidMetadata(par1));
	}
	
	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z) {
		return true;
	}
	
	@Override
	public boolean isWood(World world, int x, int y, int z) {
		return true;
	}
}