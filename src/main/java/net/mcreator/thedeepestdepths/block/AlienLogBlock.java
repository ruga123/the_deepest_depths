
package net.mcreator.thedeepestdepths.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.Rotation;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.thedeepestdepths.itemgroup.BloodlandsItemGroup;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;

import java.util.List;
import java.util.Collections;

@TheDeepestDepthsModElements.ModElement.Tag
public class AlienLogBlock extends TheDeepestDepthsModElements.ModElement {
	@ObjectHolder("the_deepest_depths:alien_log")
	public static final Block block = null;
	public AlienLogBlock(TheDeepestDepthsModElements instance) {
		super(instance, 304);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BloodlandsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = DirectionalBlock.FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.NETHER_WOOD).sound(SoundType.HYPHAE).hardnessAndResistance(0.6f, 1.6f).setLightLevel(s -> 8)
					.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.SOUTH));
			setRegistryName("alien_log");
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		@Override
		public BlockState rotate(BlockState state, Rotation rot) {
			if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
				if ((Direction) state.get(FACING) == Direction.WEST || (Direction) state.get(FACING) == Direction.EAST) {
					return state.with(FACING, Direction.UP);
				} else if ((Direction) state.get(FACING) == Direction.UP || (Direction) state.get(FACING) == Direction.DOWN) {
					return state.with(FACING, Direction.WEST);
				}
			}
			return state;
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			Direction facing = context.getFace();
			if (facing == Direction.WEST || facing == Direction.EAST)
				facing = Direction.UP;
			else if (facing == Direction.NORTH || facing == Direction.SOUTH)
				facing = Direction.EAST;
			else
				facing = Direction.SOUTH;;
			return this.getDefaultState().with(FACING, facing);
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
