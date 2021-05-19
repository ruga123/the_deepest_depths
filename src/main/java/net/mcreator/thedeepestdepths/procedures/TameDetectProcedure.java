package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class TameDetectProcedure extends TheDeepestDepthsModElements.ModElement {
	public TameDetectProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 71);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure TameDetect!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (!((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false));
	}
}
