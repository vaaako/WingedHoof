package nut.wingedhoof.handlers;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class RegistryEvent {
	public static void preInitRegistries(FMLPreInitializationEvent event) {
		// GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
	}
	
	public static void initRegistries(FMLInitializationEvent event) {
		// NetworkRegistry.INSTANCE.registerGuiHandler(WingedHoof, new GuiHandler());
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event) {
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
	}
}