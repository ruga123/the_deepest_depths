package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class BloodGodThisEntityKillsAnotherOneProcedure extends TheDeepestDepthsModElements.ModElement {
	public BloodGodThisEntityKillsAnotherOneProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 407);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure BloodGodThisEntityKillsAnotherOne!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) Math.min(
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
							+ (entity.getPersistentData().getDouble("healths"))),
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)));
		entity.getPersistentData().putDouble("healths", 0);
	}
}
