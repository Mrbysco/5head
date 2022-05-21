package com.mrbysco.fivehead.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrbysco.fivehead.FiveHead;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CustomHeadLayer.class)
public class CustomHeadLayerMixin<T extends LivingEntity> {
	@Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/renderer/blockentity/SkullBlockRenderer;renderSkull(Lnet/minecraft/core/Direction;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/model/SkullModelBase;Lnet/minecraft/client/renderer/RenderType;)V",
					shift = Shift.BEFORE,
					ordinal = 0))
	public void fiveheadRender(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
		final ItemStack itemstack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
		if (itemstack.hasTag() && itemstack.getTag().contains(FiveHead.SCALE_TAG)) {
			final float scale = itemstack.getTag().getFloat(FiveHead.SCALE_TAG);
			if (scale > 0) {
				final float newScale = scale + 1;
				poseStack.translate(-scale / 2, 0, -scale / 2);
				poseStack.scale(newScale, newScale, newScale);
			}
		}
	}
}
