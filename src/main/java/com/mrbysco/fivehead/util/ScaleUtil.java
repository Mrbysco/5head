package com.mrbysco.fivehead.util;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SkullBlock;

public class ScaleUtil {
	public static boolean isSkullBlock(ItemStack stack) {
		return stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SkullBlock;
	}
}
