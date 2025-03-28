package com.mrbysco.fivehead.registry;

import com.mrbysco.fivehead.FiveHead;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SmartRegistry {
	public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, FiveHead.MOD_ID);

	public static final DeferredHolder<DataComponentType<?>, DataComponentType<Float>> SIZE_TYPE =
			DATA_COMPONENT_TYPES.register("scale", () -> DataComponentType.<Float>builder()
					.persistent(ExtraCodecs.NON_NEGATIVE_FLOAT)
					.networkSynchronized(ByteBufCodecs.FLOAT)
					.build());
}
