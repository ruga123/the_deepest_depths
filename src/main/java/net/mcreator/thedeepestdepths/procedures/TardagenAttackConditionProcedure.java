package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class TardagenAttackConditionProcedure extends TheDeepestDepthsModElements.ModElement {
	public TardagenAttackConditionProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 391);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure TardagenAttackCondition!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				/ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)) > 3);
	}
}
