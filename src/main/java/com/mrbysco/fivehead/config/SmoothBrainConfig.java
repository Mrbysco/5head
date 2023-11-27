package com.mrbysco.fivehead.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class SmoothBrainConfig {
	public static class Client {
		public final BooleanValue showPercentage;

		Client(ModConfigSpec.Builder builder) {
			builder.comment("Client settings")
					.push("client");

			showPercentage = builder
					.comment("Dictates if the percentage of which a skull has been enlarged shows in tooltip")
					.define("showPercentage", true);

			builder.pop();
		}
	}


	public static final ModConfigSpec clientSpec;
	public static final Client CLIENT;

	static {
		final Pair<Client, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Client::new);
		clientSpec = specPair.getRight();
		CLIENT = specPair.getLeft();
	}
}
