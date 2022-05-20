package com.mrbysco.fivehead.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class SmoothBrainConfig {
	public static class Client {
		public final BooleanValue showPercentage;

		Client(ForgeConfigSpec.Builder builder) {
			builder.comment("Client settings")
					.push("client");

			showPercentage = builder
					.comment("Dictates if the percentage of which a skull has been enlarged shows in tooltip")
					.define("showPercentage", true);

			builder.pop();
		}
	}


	public static final ForgeConfigSpec clientSpec;
	public static final Client CLIENT;

	static {
		final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
		clientSpec = specPair.getRight();
		CLIENT = specPair.getLeft();
	}
}
