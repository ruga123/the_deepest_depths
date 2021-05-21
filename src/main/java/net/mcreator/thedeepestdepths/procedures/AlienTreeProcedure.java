package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.thedeepestdepths.block.AlienLogBlock;
import net.mcreator.thedeepestdepths.block.AlienLeavesBlock;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Random;
import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class AlienTreeProcedure extends TheDeepestDepthsModElements.ModElement {
	public AlienTreeProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 305);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure AlienTree!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure AlienTree!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure AlienTree!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure AlienTree!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double temp = 0;
		double randx = 0;
		double randz = 0;
		double tempe = 0;
		double tempx = 0;
		double tempy = 0;
		double tempz = 0;
		double loop1 = 0;
		double loop2 = 0;
		boolean dir = false;
		temp = (double) 0;
		for (int index0 = 0; index0 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 3)); index0++) {
			temp = (double) ((temp) - 1);
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + (temp)), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + (temp)), (int) z), AlienLogBlock.block.getDefaultState(), 3);
			} else {
				for (int index1 = 0; index1 < (int) (((temp) - 1)); index1++) {
					if (((world.getBlockState(new BlockPos((int) x, (int) (y + ((temp) + 1)), (int) z))).getBlock() == AlienLogBlock.block
							.getDefaultState().getBlock())) {
						world.setBlockState(new BlockPos((int) x, (int) (y + ((temp) + 1)), (int) z), Blocks.AIR.getDefaultState(), 3);
					}
					temp = (double) ((temp) + 1);
				}
				return (true);
			}
		}
		tempe = (double) (temp);
		for (int index2 = 0; index2 < (int) ((((new Random()).nextInt((int) 1 + 1)) + 2)); index2++) {
			temp = (double) ((tempe) + ((new Random()).nextInt((int) 1 + 1)));
			randx = (double) (((new Random()).nextInt((int) 2 + 1)) - 1);
			randz = (double) (((new Random()).nextInt((int) 2 + 1)) - 1);
			for (int index3 = 0; index3 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 2)); index3++) {
				temp = (double) ((temp) - 1);
				world.setBlockState(new BlockPos((int) (x + (randx)), (int) (y + (temp)), (int) (z + (randz))), AlienLogBlock.block.getDefaultState(),
						3);
			}
			temp = (double) ((temp) + (((new Random()).nextInt((int) 1 + 1)) + 2));
			for (int index4 = 0; index4 < (int) ((((new Random()).nextInt((int) 1 + 1)) + 2)); index4++) {
				loop1 = (double) (-2);
				loop2 = (double) (-2);
				temp = (double) ((temp) - 1);
				for (int index5 = 0; index5 < (int) ((((new Random()).nextInt((int) 1 + 1)) + 4)); index5++) {
					loop1 = (double) ((loop1) + 1);
					loop2 = (double) (-2);
					for (int index6 = 0; index6 < (int) ((((new Random()).nextInt((int) 1 + 1)) + 4)); index6++) {
						loop2 = (double) ((loop2) + 1);
						if ((world.isAirBlock(new BlockPos((int) ((x + (randx)) + (loop1)), (int) (y + (temp)), (int) ((z + (randz)) + (loop2)))))) {
							world.setBlockState(new BlockPos((int) ((x + (randx)) + (loop1)), (int) (y + (temp)), (int) ((z + (randz)) + (loop2))),
									AlienLeavesBlock.block.getDefaultState(), 3);
						}
					}
				}
			}
			for (int index7 = 0; index7 < (int) ((((new Random()).nextInt((int) 1 + 1)) + 1)); index7++) {
				loop1 = (double) (-1);
				loop2 = (double) (-1);
				temp = (double) ((temp) - 1);
				for (int index8 = 0; index8 < (int) ((((new Random()).nextInt((int) 1 + 1)) + 2)); index8++) {
					loop1 = (double) ((loop1) + 1);
					loop2 = (double) (-1);
					for (int index9 = 0; index9 < (int) ((((new Random()).nextInt((int) 1 + 1)) + 2)); index9++) {
						loop2 = (double) ((loop2) + 1);
						if ((world.isAirBlock(new BlockPos((int) ((x + (randx)) + (loop1)), (int) (y + (temp)), (int) ((z + (randz)) + (loop2)))))) {
							world.setBlockState(new BlockPos((int) ((x + (randx)) + (loop1)), (int) (y + (temp)), (int) ((z + (randz)) + (loop2))),
									AlienLeavesBlock.block.getDefaultState(), 3);
						}
					}
				}
			}
		}
		return (true);
	}
}
