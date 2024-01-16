package nut.wingedhoof.items.tools;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.init.ItemInit;
import net.minecraft.item.ItemSpade;
import nut.wingedhoof.interfaces.IRegisterable;

public class ToolShovel extends ItemSpade implements IRegisterable {
	public ToolShovel(String name, ToolMaterial material) {
		super(material);

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