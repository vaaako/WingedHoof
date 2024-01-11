package nut.wingedhoof.tabs;

import nut.wingedhoof.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class WingedHoofTab extends CreativeTabs {
	public WingedHoofTab(String label) {
		super(label);

		// If you want image put on assets/minecraft/textures/gui/container/creative_inventory/
		// this.setBackgroundImageName("tab_wingedhoof.png");
	}


	@Override
	public ItemStack getTabIconItem() {
		// return new ItemStack(Item.getItemFromBlock(BlockInit.PALLADIUM_BLOCK));
		return new ItemStack(ItemInit.AMBER);
	}
}