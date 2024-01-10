package nut.wingedhoof.blocks;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.init.BlockInit;
import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.util.IRegisterable;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;

public class BlockBase extends Block implements IRegisterable {
    public BlockBase(String name, Material material, float hardness, float resistance, String harvestTool, int harvestLevel) {
		super(material);
	
		updateRegistryAndLocalizedName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(harvestTool, harvestLevel);

		BlockInit.BLOCKS.add(this); // Add to block items
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name)); // Create an ItemBlock and add it to iTEMS
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 1; // Returning 0 prevents the block from dropping itself
	}

	@Override
	public void registerItemModel() {
		WingedHoof.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
	}

	@Override
	public void updateRegistryAndLocalizedName(String name) {
		setUnlocalizedName(name); // Used for language files
		setRegistryName(name); // USed for registering the item and it's models
	}
}
