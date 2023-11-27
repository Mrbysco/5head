package com.mrbysco.fivehead.client;

import com.mrbysco.fivehead.FiveHead;
import com.mrbysco.fivehead.util.ScaleUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.bus.api.SubscribeEvent;

public class TooltipHandler {
	@SubscribeEvent
	public void onItemPickup(ItemTooltipEvent event) {
		ItemStack stack = event.getItemStack();
		if (ScaleUtil.isSkullBlock(stack) && stack.getTag() != null && !stack.getTag().isEmpty() && stack.getTag().contains(FiveHead.SCALE_TAG)) {
			CompoundTag tag = stack.getTag();
			float scaleAddition = tag.getFloat(FiveHead.SCALE_TAG);
			MutableComponent component = Component.translatable("fivehead.enlarged.tooltip",
							Math.round((scaleAddition * 100) * 1000.0) / 1000.0).withStyle(ChatFormatting.GOLD)
					.append(Component.translatable("fivehead.enlarged.tooltip2").withStyle(ChatFormatting.GOLD));
			event.getToolTip().add(component);
		}
	}
}
