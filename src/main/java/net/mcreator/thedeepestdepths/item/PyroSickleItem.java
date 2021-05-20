
package net.mcreator.thedeepestdepths.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.thedeepestdepths.procedures.BloodhoundSickleLivingEntityIsHitWithToolProcedure;
import net.mcreator.thedeepestdepths.itemgroup.BloodlandsItemGroup;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@TheDeepestDepthsModElements.ModElement.Tag
public class PyroSickleItem extends TheDeepestDepthsModElements.ModElement {
	@ObjectHolder("the_deepest_depths:pyro_sickle")
	public static final Item block = null;
	public PyroSickleItem(TheDeepestDepthsModElements instance) {
		super(instance, 120);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2437;
			}

			public float getEfficiency() {
				return 18f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 17;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PyroCrystalItem.block, (int) (1)), new ItemStack(BloodhoundFangItem.block, (int) (1)),
						new ItemStack(Items.NETHERITE_INGOT, (int) (1)));
			}
		}, 3, -2.2f, new Item.Properties().group(BloodlandsItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A76Beheading"));
				list.add(new StringTextComponent("\u00A76Flaming"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					BloodhoundSickleLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("pyro_sickle"));
	}
}
