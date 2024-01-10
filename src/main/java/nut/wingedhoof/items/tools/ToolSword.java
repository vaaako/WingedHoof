package nut.wingedhoof.items.tools;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.util.IRegisterable;

import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

import net.minecraft.creativetab.CreativeTabs;

public class ToolSword extends ItemSword implements IRegisterable {
	public ToolSword(String name, ToolMaterial material) {
		super(material);

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