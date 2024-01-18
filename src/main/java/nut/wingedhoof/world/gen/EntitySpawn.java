package nut.wingedhoof.world.gen;

import java.util.Random;

import nut.wingedhoof.entities.CustomZombie;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class EntitySpawn implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)  {
		runGenerator(world, random, chunkX, chunkZ, 80, 1, 3);
	}

	private void runGenerator(World world, Random random, int chunkX, int chunkZ, int spawnWeight, int minSpawnGroup, int maxSpawnGroup) {
		// Use random.nextInt(totalWeight) to determine if the entity should spawn
		if(random.nextInt(100) < spawnWeight) {
			for (int i = 0; i < random.nextInt(maxSpawnGroup - minSpawnGroup + 1) + minSpawnGroup; i++) {
				CustomZombie entity = new CustomZombie(world);
				entity.setPosition(chunkX * 16 + random.nextInt(16), 64, chunkZ * 16 + random.nextInt(16));
				world.spawnEntity(entity);
			}
		}
	}
}

