package com.mrbysco.fivehead.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class HeadHandler {
	public static void resizeSkull(LivingEntityRenderState renderState, PoseStack poseStack) {
		final float scale = renderState.getRenderDataOrDefault(ClientHandler.HEAD_SCALE, 0.0F);
		if (scale > 0) {
			final float newScale = scale + 1;
			poseStack.translate(-scale / 2, 0, -scale / 2);
			poseStack.scale(newScale, newScale, newScale);
		}
	}
}
