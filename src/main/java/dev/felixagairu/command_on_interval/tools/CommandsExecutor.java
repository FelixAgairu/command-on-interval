/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package dev.felixagairu.command_on_interval.tools;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;

public class CommandsExecutor {
    public void exe(MinecraftServer serverInstance, String command) {

            // Get the server's command source
            ServerCommandSource source = serverInstance.getCommandSource();

            // Execute the command
            //System.out.println("[command-on-interval] command: "+command);
            serverInstance.getCommandManager().executeWithPrefix(source, command);
    }
}
