package net.mcreator.thedeepestdepths.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.item.ShadowBallItem;
import net.mcreator.thedeepestdepths.entity.ShadowGuardianEntity;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@TheDeepestDepthsModElements.ModElement.Tag
public class EntitySetTargetProcedureProcedure extends TheDeepestDepthsModElements.ModElement {
	public EntitySetTargetProcedureProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 339);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure EntitySetTargetProcedure!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure EntitySetTargetProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure EntitySetTargetProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((sourceentity instanceof ShadowGuardianEntity.CustomEntity)) {
			if ((!(sourceentity.getPersistentData().getBoolean("outing")))) {
				if (((Math.abs(((sourceentity.getPosX()) - (entity.getPosX()))) > 12)
						|| ((Math.abs(((sourceentity.getPosY()) - (entity.getPosY()))) > 12)
								|| (Math.abs(((sourceentity.getPosZ()) - (entity.getPosZ()))) > 12)))) {
					while (((Math.abs(((sourceentity.getPosX()) - (entity.getPosX()))) > 12)
							|| ((Math.abs(((sourceentity.getPosY()) - (entity.getPosY()))) > 12)
									|| (Math.abs(((sourceentity.getPosZ()) - (entity.getPosZ()))) > 12)))) {
						sourceentity.getPersistentData().putBoolean("outing", (true));
						sourceentity.setInvisible((true));
						for (int index1 = 0; index1 < (int) (Math.ceil((sourceentity.getPosY()))); index1++) {
							if ((((sourceentity.getPosY()) <= 0) || (!(world.isAirBlock(new BlockPos((int) (sourceentity.getPosX()),
									(int) ((sourceentity.getPosY()) + 1.2), (int) (sourceentity.getPosZ()))))))) {
								{
									Entity _ent = sourceentity;
									_ent.setPositionAndUpdate(((((new Random()).nextInt((int) 2 + 1)) - 1) + (entity.getPosX())),
											((entity.getPosY()) - 4), ((((new Random()).nextInt((int) 2 + 1)) - 1) + (entity.getPosZ())));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(
												((((new Random()).nextInt((int) 2 + 1)) - 1) + (entity.getPosX())), ((entity.getPosY()) - 4),
												((((new Random()).nextInt((int) 2 + 1)) - 1) + (entity.getPosZ())), _ent.rotationYaw,
												_ent.rotationPitch, Collections.emptySet());
									}
								}
								sourceentity.setInvulnerable((true));
								break;
							}
							sourceentity.setNoGravity((true));
							{
								Entity _ent = sourceentity;
								_ent.setPositionAndUpdate((sourceentity.getPosX()), ((sourceentity.getPosY()) - 0.25), (sourceentity.getPosZ()));
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((sourceentity.getPosX()),
											((sourceentity.getPosY()) - 0.25), (sourceentity.getPosZ()), _ent.rotationYaw, _ent.rotationPitch,
											Collections.emptySet());
								}
							}
							sourceentity.setMotion((sourceentity.getMotion().getX()), (-1.6), (sourceentity.getMotion().getZ()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (sourceentity.getPosX()), (sourceentity.getPosY()),
										(sourceentity.getPosZ()), (int) 5, 0.3, 0.3, 0.3, 0.1);
							}
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (sourceentity.getPosX()), (entity.getPosY()),
										(sourceentity.getPosZ()), (int) 5, 0.2, 0.2, 0.2, 0.1);
							}
						}
						sourceentity.setNoGravity((true));
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;
						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if ((sourceentity.getPersistentData().getBoolean("outing"))) {
								sourceentity.getPersistentData().putBoolean("outing", (false));
								new Object() {
									private int ticks = 0;
									private float waitTicks;
									private IWorld world;
									public void start(IWorld world, int waitTicks) {
										this.waitTicks = waitTicks;
										MinecraftForge.EVENT_BUS.register(this);
										this.world = world;
									}

									@SubscribeEvent
									public void tick(TickEvent.ServerTickEvent event) {
										if (event.phase == TickEvent.Phase.END) {
											this.ticks += 1;
											if (this.ticks >= this.waitTicks)
												run();
										}
									}

									private void run() {
										{
											Entity _ent = sourceentity;
											_ent.setPositionAndUpdate(((((new Random()).nextInt((int) 1 + 1)) - 0.5) + (entity.getPosX())),
													((entity.getPosY()) - 4), ((((new Random()).nextInt((int) 1 + 1)) - 0.5) + (entity.getPosZ())));
											if (_ent instanceof ServerPlayerEntity) {
												((ServerPlayerEntity) _ent).connection.setPlayerLocation(
														((((new Random()).nextInt((int) 1 + 1)) - 0.5) + (entity.getPosX())),
														((entity.getPosY()) - 4),
														((((new Random()).nextInt((int) 1 + 1)) - 0.5) + (entity.getPosZ())), _ent.rotationYaw,
														_ent.rotationPitch, Collections.emptySet());
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private IWorld world;
											public void start(IWorld world, int waitTicks) {
												this.waitTicks = waitTicks;
												MinecraftForge.EVENT_BUS.register(this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(TickEvent.ServerTickEvent event) {
												if (event.phase == TickEvent.Phase.END) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												sourceentity.setInvisible((false));
												sourceentity.setInvulnerable((false));
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 6);
										for (int index2 = 0; index2 < (int) (200); index2++) {
											if (((world.isAirBlock(new BlockPos((int) (sourceentity.getPosX()), (int) (sourceentity.getPosY()),
													(int) (sourceentity.getPosZ()))))
													&& (world.isAirBlock(new BlockPos((int) (sourceentity.getPosX()),
															(int) ((sourceentity.getPosY()) + 1), (int) (sourceentity.getPosZ())))))) {
												break;
											}
											sourceentity.setMotion((sourceentity.getMotion().getX()), 0.2, (sourceentity.getMotion().getZ()));
											{
												Entity _ent = sourceentity;
												_ent.setPositionAndUpdate((sourceentity.getPosX()), ((sourceentity.getPosY()) + 0.25),
														(sourceentity.getPosZ()));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation((sourceentity.getPosX()),
															((sourceentity.getPosY()) + 0.25), (sourceentity.getPosZ()), _ent.rotationYaw,
															_ent.rotationPitch, Collections.emptySet());
												}
											}
											if (world instanceof ServerWorld) {
												((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (sourceentity.getPosX()),
														(sourceentity.getPosY()), (sourceentity.getPosZ()), (int) 5, 0.3, 0.3, 0.3, 0.1);
											}
											if (world instanceof ServerWorld) {
												((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (sourceentity.getPosX()), (entity.getPosY()),
														(sourceentity.getPosZ()), (int) 5, 0.2, 0.2, 0.2, 0.1);
											}
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 17);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 12);
					sourceentity.setNoGravity((false));
				} else if (((Math.abs(((sourceentity.getPosX()) - (entity.getPosX()))) > 4)
						|| ((Math.abs(((sourceentity.getPosY()) - (entity.getPosY()))) > 4)
								|| (Math.abs(((sourceentity.getPosZ()) - (entity.getPosZ()))) > 4)))) {
					if ((!(sourceentity.getPersistentData().getBoolean("outing")))) {
						sourceentity.getPersistentData().putDouble("shootcooldown",
								((sourceentity.getPersistentData().getDouble("shootcooldown")) + 1));
						if (((sourceentity.getPersistentData().getDouble("shootcooldown")) >= 24)) {
							sourceentity.getPersistentData().putDouble("shootcooldown", 0);
							if (sourceentity instanceof LivingEntity) {
								Entity _ent = sourceentity;
								if (!_ent.world.isRemote()) {
									ShadowBallItem.shoot(_ent.world, (LivingEntity) sourceentity, new Random(), (float) 0.5, (float) 12, (int) 0.5);
								}
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntitySetsAttackTarget(LivingSetAttackTargetEvent event) {
		LivingEntity entity = event.getTarget();
		LivingEntity sourceentity = event.getEntityLiving();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", sourceentity.getPosX());
		dependencies.put("y", sourceentity.getPosY());
		dependencies.put("z", sourceentity.getPosZ());
		dependencies.put("world", sourceentity.getEntityWorld());
		dependencies.put("entity", entity);
		dependencies.put("sourceentity", sourceentity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
