package com.mrbysco.fivehead.recipe;

import com.google.common.collect.Lists;
import com.mrbysco.fivehead.FiveHead;
import com.mrbysco.fivehead.util.ScaleUtil;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

import java.util.List;

public class BigBrainRecipe extends CustomRecipe {
	public BigBrainRecipe(CraftingBookCategory category) {
		super(category);
	}

	@Override
	public boolean matches(CraftingContainer container, Level level) {
		List<ItemStack> list = Lists.newArrayList();

		for (int i = 0; i < container.getContainerSize(); ++i) {
			ItemStack itemstack = container.getItem(i);
			if (!itemstack.isEmpty()) {
				list.add(itemstack);
				if (list.size() > 1) {
					ItemStack stack1 = list.get(0);
					if (itemstack.getItem() != stack1.getItem() || !ScaleUtil.isSkullBlock(itemstack)) {
						return false;
					}
				}
			}
		}

		return list.size() == 2;
	}

	@Override
	public ItemStack assemble(CraftingContainer container, RegistryAccess access) {
		List<ItemStack> list = Lists.newArrayList();

		for (int i = 0; i < container.getContainerSize(); ++i) {
			ItemStack itemstack = container.getItem(i);
			if (!itemstack.isEmpty()) {
				list.add(itemstack);
				if (list.size() > 1) {
					ItemStack stack1 = list.get(0);
					if (itemstack.getItem() != stack1.getItem() && !ScaleUtil.isSkullBlock(itemstack)) {
						return ItemStack.EMPTY;
					}
				}
			}
		}

		if (list.size() == 2) {
			ItemStack stack1 = list.get(0);
			ItemStack stack2 = list.get(1);
			if (ItemStack.isSameItem(stack1, stack2)) {
				float size1 = stack1.hasTag() && stack1.getTag().contains(FiveHead.SCALE_TAG) ? stack1.getTag().getFloat(FiveHead.SCALE_TAG) : 0.03125F;
				float size2 = stack2.hasTag() && stack2.getTag().contains(FiveHead.SCALE_TAG) ? stack2.getTag().getFloat(FiveHead.SCALE_TAG) : 0.03125F;
				float newSize = size1 + size2;

				ItemStack stackCopy = stack1.copy();
				CompoundTag tag = stackCopy.getOrCreateTag();
				tag.putFloat(FiveHead.SCALE_TAG, newSize);
				stackCopy.setCount(1);
				stackCopy.setTag(tag);

				return stackCopy;
			}
		}

		return ItemStack.EMPTY;
	}

	@Override
	public boolean canCraftInDimensions(int x, int y) {
		return x * y >= 2;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return SmartRecipes.BIG_BRAIN_SERIALIZER.get();
	}
}
