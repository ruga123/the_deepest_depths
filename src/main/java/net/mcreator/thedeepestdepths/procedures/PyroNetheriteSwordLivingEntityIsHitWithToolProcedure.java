package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class PyroNetheriteSwordLivingEntityIsHitWithToolProcedure extends TheDeepestDepthsModElements.ModElement {
	public PyroNetheriteSwordLivingEntityIsHitWithToolProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 92);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure PyroNetheriteSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		String displayname = "";
		double damage = 0;
		entity.setFire((int) 5);
	}
}
