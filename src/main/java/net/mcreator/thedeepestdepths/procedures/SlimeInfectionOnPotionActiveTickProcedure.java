package net.mcreator.thedeepestdepths.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.util.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.potion.SlimeInfectionPotion;
import net.mcreator.thedeepestdepths.entity.AdaptiveSlimeEntity;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Random;
import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class SlimeInfectionOnPotionActiveTickProcedure extends TheDeepestDepthsModElements.ModElement {
	public SlimeInfectionOnPotionActiveTickProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 298);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure SlimeInfectionOnPotionActiveTick!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure SlimeInfectionOnPotionActiveTick!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure SlimeInfectionOnPotionActiveTick!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure SlimeInfectionOnPotionActiveTick!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure SlimeInfectionOnPotionActiveTick!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		entity.getPersistentData().putDouble("slimeinfectiontime",
				(((new Random()).nextInt((int) 2 + 1)) + (entity.getPersistentData().getDouble("slimeinfectiontime"))));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(SlimeInfectionPotion.potion, (int) 60000, (int) 255, (false), (true)));
		if ((((new Random()).nextInt((int) 10000 + 1)) == 1)) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) == 1)) {
				for (int index0 = 0; index0 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 2)); index0++) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new AdaptiveSlimeEntity.CustomEntity(AdaptiveSlimeEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				}
				return (true);
			} else {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
			}
		}
		if (((entity.getPersistentData().getDouble("slimeinfectiontime")) > 120000)) {
			for (int index1 = 0; index1 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 2)); index1++) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new AdaptiveSlimeEntity.CustomEntity(AdaptiveSlimeEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) 0);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(
						new StringTextComponent(
								(new java.text.DecimalFormat("##").format((entity.getPersistentData().getDouble("slimeinfectiontime"))))),
						ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		return (true);
	}
}
