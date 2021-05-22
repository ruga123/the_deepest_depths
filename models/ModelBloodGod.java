// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelBloodGod extends EntityModel<Entity> {
	private final ModelRenderer torso;
	private final ModelRenderer backpack;
	private final ModelRenderer cube_r1;
	private final ModelRenderer rightarm;
	private final ModelRenderer righthandlower;
	private final ModelRenderer head;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;

	public ModelBloodGod() {
		textureWidth = 256;
		textureHeight = 256;

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, -3.6667F, 0.0F);
		torso.setTextureOffset(36, 100).addBox(13.0F, -31.3333F, -7.0F, 4.0F, 14.0F, 12.0F, 0.0F, false);
		torso.setTextureOffset(0, 0).addBox(-13.0F, -32.3333F, -8.0F, 26.0F, 16.0F, 14.0F, 0.0F, false);
		torso.setTextureOffset(0, 62).addBox(-11.0F, -16.3333F, -5.0F, 22.0F, 16.0F, 10.0F, 0.0F, false);

		backpack = new ModelRenderer(this);
		backpack.setRotationPoint(0.0F, -16.5833F, 9.25F);
		torso.addChild(backpack);
		setRotationAngle(backpack, 0.0F, 0.0F, 0.3054F);
		backpack.setTextureOffset(0, 30).addBox(-12.0F, -12.75F, -6.25F, 20.0F, 14.0F, 18.0F, 0.0F, false);
		backpack.setTextureOffset(62, 48).addBox(-10.0F, 1.25F, -4.25F, 16.0F, 10.0F, 14.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-5.1422F, -14.5255F, 3.75F);
		backpack.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.2182F, -0.6545F);
		cube_r1.setTextureOffset(68, 18).addBox(-4.0F, -3.0F, -6.0F, 12.0F, 12.0F, 12.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-12.5F, -25.1667F, -1.0F);
		torso.addChild(rightarm);
		rightarm.setTextureOffset(64, 72).addBox(-12.5F, -6.1667F, -6.0F, 12.0F, 24.0F, 12.0F, 0.0F, false);

		righthandlower = new ModelRenderer(this);
		righthandlower.setRotationPoint(-6.5F, 14.8333F, 0.0F);
		rightarm.addChild(righthandlower);
		righthandlower.setTextureOffset(102, 98).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 18.0F, 10.0F, 0.0F, false);
		righthandlower.setTextureOffset(66, 0).addBox(-4.0F, 17.0F, -4.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -32.3333F, -1.0F);
		torso.addChild(head);
		head.setTextureOffset(0, 88).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-6.0F, -4.0F, 0.0F);
		rightleg.setTextureOffset(108, 32).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 14.0F, 10.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 112).addBox(-4.0F, 14.0F, -4.0F, 8.0F, 14.0F, 8.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(6.0F, -4.0F, 0.0F);
		leftleg.setTextureOffset(68, 108).addBox(-4.0F, 14.0F, -4.0F, 8.0F, 14.0F, 8.0F, 0.0F, false);
		leftleg.setTextureOffset(104, 0).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 14.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f4 / (180F / (float) Math.PI);
		this.righthandlower.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}