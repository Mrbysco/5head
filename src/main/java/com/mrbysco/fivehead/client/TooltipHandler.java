package com.mrbysco.fivehead.client;

import com.mrbysco.fivehead.FiveHead;
import com.mrbysco.fivehead.ScaleUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TooltipHandler {
	@SubscribeEvent
	public void onItemPickup(ItemTooltipEvent event) {
		ItemStack stack = event.getItemStack();
		if (ScaleUtil.isSkullBlock(stack) && stack.hasTag() && !stack.getTag().isEmpty() && stack.getTag().contains(FiveHead.SCALE_TAG)) {
			CompoundTag tag = stack.getTag();
			float scaleAddition = tag.getFloat(FiveHead.SCALE_TAG);
			MutableComponent component = new TranslatableComponent("fivehead.enlarged.tooltip", Math.round((scaleAddition * 100) * 1000.0) / 1000.0).withStyle(ChatFormatting.GOLD);
			component.append(new TranslatableComponent("fivehead.enlarged.tooltip2").withStyle(ChatFormatting.GOLD));
			event.getToolTip().add(component);
		}
	}
}
