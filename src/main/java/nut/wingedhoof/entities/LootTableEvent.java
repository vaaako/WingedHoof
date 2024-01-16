package nut.wingedhoof.entities;

import java.util.Random;

import nut.wingedhoof.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.RandomValueRange;

import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.world.storage.loot.functions.EnchantWithLevels;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class LootTableEvent {

	// I think this is better for simple one item drop
	@SubscribeEvent
	public static void customLootTableDrop(LivingDropsEvent event) {
		Random rand = new Random();

		if(event.getEntityLiving() instanceof EntityCow) {
			// 25% chance to drop cow horn
			if(rand.nextInt(4) == 0) {
				event.getEntityLiving().entityDropItem(new ItemStack(ItemInit.COW_HORN, 1), 0.0f);
			}
		}
	}

	// This is better for complex loot and chest/gameplay loot
	@SubscribeEvent
	public static void customLootTableDrop(LootTableLoadEvent event) {
		System.out.println("[WingedHoof] Loot table loaded: " + event.getName());

		String eventName = event.getName().toString();

		if(eventName.equals("minecraft:chests/village_blacksmith")
			|| eventName.equals("minecraft:chests/abandoned_mineshaft")) {
			event.getTable().addPool(palladiumPool());


		} else if(eventName.equals("minecraft:chests/desert_pyramid")) {
			event.getTable().addPool(amberPool());


		} else if(eventName.equals("minecraft:chests/simple_dungeon")) {
			event.getTable().addPool(palladiumSwordPool());
		}
	}


	private static LootPool amberPool() {
		// Item.getItemFromBlock(BLOCKS.DIAMOND_BLOCK)

		LootFunction setCountFunction = new SetCount(
			new LootCondition[0],      // Conditions
			new RandomValueRange(0, 3) // (minCount, maxCount)
		);

		LootEntryItem chest_amber = new LootEntryItem(
			ItemInit.AMBER, 1, 0,                                     
			new LootFunction[]{ setCountFunction }, 
			new LootCondition[0], "amber"                               
		);

		// lootEntries, conditions, (minCount, maxCount), (minQuality, maxQuality), name
		return new LootPool(
			new LootEntryItem[]{ chest_amber },
			new LootCondition[0],
			new RandomValueRange(1),
			new RandomValueRange(1),
			"amber_pool"
		);
	}


	private static LootPool palladiumPool() {
		LootEntryItem chest_palladium = new LootEntryItem(
			ItemInit.PALLADIUM_INGOT, 1, 0,
			new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(0, 3)) },
			new LootCondition[0], "palladium_ore"
		);

		return new LootPool(new LootEntryItem[]{ chest_palladium }, new LootCondition[0],
				new RandomValueRange(1), new RandomValueRange(1), "palladium_ore_pool");
	}


	private static LootPool palladiumSwordPool() {
		// REMEMBER: nextInt(2) generates a random int from 0 to 1

		LootFunction[] swordFunctions = {
			// Enchant the sword with random levels (up to 30)
			// new EnchantWithLevels(new LootCondition[0], new RandomValueRange(1, 30), false), // Conditions, Enchantments level range, Over pass the enchantment limit

			new EnchantWithLevels(new LootCondition[0], new RandomValueRange(1, 2), false) {
				@Override
				public ItemStack apply(ItemStack stack, Random rand, LootContext context) {
					int enchantChance = 2;

					// 50% chance
					if(rand.nextInt(enchantChance) == 0) {
						stack.addEnchantment(Enchantment.getEnchantmentByID(34), rand.nextInt(2) + 1); // 34 is the ID for Unbreaking
						enchantChance += 2;
					}

					// 25% chance
					if(rand.nextInt(enchantChance) == 0) {
						stack.addEnchantment(Enchantment.getEnchantmentByID(19), rand.nextInt(2) + 1); // 19 is the ID for Knockback
						enchantChance += 2;
					}


					// 16% chance
					if(rand.nextInt(enchantChance) == 0) {
						stack.addEnchantment(Enchantment.getEnchantmentByID(16), 1); // 16 is the ID for Sharpness
					}

					return stack;
				}
			},

			// Set durability for the sword
			new LootFunction(new LootCondition[0]) {
				@Override
				public ItemStack apply(ItemStack stack, Random rand, LootContext context) {
					// Reduce durability from 50% to 100%
					double durabilityPercentage = rand.nextFloat() * 0.5f + 0.5f; // Generate a random number from 0.5 to 1.0
				
					// Adjust the percentage to avoid reducing durability to 100%
					if (durabilityPercentage >= 0.99) {
						durabilityPercentage = 0.98;
					}

					int remainingDurability = (int)((1.0 - rand.nextDouble()) * stack.getMaxDamage()); // "1 - " = Lower Number -> Less descrease
					stack.setItemDamage(remainingDurability);
					return stack;
				}
			}
		};


		LootEntryItem swordEntry = new LootEntryItem(
			ItemInit.PALLADIUM_SWORD,  // ItemStack representing the item to be dropped
			1,                         // Weight (probability) of this entry
			0,                         // Quality (not directly used in this case)
			swordFunctions,            // Array of LootFunctions to apply
			new LootCondition[0],      // Conditions for the loot entry (it means the conditions in what the loot should appear, used for mob loot)
			"palladium_sword"          // Entry name
		);

		LootPool palladiumSwordPool = new LootPool(
			new LootEntryItem[]{swordEntry}, // Array of loot entries in the pool
			new LootCondition[0],            // Conditions for the entire pool (none in this case)
			new RandomValueRange(1),         // Weight (probability) of the entire pool
			new RandomValueRange(0),         // Quality (not directly used in this case)
			"palladium_sword_pool"           // Pool name
		);

		return palladiumSwordPool;
	}

}

/*
- LootTableLoadEvent event -
- MOBS -
minecraft:entities/mob_id

- CHESTS -
minecraft:chests/abandoned_mineshaft
minecraft:chests/desert_pyramid
minecraft:chests/end_city_treasure
minecraft:chests/igloo_chest
minecraft:chests/jungle_temple
minecraft:chests/jungle_temple_dispenser
minecraft:chests/nether_bridge
minecraft:chests/simple_dungeon
minecraft:chests/spawn_bonus_chest
minecraft:chests/stronghold_corridor
minecraft:chests/stronghold_crossing
minecraft:chests/stronghold_library
minecraft:chests/village_blacksmith
minecraft:chests/woodland_mansion

- OTHERS -
minecraft:gameplay/fishing/treasure
minecraft:gameplay/fishing/fish
minecraft:gameplay/fishing/junk
minecraft:gameplay/fishing
minecraft:empty
*/