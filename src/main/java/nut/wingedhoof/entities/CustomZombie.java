package nut.wingedhoof.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class CustomZombie extends EntityZombie {
	private static List<Set<Biome>> biomeList = new ArrayList<>();
	public static Biome[] spawnBiomes;

	public CustomZombie(World worldIn) {
		super(worldIn);

		// setChild(true);
		// this.setSize(0.6F, 1.95F); // Width, Height

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
	
		// Set actual health to the maximum health
		this.setHealth(this.getMaxHealth());

		// biomeList.add(BiomeDictionary.getBiomes(BiomeDictionary.Type.PLAINS));
		// biomeList.add(BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST));
		// biomeList.add(BiomeDictionary.getBiomes(BiomeDictionary.Type.SANDY));

		// Calculate the total size needed for the flat array
		// int totalSize = biomeList.stream().mapToInt(Set::size).sum();

		// Create the flat array
		// spawnBiomes = new Biome[totalSize];

		// Populate the flat array by iterating through the list of sets
		// int currentIndex = 0;
		// for(Set<Biome> biomeSet : biomeList) {
		// 	for(Biome biome : biomeSet) {
		// 		spawnBiomes[currentIndex++] = biome;
		// 	}
		// }
		// System.out.println("[WingedHoof] Added all biomes to spawnBiomes with a length of " + spawnBiomes.length);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0);

		// If don't check before it can lead to not spawn anymore
		if(this.getAttributeMap().getAttributeInstance(SPAWN_REINFORCEMENTS_CHANCE) == null) {
			this.getAttributeMap().registerAttribute(SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(this.rand.nextDouble() * net.minecraftforge.common.ForgeModContainer.zombieSummonBaseChance);
		}
	}

	// @Override
	// public float getEyeHeight() {
	// 	return 1.90f;
	// }

	public EntityZombie createChild(EntityAgeable ageable) {
		return new CustomZombie(this.world);
	}

	// To add custom sounds later
	@Override
	public SoundEvent getAmbientSound() {
		return super.getAmbientSound();
	}

	@Override
	public SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return super.getHurtSound(damageSourceIn);
	}

	@Override
	public SoundEvent getDeathSound() {
		return super.getDeathSound();
	}

}


/*
- BIOMES TYPES -
Remember: The same biome can have multiple types

- Temperature-based tags. Specifying neither implies a biome is temperate
	HOT
	COLD

- Tags specifying the amount of vegetation a biome has. Specifying neither implies a biome to have moderate amounts
	SPARSE
	DENSE

- Tags specifying how moist a biome is. Specifying neither implies the biome as having moderate humidity
	WET
	DRY

- Tree-based tags, SAVANNA refers to dry, desert-like trees (Such as Acacia),
 + CONIFEROUS refers to snowy trees (Such as Spruce) and JUNGLE refers to jungle trees.
 + Specifying no tag implies a biome has temperate trees (Such as Oak)

	SAVANNA
	CONIFEROUS
	JUNGLE

- Tags specifying the nature of a biome
	SPOOKY
	DEAD
	LUSH
	NETHER
	END
	MUSHROOM
	MAGICAL
	RARE

	OCEAN
	RIVER

- A general tag for all water-based biomes. Shown as present if OCEAN or RIVER are.
	WATER

- Generic types which a biome can be
	MESA
	FOREST
	PLAINS
	MOUNTAIN
	HILLS
	SWAMP
	SANDY
	SNOWY
	WASTELAND
	BEACH
	VOID
*/