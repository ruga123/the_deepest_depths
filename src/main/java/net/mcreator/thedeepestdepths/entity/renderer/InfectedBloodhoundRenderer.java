package net.mcreator.thedeepestdepths.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.thedeepestdepths.entity.InfectedBloodhoundEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class InfectedBloodhoundRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(InfectedBloodhoundEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelinfectedbloodhoundmob(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_deepest_depths:textures/infestedbloodhound.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("the_deepest_depths:textures/infectedbloodhoundglow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelinfectedbloodhoundmob extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r2;
		private final ModelRenderer tailupper;
		private final ModelRenderer cube_r3;
		private final ModelRenderer taillower;
		private final ModelRenderer cube_r4;
		private final ModelRenderer head;
		private final ModelRenderer leg4;
		private final ModelRenderer leg3;
		private final ModelRenderer leg2;
		private final ModelRenderer cube_r7;
		private final ModelRenderer leg1;
		public Modelinfectedbloodhoundmob() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 15.2641F, -0.2209F);
			setRotationAngle(body, 0.0F, 3.1416F, 0.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(2.5F, -2.7641F, 3.2209F);
			body.addChild(cube_r1);
			setRotationAngle(cube_r1, 1.7017F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 13).addBox(-5.5F, -11.5F, -3.5F, 6.0F, 6.0F, 5.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(-6.0F, -5.5F, -4.0F, 7.0F, 7.0F, 6.0F, 0.01F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-6.2052F, -4.5129F, 3.7044F);
			cube_r1.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.2618F, -0.6109F, -0.5236F);
			cube_r5.setTextureOffset(52, 40).addBox(-2.0F, -6.0F, -2.75F, 4.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r5.setTextureOffset(54, 58).addBox(-1.0F, -5.0F, -5.75F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, -1.6634F, 1.8499F);
			cube_r1.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.2618F, 0.0F, 0.7418F);
			cube_r6.setTextureOffset(52, 49).addBox(-2.5F, -2.5F, 1.5F, 4.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r6.setTextureOffset(54, 58).addBox(-1.5F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -5.4774F, 0.8465F);
			body.addChild(cube_r2);
			setRotationAngle(cube_r2, 1.2217F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(24, 33).addBox(-0.5F, -5.5F, -3.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 33).addBox(-0.5F, -8.5F, -5.0F, 1.0F, 7.0F, 2.0F, -0.2F, false);
			cube_r2.setTextureOffset(30, 33).addBox(-0.5F, -7.5F, -4.0F, 1.0F, 7.0F, 2.0F, -0.1F, false);
			cube_r2.setTextureOffset(0, 33).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 7.0F, 2.0F, 0.3F, false);
			cube_r2.setTextureOffset(34, 12).addBox(-0.5F, -3.5F, -2.0F, 1.0F, 7.0F, 2.0F, 0.1F, false);
			tailupper = new ModelRenderer(this);
			tailupper.setRotationPoint(0.0F, 0.2359F, -6.6255F);
			body.addChild(tailupper);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.184F, -2.8465F);
			tailupper.addChild(cube_r3);
			setRotationAngle(cube_r3, 1.7017F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(35, 0).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			taillower = new ModelRenderer(this);
			taillower.setRotationPoint(0.0F, 0.5F, -5.1535F);
			tailupper.addChild(taillower);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.3366F, -2.6502F);
			taillower.addChild(cube_r4);
			setRotationAngle(cube_r4, 1.7017F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(36, 29).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -1.5308F, 4.6376F);
			body.addChild(head);
			head.setTextureOffset(0, 3).addBox(1.0F, -4.7333F, 1.5833F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-3.0F, -4.7333F, 1.5833F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(17, 19).addBox(-3.0F, -2.7333F, -1.4167F, 6.0F, 5.0F, 5.0F, 0.0F, false);
			head.setTextureOffset(36, 36).addBox(-1.5F, 0.0667F, 3.5833F, 3.0F, 2.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(47, 56).addBox(0.5F, 2.0667F, 3.5833F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(47, 56).addBox(-1.5F, 2.0667F, 3.5833F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(2.5F, 1.0692F, -5.7791F);
			body.addChild(leg4);
			leg4.setTextureOffset(24, 11).addBox(-1.0F, 0.6667F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-2.5F, 1.0692F, -5.7791F);
			body.addChild(leg3);
			leg3.setTextureOffset(16, 29).addBox(-1.0F, 0.6667F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(2.5F, -0.0975F, 4.2209F);
			body.addChild(leg2);
			leg2.setTextureOffset(0, 24).addBox(-1.0F, 0.8333F, -2.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(1.0F, 3.67F, -2.1501F);
			leg2.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.2618F, 1.9199F, 0.0437F);
			cube_r7.setTextureOffset(52, 49).addBox(-2.5F, -2.5F, 1.5F, 4.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r7.setTextureOffset(54, 58).addBox(-1.5F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-2.5F, -0.0975F, 3.2209F);
			body.addChild(leg1);
			leg1.setTextureOffset(8, 24).addBox(-1.0F, 0.8333F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.tailupper.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.tailupper.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.taillower.rotateAngleY = f4 / (180F / (float) Math.PI);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
