package nut.wingedhoof.handlers;

import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.entities.CustomZombie;
import nut.wingedhoof.init.BlockInit;
import nut.wingedhoof.init.EntityInit;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;


// This is something we need to immediately load in our event bus at mod construction time (built)
@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) throws Exception {
		// Register all mod items
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		// Register all mod blocks
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onEvent(final RegistryEvent.Register<EntityEntry> event) {
		final IForgeRegistry<EntityEntry> registry = event.getRegistry();

		for(final EntityEntry entityEntry : EntityInit.SET_ENTITIES) {
			System.out.println("[WingedHoof] Registering entity = " + entityEntry.getEntityClass());

			registry.register(entityEntry);
		}
	}


	@SubscribeEvent
	@SideOnly(Side.CLIENT) // Just in case
	public static void onModelRegister(final ModelRegistryEvent event) {
		ItemInit.registerModels();
		BlockInit.registerModels();
	}
}