package nut.wingedhoof.world.gen;

import java.util.Random;

import nut.wingedhoof.world.gen.blocks.BlockGen;
import nut.wingedhoof.init.BlockInit;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OresGen implements IWorldGenerator {
	// If you want to use variant -> BlockInit.VARIANT_NAME.getDefaultState().withProperty(OreBlock.VARIANT, EnumHandler.EnumType.AMBER),

	private BlockGen[] worldBlocks = {
		new BlockGen(
			BlockInit.AMBER_ORE, // Block to gen
			4,                   // Max amoun to gen
			Blocks.STONE,        // Gen next to
			3,                   // Chance
			10,                  // Min height
			25                   // Max height
		),

		new BlockGen(BlockInit.PALLADIUM_ORE, 7, Blocks.STONE, 2, 0, 10)
	};


	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)  {
		for(BlockGen block : worldBlocks) {
			runGenerator(block.worldGenMinable, world, random, chunkX, chunkZ, block.chance, block.minHeight, block.maxHeight);
		}


		// Uncomment and add the for-loop where you want
		// switch(world.provider.getDimension()) {
		// 	case -1: // Nether
		// 		break;
		// 	case 0: // Overworld
		// 		break;
		// 	case 1: // End
		// 		break;
		// }
	}

	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) {
			throw new IllegalArgumentException("Ore generated out of bound");
		}


		int heightDiff = maxHeight - minHeight + 1;

		for(int i = 0; i < chance; i++) {
			gen.generate(world, rand, new BlockPos(
				// Get random position to generate the ore
					chunkX * 16 + rand.nextInt(16),
					minHeight   + rand.nextInt(heightDiff),
					chunkZ * 16 + rand.nextInt(16)
				)
			);
		}

	}
}


/*
Coal:
	Spawn Chance: 20%
	Min Height: 1
	Max Height: 128
	Max Quantity per Vein: 17

Iron:
	Spawn Chance: 9%
	Min Height: 1
	Max Height: 63
	Max Quantity per Vein: 9

Copper:
	Spawn Chance: 2%
	Min Height: 1
	Max Height: 63
	Max Quantity per Vein: 9

Gold:
	Spawn Chance: 9%
	Min Height: 1
	Max Height: 31
	Max Quantity per Vein: 9

Redstone:
	Spawn Chance: 8%
	Min Height: 1
	Max Height: 15
	Max Quantity per Vein: 8

Lapis Lazuli:
	Spawn Chance: 1%
	Min Height: 1
	Max Height: 15
	Max Quantity per Vein: 7

Diamond:
	Spawn Chance: 1.7%
	Min Height: 1
	Max Height: 15
	Max Quantity per Vein: 8

Emerald:
	Spawn Chance: 1.1%
	Min Height: 4
	Max Height: 32
	Max Quantity per Vein: 1

Nether Quartz:
	Spawn Chance: 0.2%
	Min Height: 10
	Max Height: 117
	Max Quantity per Vein: 13

Ancient Debris (Added in version 1.16):
	Spawn Chance: 1.7%
	Min Height: 8
	Max Height: 119
	Max Quantity per Vein: 3
*/