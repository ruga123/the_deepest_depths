// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelFleshHunter extends EntityModel<Entity> {
	private final ModelRenderer torsoupper;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer tail;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer head;
	private final ModelRenderer cube_r7;

	public ModelFleshHunter() {
		textureWidth = 64;
		textureHeight = 64;

		torsoupper = new ModelRenderer(this);
		torsoupper.setRotationPoint(0.0F, 19.5F, 4.5F);
		torsoupper.setTextureOffset(18, 30).addBox(-1.0F, 1.0F, -7.5F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		torsoupper.addChild(cube_r1);
		setRotationAngle(cube_r1, 2.3126F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(9, 28).addBox(-1.0F, -5.0F, -2.5F, 2.0F, 2.0F, 5.0F, -0.5F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		torsoupper.addChild(cube_r2);
		setRotationAngle(cube_r2, -2.3126F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(29, 25).addBox(-1.0F, 1.0F, 0.5F, 2.0F, 2.0F, 5.0F, -0.5F, false);
		cube_r2.setTextureOffset(30, 0).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 5.0F, -0.5F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 2.0F, -1.0F);
		torsoupper.addChild(tail);
		tail.setTextureOffset(11, 21).addBox(-1.0F, -1.0F, 0.5F, 2.0F, 2.0F, 5.0F, -0.01F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -2.0F, 1.0F);
		tail.addChild(cube_r3);
		setRotationAngle(cube_r3, 2.3126F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 26).addBox(-1.0F, 1.0F, -8.5F, 2.0F, 2.0F, 5.0F, -0.5F, false);
		cube_r3.setTextureOffset(20, 23).addBox(-1.0F, -1.0F, -6.5F, 2.0F, 2.0F, 5.0F, -0.5F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.1944F, 0.2144F);
		tail.addChild(cube_r4);
		setRotationAngle(cube_r4, 2.3126F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(26, 11).addBox(-1.0F, -0.9383F, -3.4129F, 2.0F, 2.0F, 4.0F, -0.5F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -2.0F, 1.0F);
		tail.addChild(cube_r5);
		setRotationAngle(cube_r5, -2.5744F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(0, 18).addBox(-1.0F, -4.0F, -5.5F, 2.0F, 2.0F, 6.0F, -0.49F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, -2.0F, 1.0F);
		tail.addChild(cube_r6);
		setRotationAngle(cube_r6, -2.3126F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(16, 12).addBox(-1.0F, -6.0F, -6.5F, 2.0F, 3.0F, 6.0F, -0.5F, false);
		cube_r6.setTextureOffset(29, 18).addBox(-1.0F, -3.0F, -3.5F, 2.0F, 2.0F, 5.0F, -0.5F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 2.125F, -5.375F);
		torsoupper.addChild(head);
		head.setTextureOffset(0, 9).addBox(-2.5F, -2.625F, -6.125F, 5.0F, 3.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-3.0F, 0.375F, -7.125F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, -2.125F, 5.375F);
		head.addChild(cube_r7);
		setRotationAngle(cube_r7, -2.3126F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(32, 32).addBox(-1.0F, 4.0F, 1.5F, 2.0F, 2.0F, 4.0F, -0.5F, false);
		cube_r7.setTextureOffset(20, 3).addBox(-1.0F, 6.0F, 1.5F, 2.0F, 2.0F, 6.0F, -0.3F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		torsoupper.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.tail.rotateAngleY = f4 / (180F / (float) Math.PI);
	}
}