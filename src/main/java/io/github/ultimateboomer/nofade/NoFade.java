package io.github.ultimateboomer.nofade;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoFade implements ModInitializer {
	public static final String MOD_NAME = "Fadeless";

	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_NAME + " is running");
	}
}
