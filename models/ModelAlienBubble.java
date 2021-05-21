// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelAlienBubble extends EntityModel<Entity> {
	private final ModelRenderer bone;

	public ModelAlienBubble() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-5.5F, -9.0F, -4.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(28, 20).addBox(-5.5F, -3.0F, 2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(12, 20).addBox(4.5F, -3.0F, 2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(30, 0).addBox(4.5F, -8.0F, -3.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(16, 20).addBox(0.0F, -10.5F, 1.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 20).addBox(-4.0F, -3.5F, 0.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 28).addBox(-3.0F, -10.5F, -4.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(24, 28).addBox(1.0F, -2.5F, -5.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(12, 28).addBox(-4.0F, -9.0F, -5.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}