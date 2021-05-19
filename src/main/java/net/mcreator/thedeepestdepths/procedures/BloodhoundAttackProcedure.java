package net.mcreator.thedeepestdepths.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.potion.SlimeInfectionPotion;
import net.mcreator.thedeepestdepths.item.MuscleItem;
import net.mcreator.thedeepestdepths.entity.InfectedBloodhoundEntity;
import net.mcreator.thedeepestdepths.entity.BloodhoundEntity;
import net.mcreator.thedeepestdepths.entity.AdaptiveSlimeEntity;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;

@TheDeepestDepthsModElements.ModElement.Tag
public class BloodhoundAttackProcedure extends TheDeepestDepthsModElements.ModElement {
	public BloodhoundAttackProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 64);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure BloodhoundAttack!");
			return false;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BloodhoundAttack!");
			return false;
		}
		if (dependencies.get("amount") == null) {
			if (!dependencies.containsKey("amount"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency amount for procedure BloodhoundAttack!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure BloodhoundAttack!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure BloodhoundAttack!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure BloodhoundAttack!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure BloodhoundAttack!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double amount = dependencies.get("amount") instanceof Integer ? (int) dependencies.get("amount") : (double) dependencies.get("amount");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double reflex = 0;
		double damage = 0;
		if (((sourceentity instanceof BloodhoundEntity.CustomEntity) || (sourceentity instanceof InfectedBloodhoundEntity.CustomEntity))) {
			if (((entity.getPersistentData().getBoolean("bite")) || (((new Random()).nextInt((int) 3 + 1)) == 2))) {
				if (sourceentity instanceof LivingEntity)
					((LivingEntity) sourceentity).setHealth(
							(float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1) + ((amount) / 4.5)));
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
						if ((entity.isAlive())) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).setHealth(
										(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + ((amount) / 4)));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1);
			} else {
				if ((((new Random()).nextInt((int) 3 + 1)) == 2)) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
				} else {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
				}
			}
		} else if (((entity instanceof PlayerEntity) || (entity instanceof ServerPlayerEntity))) {
			if ((!(((PlayerEntity) entity).isActiveItemStackBlocking()))) {
				reflex = (double) 0;
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY).getItem() == new ItemStack(MuscleItem.boots, (int) (1)).getItem())) {
					reflex = (double) ((reflex) + 1);
				}
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY).getItem() == new ItemStack(MuscleItem.legs, (int) (1)).getItem())) {
					reflex = (double) ((reflex) + 1);
				}
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY).getItem() == new ItemStack(MuscleItem.body, (int) (1)).getItem())) {
					reflex = (double) ((reflex) + 1);
				}
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
						: ItemStack.EMPTY).getItem() == new ItemStack(MuscleItem.helmet, (int) (1)).getItem())) {
					reflex = (double) ((reflex) + 1);
				}
				if (((reflex) > 0)) {
					if ((((new Random()).nextInt((int) (5 - (reflex)) + 1)) == 0)) {
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
						}
						damage = (double) Math.min((((amount) * (reflex)) / 3), 16);
						sourceentity.attackEntityFrom(DamageSource.GENERIC, (float) (damage));
					}
				}
			}
		} else if ((sourceentity instanceof AdaptiveSlimeEntity.CustomEntity)) {
			if ((!(entity.getPersistentData().getBoolean("adaptive_slime")))) {
				if ((!((entity instanceof PlayerEntity) || (entity instanceof ServerPlayerEntity)))) {
					entity.getPersistentData().putBoolean("adaptive_slime", (true));
					entity.getPersistentData().putDouble("adaptive_slimehealth",
							((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) Math.min(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1),
										(4 * ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1))));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(SlimeInfectionPotion.potion, (int) 60, (int) 1, (false), (true)));
					if (!sourceentity.world.isRemote())
						sourceentity.remove();
				}
			}
		}
		if ((entity.getPersistentData().getBoolean("adaptive_slime"))) {
			if ((!(sourceentity instanceof AdaptiveSlimeEntity.CustomEntity))) {
				if ((((new Random()).nextInt((int) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
						- (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - 1)) + 1)) == 0)) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new AdaptiveSlimeEntity.CustomEntity(AdaptiveSlimeEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) (entity.rotationYaw), (float) 0);
						entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					entity.getPersistentData().putBoolean("adaptive_slime", (false));
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if ((entityiterator instanceof AdaptiveSlimeEntity.CustomEntity)) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1));
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).setHealth((float) (entity.getPersistentData().getDouble("adaptive_slimehealth")));
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).removePotionEffect(SlimeInfectionPotion.potion);
								}
								entity.getPersistentData().putDouble("adaptive_slimehealth", 0);
								return (true);
							}
						}
					}
				}
			}
		}
		if ((sourceentity.getPersistentData().getBoolean("adaptive_slime"))) {
			damage = (double) Math.ceil(((amount) / 1.6));
			entity.attackEntityFrom(DamageSource.GENERIC, (float) (damage));
		}
		return (true);
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
