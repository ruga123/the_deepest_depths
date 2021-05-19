
package net.mcreator.thedeepestdepths.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.thedeepestdepths.block.PyroxeneBlock;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;

@TheDeepestDepthsModElements.ModElement.Tag
public class BloodlandsItemGroup extends TheDeepestDepthsModElements.ModElement {
	public BloodlandsItemGroup(TheDeepestDepthsModElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbloodlands") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PyroxeneBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
