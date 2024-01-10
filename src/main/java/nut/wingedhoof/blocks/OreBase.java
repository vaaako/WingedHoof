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

public class OreBase extends Block implements IRegisterable {
	private String name;
	private float hardness;
	private float resistance;
	private String harvestTool;
	private int harvestLevel;
	private Item dropItem = null;

	private int dropQuantity = 1;
	private int maxExp = 3;

	public OreBase(String name, float hardness, float resistance, String harvestTool, int harvestLevel) {
		super(Material.ROCK);
		this.name         = name;
		this.hardness     = hardness;
		this.resistance   = resistance;
		this.harvestTool  = harvestTool;
		this.harvestLevel = harvestLevel;
		this.dropItem     = dropItem;

		init();
	}

	public OreBase(String name, float hardness, float resistance, String harvestTool, int harvestLevel, Item dropItem) {
		super(Material.ROCK);

		this.name         = name;
		this.hardness     = hardness;
		this.resistance   = resistance;
		this.harvestTool  = harvestTool;
		this.harvestLevel = harvestLevel;
		this.dropItem     = dropItem;

		init();
	}

	private void init() {
		updateRegistryAndLocalizedName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(harvestTool, harvestLevel);

		BlockInit.BLOCKS.add(this); // Add to block items
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name)); // Create an ItemBlock and add it to iTEMS
	}



	public void setDropItem(Item dropItem) {
		this.dropItem = dropItem;
	}

	public void setDropQuantity(int dropQuantity) {
		this.dropQuantity = dropQuantity;
	}

	public void setExpMax(int maxExp) {
		this.maxExp = (maxExp <= 0) ? 1 : maxExp;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(dropItem));
		super.getDrops(drops, world, pos, state, fortune);
	}

	// TODO -- The following two functions can be placed on other class called "BlockOreBase" or the values can be passed as class paramter
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		if(dropItem == null)
			return dropQuantity;
		return 0; // Returning 0 prevents the block from dropping itself
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		// Return the amount of experience points to drop
		Random random = world instanceof World ? ((World)world).rand : new Random();
		return MathHelper.getInt(random, 1, maxExp);
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
