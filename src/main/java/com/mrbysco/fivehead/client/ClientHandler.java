package com.mrbysco.fivehead.client;

import com.google.common.reflect.TypeToken;
import com.mrbysco.fivehead.FiveHead;
import com.mrbysco.fivehead.registry.SmartRegistry;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.context.ContextKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.renderstate.RegisterRenderStateModifiersEvent;

public class ClientHandler {
	public static final ContextKey<Float> HEAD_SCALE = new ContextKey<>(
			Identifier.fromNamespaceAndPath(FiveHead.MOD_ID, "head_scale"));

	public static void registerCustomRenderData(RegisterRenderStateModifiersEvent event) {
		event.registerEntityModifier(new TypeToken<LivingEntityRenderer<?, ?, ?>>() {
		}, (living, state) -> {
			float size = 0F;
			ItemStack itemstack = living.getItemBySlot(EquipmentSlot.HEAD);
			if (itemstack.has(SmartRegistry.SIZE_TYPE.get())) {
				size = itemstack.getOrDefault(SmartRegistry.SIZE_TYPE.get(), 0.03125F);
			}
			state.setRenderData(HEAD_SCALE, size);
		});
	}
}
