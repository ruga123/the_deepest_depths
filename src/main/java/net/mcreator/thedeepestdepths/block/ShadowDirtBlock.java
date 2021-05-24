
package net.mcreator.thedeepestdepths.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.thedeepestdepths.itemgroup.ShadowItemGroup;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;

import java.util.List;
import java.util.Collections;

@TheDeepestDepthsModElements.ModElement.Tag
public class ShadowDirtBlock extends TheDeepestDepthsModElements.ModElement {
	@ObjectHolder("the_deepest_depths:shadow_dirt")
	public static final Block block = null;
	public ShadowDirtBlock(TheDeepestDepthsModElements instance) {
		super(instance, 418);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ShadowItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.4f, 10f).setLightLevel(s -> 0)
					.harvestLevel(1).harvestTool(ToolType.SHOVEL));
			setRegistryName("shadow_dirt");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
