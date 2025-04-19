package dev.felixagairu.command_on_interval.tools;

import com.google.gson.JsonObject;
import dev.felixagairu.configmanager.ConfigManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DataLoader {
    private static final String defaultConfigs ="""
            {
                  \t"0":{
                    \t\t"enabled":false,
                    \t\t"unit-use-ticks":false,
                    \t\t"delay":0,
                    \t\t"interval":10,
                    \t\t"command":""
                  \t}
            }""";

    private static final ConfigManager cM = new ConfigManager("command_on_interval.json", defaultConfigs);
    private static final JsonObject configs = cM.loadConfig();
    private static final Set<String> keys = configs.keySet();

    public static List<Boolean> listOfUnitUseTicks = new ArrayList<>();
    public static List<Integer> listOfDelay = new ArrayList<>();
    public static List<Integer> listOfInterval = new ArrayList<>();
    public static List<String> listOfCommands = new ArrayList<>();

    public static boolean load() {
        //System.out.println("[command-on-interval] Processing cM: " + cM);
        //System.out.println("[command-on-interval] Processing configs: " + configs);
        //System.out.println("[command-on-interval] Processing keys: " + keys);
        //System.out.println("[command-on-interval] Processing keys.size(): " + keys.size());
        try {
            int j = 0;
            for (int i = 0; i < keys.size(); i++) {
                JsonObject nestedConfigs = configs.getAsJsonObject(String.valueOf(i));
                //System.out.println("[command-on-interval] Processing nestedConfigs: " + nestedConfigs);

                // Access specific properties in the nested JSON object
                //System.out.println("[command-on-interval] Processing unit-use-ticks: " + nestedConfigs.get("unit-use-ticks").getAsBoolean());
                //System.out.println("[command-on-interval] Processing i: " + i);
                //System.out.println("[command-on-interval] Processing listOfUnitUseTicks.size(): " + listOfUnitUseTicks.size());
                if (nestedConfigs.get("enabled").getAsBoolean()) {
                    listOfUnitUseTicks.add(j, nestedConfigs.get("unit-use-ticks").getAsBoolean());
                    listOfDelay.add(j, nestedConfigs.get("delay").getAsInt());
                    listOfInterval.add(j, nestedConfigs.get("interval").getAsInt());
                    listOfCommands.add(j, nestedConfigs.get("command").getAsString());
                    j++;
                }
            }
            return true;
        } catch (Exception e) {
            System.err.println("[command-on-interval] Failed to read configs: " + e.getMessage());
            return false;
        }
    }

    public static boolean reset() {
        return cM.resetConfig();
    }
}
