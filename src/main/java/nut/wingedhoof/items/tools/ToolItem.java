package nut.wingedhoof.items.tools;

import java.util.Set;
import java.util.Collections;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.tabs.WingedHoofTab;
import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.interfaces.IRegisterable;

import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;

import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;

public class ToolItem extends ItemTool implements IRegisterable {
	// For some reason the damage is incresead by three (???)
	// And base speed is 4 (???????)
	// -1 fixes value (e.g.g -> speed = 0.8 -> Descrese the value taht is increased: 4 - 0.8 = -3.2 -> On increse: -3.2 + 4 = 0.8)

	// new HashSet<>();
	public ToolItem(String name, ToolMaterial material, float damage, float speed) {
		super(damage - 3, (4 - speed) * -1, material, Collections.emptySet());

		this.init(name);
	}

	public ToolItem(String name, ToolMaterial material, float damage, float speed, Set<Block> effectiveOn) {
		super(damage - 3, (4 - speed) * -1, material, effectiveOn);
		this.init(name);
	}

	private void init(String name) {
		updateRegistryAndLocalizedName(name);
		setCreativeTab(WingedHoof.CREATIVE_TAB);

		ItemInit.ITEMS.add(this);
	}

	// public float getStrVsBlock(ItemStack stack, IBlockState state) {
	// 	Material material = state.getMaterial();
	// 	return material != (Material.WOOD && material != Material.PLANTS && material != Material.VINE)
	// 		? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
	// }

	private float calcDamage(float damage) {
		return (3 - damage) * -1;
	}

	private float calcSpeed(float speed) {
		return (4 - speed) * -1;
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