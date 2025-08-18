/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package dev.felixagairu.command_on_interval;

import dev.felixagairu.command_on_interval.tools.DataLoader;
import dev.felixagairu.command_on_interval.tools.IntervalRegister;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class CommandOnInterval implements ModInitializer {
    public static final String MOD_ID = "command-on-interval";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        commandOnIntervalStart();
    }

    private void commandOnIntervalStart() {
        try {
            if (DataLoader.load() && !DataLoader.listOfCommands.isEmpty()) {
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
        } catch (Exception e) {
            System.err.println("[command-on-interval] Failed to initialize configs: " + e.getMessage());
            DataLoader.reset();
        }
    }
}/**/