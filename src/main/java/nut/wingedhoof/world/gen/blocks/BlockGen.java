package nut.wingedhoof.world.gen.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BlockGen {
	public WorldGenMinable worldGenMinable;
	public int chance;
	public int minHeight;
	public int maxHeight;

	public BlockGen(Block block, int maxBlocks, Block nextTo, int chance, int minHeight, int maxHeight) {
		this.worldGenMinable = new WorldGenMinable(
			block.getDefaultState(),
			5,
			BlockMatcher.forBlock(nextTo)
		);

		this.chance = chance;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}
}