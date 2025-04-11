package dev.felixagairu.command_on_interval;

import dev.felixagairu.command_on_interval.tools.DataLoader;
import dev.felixagairu.command_on_interval.tools.IntervalRegister;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Commandoninterval implements ModInitializer {
	public static final String MOD_ID = "command-on-interval";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		regCmd();
	}

	private void regCmd() {
		DataLoader.load();
		if (!DataLoader.listOfCommands.isEmpty()) {
			ArrayList<IntervalRegister> instances = new ArrayList<>();
			for (int i = 0; i < DataLoader.listOfCommands.size(); i++) {
				instances.add(new IntervalRegister(
						DataLoader.listOfUnitUseTicks.get(i),
						DataLoader.listOfDelay.get(i),
						DataLoader.listOfInterval.get(i),
						DataLoader.listOfCommands.get(i)
				));
			}
		}
	}
}