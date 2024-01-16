package nut.wingedhoof.proxy;

import nut.wingedhoof.WingedHoof;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;


public class ClientProxy extends CommonProxy {
	// Find the mod ID in the assets folder in [mod id]/models/[item id].json
	@Override
	public void registerItemRenderer(Item item, int metadata) {
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	// @Override	
	// public void registerVariantRenderer(Item item, int metadata, String filename) {
	// 	ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(new ResourceLocation(WingedHoof.MODID, filename), "inventory"));
	// }
}