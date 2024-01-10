package nut.wingedhoof.items.tools;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.util.IRegisterable;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

import net.minecraft.creativetab.CreativeTabs;

public class ToolItem extends ItemTool implements IRegisterable {
private static Set<Block> EFFECTIVE_ON = new HashSet<>(Arrays.asList(/* blocks go here */));


	public ToolItem(String name, ToolMaterial material) {
		super(material, EFFECTIVE_ON);

		updateRegistryAndLocalizedName(name);
		setCreativeTab(CreativeTabs.TOOLS);

		ItemInit.ITEMS.add(this);
	}

	// public float getStrVsBlock(ItemStack stack, IBlockState state) {
	// 	Material material = state.getMaterial();
	// 	return material != (Material.WOOD && material != Material.PLANTS && material != Material.VINE)
	// 		? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
	// }

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