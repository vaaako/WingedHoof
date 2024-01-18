package nut.wingedhoof.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

@SideOnly(Side.CLIENT)
public class ModelCustomZombie extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public ModelCustomZombie() {
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 32, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		RightArm.cubeList.add(new ModelBox(RightArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 40, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		Head.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}


	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

		// float armChill = MathHelper.sin(this.swingProgress * 3.1415927F);
		// float armChill2 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * 3.1415927F);

		// this.RightArm.rotateAngleZ = 0.0F;
		// this.LeftArm.rotateAngleZ = 0.0F;

		// this.RightArm.rotateAngleY = -(0.1F - armChill * 0.6F);
		// this.LeftArm.rotateAngleY = 0.1F - armChill * 0.6F;

		// Stand arms //
		// float rotate = -3.1415927F / 2.25F;
		// this.RightArm.rotateAngleX = rotate;
		// this.LeftArm.rotateAngleX = rotate;
		// Stand arms //

		// ModelRenderer arm = this.RightArm;
		// arm.rotateAngleX += armChill * 1.2F - armChill2 * 0.4F;
	
		// arm = this.LeftArm;
		// arm.rotateAngleX += armChill * 1.2F - armChill2 * 0.4F;
		
		// arm = this.RightArm;
		// arm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		
		// arm = this.LeftArm;
		// arm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		
		// Front and back //
		// arm = this.RightArm;
		// arm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		// arm = this.LeftArm;
		// arm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		// Front and back //

		// Legs movement
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;

		// Head rotation
		this.Head.rotateAngleX = headPitch * 0.017453292f;
		this.Head.rotateAngleY = netHeadYaw * 0.017453292f;
	}
}