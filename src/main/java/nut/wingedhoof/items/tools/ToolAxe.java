package nut.wingedhoof.items.tools;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.tabs.WingedHoofTab;
import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.util.IRegisterable;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

/*
- DAMAGE -
WOOD      = 7
GOLD      = 7
STONE     = 9
IRON      = 9
DIAMOND   = 9
NETHERITE = 10

- SPEED -
WOOD      = 0.8
STONE     = 0.8
IRON      = 0.9
GOLD      = 1.0
DIAMOND   = 1.0
NETHERITE = 1.0
*/

public class ToolAxe extends ItemAxe implements IRegisterable {
	public ToolAxe(String name, ToolMaterial material, float damage, float speed) {
		// For some reason the damage is incresead by one (???)
		// And base speed is 4 (???????), the math below is for the speed be what should it be
		super(material, damage - 1, (4 - speed) * -1);

		updateRegistryAndLocalizedName(name);
		setCreativeTab(WingedHoof.CREATIVE_TAB);

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