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

import net.mcreator.thedeepestdepths.entity.ShadowGuardianEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ShadowGuardianRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ShadowGuardianEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelAlienGuardian(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_deepest_depths:textures/alienguardian.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("the_deepest_depths:textures/alienguardianglow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class ModelAlienGuardian extends EntityModel<Entity> {
		private final ModelRenderer leftarmbone;
		private final ModelRenderer leftarm;
		private final ModelRenderer shield;
		private final ModelRenderer rightarm;
		private final ModelRenderer leftleg;
		private final ModelRenderer rightleg;
		private final ModelRenderer head;
		private final ModelRenderer body;
		public ModelAlienGuardian() {
			textureWidth = 64;
			textureHeight = 64;
			leftarmbone = new ModelRenderer(this);
			leftarmbone.setRotationPoint(3.5F, 2.5F, 0.0F);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(0.25F, 0.75F, 0.0F);
			leftarmbone.addChild(leftarm);
			setRotationAngle(leftarm, -0.9163F, 1.2654F, -0.5672F);
			leftarm.setTextureOffset(0, 27).addBox(0.25F, -2.25F, -2.0F, 3.0F, 15.0F, 4.0F, 0.0F, false);
			shield = new ModelRenderer(this);
			shield.setRotationPoint(-3.75F, 20.75F, 0.0F);
			leftarm.addChild(shield);
			shield.setTextureOffset(14, 27).addBox(7.0F, -17.0F, 3.0F, 1.0F, 10.0F, 1.0F, 0.0F, false);
			shield.setTextureOffset(18, 21).addBox(7.0F, -19.0F, -3.0F, 1.0F, 13.0F, 6.0F, 0.0F, false);
			shield.setTextureOffset(18, 15).addBox(7.0F, -21.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
			shield.setTextureOffset(14, 38).addBox(7.0F, -17.0F, -4.0F, 1.0F, 10.0F, 1.0F, 0.0F, false);
			shield.setTextureOffset(38, 7).addBox(7.0F, -6.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-3.5F, 2.5F, 0.0F);
			rightarm.setTextureOffset(24, 0).addBox(-3.5F, -1.5F, -2.0F, 3.0F, 15.0F, 4.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
			leftleg.setTextureOffset(32, 19).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
			rightleg.setTextureOffset(32, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 1.0F, 0.0F);
			head.setTextureOffset(0, 15).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 5.25F, -1.0F);
			body.setTextureOffset(0, 0).addBox(-4.0F, -4.25F, -1.0F, 8.0F, 11.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(38, 0).addBox(-4.0F, -4.25F, -1.5F, 8.0F, 6.0F, 1.0F, -0.01F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			leftarmbone.render(matrixStack, buffer, packedLight, packedOverlay);
			rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
			leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
			rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leftarmbone.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
