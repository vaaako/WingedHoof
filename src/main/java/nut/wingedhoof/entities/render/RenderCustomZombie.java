package nut.wingedhoof.entities.render;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.entities.CustomZombie;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCustomZombie extends RenderLiving<CustomZombie> {
	public static final ResourceLocation TEXTURES = new ResourceLocation(WingedHoof.MODID + ":textures/entity/custom_zombie.png");

	public RenderCustomZombie(RenderManager manager) {
		// super(manager, new ModelCustomZombie(), 0.5f);
		super(manager, new ModelZombie(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(CustomZombie entity) {
		return TEXTURES;
	}

	@Override
	protected void applyRotations(CustomZombie entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}