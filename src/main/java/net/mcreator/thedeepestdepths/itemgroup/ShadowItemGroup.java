
package net.mcreator.thedeepestdepths.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.thedeepestdepths.item.ShadowBallItem;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;

@TheDeepestDepthsModElements.ModElement.Tag
public class ShadowItemGroup extends TheDeepestDepthsModElements.ModElement {
	public ShadowItemGroup(TheDeepestDepthsModElements instance) {
		super(instance, 415);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabshadow") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ShadowBallItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
