package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class TardagenSpawnOnInitialEntitySpawnProcedure extends TheDeepestDepthsModElements.ModElement {
	public TardagenSpawnOnInitialEntitySpawnProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 389);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure TardagenSpawnOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!entity.world.isRemote())
			entity.remove();
	}
}
