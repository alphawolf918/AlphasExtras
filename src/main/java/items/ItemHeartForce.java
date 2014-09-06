package alphaitems.items;

import java.util.List;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;
import alphaitems.creativetabs.ModTabs;

public class ItemHeartForce extends Item {
	
	double dblMaxHealthLimit = 80.0D;
	int intMaxHealthLimit = (int) dblMaxHealthLimit;
	int numTimes = 0;
	double healthIncreaseAmount = 2.0D;
	
	public ItemHeartForce(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.aiTab);
		this.setUnlocalizedName("heartforce");
		this.setTextureName("awei:heartforce");
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4,
			int par5,
			int par6, int par7, float par8, float par9, float par10)
	{
		EntityPlayer player = par2EntityPlayer;
		if (!player.capabilities.isCreativeMode) {
			float maxHealth = player.getMaxHealth();
			AttributeInstance attrMaxHealth = player.getEntityAttribute(
					SharedMonsterAttributes.maxHealth);
			if (attrMaxHealth.getAttributeValue() < dblMaxHealthLimit) {
				maxHealth += healthIncreaseAmount;
				player.getEntityAttribute(
						SharedMonsterAttributes.maxHealth)
						.setAttribute(maxHealth);
				player.setHealth(maxHealth);
				par1ItemStack.damageItem(2, par2EntityPlayer);
				ChatMessageComponent txtc = ChatMessageComponent
						.createFromText("Your max health has been increased!");
				player.sendChatToPlayer(txtc);
			} else {
				ChatMessageComponent txt = ChatMessageComponent
						.createFromText("Your max health cannot exceed "
								+ intMaxHealthLimit + ".");
				if (numTimes == 0) {
					player.sendChatToPlayer(txt);
					numTimes++;
				}
			}
		}
		return true;
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Adds a heart to the Player's health bar, but "
				+ "max health can't go over " + intMaxHealthLimit + ".");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.epic;
	}
}