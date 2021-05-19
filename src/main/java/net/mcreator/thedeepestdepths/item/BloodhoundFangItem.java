
package net.mcreator.thedeepestdepths.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.thedeepestdepths.itemgroup.BloodlandsItemGroup;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;

@TheDeepestDepthsModElements.ModElement.Tag
public class BloodhoundFangItem extends TheDeepestDepthsModElements.ModElement {
	@ObjectHolder("the_deepest_depths:bloodhound_fang")
	public static final Item block = null;
	public BloodhoundFangItem(TheDeepestDepthsModElements instance) {
		super(instance, 98);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(BloodlandsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("bloodhound_fang");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
