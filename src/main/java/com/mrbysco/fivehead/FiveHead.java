package com.mrbysco.fivehead;

import com.mojang.logging.LogUtils;
import com.mrbysco.fivehead.client.TooltipHandler;
import com.mrbysco.fivehead.config.SmoothBrainConfig;
import com.mrbysco.fivehead.recipe.SmartRecipes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(FiveHead.MOD_ID)
public class FiveHead {
	public static final String MOD_ID = "fivehead";
	public static final Logger LOGGER = LogUtils.getLogger();

	public static final String SCALE_TAG = "FiveHeadScale";

	public FiveHead() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(Type.CLIENT, SmoothBrainConfig.clientSpec);

		SmartRecipes.RECIPE_SERIALIZERS.register(eventBus);
		SmartRecipes.RECIPE_TYPES.register(eventBus);

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			MinecraftForge.EVENT_BUS.register(new TooltipHandler());
		});
	}
}
