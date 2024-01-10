package nut.wingedhoof.handlers;

import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.init.BlockInit;
import nut.wingedhoof.util.IRegisterable;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

// This is something we need to immediately load in our event bus at mod construction time (built)
@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) throws Exception {
		// Register all mod items
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));

		// try {
		// 	IForgeRegistry<Item> registry = event.getRegistry();
		// 	ItemsRegistry.register(registry);
		// 	BlocksRegistry.registerItemBlocks(event.getRegistry());

		// } catch(ArrayIndexOutOfBoundsException ex) {
		// 	throw ex.getMessage();

		// } catch(Throwable ex) {
		// 	throw ex.getMessage();
		// }
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		// Register all mod blocks
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));

		// BlocksRegistry.register(event.getRegistry());
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		ItemInit.registerModels();
		BlockInit.registerModels();
	}
}