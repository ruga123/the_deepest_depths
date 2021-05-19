package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.thedeepestdepths.block.RootedBloodstoneBlock;
import net.mcreator.thedeepestdepths.block.BloodstoneBlock;
import net.mcreator.thedeepestdepths.block.BloodshroomBrainRootBlock;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Random;
import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class BloodshroomBrainInfestedBloodstoneUpdateTickProcedure extends TheDeepestDepthsModElements.ModElement {
	public BloodshroomBrainInfestedBloodstoneUpdateTickProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 60);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure BloodshroomBrainInfestedBloodstoneUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure BloodshroomBrainInfestedBloodstoneUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure BloodshroomBrainInfestedBloodstoneUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure BloodshroomBrainInfestedBloodstoneUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double numy = 0;
		if ((((((new Random()).nextInt((int) 2 + 1)) + 2) % 2) == 0)) {
			numy = (double) y;
			while (((numy) > 0)) {
				numy = (double) ((numy) - 1);
				if (((world.getBlockState(new BlockPos((int) x, (int) (numy), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
					if (((world.getBlockState(new BlockPos((int) x, (int) ((numy) + 1), (int) z))).getBlock() == RootedBloodstoneBlock.block
							.getDefaultState().getBlock())) {
						world.setBlockState(new BlockPos((int) x, (int) (numy), (int) z), BloodshroomBrainRootBlock.block.getDefaultState(), 3);
					}
					break;
				} else if (((world.getBlockState(new BlockPos((int) x, (int) (numy), (int) z))).getBlock() == BloodstoneBlock.block.getDefaultState()
						.getBlock())) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (numy), (int) z);
						BlockState _bs = RootedBloodstoneBlock.block.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
					break;
				} else if ((!((world.getBlockState(new BlockPos((int) x, (int) (numy), (int) z))).getBlock() == RootedBloodstoneBlock.block
						.getDefaultState().getBlock()))) {
					break;
				}
			}
		}
	}
}
