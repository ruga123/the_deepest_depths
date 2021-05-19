package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.thedeepestdepths.block.RootedBloodstoneBlock;
import net.mcreator.thedeepestdepths.block.BloodstoneBlock;
import net.mcreator.thedeepestdepths.block.BloodshroomStemBlock;
import net.mcreator.thedeepestdepths.block.BloodshroomBrainRootBlock;
import net.mcreator.thedeepestdepths.block.BloodshroomBrainInfestedBloodstoneBlock;
import net.mcreator.thedeepestdepths.block.BloodshroomBlockBlock;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Random;
import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class BloodshroomOnStructureInstanceGeneratedProcedure extends TheDeepestDepthsModElements.ModElement {
	public BloodshroomOnStructureInstanceGeneratedProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 28);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure BloodshroomOnStructureInstanceGenerated!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure BloodshroomOnStructureInstanceGenerated!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure BloodshroomOnStructureInstanceGenerated!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure BloodshroomOnStructureInstanceGenerated!");
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
		temp = (double) 0;
		for (int index0 = 0; index0 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 3)); index0++) {
			temp = (double) (1 + (temp));
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + (temp)), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + (temp)), (int) z), BloodshroomStemBlock.block.getDefaultState(), 3);
			} else {
				for (int index1 = 0; index1 < (int) (((temp) - 1)); index1++) {
					if (((world.getBlockState(new BlockPos((int) x, (int) (y + ((temp) - 1)), (int) z))).getBlock() == BloodshroomStemBlock.block
							.getDefaultState().getBlock())) {
						world.setBlockState(new BlockPos((int) x, (int) (y + ((temp) - 1)), (int) z), Blocks.AIR.getDefaultState(), 3);
					}
					temp = (double) ((temp) - 1);
				}
				return (true);
			}
		}
		for (int index2 = 0; index2 < (int) (121); index2++) {
			tempx = (double) ((((new Random()).nextInt((int) 4 + 1)) - 2) + x);
			tempz = (double) ((((new Random()).nextInt((int) 4 + 1)) - 2) + z);
			tempy = (double) (y - ((new Random()).nextInt((int) 2 + 1)));
			if ((((world.getBlockState(new BlockPos((int) (tempx), (int) (tempy), (int) (tempz)))).getBlock() == BloodstoneBlock.block
					.getDefaultState().getBlock())
					&& (((world.getBlockState(new BlockPos((int) (tempx), (int) ((tempy) + 1), (int) (tempz))))
							.getBlock() == BloodshroomStemBlock.block.getDefaultState().getBlock())
							|| ((world.getBlockState(new BlockPos((int) (tempx), (int) ((tempy) + 1), (int) (tempz)))).getBlock() == Blocks.AIR
									.getDefaultState().getBlock())))) {
				{
					BlockPos _bp = new BlockPos((int) (tempx), (int) (tempy), (int) (tempz));
					BlockState _bs = BloodshroomBrainInfestedBloodstoneBlock.block.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) (tempx), (int) (tempy), (int) (tempz)))).getBlock() == Blocks.AIR.getDefaultState()
					.getBlock()) && (world.getBlockState(new BlockPos((int) (tempx), (int) ((tempy) + 1), (int) (tempz))).isSolid()))) {
				if ((((new Random()).nextInt((int) 2 + 1)) == 2)) {
					world.setBlockState(new BlockPos((int) (tempx), (int) (tempy), (int) (tempz)), BloodshroomBrainRootBlock.block.getDefaultState(),
							3);
				}
			} else if (((world.getBlockState(new BlockPos((int) (tempx), (int) (tempy), (int) (tempz)))).getBlock() == BloodstoneBlock.block
					.getDefaultState().getBlock())) {
				{
					BlockPos _bp = new BlockPos((int) (tempx), (int) (tempy), (int) (tempz));
					BlockState _bs = RootedBloodstoneBlock.block.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
			}
		}
		tempe = (double) (temp);
		for (int index3 = 0; index3 < (int) ((((new Random()).nextInt((int) 1 + 1)) + 2)); index3++) {
			temp = (double) ((tempe) - ((new Random()).nextInt((int) 2 + 1)));
			randx = (double) (((new Random()).nextInt((int) 2 + 1)) - 1);
			randz = (double) (((new Random()).nextInt((int) 2 + 1)) - 1);
			for (int index4 = 0; index4 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 2)); index4++) {
				temp = (double) (1 + (temp));
				world.setBlockState(new BlockPos((int) (x + (randx)), (int) (y + (temp)), (int) (z + (randz))),
						BloodshroomStemBlock.block.getDefaultState(), 3);
			}
			world.setBlockState(new BlockPos((int) (x + (randx)), (int) ((y + (temp)) + 1), (int) (z + (randz))),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 1), (int) ((y + (temp)) + 1), (int) ((z + (randz)) + 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 1), (int) ((y + (temp)) + 1), (int) ((z + (randz)) + 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 1), (int) ((y + (temp)) + 1), (int) ((z + (randz)) - 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 1), (int) ((y + (temp)) + 1), (int) (z + (randz))),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 1), (int) ((y + (temp)) + 1), (int) (z + (randz))),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 1), (int) ((y + (temp)) + 1), (int) ((z + (randz)) - 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + (randx)), (int) ((y + (temp)) + 1), (int) ((z + (randz)) - 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + (randx)), (int) ((y + (temp)) + 1), (int) ((z + (randz)) + 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 2), (int) ((y + (temp)) - 1), (int) ((z + (randz)) + 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 2), (int) ((y + (temp)) - 1), (int) (z + (randz))),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 2), (int) ((y + (temp)) - 1), (int) ((z + (randz)) - 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 2), (int) ((y + (temp)) - 0), (int) ((z + (randz)) + 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 2), (int) ((y + (temp)) - 0), (int) (z + (randz))),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 2), (int) ((y + (temp)) - 0), (int) ((z + (randz)) - 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 2), (int) ((y + (temp)) - 1), (int) ((z + (randz)) + 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 2), (int) ((y + (temp)) - 1), (int) (z + (randz))),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 2), (int) ((y + (temp)) - 1), (int) ((z + (randz)) - 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 2), (int) ((y + (temp)) - 0), (int) ((z + (randz)) + 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 2), (int) ((y + (temp)) - 0), (int) (z + (randz))),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 2), (int) ((y + (temp)) - 0), (int) ((z + (randz)) - 1)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 1), (int) ((y + (temp)) - 1), (int) ((z + (randz)) + 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 1), (int) ((y + (temp)) - 1), (int) ((z + (randz)) + 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + (randx)), (int) ((y + (temp)) - 1), (int) ((z + (randz)) + 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 1), (int) ((y + (temp)) - 0), (int) ((z + (randz)) + 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 1), (int) ((y + (temp)) - 0), (int) ((z + (randz)) + 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + (randx)), (int) ((y + (temp)) - 0), (int) ((z + (randz)) + 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 1), (int) ((y + (temp)) - 1), (int) ((z + (randz)) - 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 1), (int) ((y + (temp)) - 1), (int) ((z + (randz)) - 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + (randx)), (int) ((y + (temp)) - 1), (int) ((z + (randz)) - 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) - 1), (int) ((y + (temp)) - 0), (int) ((z + (randz)) - 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((x + (randx)) + 1), (int) ((y + (temp)) - 0), (int) ((z + (randz)) - 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + (randx)), (int) ((y + (temp)) - 0), (int) ((z + (randz)) - 2)),
					BloodshroomBlockBlock.block.getDefaultState(), 3);
		}
		return (true);
	}
}
