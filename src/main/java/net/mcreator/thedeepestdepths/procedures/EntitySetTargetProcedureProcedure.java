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
				while (((Math.abs(((sourceentity.getPosX()) - (entity.getPosX()))) > 8)
						|| ((Math.abs(((sourceentity.getPosY()) - (entity.getPosY()))) > 8)
								|| (Math.abs(((sourceentity.getPosZ()) - (entity.getPosZ()))) > 8)))) {
					sourceentity.getPersistentData().putBoolean("outing", (true));
					while ((true)) {
						if ((((sourceentity.getPosY()) <= 0) || (!(world.isAirBlock(new BlockPos((int) (sourceentity.getPosX()),
								(int) ((sourceentity.getPosY()) + 1.2), (int) (sourceentity.getPosZ()))))))) {
							{
								Entity _ent = sourceentity;
								_ent.setPositionAndUpdate((entity.getPosX()), ((entity.getPosY()) - 4), (entity.getPosZ()));
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), ((entity.getPosY()) - 4),
											(entity.getPosZ()), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
								}
							}
							break;
						}
						sourceentity.setNoGravity((true));
						{
							Entity _ent = sourceentity;
							_ent.setPositionAndUpdate(((sourceentity.getPosX()) + ((new Random()).nextInt((int) 2 + 1))),
									((sourceentity.getPosY()) - 0.1), ((sourceentity.getPosZ()) + ((new Random()).nextInt((int) 2 + 1))));
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation(
										((sourceentity.getPosX()) + ((new Random()).nextInt((int) 2 + 1))), ((sourceentity.getPosY()) - 0.1),
										((sourceentity.getPosZ()) + ((new Random()).nextInt((int) 2 + 1))), _ent.rotationYaw, _ent.rotationPitch,
										Collections.emptySet());
							}
						}
						sourceentity.setMotion((sourceentity.getMotion().getX()), (-1.6), (sourceentity.getMotion().getZ()));
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (sourceentity.getPosX()), (sourceentity.getPosY()),
									(sourceentity.getPosZ()), (int) 2, 1, 1, 1, 0.1);
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
									for (int index2 = 0; index2 < (int) (40); index2++) {
										if (((sourceentity.getPosY()) >= (entity.getPosY()))) {
											break;
										}
										sourceentity.setMotion((sourceentity.getMotion().getX()), 0.2, (sourceentity.getMotion().getZ()));
										{
											Entity _ent = sourceentity;
											_ent.setPositionAndUpdate((sourceentity.getPosX()), ((sourceentity.getPosY()) + 0.1),
													(sourceentity.getPosZ()));
											if (_ent instanceof ServerPlayerEntity) {
												((ServerPlayerEntity) _ent).connection.setPlayerLocation((sourceentity.getPosX()),
														((sourceentity.getPosY()) + 0.1), (sourceentity.getPosZ()), _ent.rotationYaw,
														_ent.rotationPitch, Collections.emptySet());
											}
										}
										if (world instanceof ServerWorld) {
											((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (sourceentity.getPosX()),
													(sourceentity.getPosY()), (sourceentity.getPosZ()), (int) 1, 1, 1, 1, 0.1);
										}
									}
									sourceentity.getPersistentData().putBoolean("outing", (false));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 17);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 12);
				sourceentity.setNoGravity((false));
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
