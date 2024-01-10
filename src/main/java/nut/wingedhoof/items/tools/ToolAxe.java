package nut.wingedhoof.items.tools;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.util.IRegisterable;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

import net.minecraft.creativetab.CreativeTabs;

public class ToolAxe extends ItemAxe implements IRegisterable {
	public ToolAxe(String name, ToolMaterial material, float damage, float speed) {
		super(material, damage - 1, speed); // For some reason the damage is incresead by one (???)

		updateRegistryAndLocalizedName(name);
		setCreativeTab(CreativeTabs.TOOLS);

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