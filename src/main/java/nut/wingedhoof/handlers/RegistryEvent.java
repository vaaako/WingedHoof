package nut.wingedhoof.handlers;

import nut.wingedhoof.entities.LootTableEvent;
import nut.wingedhoof.world.gen.WorldGenCustomOres;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class RegistryEvent {
	public static void preInitRegistries(FMLPreInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
	}
	
	public static void initRegistries(FMLInitializationEvent event) {
		// NetworkRegistry.INSTANCE.registerGuiHandler(WingedHoof, new GuiHandler());

		MinecraftForge.EVENT_BUS.register(LootTableEvent.class);
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event) {
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
	}
}