package com.mrbysco.fivehead;

import com.mojang.logging.LogUtils;
import com.mrbysco.fivehead.config.SmoothBrainConfig;
import com.mrbysco.fivehead.recipe.SmartRecipes;
import com.mrbysco.fivehead.registry.SmartRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.slf4j.Logger;

@Mod(FiveHead.MOD_ID)
public class FiveHead {
	public static final String MOD_ID = "fivehead";
	public static final Logger LOGGER = LogUtils.getLogger();

	public FiveHead(IEventBus eventBus, Dist dist, ModContainer container) {
		SmartRegistry.DATA_COMPONENT_TYPES.register(eventBus);
		SmartRecipes.RECIPE_SERIALIZERS.register(eventBus);

		if (dist.isClient()) {
			container.registerConfig(Type.CLIENT, SmoothBrainConfig.clientSpec);
			container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
		}
	}
}
