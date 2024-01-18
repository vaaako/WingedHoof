package nut.wingedhoof.handlers;

import nut.wingedhoof.entities.CustomZombie;
import java.util.List;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;


public class SpawnEvent {
	@SubscribeEvent
	public static void onBiomeSpawnList(BiomeEvent event) {
		// BiomeManager.getBiomes(BiomeManager.BiomeType.WARM)

		if(event.getBiome() != null) {
			List<SpawnListEntry> monsterSpawns = event.getBiome().getSpawnableList(EnumCreatureType.MONSTER);
			if (monsterSpawns != null) {
				monsterSpawns.add(new Biome.SpawnListEntry(CustomZombie.class, 100, 1, 4));
			}
		}
	}


	// @SubscribeEvent
	// public static void onEntityRegistry(RegistryEvent.Register<EntityEntry> event) {
	// 	System.out.println("[WingedHoof] Spawning mob");
	// 	event.getRegistry().register(EntityEntryBuilder.create()
	// 		.entity(CustomZombie.class)

	// 		// Registr name
	// 		.id(new ResourceLocation(WingedHoof.MODID + ":" + "custom_zombie"),
	// 			EntityInit.CUSTOM_ZOMBIE_ID).name("custom_zombie")

	// 		// Range (how far way will see the player), updateFrequency, sendVelocityUpdates
	// 		.tracker(50, 1, true)

	// 		// Mob Type, Weight, minGroupCount, maxGroupCount
	// 		.spawn(EnumCreatureType.CREATURE, 100, 1, 6, CustomZombie.spawnBiomes)

	// 		// Egg primary color, Egg secondary color
	// 		.egg(MapColor.PURPLE.colorValue, MapColor.BLUE_STAINED_HARDENED_CLAY.colorValue)

	// 		.build()
	// 	);
	// }
}

/*
OCEAN:
	- Ocean
	- Deep Ocean
	- Frozen Ocean (partly COLD)
	- Lukewarm Ocean
	- Cold Ocean

COLD:
	- Snowy Tundra
	- Snowy Mountains
	- Ice Plains
	- Ice Mountains
	- Frozen River
	- Cold Taiga
	- Cold Taiga Hills
	- Cold Taiga Mountains

MEDIUM:
	- Plains
	- Sunflower Plains
	- Forest
	- Flower Forest
	- Birch Forest
	- Birch Forest Hills
	- Roofed Forest
	- Taiga
	- Taiga Hills
	- Taiga Mountains
	- Mega Taiga
	- Mega Taiga Hills

WARM:
	- Desert
	- Desert Hills
	- Savannah
	- Savanna Plateau
	- Jungle
	- Jungle Hills
	- Modified Jungle
	- Jungle Edge
	- Bamboo Jungle
	- Bamboo Jungle Hills
	- Mushroom Fields (a special biome)
*/

/*
- CREATURE -
Sheep
	- Weight: 12
	- Min group count: 4
	- Max group count: 4
Pig
	- Weight: 10
	- Min group count: 4
	- Max group count: 4
Chicken
	- Weight: 10
	- Min group count: 4
	- Max group count: 4
Cow
	- Weight: 8
	- Min group count: 4
	- Max group count: 4

- MONSTER -
Spider
	- Weigth: 100
	- Min group count: 4
	- Max group count: 4
Zombie
	- Weigth: 95
	- Min group count: 4
	- Max group count: 4
ZombieVillager
	- Weigth: 5
	- Min group count: 1
	- Max group count: 1
Skeleton
	- Weigth: 100
	- Min group count: 4
	- Max group count: 4
Creeper
	- Weigth: 100
	- Min group count: 4
	- Max group count: 4
Slime
	- Weigth: 100
	- Min group count: 4
	- Max group count: 4
Enderman
	- Weigth: 10
	- Min group count: 1
	- Max group count: 4
Witch
	- Weigth: 5
	- Min group count: 1
	- Max group count: 1

- WATER -
Squid
	- Weight: 10
	- Min group count: 4
	- Max group count: 4

- CAVE -
Bat
	- Weigth: 10
	- Min group count: 8
	- Max group count: 8
*/
