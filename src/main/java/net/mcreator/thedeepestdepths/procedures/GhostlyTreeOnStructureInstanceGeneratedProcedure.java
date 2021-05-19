package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.thedeepestdepths.block.GhostlyLogBlock;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Random;
import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class GhostlyTreeOnStructureInstanceGeneratedProcedure extends TheDeepestDepthsModElements.ModElement {
	public GhostlyTreeOnStructureInstanceGeneratedProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 191);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure GhostlyTreeOnStructureInstanceGenerated!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure GhostlyTreeOnStructureInstanceGenerated!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure GhostlyTreeOnStructureInstanceGenerated!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure GhostlyTreeOnStructureInstanceGenerated!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double temp = 0;
		double randx = 0;
		double randz = 0;
		double temptemp = 0;
		temp = (double) 0;
		for (int index0 = 0; index0 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 3)); index0++) {
			temp = (double) (1 + (temp));
			if ((world.isAirBlock(new BlockPos((int) x, (int) (y + (temp)), (int) z)))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + (temp)), (int) z), GhostlyLogBlock.block.getDefaultState(), 3);
			} else {
				return (true);
			}
		}
		temptemp = (double) (temp);
		for (int index1 = 0; index1 < (int) (2); index1++) {
			temp = (double) (temptemp);
			randx = (double) (x + (((new Random()).nextInt((int) 2 + 1)) - 1));
			randz = (double) (z + (((new Random()).nextInt((int) 2 + 1)) - 1));
			for (int index2 = 0; index2 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 2)); index2++) {
				temp = (double) (1 + (temp));
				if ((world.isAirBlock(new BlockPos((int) (randx), (int) (y + (temp)), (int) (randz))))) {
					world.setBlockState(new BlockPos((int) (randx), (int) (y + (temp)), (int) (randz)), GhostlyLogBlock.block.getDefaultState(), 3);
				} else {
					return (true);
				}
			}
			if ((((new Random()).nextInt((int) 1 + 1)) == 1)) {
				randx = (double) (x + (((randx) - x) * 2));
				randz = (double) (z + (((randz) - z) * 2));
				for (int index3 = 0; index3 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 1)); index3++) {
					temp = (double) (1 + (temp));
					if ((world.isAirBlock(new BlockPos((int) (randx), (int) (y + (temp)), (int) (randz))))) {
						world.setBlockState(new BlockPos((int) (randx), (int) (y + (temp)), (int) (randz)), GhostlyLogBlock.block.getDefaultState(),
								3);
					} else {
						return (true);
					}
				}
			}
		}
		return (true);
	}
}
