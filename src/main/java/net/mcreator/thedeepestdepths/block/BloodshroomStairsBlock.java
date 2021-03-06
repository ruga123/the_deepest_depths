
package net.mcreator.thedeepestdepths.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.thedeepestdepths.itemgroup.BloodlandsItemGroup;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;

import java.util.List;
import java.util.Collections;

@TheDeepestDepthsModElements.ModElement.Tag
public class BloodshroomStairsBlock extends TheDeepestDepthsModElements.ModElement {
	@ObjectHolder("the_deepest_depths:bloodshroom_stairs")
	public static final Block block = null;
	public BloodshroomStairsBlock(TheDeepestDepthsModElements instance) {
		super(instance, 75);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BloodlandsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(
					Block.Properties.create(Material.NETHER_WOOD).sound(SoundType.HYPHAE).hardnessAndResistance(0.8f, 2f).setLightLevel(s -> 0))
							.getDefaultState(),
					Block.Properties.create(Material.NETHER_WOOD).sound(SoundType.HYPHAE).hardnessAndResistance(0.8f, 2f).setLightLevel(s -> 0));
			setRegistryName("bloodshroom_stairs");
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
