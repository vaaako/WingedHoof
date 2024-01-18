package nut.wingedhoof.handlers;

import nut.wingedhoof.entities.CustomZombie;
import nut.wingedhoof.entities.render.RenderCustomZombie;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHandler {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(CustomZombie.class, new IRenderFactory<CustomZombie>() {
			@Override
			public Render<? super CustomZombie> createRenderFor(RenderManager manager) {
				return new RenderCustomZombie(manager);
			}
		});
	}
}