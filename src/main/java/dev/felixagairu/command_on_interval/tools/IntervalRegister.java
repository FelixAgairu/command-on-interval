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
                System.out.println("Running task at interval!");
                System.out.println("useTicks: "+useTicks+" finalDelay: "+finalDelay+" finalInterval: "+finalInterval+" command: "+command);
                CommandsExecutor commandsExecutor = new CommandsExecutor();
                commandsExecutor.exe(server, command); // Execute your task
            }
        });
    }
}
