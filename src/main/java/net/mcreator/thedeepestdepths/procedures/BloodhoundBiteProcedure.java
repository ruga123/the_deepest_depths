package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Random;
import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class BloodhoundBiteProcedure extends TheDeepestDepthsModElements.ModElement {
	public BloodhoundBiteProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 68);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure BloodhoundBite!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean log = false;
		log = (boolean) (((new Random()).nextInt((int) 3 + 1)) == 1);
		entity.getPersistentData().putBoolean("bite", (log));
		return (log);
	}
}
