package com.mrbysco.fivehead.recipe;

import com.google.common.collect.Lists;
import com.mrbysco.fivehead.registry.SmartRegistry;
import com.mrbysco.fivehead.util.ScaleUtil;
import net.minecraft.core.HolderLookup;
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
	public ItemStack assemble(CraftingContainer container, HolderLookup.Provider provider) {
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
				float size1 = stack1.getOrDefault(SmartRegistry.SIZE_TYPE.get(), 0.3125F);
				float size2 = stack2.getOrDefault(SmartRegistry.SIZE_TYPE.get(), 0.3125F);
				float newSize = size1 + size2;

				ItemStack stackCopy = stack1.copy();
				stackCopy.setCount(1);
				stackCopy.set(SmartRegistry.SIZE_TYPE.get(), newSize);

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
