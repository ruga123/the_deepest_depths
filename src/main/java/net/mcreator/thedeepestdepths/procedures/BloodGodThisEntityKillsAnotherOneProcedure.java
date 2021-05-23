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
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BloodGodThisEntityKillsAnotherOne!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).setHealth((float) Math.min(
					(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
							+ (sourceentity.getPersistentData().getDouble("healths"))),
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1)));
		sourceentity.getPersistentData().putDouble("healths", 0);
	}
}
