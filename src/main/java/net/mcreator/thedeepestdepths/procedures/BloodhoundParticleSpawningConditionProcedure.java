package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Random;
import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class BloodhoundParticleSpawningConditionProcedure extends TheDeepestDepthsModElements.ModElement {
	public BloodhoundParticleSpawningConditionProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 61);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure BloodhoundParticleSpawningCondition!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
				/ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)) < 0.5)
				&& (((new Random()).nextInt((int) 3 + 1)) == 1));
	}
}
