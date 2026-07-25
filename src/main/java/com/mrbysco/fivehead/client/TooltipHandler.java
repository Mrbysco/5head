package com.mrbysco.fivehead.client;

import com.mrbysco.fivehead.registry.SmartRegistry;
import com.mrbysco.fivehead.util.ScaleUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(Dist.CLIENT)
public class TooltipHandler {
	@SubscribeEvent
	public static void onItemPickup(ItemTooltipEvent event) {
		ItemStack stack = event.getItemStack();
		if (ScaleUtil.isSkullBlock(stack) && stack.has(SmartRegistry.SIZE_TYPE.get())) {
			float scaleAddition = stack.getOrDefault(SmartRegistry.SIZE_TYPE.get(), 0.03125F);
			MutableComponent component = Component.translatable("fivehead.enlarged.tooltip",
							Math.round((scaleAddition * 100) * 1000.0) / 1000.0).withStyle(ChatFormatting.GOLD)
					.append(Component.translatable("fivehead.enlarged.tooltip2").withStyle(ChatFormatting.GOLD));
			event.getToolTip().add(component);
		}
	}
}
