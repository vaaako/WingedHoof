package nut.wingedhoof.init;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.blocks.BlockBase;
import nut.wingedhoof.blocks.OreBase;
import nut.wingedhoof.interfaces.IRegisterable;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit  {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	/**
	 * AMBER */
	public static final Block AMBER_ORE = new OreBase("amber_ore",
		5.0f,          // Hardness (The time it takes to mine the block)
		5.0f,          // Resistance to explosions
		"pickaxe",     // The type of tool required to harvest the block
		2,             // The level of the tool required to harvest the block
		ItemInit.AMBER
	);

	public static final Block AMBER_BLOCK = new BlockBase("amber_block",
		Material.IRON, // Material
		2.5f,          // Hardness
		5.0f,          // Resistance
		"pickaxe",     // Harvest Tool
		2              // Tool level
	);


	/**
	 * PALLADIUM */
	public static final Block PALLADIUM_BLOCK = new BlockBase("palladium_block",
		Material.IRON,
		10.0f,
		100.0f,
		"pickaxe",
		3
	);

	public static final Block PALLADIUM_ORE = new OreBase("palladium_ore",
		7.0f,
		5.0f,
		"pickaxe",
		3,
		ItemInit.PALLADIUM_INGOT
	);



	public static void registerModels() {
		for(Block block : BlockInit.BLOCKS) {
			if(block instanceof IRegisterable) {
				((IRegisterable)block).registerItemModel();
			}
		}
	}
}

/*
- HARVEST LEVEL -
0 = WOOD/GOLD
1 = STONE
2 = IRON
3 = DIAMOND

- HARDNESS -
LOW       = 0.2 - 1.0 (Leaves, Flowers)
MEDIUM    = 1.5 - 3.0 (Dirt, Sand)
HIGH      = 3.5 - 5.0 (Stone, Iron Ore)
VERY HIGH = 50.0 (Obsidian)

- RESISTANCE -
LOW       = 0.1 - 2.0  (Leaves, Wool)
MEDIUM    = 1.5 - 3.0  (Dirt, Sand)
HIGH      = 5.0 - 10.0 (Stone, Iron Ore)
VERY HIGH = 6000.0 (Obsidian)


- MATERIAL -
AIR
ANVIL
BAMBOO
BAMBOO_SAPLING
BARRIER
BUBBLE_COLUMN
CACTUS
CAKE
CARPET
CIRCUITS
CLAY
CLOTH
CORAL
CRAFTED_SNOW
DRAGON_EGG
EARTH
FIRE
GLASS
GOURD
GRASS
GROUND
ICE
IRON
LAVA
LEAVES
MISCELLANEOUS
OCEAN_PLANT
ORGANIC
PACKED_ICE
PISTON
PLANTS
PORTAL
REDSTONE_LIGHT
REPLACEABLE_PLANT
ROCK
SAND
SEA_GRASS
SNOW
SPONGE
STRUCTURE_VOID
TNT
VINE
WEB
WOOD
WOOL
*/