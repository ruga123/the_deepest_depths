// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelHeadHunter extends EntityModel<Entity> {
	private final ModelRenderer leftarm;
	private final ModelRenderer lowerleftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer body;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public ModelHeadHunter() {
		textureWidth = 64;
		textureHeight = 64;

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(4.25F, -26.0F, -0.25F);
		leftarm.setTextureOffset(30, 10).addBox(0.75F, -2.0F, -1.75F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		lowerleftarm = new ModelRenderer(this);
		lowerleftarm.setRotationPoint(2.25F, 9.25F, -0.25F);
		leftarm.addChild(lowerleftarm);
		lowerleftarm.setTextureOffset(36, 25).addBox(-0.5F, 0.75F, -0.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		lowerleftarm.setTextureOffset(37, 38).addBox(-1.5F, 13.75F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-3.5F, -26.0F, -0.5F);
		rightarm.setTextureOffset(0, 27).addBox(-4.5F, -2.0F, -1.5F, 3.0F, 34.0F, 3.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(-0.6667F, -20.5F, -2.5F);
		body.setTextureOffset(0, 0).addBox(-4.3333F, -8.5F, -0.5F, 10.0F, 22.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(30, 0).addBox(-4.3333F, -8.5F, -1.5F, 10.0F, 9.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(39, 10).addBox(-4.3333F, 0.5F, -1.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(3.5F, -7.5F, -0.5F);
		leftleg.setTextureOffset(12, 27).addBox(-1.5F, 0.5F, -1.5F, 3.0F, 31.0F, 3.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-3.5F, -7.5F, -0.5F);
		rightleg.setTextureOffset(24, 27).addBox(-1.5F, 0.5F, -1.5F, 3.0F, 31.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.lowerleftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}