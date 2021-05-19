
package net.mcreator.thedeepestdepths.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.thedeepestdepths.block.AlienRockBlock;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;

@TheDeepestDepthsModElements.ModElement.Tag
public class VergoZoneItemGroup extends TheDeepestDepthsModElements.ModElement {
	public VergoZoneItemGroup(TheDeepestDepthsModElements instance) {
		super(instance, 300);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabvergo_zone") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AlienRockBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
