/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package dev.felixagairu.command_on_interval.tools;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class IntervalRegister {
    private int tickCounter = 0;

    public IntervalRegister(boolean useTicks,int delay, int interval, String command) {
        if (!useTicks) {
            interval *= 20;
            delay *= 20;
        }
        int finalDelay = delay;
        int finalInterval = interval + finalDelay;
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            tickCounter++;
            if (tickCounter >= finalInterval) {
                tickCounter = 0; // Reset the counter
                //System.out.println("[command-on-interval] Running task at interval!");
                //System.out.println("[command-on-interval] useTicks: "+useTicks+" finalDelay: "+finalDelay+" finalInterval: "+finalInterval+" command: "+command);
                CommandsExecutor commandsExecutor = new CommandsExecutor();
                commandsExecutor.exe(server, command); // Execute your task
            }
        });
    }
}
