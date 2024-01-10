package nut.wingedhoof;

import nut.wingedhoof.proxy.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;

import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = WingedHoof.MODID, name = WingedHoof.NAME, version = WingedHoof.VERSION)
public class WingedHoof {
	public static final String MODID = "wingedhoof";
	public static final String NAME = "WingedHoof";
	public static final String VERSION = "1.0";

	public static final String CLIENT = "nut.wingedhoof.proxy.ClientProxy";
	public static final String SERVER = "nut.wingedhoof.proxy.CommonProxy";

	@Instance
	public static WingedHoof instance;

	@SidedProxy(clientSide = WingedHoof.CLIENT, serverSide = WingedHoof.SERVER)
	public static CommonProxy proxy;


	/* EVENTS */
	private static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// some example code
		logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}


	// @EventHandler
	// public static void preInit(FMLPreInitializationEvent event)  {
	// 	RegistryHandler.preInitRegistries(event);
	// }
	
	// @EventHandler
	// public static void init(FMLInitializationEvent event) {
	// 	RegistryHandler.initRegistries(event);
	// }
	
	// @EventHandler
	// public static void postInit(FMLPostInitializationEvent event) {
	// 	RegistryHandler.postInitRegistries(event);
	// }
	
	// @EventHandler
	// public static void serverInit(FMLServerStartingEvent event) {
	// 	RegistryHandler.serverRegistries(event);
	// }
}
