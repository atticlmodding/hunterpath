package com.atticl;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atticl.items.ModItems;

public class HunterPath implements ModInitializer {
	public static final String MOD_ID = "hunter-path";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		LOGGER.info("Hello Fabric world!");
	}
}