package nut.wingedhoof.items.armor;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.interfaces.IRegisterable;
import net.minecraft.item.ItemArmor;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ArmorBase extends ItemArmor implements IRegisterable {
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);

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
