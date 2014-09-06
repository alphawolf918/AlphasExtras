package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;

public class MagmaSlimeBlock extends Block {
	public MagmaSlimeBlock(int par1) {
		super(par1, Material.sponge);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("magmaslimeblock");
		this.setHardness(4F);
		this.setResistance(10F);
		this.setTextureName("awei:magmaslimeblock");
		this.setStepSound(Block.soundSnowFootstep);
		this.slipperiness = 0.5F;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1world, int par2, int par3,
			int par4, int par5) {
		int rand = (int) (Math.floor(8) * Math.random());
		if (par1world.difficultySetting != 0 && !par1world.isRemote) {
			if (rand <= 3) {
				Entity slime = new EntityMagmaCube(par1world);
				slime.setLocationAndAngles(par2 + 0.5D, par3,
						par4 + 0.5D, 0.0F, 0.0F);
				par1world.spawnEntityInWorld(slime);
			}
		}
	}
	
	@Override
	public int idDropped(int par1, Random par2random, int par3) {
		return Item.magmaCream.itemID;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		entity.motionY += 0.5F;
		entity.fallDistance = 0F;
		entity.setFire(2);
	}
	
	public void onBlockClicked(World world, int x, int y, int z, Entity player) {
		player.setFire(2);
	}
}