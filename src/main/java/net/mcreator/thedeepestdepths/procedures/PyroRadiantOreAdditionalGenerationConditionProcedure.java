package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

import net.mcreator.thedeepestdepths.block.PyroxeneBlock;
import net.mcreator.thedeepestdepths.block.PyroRadiantOreBlock;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class PyroRadiantOreAdditionalGenerationConditionProcedure extends TheDeepestDepthsModElements.ModElement {
	public PyroRadiantOreAdditionalGenerationConditionProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 99);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure PyroRadiantOreAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure PyroRadiantOreAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure PyroRadiantOreAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure PyroRadiantOreAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == PyroxeneBlock.block.getDefaultState().getBlock())
				&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == PyroxeneBlock.block.getDefaultState()
						.getBlock())
						&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == PyroxeneBlock.block.getDefaultState()
								.getBlock())
								&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == PyroxeneBlock.block
										.getDefaultState().getBlock())
										&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == PyroxeneBlock.block
												.getDefaultState().getBlock())
												&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
														.getBlock() == PyroxeneBlock.block.getDefaultState().getBlock()))))))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = PyroRadiantOreBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
		return (false);
	}
}
