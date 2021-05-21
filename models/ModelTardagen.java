// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelTardagen extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer rightleg3;
	private final ModelRenderer cube_r1;
	private final ModelRenderer rightleg4;
	private final ModelRenderer cube_r2;
	private final ModelRenderer leftleg3;
	private final ModelRenderer cube_r3;
	private final ModelRenderer head;
	private final ModelRenderer leftleg2;
	private final ModelRenderer cube_r4;
	private final ModelRenderer rightleg2;
	private final ModelRenderer cube_r5;
	private final ModelRenderer rightleg;
	private final ModelRenderer cube_r6;
	private final ModelRenderer lefleg;
	private final ModelRenderer cube_r7;
	private final ModelRenderer leftleg4;
	private final ModelRenderer cube_r8;

	public ModelTardagen() {
		textureWidth = 412;
		textureHeight = 412;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 28).addBox(-5.0F, -15.0F, 3.0F, 10.0F, 10.0F, 8.0F, -0.1F, false);
		bone.setTextureOffset(37, 42).addBox(-4.0F, -14.0F, 12.0F, 8.0F, 8.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 3).addBox(-3.5F, -13.5F, 2.0F, 7.0F, 7.0F, 10.0F, 0.0F, false);

		rightleg3 = new ModelRenderer(this);
		rightleg3.setRotationPoint(-3.0F, -5.5F, 5.0F);
		bone.addChild(rightleg3);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightleg3.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3054F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(18, 55).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		rightleg4 = new ModelRenderer(this);
		rightleg4.setRotationPoint(-3.0F, -5.5F, 9.0F);
		bone.addChild(rightleg4);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightleg4.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.3054F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 55).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		leftleg3 = new ModelRenderer(this);
		leftleg3.setRotationPoint(3.0F, -5.5F, 5.0F);
		bone.addChild(leftleg3);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftleg3.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.3054F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 47).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -10.6667F, 2.5417F);
		bone.addChild(head);
		head.setTextureOffset(35, 0).addBox(-5.0F, -4.3333F, -8.5417F, 10.0F, 10.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(37, 28).addBox(-4.0F, -3.3333F, -13.5417F, 8.0F, 8.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-3.5F, -2.8333F, -11.5417F, 7.0F, 7.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-2.0F, -1.3333F, -14.5417F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 3).addBox(-3.5F, -2.8333F, -8.5417F, 7.0F, 7.0F, 10.0F, -0.01F, false);
		head.setTextureOffset(0, 3).addBox(-3.5F, -2.8333F, -8.5417F, 7.0F, 7.0F, 8.0F, -0.01F, false);

		leftleg2 = new ModelRenderer(this);
		leftleg2.setRotationPoint(3.0F, 5.1667F, -2.5417F);
		head.addChild(leftleg2);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftleg2.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.3054F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(18, 47).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		rightleg2 = new ModelRenderer(this);
		rightleg2.setRotationPoint(-3.0F, 5.1667F, -2.5417F);
		head.addChild(rightleg2);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightleg2.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.3054F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(36, 55).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-3.0F, 5.1667F, -6.5417F);
		head.addChild(rightleg);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightleg.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.3054F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(62, 25).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		lefleg = new ModelRenderer(this);
		lefleg.setRotationPoint(3.0F, 5.1667F, -6.5417F);
		head.addChild(lefleg);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
		lefleg.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.3054F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(54, 55).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		leftleg4 = new ModelRenderer(this);
		leftleg4.setRotationPoint(3.0F, -5.5F, 9.0F);
		bone.addChild(leftleg4);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftleg4.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.3054F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(0, 7).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
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
		this.rightleg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightleg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.bone.rotateAngleX = f3 / (180F / (float) Math.PI);
		this.lefleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f4 / (180F / (float) Math.PI);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftleg4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftleg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}