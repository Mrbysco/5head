package com.mrbysco.fivehead.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrbysco.fivehead.client.HeadHandler;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CustomHeadLayer.class)
public class CustomHeadLayerMixin<S extends LivingEntityRenderState> {
	@Inject(method = "submit(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;ILnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;FF)V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/renderer/entity/layers/CustomHeadLayer;resolveSkullRenderType(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lnet/minecraft/world/level/block/SkullBlock$Type;)Lnet/minecraft/client/renderer/rendertype/RenderType;",
					shift = Shift.AFTER,
					ordinal = 0
			)
	)
	public void fiveheadRender(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, S state,
	                           float yRot, float xRot, CallbackInfo ci) {
		HeadHandler.resizeSkull(state, poseStack);
	}
}
