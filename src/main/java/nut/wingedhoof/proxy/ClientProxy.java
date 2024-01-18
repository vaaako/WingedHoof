package nut.wingedhoof.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;


@SideOnly(Side.CLIENT) // Maybe not? I don't know
public class ClientProxy extends CommonProxy {
	// Find the mod ID in the assets folder in [mod id]/models/[item id].json
	@Override
	public void registerItemRenderer(Item item, int metadata) {
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	// @Override
	// public void render() {
	// 	super.render();
	// }

	// @Override	
	// public void registerVariantRenderer(Item item, int metadata, String filename) {
	// 	ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(new ResourceLocation(WingedHoof.MODID, filename), "inventory"));
	// }
}