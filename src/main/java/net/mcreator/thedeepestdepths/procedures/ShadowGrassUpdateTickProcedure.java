package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.thedeepestdepths.block.ShadowDirtBlock;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class ShadowGrassUpdateTickProcedure extends TheDeepestDepthsModElements.ModElement {
	public ShadowGrassUpdateTickProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 420);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure ShadowGrassUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure ShadowGrassUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure ShadowGrassUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure ShadowGrassUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).isSolid())
				|| ((world.getLight(new BlockPos((int) x, (int) y, (int) z))) > 10))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ShadowDirtBlock.block.getDefaultState(), 3);
		}
	}
}
