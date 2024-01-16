package nut.wingedhoof.items;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.interfaces.IRegisterable;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IRegisterable {
	public ItemBase(String name) {
		updateRegistryAndLocalizedName(name);
		setCreativeTab(WingedHoof.CREATIVE_TAB);

		// Add this item to mod items
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerItemModel() {
		WingedHoof.proxy.registerItemRenderer(this, 0);
	}
	
	@Override
	public void updateRegistryAndLocalizedName(String name) {
		setUnlocalizedName(name); // Used for language files
		setRegistryName(name); // USed for registering the item and it's models
	}
}
