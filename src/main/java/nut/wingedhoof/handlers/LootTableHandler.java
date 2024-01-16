package nut.wingedhoof.handlers;

import nut.wingedhoof.WingedHoof;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class LootTableHandler  {
	public static final ResourceLocation CHIRO = LootTableList.register(new ResourceLocation("minecraft", "cow"));
	// public static final ResourceLocation CHIRO = LootTableList.register(new ResourceLocation(WingedHoof.MODID, "chiro"));
	
	// @SubscribeEvent
	// public static void onLootTableLoad(LootTableLoadEvent event) {
	// 	if (event.getName().equals(LootTableList.ENTITIES_COW)) {
	// 		// Override the loot table for cows here
	// 		event.getTable().addPool(getCustomPool());
	// 	}
	// }


	// private static LootPool getCustomPool() {
	// 	LootEntryItem customItemEntry = new LootEntryItem(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK), 1, 0,
	// 			new LootCondition[]{new RandomChance(0.1f)}, "custom_item");

	// 	LootPool customPool = new LootPool(new LootEntryItem[]{customItemEntry}, new LootCondition[0],
	// 			new RandomValueRange(1), new RandomValueRange(0, 1), "custom_pool");

	// 	return customPool;
	// }

}
