package net.mcreator.thedeepestdepths.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.thedeepestdepths.entity.GreatDestructionEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GreatDestructionRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(GreatDestructionEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelGreatDestruction(), 0.7f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_deepest_depths:textures/greatdestruction.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class ModelGreatDestruction extends EntityModel<Entity> {
		private final ModelRenderer torso;
		private final ModelRenderer cube_r1;
		private final ModelRenderer head;
		private final ModelRenderer rightleg;
		private final ModelRenderer lefleg;
		private final ModelRenderer leftarm;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer rightarm;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		public ModelGreatDestruction() {
			textureWidth = 128;
			textureHeight = 128;
			torso = new ModelRenderer(this);
			torso.setRotationPoint(-1.5F, -9.5F, -5.5F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(1.5F, -2.0F, 7.0F);
			torso.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.5236F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 0).addBox(-9.0F, -12.5F, -10.5F, 18.0F, 25.0F, 9.0F, 0.01F, false);
			cube_r1.setTextureOffset(28, 69).addBox(-10.0F, -1.5F, -13.5F, 11.0F, 2.0F, 12.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 34).addBox(-10.0F, 0.5F, -13.5F, 20.0F, 12.0F, 12.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(1.1667F, -8.3333F, -2.8333F);
			torso.addChild(head);
			head.setTextureOffset(51, 45).addBox(-6.6667F, -11.1667F, -7.6667F, 13.0F, 11.0F, 13.0F, 0.0F, false);
			head.setTextureOffset(69, 21).addBox(-2.6667F, -13.1667F, -7.6667F, 9.0F, 2.0F, 13.0F, 0.0F, false);
			head.setTextureOffset(52, 34).addBox(-6.6667F, -13.1667F, -0.6667F, 4.0F, 2.0F, 6.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-4.5F, 10.0F, 7.5F);
			torso.addChild(rightleg);
			rightleg.setTextureOffset(52, 91).addBox(-3.0F, 0.5F, -3.0F, 6.0F, 23.0F, 6.0F, 0.0F, false);
			lefleg = new ModelRenderer(this);
			lefleg.setRotationPoint(7.5F, 10.0F, 7.5F);
			torso.addChild(lefleg);
			lefleg.setTextureOffset(28, 83).addBox(-3.0F, 0.5F, -3.0F, 6.0F, 23.0F, 6.0F, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(10.0F, -5.9817F, -3.5078F);
			torso.addChild(leftarm);
			setRotationAngle(leftarm, 0.6545F, 0.0F, 0.0F);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(4.0F, 8.1516F, 4.1351F);
			leftarm.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.3927F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(76, 91).addBox(-3.5F, -10.5F, -8.5F, 7.0F, 17.0F, 7.0F, 0.01F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(29.0F, 7.6742F, 5.9324F);
			leftarm.addChild(cube_r3);
			setRotationAngle(cube_r3, -1.1345F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(65, 74).addBox(-29.5F, 31.5F, -5.5F, 9.0F, 8.0F, 9.0F, 0.5F, false);
			cube_r3.setTextureOffset(54, 0).addBox(-28.5F, 7.5F, -4.5F, 7.0F, 27.0F, 7.0F, 0.5F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-7.0F, -9.0456F, -0.6246F);
			torso.addChild(rightarm);
			setRotationAngle(rightarm, 0.6109F, 0.0F, 0.0F);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(21.0F, 10.7381F, 3.0492F);
			rightarm.addChild(cube_r4);
			setRotationAngle(cube_r4, -1.1345F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(82, 0).addBox(-29.5F, 31.5F, -5.5F, 9.0F, 8.0F, 9.0F, 0.5F, false);
			cube_r4.setTextureOffset(0, 58).addBox(-28.5F, 7.5F, -4.5F, 7.0F, 27.0F, 7.0F, 0.5F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-4.0F, 11.8083F, 1.6497F);
			rightarm.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.9599F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(0, 92).addBox(-3.5F, -9.5F, -13.5F, 7.0F, 5.0F, 7.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-4.0F, 11.2155F, 1.2519F);
			rightarm.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.3927F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(0, 92).addBox(-3.5F, -10.5F, -8.5F, 7.0F, 17.0F, 7.0F, 0.01F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			torso.render(matrixStack, buffer, packedLight, packedOverlay);
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
			this.lefleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
