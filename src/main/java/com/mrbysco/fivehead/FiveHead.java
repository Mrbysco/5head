package com.mrbysco.fivehead;

import com.mojang.logging.LogUtils;
import com.mrbysco.fivehead.client.TooltipHandler;
import com.mrbysco.fivehead.config.SmoothBrainConfig;
import com.mrbysco.fivehead.recipe.SmartRecipes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(FiveHead.MOD_ID)
public class FiveHead {
	public static final String MOD_ID = "fivehead";
	public static final Logger LOGGER = LogUtils.getLogger();

	public static final String SCALE_TAG = "FiveHeadScale";

	public FiveHead(IEventBus eventBus) {
		ModLoadingContext.get().registerConfig(Type.CLIENT, SmoothBrainConfig.clientSpec);

		SmartRecipes.RECIPE_SERIALIZERS.register(eventBus);

		if (FMLEnvironment.dist.isClient()) {
			NeoForge.EVENT_BUS.register(new TooltipHandler());
		}
	}
}
