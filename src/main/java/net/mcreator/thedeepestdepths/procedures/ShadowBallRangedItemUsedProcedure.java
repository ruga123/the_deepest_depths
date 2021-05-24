package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.Map;

@TheDeepestDepthsModElements.ModElement.Tag
public class ShadowBallRangedItemUsedProcedure extends TheDeepestDepthsModElements.ModElement {
	public ShadowBallRangedItemUsedProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 412);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowBallRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShadowBallRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
			((itemstack)).shrink((int) 1);
		}
	}
}
