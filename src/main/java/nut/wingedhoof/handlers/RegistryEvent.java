package nut.wingedhoof.handlers;

import nut.wingedhoof.init.EntityInit;
import nut.wingedhoof.world.gen.OresGen;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class RegistryEvent {
	@SideOnly(Side.CLIENT)
	private static void preInitClientOnly() {
		RenderHandler.registerEntityRenders();
	}


	public static void preInitRegistries(FMLPreInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new OresGen(), 0);
		// GameRegistry.registerWorldGenerator(new EntitySpawn(), 0);
		
		// EntityInit.registerEntities();
		
		// Registry events
		// MinecraftForge.EVENT_BUS.register(SpawnEvent.class);
		MinecraftForge.EVENT_BUS.register(LootTableEvent.class);
	
		preInitClientOnly();
	}
	
	public static void initRegistries(FMLInitializationEvent event) {
	}

	public static void postInitRegistries(FMLPostInitializationEvent event) {
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
	}
}