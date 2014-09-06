package alphaitems.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;

public class SlimeBlock extends Block {
	public SlimeBlock(int par1) {
		super(par1, Material.sponge);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("slimeblock");
		this.setHardness(1F);
		this.setResistance(10F);
		this.setStepSound(Block.soundSnowFootstep);
		this.setTextureName("awei:slimeblock");
		this.slipperiness = 1.5F;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1world, int par2,
			int par3,
			int par4, int par5) {
		int rand = (new Random()).nextInt(8);
		if (par1world.difficultySetting != 0 && !par1world.isRemote) {
			if (rand <= 3) {
				EntitySlime slime = new EntitySlime(par1world);
				slime.setLocationAndAngles(par2 + 0.5D, par3,
						par4 + 0.5D, 0.0F, 0.0F);
				par1world.spawnEntityInWorld(slime);
			}
		}
	}
	
	@Override
	public int idDropped(int par1, Random par2random, int par3) {
		return Item.slimeBall.itemID;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z,
			Entity entity) {
		entity.motionY += 1.0F;
		entity.fallDistance = 0F;
	}
}