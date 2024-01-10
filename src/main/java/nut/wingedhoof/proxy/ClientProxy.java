package nut.wingedhoof.proxy;

import net.minecraft.item.Item;
import nut.wingedhoof.init.ItemInit;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class ClientProxy extends CommonProxy {
	// Find the mod ID in the assets folder in [mod id]/models/[item id].json
	@Override
	public void registerItemRenderer(Item item, int metadata) {
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}