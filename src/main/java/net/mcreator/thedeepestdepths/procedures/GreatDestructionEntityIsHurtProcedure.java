package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class GreatDestructionEntityIsHurtProcedure extends TheDeepestDepthsModElements.ModElement {
	public GreatDestructionEntityIsHurtProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 355);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure GreatDestructionEntityIsHurt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure GreatDestructionEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure GreatDestructionEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure GreatDestructionEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure GreatDestructionEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double a = 0;
		double b = 0;
		double c = 0;
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).swing(Hand.OFF_HAND, true);
		}
		c = (double) 0;
		for (int index0 = 0; index0 < (int) (5); index0++) {
			c = (double) ((c) + 1);
			a = (double) (-1);
			for (int index1 = 0; index1 < (int) (3); index1++) {
				b = (double) (-1);
				a = (double) ((a) + 1);
				for (int index2 = 0; index2 < (int) (3); index2++) {
					b = (double) ((b) + 1);
					if (world instanceof World) {
						Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (a)), (int) (y + (c)), (int) (z + (b)))), (World) world,
								new BlockPos((int) (x + (a)), (int) (y + (c)), (int) (z + (b))));
						world.destroyBlock(new BlockPos((int) (x + (a)), (int) (y + (c)), (int) (z + (b))), false);
					}
				}
			}
		}
	}
}
