package nut.wingedhoof.init;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.entities.CustomZombie;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.material.MapColor;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

public class EntityInit {
	public static final int CUSTOM_ZOMBIE_ID = 120;

	public static final Set<EntityEntry> SET_ENTITIES = ImmutableSet.of(
		EntityEntryBuilder.create()
			.entity(CustomZombie.class)

			// Register name
			.id(new ResourceLocation(WingedHoof.MODID, "custom_zombie"), EntityInit.CUSTOM_ZOMBIE_ID)
			.name("custom_zombie")

			// Range (how far way will see the player), updateFrequency, sendVelocityUpdates
			.tracker(50, 1, true)

			// Mob Type, Weight, minGroupCount, maxGroupCount
			// .spawn(EnumCreatureType.CREATURE, 100, 1, 6, CustomZombie.spawnBiomes)
			.spawn(EnumCreatureType.CREATURE, 100, 1, 6, BiomeDictionary.getBiomes(BiomeDictionary.Type.PLAINS))

			// Egg primary color, Egg secondary color
			.egg(MapColor.PURPLE.colorValue, MapColor.BLUE_STAINED_HARDENED_CLAY.colorValue)

			.build()
	);
}
