package net.mcreator.thedeepestdepths.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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

import net.mcreator.thedeepestdepths.entity.AlienBubbleEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class AlienBubbleRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(AlienBubbleEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelAlienBubble(), 0.6f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_deepest_depths:textures/alienbubble.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("the_deepest_depths:textures/alienbubbleglow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class ModelAlienBubble extends EntityModel<Entity> {
		private final ModelRenderer bone;
		public ModelAlienBubble() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-0.15F, 19.05F, -0.25F);
			bone.setTextureOffset(0, 0).addBox(-4.85F, -5.05F, -4.75F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			bone.setTextureOffset(0, 0).addBox(-5.35F, -4.05F, -3.75F, 1.0F, 4.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(28, 20).addBox(-5.35F, 1.95F, 2.25F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(12, 20).addBox(4.65F, 1.95F, 2.25F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(30, 0).addBox(4.65F, -3.05F, -2.75F, 1.0F, 3.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(16, 20).addBox(0.15F, -5.55F, 1.75F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(0, 20).addBox(-3.85F, 1.45F, 0.25F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(0, 28).addBox(-2.85F, -5.55F, -3.75F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(24, 28).addBox(1.15F, 2.45F, -5.25F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(12, 28).addBox(-3.85F, -4.05F, -5.25F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.bone.rotateAngleZ = f2 / 20.f;
		}
	}
}
