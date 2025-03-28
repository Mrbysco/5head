package com.mrbysco.fivehead.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrbysco.fivehead.client.HeadHandler;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CustomHeadLayer.class)
public class CustomHeadLayerMixin<S extends LivingEntityRenderState> {
	@Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;FF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/blockentity/SkullBlockRenderer;getRenderType(Lnet/minecraft/world/level/block/SkullBlock$Type;Lnet/minecraft/world/item/component/ResolvableProfile;)Lnet/minecraft/client/renderer/RenderType;", shift = Shift.AFTER, ordinal = 0))
	public void fiveheadRender(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, S renderState, float v, float v1, CallbackInfo ci) {
		HeadHandler.resizeSkull(renderState, poseStack);
	}
}
