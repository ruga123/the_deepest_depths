package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class TardagenOnEntityTickUpdateProcedure extends TheDeepestDepthsModElements.ModElement {
	public TardagenOnEntityTickUpdateProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 387);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure TardagenOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double e = 0;
		if ((entity.isAlive())) {
			entity.getPersistentData().putDouble("tardaheal", (1 + (entity.getPersistentData().getDouble("tardaheal"))));
			if (((entity.getPersistentData().getDouble("tardaheal")) >= 40)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity)
							.setHealth((float) Math.min((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2),
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)));
				entity.getPersistentData().putDouble("tardaheal", 0);
			}
		}
	}
}
