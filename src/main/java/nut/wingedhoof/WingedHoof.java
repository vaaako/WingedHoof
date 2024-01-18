package nut.wingedhoof;

import nut.wingedhoof.proxy.CommonProxy;
import nut.wingedhoof.tabs.WingedHoofTab;
import nut.wingedhoof.handlers.RegistryEvent;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;

import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = WingedHoof.MODID, name = WingedHoof.NAME, version = WingedHoof.VERSION)
public class WingedHoof {
	public static final String MODID = "wingedhoof";
	public static final String NAME = "WingedHoof";
	public static final String VERSION = "1.0";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static final String CLIENT = "nut.wingedhoof.proxy.ClientProxy";
	public static final String SERVER = "nut.wingedhoof.proxy.CommonProxy";

	public static final CreativeTabs CREATIVE_TAB = new WingedHoofTab("wingedhooftab");

	@Instance
	public static WingedHoof instance;

	@SidedProxy(clientSide = WingedHoof.CLIENT, serverSide = WingedHoof.SERVER)
	public static CommonProxy proxy;


	/* EVENTS */
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)  {
		RegistryEvent.preInitRegistries(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		RegistryEvent.initRegistries(event);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		RegistryEvent.postInitRegistries(event);
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) {
		RegistryEvent.serverRegistries(event);
	}
}
